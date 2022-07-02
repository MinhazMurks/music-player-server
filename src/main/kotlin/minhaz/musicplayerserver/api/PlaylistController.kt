package minhaz.musicplayerserver.api

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
@RequestMapping("/playlists")
class PlaylistController(
    private val playlistRepository: PlaylistRepository,
    private val songRepository: SongRepository,
    private val featureRepository: FeatureRepository,
    private val musicUserRepository: MusicUserRepository,
    private val artistRepository: ArtistRepository
) {

    @GetMapping("/test")
    fun testEndpoint(): ResponseEntity<String> {
        val playlists = playlistRepository.findAll()
        println(playlists.size)
        playlists.map {
            println(it)
        }
        return ResponseEntity.ok().body("Hello World")
    }

    @GetMapping("/test_get")
    fun test2Endpoint(): ResponseEntity<String> {
        println(songRepository.findAll())
        println(musicUserRepository.findAll())
        return ResponseEntity.ok().body("")
    }
}
