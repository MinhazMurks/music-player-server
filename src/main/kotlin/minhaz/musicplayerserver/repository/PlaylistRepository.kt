package minhaz.musicplayerserver.repository

import minhaz.musicplayerserver.model.Playlist
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PlaylistRepository : JpaRepository<Playlist, UUID>
