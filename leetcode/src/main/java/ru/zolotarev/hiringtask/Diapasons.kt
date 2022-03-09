package ru.zolotarev.hiringtask


/**
Реализовать отображение некого диапозона целых положительных чисел, в человеко читаемомо виде:
[1,4,5,2,3,9,8,11,0] => "0-5,8-9,11"
[10,20,30,40] => "10,20,30,40"
[3,1,4,2] => "1-4"
 */
class Diapasons {

    // память O(N)
    // Время o(n*logn)
    fun convert(origin: IntArray): String {

        if (origin.isEmpty()) {
            return ""
        }

        val source = origin.clone().also { it.sort() }

        val result = StringBuilder()
        var leftIndex = 0

        for (index in 1 until source.size) {
            val rightIndex = index - 1
            val diff = source[index] - source[rightIndex]

            if (2 <= diff) {
                result.printValue(source[leftIndex], source[rightIndex])
                leftIndex = index
            }
        }
        val rightIndex = source.size - 1

        result.printValue(source[leftIndex], source[rightIndex])

        return result.trimEnd(',').toString()

    }

    private fun StringBuilder.printValue(leftValue: Int, rightValue: Int) {
        if (leftValue != rightValue) {
            append("${leftValue}-${rightValue},")
        } else {
            append("${rightValue},")
        }
    }
}