package minhaz.musicplayerserver.repository

import minhaz.musicplayerserver.model.Album
import minhaz.musicplayerserver.model.projections.AlbumSummary
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface AlbumRepository : CustomAlbumRepository
interface CustomAlbumRepository : JpaRepository<Album, UUID> {
    // TODO: remove
    fun getAllByTagsNotNull(): List<AlbumSummary>
}
