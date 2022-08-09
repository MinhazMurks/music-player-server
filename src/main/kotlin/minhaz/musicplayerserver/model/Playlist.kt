package minhaz.musicplayerserver.model

import com.vladmihalcea.hibernate.type.array.ListArrayType
import org.hibernate.annotations.Type
import org.hibernate.annotations.TypeDef
import org.hibernate.annotations.TypeDefs
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
@Table(name = "playlist")
@TypeDefs(
    TypeDef(name = "list-array", typeClass = ListArrayType::class)
)
class Playlist(
    @Column(name = "id")
    @Id
    val id: UUID,

    @ManyToOne
    @JoinColumn(name = "creator", referencedColumnName = "id")
    val creator: MusicUser,

    @Column(name = "name")
    val name: String,

    @Column(name = "art")
    val art: String,

    @Column(name = "is_public")
    val isPublic: Boolean = false,

    @Type(type = "list-array")
    @Column(name = "tags", columnDefinition = "text[]")
    val tags: List<String>,

    @OneToMany
    @JoinTable(
        name = "playlist_song",
        joinColumns = [JoinColumn(name = "song", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "playlist", referencedColumnName = "id")]
    )
    val songs: List<Song>
) {
    override fun toString(): String {
        return "Playlist(id=$id, name='$name', isPublic=$isPublic, tags=$tags)"
    }
}
