package ru.zolotarev.busroutes

import ru.zolotarev.busroutes.models.DirectResponse
import java.io.File


class Main(
    private val fileReader: PathFileReader = PathFileReaderImpl(),
    private val pathFinder: PathFinder = PathFinderImpl()
) {

    fun main(from: Int, to: Int) {

        val toURI = File("src/main/assets/routes.txt").toURI()
        val answer = fileReader.readFile(toURI) {
            val direct = pathFinder.existValidRoute(it, from, to)

            DirectResponse(from, to, direct)
        }

        println(answer.toJson())
    }
}