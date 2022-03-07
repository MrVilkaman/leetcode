package ru.zolotarev.busroutes.domain.direct

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File

interface ExistValidWayUseCase {
    suspend fun invoke(from: Int, to: Int): Boolean
}

class ExistValidWayUseCaseImpl(
    private val routeSheetFile: File,
    private val fileReader: PathFileReader = PathFileReaderImpl(),
    private val pathFinder: PathFinder = FastPathFinderImpl()
) : ExistValidWayUseCase {

    override suspend fun invoke(from: Int, to: Int): Boolean = withContext(Dispatchers.IO) {

        fileReader.readFile(routeSheetFile.toURI()) { lines ->
            pathFinder.existValidRoute(lines, from, to)
        }
    }
}