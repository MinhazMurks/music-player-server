package minhaz.musicplayerserver.service

import minhaz.musicplayerserver.api.exception.NotFoundException
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
        val songs = songRepository.findAll()
        return SongFeedResponse(
            songs.map {
                return@map SongResponse(it)
            }
        )
    }

    fun getSong(songUUID: UUID): SongResponse {
        val song = songRepository.findById(songUUID)

        if (song.isEmpty) {
            throw NotFoundException("Song $songUUID was not found.")
        }

        return SongResponse(song.get())
    }
}
