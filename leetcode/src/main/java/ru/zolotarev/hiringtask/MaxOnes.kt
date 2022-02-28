package ru.zolotarev.hiringtask

import kotlin.math.max


/**
 * Дан массив из нулей и единиц. Нужно определить, какой максимальный по длине подинтервал единиц можно получить,
 * удалив ровно один элемент массива.
 * maxOnes(new int[]{0, 0}) == 0
 * maxOnes(new int[]{1, 0}) == 1
 * maxOnes(new int[]{0, 1}) == 1
 * maxOnes(new int[]{1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1}) == 5
 * maxOnes(new int[]{1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1}) == 6
 *
 * Удалять один элемент из массива обязательно.
 * Требуется решение без дополнительной памяти - O(1), и за линейное время - O(N), исходный массив менять нельзя
 */
interface MaxOnes {

    fun maxOnes(arr: IntArray): Int
}

class MaxOnesYandexImpl : MaxOnes {

    override fun maxOnes(arr: IntArray): Int {
        var maxInterval = 0
        var currentInterval = 0
        var maybeMaxInterval = 0

        for (i in 0 until arr.size) {
            val value = arr[i]

            if (value == 1) {
                currentInterval++
            } else {
                maxInterval = max(maxInterval, maybeMaxInterval + currentInterval)
                maybeMaxInterval = currentInterval
                currentInterval = 0
            }

        }

        maxInterval = max(maxInterval, maybeMaxInterval + currentInterval)
        maybeMaxInterval = currentInterval
        currentInterval = 0

        if (maxInterval == arr.size) {
            maxInterval--
        }


        return maxInterval
    }
}