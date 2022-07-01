package minhaz.musicplayerserver.model

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "user")
class User {
    @Column(name = "id")
    @Id
    lateinit var id: UUID

    @Column(name = "username")
    lateinit var username: String

    @Column(name = "email")
    lateinit var email: String
}
