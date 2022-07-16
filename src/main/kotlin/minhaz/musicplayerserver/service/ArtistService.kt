package minhaz.musicplayerserver.service

import minhaz.musicplayerserver.api.response.ArtistFeedResponse
import minhaz.musicplayerserver.repository.ArtistRepository
import org.springframework.stereotype.Service

@Service
class ArtistService(
    private val artistRepository: ArtistRepository
) {
    fun getFeed(): ArtistFeedResponse {
        return ArtistFeedResponse(
            artistRepository.findAll()
        )
    }
}
