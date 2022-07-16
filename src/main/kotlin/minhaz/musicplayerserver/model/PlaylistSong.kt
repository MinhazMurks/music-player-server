package minhaz.musicplayerserver.model

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity(name = "playlist_song")
class PlaylistSong {

    @Column(name = "id")
    @Id
    lateinit var id: UUID

    @Column(name = "playlist")
    lateinit var playlistUUID: UUID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "song")
    var song: Song? = null
}
