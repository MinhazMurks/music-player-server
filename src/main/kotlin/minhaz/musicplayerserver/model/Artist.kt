package minhaz.musicplayerserver.model

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity()
@Table(name = "artist")
public class Artist(
    @Column(name = "id")
    @Id
    val id: UUID,

    @Column(name = "music_user")
    val musicUserUUID: UUID,

    @Column(name = "name")
    val name: String
) {
    override fun toString(): String {
        return "Artist(id=$id, name='$name')"
    }
}
