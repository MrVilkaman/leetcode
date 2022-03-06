package ru.zolotarev.busroutes


interface PathFinder {
    /**
     * @param lines - Каждая строка состоит из идентификатор маршрута и идентификаторов остановок на
     * данном маршруте. Маршруты однонаправленные
     * @return true - если в lines есть строка в которые есть x и y */
    fun existValidRoute(lines: Sequence<String>, x: Int, y: Int): Boolean
}

class PathFinderImpl : PathFinder {

    override fun existValidRoute(lines: Sequence<String>, x: Int, y: Int): Boolean {
        val route = lines
            .map {
                it.splitToSequence(' ')
                    .drop(1) // идентификатор маршрута
                    .map(String::toInt)
                    .filter { stepId -> stepId == x || stepId == y } // находим обе остановки
            }.find { steps ->

                // нам важен порядок
                if (steps.count() != 2) {
                    return@find false
                }
                steps.elementAt(0) == x && steps.elementAt(1) == y
            }

        return route != null
    }
}