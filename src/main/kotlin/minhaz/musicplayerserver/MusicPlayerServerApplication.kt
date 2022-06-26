package minhaz.musicplayerserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MusicPlayerServerApplication

fun main(args: Array<String>) {
    runApplication<MusicPlayerServerApplication>(*args)
}
