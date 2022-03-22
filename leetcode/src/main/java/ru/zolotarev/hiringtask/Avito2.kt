package ru.zolotarev.hiringtask


//Дан массив целых чисел и целое число k. Найти k наиболее часто встречающихся элементов.
//Например, ввод: nums = [1,1,1,2,2,3], k = 2. Вывод: [1, 2]
interface Avito2 {
    fun topKByFrequency(nums: List<Int>, k: Int): List<Int>
}


// Время  O(N*logN + 2N + K)
// Память О(3N + 2K)

class Avito2Impl : Avito2 {
    override fun topKByFrequency(nums: List<Int>, k: Int): List<Int> {
        val someMap = HashMap<Int, Int>() // key - значение value - кол-во

        // O(N)
        for (value in nums) {
            val tempValue: Int? = someMap[value]
            someMap[value] = if (tempValue != null) tempValue + 1 else 1
        }

        //  1 -> 3
        //  2 -> 1
        //  3 -> 2

        return someMap
            .toList() // O(N)
            .sortedWith { t1: Pair<Int, Int>, t2: Pair<Int, Int> ->    // O(N*logN)
                when {
                    t1.second == t2.second -> 0
                    t1.second < t2.second -> 1
                    else -> -1
                }
            }
            //  1 -> 3
            //  3 -> 2
            //  2 -> 1
            .take(k)   // O(1)
            //  1 -> 3
            //  3 -> 2
            .map { it.first }  // O(K)
        //  [1,3]

    }
}
