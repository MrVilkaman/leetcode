package ru.zolotarev.hiringtask


/** https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/ */
/** 226 ms	34.8 MB */
interface DecryptStringFromAlphabetToIntegerMapping {

    fun freqAlphabets(s: String): String

}


class SberHiringImpl : DecryptStringFromAlphabetToIntegerMapping {

    override fun freqAlphabets(s: String): String {
        if (s.isEmpty()) return ""

        val result = StringBuilder()
        var index = s.length - 1

        while (0 <= index) {
            if (s[index] == '#') {
                val numb = s.substring(index - 2, index).toInt()

                val char = numb.mapToChar()
                result.append(char)

                index -= 3
            } else {
                val char = Character.getNumericValue(s[index]).mapToChar()
                result.append(char)
                index--
            }
        }

        // делаем reverse так как исходную строку проходили с конца
        return result.reverse().toString()
    }

    private fun Int.mapToChar(): Char = ('a' + this - 1)
}