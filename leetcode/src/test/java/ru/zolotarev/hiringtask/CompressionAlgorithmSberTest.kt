package ru.zolotarev.hiringtask

import org.assertj.core.api.Assertions
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized


@RunWith(Parameterized::class)
class CompressionAlgorithmSberTest(
    private val value: String,
    private val result: String,
) {

    companion object {

        lateinit var case: CompressionAlgorithm

        @BeforeClass
        @JvmStatic
        fun init() {
            case = CompressionAlgorithmSber()
        }

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf("AAAABBBCC", "4A3B2C"),
                arrayOf("ABCDDDDDEEE", "ABC5D3E"),
                arrayOf("ABCDDDDDEEECC", "ABC5D3E2C"),
                arrayOf("", ""),
                arrayOf("AAAAA", "5A"),
            )
        }
    }

    @Test
    fun testIsPalindrome() {

        val answer = case.compressString(value)

        Assertions.assertThat(answer).isEqualTo(result)
    }
}