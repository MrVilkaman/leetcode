package ru.zolotarev.busroutes.domain.direct

@Deprecated("не эффективный")
class PathFinderImpl : PathFinder {

    override fun existValidRoute(lines: Sequence<String>, x: Int, y: Int): Boolean {
        val route = lines
            .map {
                it.splitToSequence(' ')
                    .drop(1) // идентификатор маршрута
                    .filter(String::isNotEmpty)
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

@Deprecated("не эффективный")
class CustomPathFinderImpl : PathFinder {

    override fun existValidRoute(lines: Sequence<String>, x: Int, y: Int): Boolean {

        val xStr = x.toString()
        val yStr = y.toString()


        val route = lines
            .find { thisLine ->

                var isXFound = false

                var isFirstWasSkipped = false

                var mainIndex = 0

                while (mainIndex < thisLine.length) {
                    if (!isXFound && thisLine[mainIndex] == xStr[0]) {

                        if (isFirstWasSkipped && thisLine[mainIndex - 1] == ' ') {
                            var subIndex = 0
                            while (subIndex <= xStr.length) {
                                if (subIndex == xStr.length) {
                                    val i = mainIndex + subIndex
                                    if (i < thisLine.length && thisLine[i] == ' ') {
                                        isXFound = true
                                        mainIndex != subIndex
                                    }
                                    break
                                }

                                if (xStr[subIndex] != thisLine[mainIndex + subIndex]) {
                                    break
                                }

                                subIndex++
                            }
                        }

                    }

                    if (isXFound && thisLine[mainIndex] == yStr[0] && thisLine[mainIndex - 1] == ' ') {

                        var subIndex = 0
                        while (subIndex <= yStr.length) {

                            if (subIndex == yStr.length) {
                                val i = mainIndex + subIndex

                                if (thisLine.length == i || (i < thisLine.length && thisLine[i] == ' ')) {
                                    return@find true
                                } else {
                                    break
                                }
                            }

                            if (yStr[subIndex] != thisLine[mainIndex + subIndex]) {
                                break
                            }

                            subIndex++
                        }
                    }

                    if (!isFirstWasSkipped && thisLine[mainIndex] == ' ') {
                        isFirstWasSkipped = true
                    }

                    mainIndex++
                }

                false
            }

        return route != null
    }
}