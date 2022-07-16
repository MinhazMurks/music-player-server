package minhaz.musicplayerserver.api

import minhaz.musicplayerserver.api.response.ArtistFeedResponse
import minhaz.musicplayerserver.service.ArtistService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/artist")
class ArtistController(
    private val artistService: ArtistService
) {
    @GetMapping("/feed")
    fun getFeed(): ResponseEntity<ArtistFeedResponse> {
        return ResponseEntity.ok().body(artistService.getFeed())
    }
}
