package ru.zolotarev


/** https://leetcode.com/problems/is-subsequence/ */
interface IsSubsequence {

    fun isSubsequence(s: String, t: String): Boolean
}

/** 140 ms	33.7 MB */
class IsSubsequenceSimpleImpl : IsSubsequence {

    override fun isSubsequence(s: String, t: String): Boolean {
        if (s.isEmpty()) return true

        if (t.isEmpty()) return false

        // если подстрока больше чем исходная строка, то не смысла искать дальше
        if (t.length < s.length) return false

        var subsIndex = 0

        for (char in t) {
            if (char == s[subsIndex]) {
                subsIndex++
            }
            if (subsIndex == s.length) {
                return true
            }
        }

        return false
    }
}

