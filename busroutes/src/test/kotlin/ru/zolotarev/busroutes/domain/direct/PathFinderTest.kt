package ru.zolotarev.busroutes.domain.direct

import org.assertj.core.api.Assertions
import org.junit.Test


class PathFinderTest {

    private val route: PathFinder = PathFinderImpl()

    @Test
    fun testRightWay() {

        val routeLines = arrayOf(
            "0 0 1 2 3 4",
            "1 3 1 6 5",
            "2 0 6 4"
        ).asSequence()


        val result = route.existValidRoute(routeLines, 3, 6)

        Assertions.assertThat(result).isTrue
    }

    @Test
    fun testWrongWay_missRoute() {

        val routeLines = arrayOf(
            "0 0 1 2 3 4",
            "1 3 1 6 5",
            "2 0 6 4"
        ).asSequence()


        val result = route.existValidRoute(routeLines, 10, 4)

        Assertions.assertThat(result).isFalse
    }

    @Test
    // Маршруты однонаправленные, т.е. если из А можно доехать до Б, то это не значит, что
    // этим же маршрутом можно доехать из Б до А.
    fun testWrongWay_missDirection() {

        val routeLines = arrayOf(
            "0 0 1 2 3 4",
            "1 3 1 6 5",
            "2 0 6 4"
        ).asSequence()


        val result = route.existValidRoute(routeLines, 6, 3)

        Assertions.assertThat(result).isFalse
    }

    @Test
    fun testCheckRountId() {

        val routeLines = arrayOf(
            "0 0 1 2 3 4",
            "1 3 1 6 5",
            "2 0 6 4"
        ).asSequence()


        val result = route.existValidRoute(routeLines, 2, 6)

        Assertions.assertThat(result).isFalse
    }
}