package minhaz.musicplayerserver.model

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity(name = "album_song")
class AlbumSong {
    @Column(name = "id")
    @Id
    lateinit var id: UUID

    @ManyToOne
    @JoinColumn(name = "song")
    var song: Song? = null

    @ManyToOne
    @JoinColumn(name = "album")
    var album: Album? = null
}
