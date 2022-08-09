package minhaz.musicplayerserver.service

import minhaz.musicplayerserver.api.response.ArtistFeedResponse
import minhaz.musicplayerserver.api.response.ArtistResponse
import minhaz.musicplayerserver.repository.ArtistRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ArtistService(
    private val artistRepository: ArtistRepository
) {
    fun getFeed(): ArtistFeedResponse {
        val artists = artistRepository.getAllByIdIsNotNull()
        return ArtistFeedResponse(
            artists.map {
                return@map ArtistResponse(it)
            }
        )
    }

    fun getArtist(artistUUID: UUID): ArtistResponse {
        val artist = artistRepository.getArtistById(artistUUID)

        return ArtistResponse(artist)
    }
}
