package minhaz.musicplayerserver.api

import minhaz.musicplayerserver.model.Playlist
import minhaz.musicplayerserver.repository.ArtistRepository
import minhaz.musicplayerserver.repository.FeatureRepository
import minhaz.musicplayerserver.repository.MusicUserRepository
import minhaz.musicplayerserver.repository.PlaylistRepository
import minhaz.musicplayerserver.repository.SongRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("feed")
class FeedController(
    private val playlistRepository: PlaylistRepository,
    private val songRepository: SongRepository,
    private val featureRepository: FeatureRepository,
    private val musicUserRepository: MusicUserRepository,
    private val artistRepository: ArtistRepository
) {
    @GetMapping()
    fun getFeed(): ResponseEntity<List<Playlist>> {
        println(System.getenv())

        return ResponseEntity.ok().body(playlistRepository.findAll())
    }
}
