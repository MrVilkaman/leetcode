package ru.zolotarev

import junit.framework.TestCase
import org.assertj.core.api.Assertions
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class PalindromeNumberTest(
    val number: Int,
    val result: Boolean
) : TestCase() {

    companion object {

        lateinit var case: PalindromeNumber

        @BeforeClass
        @JvmStatic
        fun init() {
            // case = PalindromeNumberStringConvertor()
            case = PalindromeNumberNoStrings()
        }

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf(0, true),
                arrayOf(121, true),
                arrayOf(-121, false),
                arrayOf(10, false),
                arrayOf(123454321, true),
                arrayOf(12344321, true),
            )
        }
    }

    @Test
    fun testIsPalindrome() {

        val answer = case.isPalindrome(number)

        Assertions.assertThat(answer).isEqualTo(result)
    }
}