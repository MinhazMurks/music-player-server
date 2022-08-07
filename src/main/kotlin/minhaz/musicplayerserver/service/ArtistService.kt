package minhaz.musicplayerserver.service

import minhaz.musicplayerserver.api.exception.NotFoundException
import minhaz.musicplayerserver.api.response.ArtistFeedResponse
import minhaz.musicplayerserver.api.response.ArtistResponse
import minhaz.musicplayerserver.model.Artist
import minhaz.musicplayerserver.repository.ArtistRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ArtistService(
    private val artistRepository: ArtistRepository
) {
    fun getFeed(): ArtistFeedResponse {
        return ArtistFeedResponse(
            buildArtistResponseList(artistRepository.findAll())
        )
    }

    fun getArtist(artistUUID: UUID): ArtistResponse {
        val artist = artistRepository.findById(artistUUID)

        if (artist.isEmpty) {
            throw NotFoundException("Artist $artistUUID was not found.")
        }

        return buildArtistResponse(artist.get())
    }

    private fun buildArtistResponse(artist: Artist): ArtistResponse {
        return ArtistResponse(
            id = artist.id,
            musicUserUUID = artist.musicUserUUID,
            name = artist.name,
            portrait = artist.portrait
        )
    }

    private fun buildArtistResponseList(artists: List<Artist>): List<ArtistResponse> {
        return artists.map {
            return@map buildArtistResponse(it)
        }
    }
}
