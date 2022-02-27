package ru.zolotarev

/**
 * Описание задания:  https://leetcode.com/problems/two-sum/
 * */
interface TwoSumProblems {
    fun twoSum(nums: IntArray, target: Int): IntArray
}

/** Результат 402 ms 40.8 MB */
class TwoSumBrutforce : TwoSumProblems {

    override fun twoSum(nums: IntArray, target: Int): IntArray {

        nums.forEachIndexed { index, value1 ->

            for (j in index + 1 until nums.size) {
                if (value1 + nums[j] == target) {
                    return intArrayOf(index, j)
                }
            }
        }


        return intArrayOf()
    }
}

/** Результат 	236 ms	39 MB */
class TwoSumWithSort : TwoSumProblems {

    override fun twoSum(nums: IntArray, target: Int): IntArray {

        // сортируем по возрастанию, с запоминанием исходных индексов
        val numsMap = nums.mapIndexed { index, value ->
            index to value
        }.sortedBy(Pair<Int, Int>::second)

        // будем проходить с двух сторон на встречу по отсортированному массиву
        var left = 0
        var right = numsMap.size - 1

        while (true) {
            val pairLeft = numsMap[left]
            val pairRight = numsMap[right]
            val maybeValue = pairLeft.second + pairRight.second

            if (maybeValue == target) {
                return intArrayOf(pairLeft.first, pairRight.first)
            }
            // если встретились на одном элементе, значие решение нет
            if (pairLeft.first == pairRight.first) {
                break
            }

            if (maybeValue < target) {
                left++
            } else {
                right--
            }
        }

        return intArrayOf()
    }
}