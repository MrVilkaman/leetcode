package ru.zolotarev.hiringtask

import org.assertj.core.api.Assertions
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized


@RunWith(Parameterized::class)
class MaxOnesImplTest(
    val array: IntArray,
    val result: Int
) {

    companion object {

        lateinit var case: MaxOnes

        @BeforeClass
        @JvmStatic
        fun init() {
            case = MaxOnesYandexImpl()
        }

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf(intArrayOf(0, 0), 0),
                arrayOf(intArrayOf(1, 0), 1),
                arrayOf(intArrayOf(0, 1), 1),
                arrayOf(intArrayOf(1, 1), 1),
                arrayOf(intArrayOf(1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1), 5),
                arrayOf(intArrayOf(1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1), 6),
            )
        }
    }

    @Test
    fun testIsPalindrome() {

        val answer = case.maxOnes(array)

        Assertions.assertThat(answer).isEqualTo(result)
    }
}