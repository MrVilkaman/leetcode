package ru.zolotarev.busroutes.domain.direct

import org.assertj.core.api.Assertions
import org.junit.Test


class PathFinderTest {

    private val route: PathFinder = FastPathFinderImpl()

    @Test
    fun testRightWay() {

        val routeLines = arrayOf(
            "0 0 1 2 3 4 ",
            "1 3 1 6 5" ,
            "2 0 6 4 "
        ).asSequence()


        val result = route.existValidRoute(routeLines, 3, 6)

        Assertions.assertThat(result).isTrue
    }

    @Test
    fun testWrongWay_missRoute() {

        val routeLines = arrayOf(
            "0 0 1 2 3 4 ",
            "1 3 1 6 5 ",
            "2 0 6 4 "
        ).asSequence()


        val result = route.existValidRoute(routeLines, 10, 4)

        Assertions.assertThat(result).isFalse
    }

    @Test
    // Маршруты однонаправленные, т.е. если из А можно доехать до Б, то это не значит, что
    // этим же маршрутом можно доехать из Б до А.
    fun testWrongWay_missDirection() {

        val routeLines = arrayOf(
            "0 0 1 2 3 4 ",
            "1 3 1 6 5 ",
            "2 0 6 4 "
        ).asSequence()


        val result = route.existValidRoute(routeLines, 6, 3)

        Assertions.assertThat(result).isFalse
    }

    @Test
    fun testCheckRountId() {

        val routeLines = arrayOf(
            "0 0 1 2 3 4 ",
            "1 3 1 6 5 ",
            "2 0 6 4 "
        ).asSequence()


        val result = route.existValidRoute(routeLines, 2, 6)

        Assertions.assertThat(result).isFalse
    }

    @Test
    fun testEndNumber() {

        val routeLines = arrayOf(
            "0 0 1 2 3 4 ",
            "1 3 1 6 5 ",
            "2 0 6 4 "
        ).asSequence()


        val result = route.existValidRoute(routeLines, 0, 4)

        Assertions.assertThat(result).isTrue
    }

    @Test
    fun testBigNumber() {

        val routeLines = arrayOf(
            "0 0 10 2 3 40 ",
            "1 3 1 6 5 ",
            "2 0 6 9 "
        ).asSequence()


        val result = route.existValidRoute(routeLines, 0, 4)

        Assertions.assertThat(result).isFalse
    }


    @Test
    fun testBigNumber2() {

        val routeLines = arrayOf(
            "0 0 10 2 3 40 ",
            "1 3 1 6 5 ",
            "2 0 6 9 "
        ).asSequence()


        val result = route.existValidRoute(routeLines, 1, 4)

        Assertions.assertThat(result).isFalse
    }

    @Test
    fun testBigNumber3() {

        val routeLines = arrayOf(
            "0 0 21 2 3 24 6 ",
            "1 3 1 6 5 ",
            "2 0 6 9 "
        ).asSequence()


        val result = route.existValidRoute(routeLines, 1, 4)

        Assertions.assertThat(result).isFalse
    }
}