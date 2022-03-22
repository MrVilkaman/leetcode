package ru.zolotarev.hiringtask

import junit.framework.TestCase
import org.assertj.core.api.Assertions
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Avito2Test(
    val list1: List<Int>,
    val k: Int,
    val result: List<Int>
) : TestCase() {

    companion object {

        lateinit var case: Avito2

        @BeforeClass
        @JvmStatic
        fun init() {
            case = Avito2Impl()
        }

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {

            return listOf(
                arrayOf(listOf(1, 1, 1, 2, 3, 3), 2, listOf(1, 3)),
                arrayOf(listOf(1, 1, 1), 1, listOf(1)),
                arrayOf(listOf(4, 2, 1, 1, 3, 2, 4), 2, listOf(1, 2)),
                arrayOf(listOf(4, 2, 1, 1, 3, 2, 4), 0, listOf<Int>()),
                arrayOf(listOf<Int>(), 0, listOf<Int>()),
            )
        }
    }

    @Test
    fun testIsPalindrome() {

        val answer = case.topKByFrequency(list1, k)

        Assertions.assertThat(answer).isEqualTo(result)
    }
}




