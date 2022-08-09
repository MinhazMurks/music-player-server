package minhaz.musicplayerserver.model.projections

import java.util.UUID

interface SongSummary {
    var id: UUID
    var audioFile: String
    var name: String
    val art: String
    val artistUUID: UUID
}
