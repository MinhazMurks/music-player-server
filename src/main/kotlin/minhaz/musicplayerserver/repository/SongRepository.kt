package minhaz.musicplayerserver.repository

import minhaz.musicplayerserver.model.Song
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface SongRepository : CustomSongRepository

interface CustomSongRepository : JpaRepository<Song, UUID> {
    fun getSongByIdIsIn(songIds: List<UUID>)
}
