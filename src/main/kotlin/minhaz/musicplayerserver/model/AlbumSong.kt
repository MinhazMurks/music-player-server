package minhaz.musicplayerserver.model

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity(name = "album_song")
class AlbumSong(
    @Column(name = "id")
    @Id
    val id: UUID,

    @Column(name = "album")
    val albumUuid: UUID,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album")
    val album: Album? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "song")
    val song: Song? = null,
) {
    override fun toString(): String {
        return "AlbumSong(id=$id, song=$song, album=$album)"
    }
}
