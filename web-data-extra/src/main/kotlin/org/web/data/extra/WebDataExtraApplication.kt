package org.web.data.extra

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WebDataExtraApplication

fun main(args: Array<String>) {
    runApplication<WebDataExtraApplication>(*args)
}

@Volatile
var switch: Boolean = true

/*@Component
class InitSocketVertX : CommandLineRunner {
    override fun run(vararg args: String?) {
        print("init CommandLineRunner")
        val repository = CharacterRepository()

        val socketTask = SocketTask(repository)
        socketTask.init(socketTask.vertx, null)
        val scanner = Scanner(System.`in`)

//        @Volatile
//        val num = 0

        while (switch && scanner.hasNextLine()) {
            print("scnner heart beat=====$switch")
            switch = false
            socketTask.start(Promise.promise())
//            Thread.sleep(15_000)
        }

//        Thread {
//            while (true){
//                print("heart beat=====")
//                TimeUnit.SECONDS.sleep(3)
//                switch = true
//            }
//        }
    }

}*/