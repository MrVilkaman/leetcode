package ru.zolotarev.hiringtask

//Нужно слить 2 отсортированных массива в один отсортированный массив.
//Например, ввод [1, 2, 5], [1, 2, 3, 4, 6]. Вывод [1, 1, 2, 2, 3, 4, 5, 6]
interface Avito1 {

    fun merge(first: List<Int>, second: List<Int>): List<Int>
}

class Avito1Impl : Avito1 {
    override fun merge(first: List<Int>, second: List<Int>): List<Int> {
        if (first.isEmpty()) return second
        if (second.isEmpty()) return first

        var indexFirst = 0
        var indexSecond = 0

        val result = ArrayList<Int>(first.size + second.size)

        while (indexFirst < first.size || indexSecond < second.size) {
            val valueFisrt: Int? = first.getOrNull(indexFirst)
            val valueSecond: Int? = second.getOrNull(indexSecond)

            if (valueFisrt != null && valueSecond != null) {
                if (valueFisrt < valueSecond) {
                    result.add(valueFisrt)
                    indexFirst++
                } else {
                    result.add(valueSecond)
                    indexSecond++
                }
            } else if (valueSecond != null) {
                result.add(valueSecond)
                indexSecond++
            } else if (valueFisrt != null) {
                result.add(valueFisrt)
                indexFirst++
            }
        }

        return result
    }
}