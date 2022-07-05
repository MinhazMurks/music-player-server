package minhaz.musicplayerserver.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebServerConfiguration {

    @Value("\${cors.origin-patterns}")
    private val corsOriginPatterns: List<String> = mutableListOf()

    @Bean
    fun addCorsConfig(): WebMvcConfigurer {
        return object : WebMvcConfigurer {
            override fun addCorsMappings(registry: CorsRegistry) {
                corsOriginPatterns.forEach {
                    registry.addMapping("/**")
                        .allowedMethods("*")
                        .allowedOriginPatterns(it)
                        .allowCredentials(true)
                }
            }
        }
    }
}
