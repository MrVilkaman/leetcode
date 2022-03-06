package ru.zolotarev.busroutes.api.direct

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import ru.zolotarev.busroutes.domain.direct.ExistValidWayUseCase


/** есть ли беспересадочный маршрут, соединяющий две указанные остановки, или нет. */
fun Route.directWayRoute(useCase: Lazy<ExistValidWayUseCase>) {

    get("direct") {
        val request = call.request
        val from = request.queryParameters["from"]?.toInt()
        val to = request.queryParameters["to"]?.toInt()

        if (from == null || to == null) {
            call.respond(HttpStatusCode.BadRequest.description("Expected parameters: \"from\" and \"to\""))
            return@get
        }

        try {
            val response = useCase.value.main(from, to)
            call.respondText(response)
        } catch (e: Exception) {
            // todo плохо во внешний мир отдавать инфу о внутреннией ошибке =(
            call.respond(HttpStatusCode.InternalServerError.description(e.toString()))
        }
    }
}