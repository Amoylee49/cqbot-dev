package org.web.data.extra

import io.vertx.core.Promise
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import org.web.data.extra.repository.CharacterRepository
import org.web.data.extra.repository.socket.SocketTask
import java.util.*

@SpringBootApplication
class WebDataExtraApplication

fun main(args: Array<String>) {
    runApplication<WebDataExtraApplication>(*args)
}

@Component
class initSocketVertX : CommandLineRunner {
    override fun run(vararg args: String?) {
        print("init CommandLineRunner")
        val repository = CharacterRepository()

        val socketTask = SocketTask(repository)
        socketTask.init(socketTask.vertx, null)
        val scanner = Scanner(System.`in`)
        var switch: Boolean = true

        while (scanner.hasNext()) {
            switch = false
            socketTask.start(Promise.promise())
            Thread.sleep(15_000)
        }
    }

}