package minhaz.musicplayerserver.model

import org.hibernate.annotations.Type
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity(name = "album")
class Album {

    @Column(name = "id")
    @Id
    lateinit var id: UUID

    @Column(name = "name")
    lateinit var name: String

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist")
    lateinit var artist: Artist

    @Type(type = "list-array")
    @Column(name = "tags", columnDefinition = "text[]")
    lateinit var tags: List<String>

    @OneToMany(mappedBy = "album", fetch = FetchType.LAZY, orphanRemoval = false)
    var songs: List<AlbumSong> = mutableListOf()

    override fun toString(): String {
        return "Album(id=$id, name='$name', artist=$artist, tags=$tags, songs=$songs)"
    }
}
