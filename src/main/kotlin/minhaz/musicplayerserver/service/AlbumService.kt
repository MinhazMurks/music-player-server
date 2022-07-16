package minhaz.musicplayerserver.service

import minhaz.musicplayerserver.api.response.AlbumFeedResponse
import minhaz.musicplayerserver.repository.AlbumRepository
import org.springframework.stereotype.Service

@Service
class AlbumService(
    private val albumRepository: AlbumRepository
) {
    fun getFeed(): AlbumFeedResponse {
        return AlbumFeedResponse(
            albumRepository.findAll()
        )
    }
}
