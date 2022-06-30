package minhaz.musicplayerserver.api

import minhaz.musicplayerserver.repository.PlaylistRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/playlists")
class PlaylistController(
    private val playlistRepository: PlaylistRepository
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
}
