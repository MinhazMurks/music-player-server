package minhaz.musicplayerserver.api

import minhaz.musicplayerserver.api.response.FeedResponse
import minhaz.musicplayerserver.service.FeedService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("feed")
class FeedController(
    private val feedService: FeedService
) {
    @GetMapping()
    fun getFeed(): ResponseEntity<FeedResponse> {
        println(System.getenv())

        return ResponseEntity.ok().body(feedService.getDefaultUserFeed())
    }
}
