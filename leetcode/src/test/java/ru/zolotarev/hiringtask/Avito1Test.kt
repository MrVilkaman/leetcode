package ru.zolotarev.hiringtask

import junit.framework.TestCase
import org.assertj.core.api.Assertions
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized


@RunWith(Parameterized::class)
class Avito1Test(
    val list1: List<Int>,
    val list2: List<Int>,
    val result: List<Int>
) : TestCase() {

    companion object {

        lateinit var case: Avito1

        @BeforeClass
        @JvmStatic
        fun init() {
            case = Avito1Impl()
        }

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {

            return listOf(
                arrayOf(listOf(1, 2, 5), listOf(1, 2, 3, 4, 6), listOf(1, 1, 2, 2, 3, 4, 5, 6)),
                arrayOf(listOf(2, 3), listOf(1, 4), listOf(1, 2, 3, 4)),
                arrayOf(listOf<Int>(), listOf<Int>(), listOf<Int>()),
                arrayOf(listOf(1, 2), listOf<Int>(), listOf(1, 2)),
                arrayOf(listOf<Int>(), listOf(1, 2), listOf(1, 2)),
            )
        }
    }

    @Test
    fun testIsPalindrome() {

        val answer = case.merge(list1, list2)

        Assertions.assertThat(answer).isEqualTo(result)
    }
}
