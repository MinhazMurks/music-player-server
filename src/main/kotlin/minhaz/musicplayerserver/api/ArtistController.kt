package minhaz.musicplayerserver.api

import minhaz.musicplayerserver.api.response.ArtistFeedResponse
import minhaz.musicplayerserver.api.response.ArtistResponse
import minhaz.musicplayerserver.service.ArtistService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController()
@RequestMapping("/artist")
class ArtistController(
    private val artistService: ArtistService
) {
    @GetMapping("/feed")
    @ResponseBody
    fun getFeed(): ResponseEntity<ArtistFeedResponse> {
        val response = artistService.getFeed()
        return ResponseEntity.ok().body(response)
    }

    @GetMapping("/{artistUUID}")
    @ResponseBody
    fun getArtist(@PathVariable artistUUID: UUID): ResponseEntity<ArtistResponse> {
        val response = artistService.getArtist(artistUUID)
        return ResponseEntity.ok().body(response)
    }
}
