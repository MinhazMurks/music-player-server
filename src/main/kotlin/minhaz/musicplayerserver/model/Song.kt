package minhaz.musicplayerserver.model

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
@Table(name = "song")
class Song(
    @Column(name = "id")
    @Id
    var id: UUID = UUID.randomUUID(),

    @Column(name = "audio_file")
    var audioFile: String,

    @Column(name = "name")
    var name: String,

    @Column(name = "length")
    var length: Int,

    @Column(name = "art")
    val art: String,

    @Column(name = "artist")
    val artistUUID: UUID,

    @ManyToOne
    @JoinColumn(name = "artist", referencedColumnName = "id", insertable = false, updatable = false)
    var artist: Artist,

    @Column(name = "explicit")
    val explicit: Boolean,

    @OneToMany
    @JoinTable(
        name = "feature",
        joinColumns = [JoinColumn(name = "Artist_id")],
        inverseJoinColumns = [JoinColumn(name = "Song_id")]
    )
    var featuredArtists: List<Artist>
) {

    override fun toString(): String {
        return "Song(id=$id, audioFile='$audioFile', name='$name')"
    }
}
