package minhaz.musicplayerserver.repository

import minhaz.musicplayerserver.model.Playlist
import minhaz.musicplayerserver.model.projections.PlaylistSummary
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface PlaylistRepository : CustomPlaylistRepository {
    fun getPlaylistById(id: UUID): PlaylistSummary

    // TODO: remove
    fun getAllByTagsNotNull(): List<PlaylistSummary>
}

interface CustomPlaylistRepository : JpaRepository<Playlist, UUID>
