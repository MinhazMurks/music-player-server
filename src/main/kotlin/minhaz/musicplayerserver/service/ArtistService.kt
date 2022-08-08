package minhaz.musicplayerserver.service

import minhaz.musicplayerserver.api.exception.NotFoundException
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
        val artists = artistRepository.findAll()
        return ArtistFeedResponse(
            artists.map {
                return@map ArtistResponse(it)
            }
        )
    }

    fun getArtist(artistUUID: UUID): ArtistResponse {
        val artist = artistRepository.findById(artistUUID)

        if (artist.isEmpty) {
            throw NotFoundException("Artist $artistUUID was not found.")
        }

        return ArtistResponse(artist.get())
    }
}
