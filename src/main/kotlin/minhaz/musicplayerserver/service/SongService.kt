package minhaz.musicplayerserver.service

import aws.sdk.kotlin.services.s3.S3Client
import aws.sdk.kotlin.services.s3.model.GetObjectRequest
import aws.smithy.kotlin.runtime.content.writeToFile
import minhaz.musicplayerserver.api.response.SongFeedResponse
import minhaz.musicplayerserver.api.response.SongResponse
import minhaz.musicplayerserver.repository.SongRepository
import org.springframework.stereotype.Service
import java.io.File
import java.nio.file.Paths
import java.util.UUID
import kotlin.io.path.pathString

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
        val song = songRepository.getSongById(songUUID)

        return SongResponse(song)
    }

    suspend fun test(): String {

        val keyString = "Music/ClapAlong.mp3"
        val bucketString = "music-server-storage"

        val req = GetObjectRequest {
            key = keyString
            bucket = bucketString
        }

        val path = Paths.get("/tmp/download.txt").pathString

        val s3Client = S3Client { region = "us-east-1" }.use { s3 ->
            s3.getObject(req) { resp ->
                val myFile = File(path)
                resp.body?.writeToFile(myFile)
                println("Successfully read $keyString from $bucketString")
            }
        }

        return ""
    }
}
