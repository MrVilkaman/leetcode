package ru.zolotarev.hiringtask

import junit.framework.TestCase
import org.assertj.core.api.Assertions
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized


@RunWith(Parameterized::class)
class DecryptStringFromAlphabetToIntegerMappingTest(
    val number: String,
    val result: String
) : TestCase() {

    companion object {

        lateinit var case: DecryptStringFromAlphabetToIntegerMapping

        @BeforeClass
        @JvmStatic
        fun init() {
            case = SberHiringImpl()
        }

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {

            return listOf(
                arrayOf("10#11#12", "jkab"),
                arrayOf("1326#", "acz"),
                arrayOf("111", "aaa"),
                arrayOf("110#", "aj"),
                arrayOf("10#10#", "jj"),
                arrayOf("", ""),
            )
        }
    }

    @Test
    fun testIsPalindrome() {

        val answer = case.freqAlphabets(number)

        Assertions.assertThat(answer).isEqualTo(result)
    }
}
