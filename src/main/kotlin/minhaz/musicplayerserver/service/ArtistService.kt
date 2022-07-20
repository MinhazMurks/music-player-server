package minhaz.musicplayerserver.service

import minhaz.musicplayerserver.api.response.ArtistFeedResponse
import minhaz.musicplayerserver.api.response.ArtistResponse
import minhaz.musicplayerserver.model.Artist
import minhaz.musicplayerserver.repository.ArtistRepository
import org.springframework.stereotype.Service

@Service
class ArtistService(
    private val artistRepository: ArtistRepository
) {
    fun getFeed(): ArtistFeedResponse {
        return ArtistFeedResponse(
            buildArtistResponseList(artistRepository.findAll())
        )
    }

    private fun buildArtistResponseList(artists: List<Artist>): List<ArtistResponse> {
        return artists.map {
            ArtistResponse(
                id = it.id,
                musicUserUUID = it.musicUserUUID,
                name = it.name,
                portrait = it.portrait
            )
        }
    }
}
