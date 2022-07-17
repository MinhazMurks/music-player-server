package minhaz.musicplayerserver.model

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "playlist_song")
class PlaylistSong(
    @Column(name = "id")
    @Id
    var id: UUID = UUID.randomUUID(),

    @Column(name = "playlist")
    val playlistUUID: UUID,

    @Column(name = "song")
    val songUUID: UUID
)
