package minhaz.musicplayerserver.model

import org.hibernate.annotations.Type
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "album")
class Album(
    @Column(name = "id")
    @Id
    val id: UUID,

    @Column(name = "artist")
    val artistUUID: UUID,

    @Column(name = "name")
    val name: String,

    @Column(name = "art")
    val art: String,

    @Type(type = "list-array")
    @Column(name = "tags", columnDefinition = "text[]")
    val tags: List<String>,
) {
    override fun toString(): String {
        return "Album(id=$id, name='$name', tags=$tags)"
    }
}
