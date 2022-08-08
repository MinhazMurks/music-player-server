package minhaz.musicplayerserver.model

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "album_song")
class AlbumSong(
    @Column(name = "id")
    @Id
    val id: UUID,

    @Column(name = "album")
    val albumUuid: UUID,

    @Column(name = "song")
    val songUuid: UUID,
) {
    override fun toString(): String {
        return "AlbumSong(id=$id, song=$songUuid, album=$albumUuid)"
    }
}
