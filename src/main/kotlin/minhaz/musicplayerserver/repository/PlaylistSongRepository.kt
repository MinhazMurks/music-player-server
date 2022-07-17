package minhaz.musicplayerserver.repository

import minhaz.musicplayerserver.model.PlaylistSong
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface PlaylistSongRepository : JpaRepository<PlaylistSong, UUID>
