package minhaz.musicplayerserver.repository

import minhaz.musicplayerserver.model.Playlist
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface PlaylistRepository : JpaRepository<Playlist, UUID>
