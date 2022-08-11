package minhaz.musicplayerserver.model.projections

import java.util.UUID

interface SongSummary {
    val id: UUID
    val audioFile: String
    val name: String
    val length: Int
    val art: String
    val artistUUID: UUID
    val explicit: Boolean
}
