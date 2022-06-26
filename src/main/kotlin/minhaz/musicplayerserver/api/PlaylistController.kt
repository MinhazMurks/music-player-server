package minhaz.musicplayerserver.api

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/playlists")
class PlaylistController {

    @GetMapping("/test")
    fun testEndpoint(): ResponseEntity<String> {

        return ResponseEntity.ok().body("Hello World")
    }
}
