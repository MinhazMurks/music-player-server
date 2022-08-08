package minhaz.musicplayerserver.repository

import minhaz.musicplayerserver.model.PlaylistSong
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface PlaylistSongRepository : CustomPlaylistSongRepository
interface CustomPlaylistSongRepository : JpaRepository<PlaylistSong, UUID> {
    @Query("SELECT t FROM PlaylistSong t WHERE t.playlistUUID = (:playlistUUID)")
    fun getPlaylistSongsByPlaylistUUID(@Param("playlistUUID") playlistUUID: UUID): List<PlaylistSong>
}
