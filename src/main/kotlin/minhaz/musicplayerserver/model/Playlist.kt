package minhaz.musicplayerserver.model

import com.vladmihalcea.hibernate.type.array.ListArrayType
import org.hibernate.annotations.Type
import org.hibernate.annotations.TypeDef
import org.hibernate.annotations.TypeDefs
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "playlist")
@TypeDefs(
    TypeDef(name = "list-array", typeClass = ListArrayType::class)
)
class Playlist(
    @Column(name = "id")
    @Id
    val id: UUID,

    @Column(name = "creator")
    val creatorUUID: UUID,

    @Column(name = "name")
    val name: String,

    @Column(name = "art")
    val art: String,

    @Column(name = "is_public")
    val isPublic: Boolean = false,

    @Type(type = "list-array")
    @Column(name = "tags", columnDefinition = "text[]")
    val tags: List<String>
) {
    override fun toString(): String {
        return "Playlist(id=$id, name='$name', isPublic=$isPublic, tags=$tags)"
    }
}
