package ru.zolotarev.busroutes.domain.direct

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.zolotarev.busroutes.api.direct.DirectResponse
import java.io.File

class ExistValidWayUseCase(
    private val routeSheetFile: File = File("src/main/assets/routes.txt"),
    private val fileReader: PathFileReader = PathFileReaderImpl(),
    private val pathFinder: PathFinder = PathFinderImpl()
) {

    suspend fun main(from: Int, to: Int): String = withContext(Dispatchers.IO) {
        val block = fun(lines: Sequence<String>): DirectResponse {
            val direct = pathFinder.existValidRoute(lines, from, to)
            return DirectResponse(from, to, direct)
        }

        fileReader.readFile(routeSheetFile.toURI(), block)
            .toJson()
    }
}