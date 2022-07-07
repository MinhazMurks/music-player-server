package minhaz.musicplayerserver.service

import minhaz.musicplayerserver.api.response.FeedResponse
import minhaz.musicplayerserver.repository.PlaylistRepository
import org.springframework.stereotype.Service

@Service
class FeedService(
    private val playlistRepository: PlaylistRepository
) {

    fun getDefaultUserFeed(): FeedResponse {
        return FeedResponse(playlistRepository.findAll())
    }
}
