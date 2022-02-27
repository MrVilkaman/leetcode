package ru.zolotarev

import org.assertj.core.api.Assertions
import org.junit.Test

class TwoSumProblemsTest {

    private val case: TwoSumProblems

    init {
        // case = TwoSumBrutforce()
        case = TwoSumWithSort()
    }

    @Test
    fun example1() {
        val nums: IntArray = intArrayOf(2, 7, 11, 15)
        val target = 9

        val result = case.twoSum(nums, target)

        Assertions.assertThat(result).containsExactly(0, 1)
    }

    @Test
    fun example2() {
        val nums: IntArray = intArrayOf(3, 2, 4)
        val target = 6

        val result = case.twoSum(nums, target)

        Assertions.assertThat(result).containsExactly(1, 2)
    }


    @Test
    fun example3() {
        val nums: IntArray = intArrayOf(3, 3)
        val target = 6

        val result = case.twoSum(nums, target)

        Assertions.assertThat(result).containsExactly(0, 1)
    }
}