package minhaz.musicplayerserver.repository

import minhaz.musicplayerserver.model.Album
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AlbumRepository : JpaRepository<Album, UUID>
