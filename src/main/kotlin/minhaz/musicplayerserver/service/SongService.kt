package minhaz.musicplayerserver.service

import minhaz.musicplayerserver.api.response.SongFeedResponse
import minhaz.musicplayerserver.api.response.SongResponse
import minhaz.musicplayerserver.model.Song
import minhaz.musicplayerserver.repository.SongRepository
import org.springframework.stereotype.Service

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

    private fun buildSongResponseList(songs: List<Song>): List<SongResponse> {
        return songs.map {
            SongResponse(
                id = it.id,
                audioFile = it.audioFile,
                name = it.name,
                art = it.art,
                artistId = it.artistUUID
            )
        }
    }
}
