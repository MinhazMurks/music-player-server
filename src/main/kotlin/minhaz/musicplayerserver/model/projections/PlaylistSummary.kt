package minhaz.musicplayerserver.model.projections

import minhaz.musicplayerserver.model.MusicUser
import java.util.UUID

interface PlaylistSummary {
    val id: UUID
    val creator: MusicUser
    val name: String
    val art: String
    val isPublic: Boolean
    val tags: List<String>
}
