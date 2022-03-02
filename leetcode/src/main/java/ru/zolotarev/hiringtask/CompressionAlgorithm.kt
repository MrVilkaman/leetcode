package ru.zolotarev.hiringtask


// Задачка:
// Алгоритм сжатия
// Нужно реализовать такой алгоритм сжатия:

// AAAABBBCC -> 4A3B2C
// ABCDDDDDEEE -> ABC4D3E
// ABCDDDDDEEECC -> ABC4D3E2C
interface CompressionAlgorithm {

    fun compressString(str: String): String
}

class CompressionAlgorithmSber : CompressionAlgorithm {

    override fun compressString(str: String): String {

        if (str.isEmpty()) {
            return ""
        }

        var counter = 0
        var currentChar = str[0]


        val resultBuilder = StringBuilder()

        for (char in str) {

            if (char == currentChar) {
                counter++
            } else {
                resultBuilder.printChars(counter, currentChar)

                counter = 1
                currentChar = char
            }
        }
        // после цикла записать последние накопленные данные
        resultBuilder.printChars(counter, currentChar)

        return resultBuilder.toString()
    }

    private fun StringBuilder.printChars(counter: Int, currentChar: Char) {

        if (counter != 1) {
            append(counter.toString())
        }
        append(currentChar)
    }
}