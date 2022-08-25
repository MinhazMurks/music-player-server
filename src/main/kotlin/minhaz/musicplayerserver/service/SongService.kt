package minhaz.musicplayerserver.service

import aws.sdk.kotlin.services.s3.S3Client
import aws.sdk.kotlin.services.s3.model.GetObjectRequest
import aws.smithy.kotlin.runtime.content.toByteArray
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import minhaz.musicplayerserver.api.response.SongFeedResponse
import minhaz.musicplayerserver.api.response.SongResponse
import minhaz.musicplayerserver.repository.SongRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class SongService(
    private val songRepository: SongRepository
) {
    fun getFeed(): SongFeedResponse {
        val songs = songRepository.getAllByIdIsNotNull()
        return SongFeedResponse(
            songs.map {
                return@map SongResponse(it)
            }
        )
    }

    fun getSong(songUUID: UUID): SongResponse {
        val song = songRepository.getSongSummaryById(songUUID)

        return SongResponse(song)
    }

    suspend fun getSongChunk(songUUID: UUID, startingBytes: Int, chunkSize: Int? = 104800): ByteArray {
        var resultArray: ByteArray = byteArrayOf()

        val song = withContext(Dispatchers.IO) {
            songRepository.getSongById(songUUID)
        }
        val endingBytes = startingBytes + chunkSize!! - 1
        val bucketString = "music-server-storage"
        val rangeString = "bytes=$startingBytes-$endingBytes"

        val req = GetObjectRequest {
            key = song.audioFile
            bucket = bucketString
            range = rangeString
        }

        val path = "output.txt"

        S3Client { region = "us-east-1" }.use { s3 ->
            s3.getObject(req) { resp ->
                println("Successfully read ${song.audioFile} from $bucketString")
                val responseBody = resp.body?.toByteArray() ?: throw RuntimeException()
                resultArray = responseBody
            }
        }

        return resultArray
    }
}
