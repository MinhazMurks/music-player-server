package minhaz.musicplayerserver.repository

import minhaz.musicplayerserver.model.PlaylistSong
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface PlaylistSongRepository : CustomPlaylistSongRepository
interface CustomPlaylistSongRepository : JpaRepository<PlaylistSong, UUID> {
    fun getPlaylistSongsByPlaylistUUID(playlistUUID: UUID): List<PlaylistSong>
}
