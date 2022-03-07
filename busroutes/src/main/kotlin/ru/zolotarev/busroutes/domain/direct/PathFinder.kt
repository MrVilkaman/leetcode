package ru.zolotarev.busroutes.domain.direct


interface PathFinder {
    /**
     * @param lines - Каждая строка состоит из идентификатор маршрута и идентификаторов остановок на
     * данном маршруте. Маршруты однонаправленные
     * @return true - если в lines есть строка в которые есть x и y */
    fun existValidRoute(lines: Sequence<String>, x: Int, y: Int): Boolean
}

class FastPathFinderImpl : PathFinder {

    override fun existValidRoute(lines: Sequence<String>, x: Int, y: Int): Boolean {

        val xStr = " $x "
        val yStr = " $y "

        val route = lines
            .find {
                val indexX = it.indexOf(xStr)
                val indexY = it.indexOf(yStr)

                indexX != -1 && indexY != -1 && indexX < indexY
            }

        return route != null
    }
}