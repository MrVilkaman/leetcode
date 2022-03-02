package ru.zolotarev

import junit.framework.TestCase
import org.assertj.core.api.Assertions
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized


@RunWith(Parameterized::class)
class IsSubsequenceTest(
    val subStr: String,
    val str: String,
    val result: Boolean
) : TestCase() {

    companion object {

        lateinit var case: IsSubsequence

        @BeforeClass
        @JvmStatic
        fun init() {
            case = IsSubsequenceSimpleImpl()
        }

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf("abc", "ahbgdc", true),
                arrayOf("axc", "ahbgdc", false),
                arrayOf("avb", "avb", true),

                arrayOf("", "", true),
                arrayOf("", "", true),
                arrayOf("abc", "", false),
                arrayOf("ab", "baab", true),
                arrayOf("leeeeetcode", "yyylyyeyyyyeyyyeyeyeyyytycyyyoydyye", true),
            )
        }
    }

    @Test
    fun testIsPalindrome() {

        val answer = case.isSubsequence(subStr, str)

        Assertions.assertThat(answer).isEqualTo(result)
    }
}