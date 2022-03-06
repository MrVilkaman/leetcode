package ru.zolotarev.busroutes

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import ru.zolotarev.busroutes.models.DirectResponse
import java.io.File


class Main(
    private val file: File = File("src/main/assets/routes.txt"),
    private val fileReader: PathFileReader = PathFileReaderImpl(),
    private val pathFinder: PathFinder = PathFinderImpl()
) {

    fun main(from: Int, to: Int): String {

        val answer = fileReader.readFile(file.toURI()) {
            val direct = pathFinder.existValidRoute(it, from, to)

            DirectResponse(from, to, direct)
        }

        return answer.toJson()
    }
}

fun main() {
    val main = Main(File("busroutes/src/main/assets/routes.txt"))
    embeddedServer(Netty, port = 8080) {
        routing {
            get("/") {
                call.respondText("Hello, world!")
            }
            get("/direct") {
                val request = call.request
                val from = request.queryParameters["from"]?.toInt()
                val to = request.queryParameters["to"]?.toInt()

                if (from == null || to == null) {

                    call.respond(HttpStatusCode(400, "Ожидаются параметры from и to"))
                    return@get
                }

                try {
                    val response = main.main(from, to)
                    call.respondText(response)
                } catch (e: Exception) {
                    call.respond(HttpStatusCode(500, e.toString()))
                }

            }
        }
    }.start(wait = true)
}