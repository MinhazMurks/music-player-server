package minhaz.musicplayerserver.repository

import minhaz.musicplayerserver.model.Song
import minhaz.musicplayerserver.model.projections.SongSummary
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface SongRepository : CustomSongRepository

interface CustomSongRepository : JpaRepository<Song, UUID> {
    fun getSongById(id: UUID): SongSummary

    fun getSongsByIdIn(songIds: List<UUID>): List<Song>

    // TODO: remove
    fun getAllByIdIsNotNull(): List<SongSummary>
}
