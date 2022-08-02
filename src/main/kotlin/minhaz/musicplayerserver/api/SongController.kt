package minhaz.musicplayerserver.api

import minhaz.musicplayerserver.api.response.SongFeedResponse
import minhaz.musicplayerserver.service.SongService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/song")
class SongController(
    private val songService: SongService
) {
    @GetMapping("/feed")
    fun getFeed(): ResponseEntity<SongFeedResponse> {
        val response = songService.getFeed()
        return ResponseEntity.ok().body(response)
    }
}
