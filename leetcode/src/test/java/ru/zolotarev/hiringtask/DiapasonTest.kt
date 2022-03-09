package ru.zolotarev.hiringtask

import junit.framework.TestCase
import org.assertj.core.api.Assertions
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized


@RunWith(Parameterized::class)
class DiapasonTest(
    val numbers: IntArray,
    val result: String
) : TestCase() {

    companion object {

        lateinit var case: Diapasons

        @BeforeClass
        @JvmStatic
        fun init() {
            case = Diapasons()
        }

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {

            return listOf(
                arrayOf(intArrayOf(1, 4, 5, 2, 3, 9, 8, 11, 0), "0-5,8-9,11"),
                arrayOf(intArrayOf(10, 20, 30, 40), "10,20,30,40"),
                arrayOf(intArrayOf(3, 1, 4, 2), "1-4"),
                arrayOf(intArrayOf(1, 4, 2), "1-2,4"),
                arrayOf(intArrayOf(4), "4"),
                arrayOf(intArrayOf(), ""),
            )
        }
    }

    @Test
    fun testConvert() {

        val answer = case.convert(numbers)

        Assertions.assertThat(answer).isEqualTo(result)
    }
}
