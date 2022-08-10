package minhaz.musicplayerserver.model

import org.hibernate.annotations.Type
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "album")
class Album(
    @Column(name = "id")
    @Id
    val id: UUID,

    @Column(name = "artist")
    val artistUUID: UUID,

    @ManyToOne
    @JoinColumn(name = "artist", referencedColumnName = "id", insertable = false, updatable = false)
    val artist: Artist,

    @Column(name = "name")
    val name: String,

    @Column(name = "art")
    val art: String,

    @Type(type = "list-array")
    @Column(name = "tags", columnDefinition = "text[]")
    val tags: List<String>,

    @OneToMany
    @JoinTable(
        name = "album_song",
        joinColumns = [JoinColumn(name = "song", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "album", referencedColumnName = "id")]
    )
    val songs: List<Song>
) {
    override fun toString(): String {
        return "Album(id=$id, name='$name', tags=$tags)"
    }
}
