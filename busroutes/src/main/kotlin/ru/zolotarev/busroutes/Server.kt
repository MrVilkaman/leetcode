package ru.zolotarev.busroutes

import io.ktor.application.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import ru.zolotarev.busroutes.api.direct.directWayRoute
import ru.zolotarev.busroutes.domain.direct.ExistValidWayUseCase
import java.io.File


fun createAndStartServer(routesFilePath: String) {


    val existValidWayUseCase = lazy { ExistValidWayUseCase(File(routesFilePath)) }

    embeddedServer(Netty, port = 8080) {
        routing {
            get("/") {
                call.respondText("Hello, world!")
            }
            route("/api") {
                directWayRoute(existValidWayUseCase)
            }

            static("docs") {
                files("busroutes/src/main/assets/Test.pdf")
            }
        }
    }.start(wait = true)
}