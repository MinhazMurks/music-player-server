package minhaz.musicplayerserver.model.projections

import java.util.UUID

interface AlbumSummary {
    val id: UUID
    val artistUUID: UUID
    val name: String
    val art: String
    val tags: List<String>
}
