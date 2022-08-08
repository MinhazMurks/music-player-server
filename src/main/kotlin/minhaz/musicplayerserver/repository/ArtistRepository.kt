package minhaz.musicplayerserver.repository

import minhaz.musicplayerserver.model.Artist
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ArtistRepository : CustomArtistRepository

interface CustomArtistRepository : JpaRepository<Artist, UUID>
