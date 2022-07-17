package minhaz.musicplayerserver.model

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity(name = "playlist_song")
class PlaylistSong(
    @Column(name = "id")
    @Id
    var id: UUID = UUID.randomUUID(),

    @Column(name = "playlist")
    val playlistUUID: UUID,

    @Column(name = "song")
    val songUUID: UUID,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "song")
    val song: Song? = null
)
