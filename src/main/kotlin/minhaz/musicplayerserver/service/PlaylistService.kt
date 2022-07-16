package minhaz.musicplayerserver.service

import minhaz.musicplayerserver.api.response.PlaylistFeedResponse
import minhaz.musicplayerserver.repository.PlaylistRepository
import org.springframework.stereotype.Service

@Service
class PlaylistService(
    private val playlistRepository: PlaylistRepository
) {

    fun getFeed(): PlaylistFeedResponse {
        return PlaylistFeedResponse(
            playlistRepository.findAll()
        )
    }
}
