package minhaz.musicplayerserver.repository

import minhaz.musicplayerserver.model.Artist
import minhaz.musicplayerserver.model.projections.ArtistSummary
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ArtistRepository : CustomArtistRepository

interface CustomArtistRepository : JpaRepository<Artist, UUID> {

    fun getArtistById(id: UUID): ArtistSummary
    fun getArtistByMusicUserUUID(musicUserUUID: UUID): Artist

    // TODO: remove
    fun getAllByIdIsNotNull(): List<ArtistSummary>
}
