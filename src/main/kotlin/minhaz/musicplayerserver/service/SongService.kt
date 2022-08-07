package minhaz.musicplayerserver.service

import minhaz.musicplayerserver.api.exception.NotFoundException
import minhaz.musicplayerserver.api.response.SongFeedResponse
import minhaz.musicplayerserver.api.response.SongResponse
import minhaz.musicplayerserver.model.Song
import minhaz.musicplayerserver.repository.SongRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class SongService(
    private val songRepository: SongRepository
) {
    fun getFeed(): SongFeedResponse {
        return SongFeedResponse(
            buildSongResponseList(
                songRepository.findAll()
            )
        )
    }

    fun getSong(songUUID: UUID): SongResponse {
        val song = songRepository.findById(songUUID)

        if (song.isEmpty) {
            throw NotFoundException("Song $songUUID was not found.")
        }

        return buildSongResponse(song.get())
    }

    private fun buildSongResponse(song: Song): SongResponse {
        return SongResponse(
            id = song.id,
            audioFile = song.audioFile,
            name = song.name,
            art = song.art,
            artistId = song.artistUUID
        )
    }

    private fun buildSongResponseList(songs: List<Song>): List<SongResponse> {
        return songs.map {
            return@map buildSongResponse(it)
        }
    }
}
