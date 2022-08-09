package minhaz.musicplayerserver.service

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
        val song = songRepository.getSongById(songUUID)

        return SongResponse(song)
    }
}
