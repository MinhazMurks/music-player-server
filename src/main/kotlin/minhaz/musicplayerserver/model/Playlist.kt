package minhaz.musicplayerserver.model

import com.vladmihalcea.hibernate.type.array.ListArrayType
import org.hibernate.annotations.Type
import org.hibernate.annotations.TypeDef
import org.hibernate.annotations.TypeDefs
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "playlist")
@TypeDefs(
    TypeDef(name = "list-array", typeClass = ListArrayType::class)
)
class Playlist() {
    @Column(name = "id")
    @Id
    lateinit var id: UUID

    @Column(name = "name")
    lateinit var name: String

    @Column(name = "is_public")
    var isPublic: Boolean = false

    @Type(type = "list-array")
    @Column(name = "tags", columnDefinition = "text[]")
    lateinit var tags: List<String>

    override fun toString(): String {
        return "Playlist(id=$id, name='$name', isPublic=$isPublic, tags=$tags)"
    }
}
