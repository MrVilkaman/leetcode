package ru.zolotarev.busroutes

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import ru.zolotarev.busroutes.api.direct.directWayRoute
import ru.zolotarev.busroutes.domain.direct.ExistValidWayUseCase
import java.io.File


fun main(args: Array<String>) {

    val existValidWayUseCase = lazy { ExistValidWayUseCase(File("busroutes/src/main/assets/routes.txt")) }

    embeddedServer(Netty, port = 8080) {
        routing {
            get("/") {
                call.respondText("Hello, world!")
            }
            route("/api") {
                directWayRoute(existValidWayUseCase)
            }
        }
    }.start(wait = true)
}