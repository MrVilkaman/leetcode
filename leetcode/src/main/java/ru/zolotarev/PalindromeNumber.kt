package ru.zolotarev


/** https://leetcode.com/problems/palindrome-number */
interface PalindromeNumber {
    fun isPalindrome(x: Int): Boolean
}

/** 208 ms	35.2 MB*/
class PalindromeNumberNoStrings : PalindromeNumber {
    override fun isPalindrome(x: Int): Boolean {

        if (x < 0) {
            return false
        }

        val buffer = ArrayList<Byte>(10)

        var currentX = x
        do {
            val currentRightNum = currentX % 10
            buffer.add(currentRightNum.toByte()) // добавляем в обратном порядке, но кажется не важно

            currentX /= 10
        } while (currentX != 0)

        val length = buffer.size
        // проходим только одну половину массива
        for (index in 0 until (length / 2)) {

            val lastIndex = length - index - 1 // индекс последнего элемента
            if (buffer[index] != buffer[lastIndex]) {
                return false
            }
        }

        return true
    }
}


/** 440 ms	39.4 MB */
class PalindromeNumberStringConvertor : PalindromeNumber {
    override fun isPalindrome(x: Int): Boolean {
        val stringValue = x.toString()

        val length = stringValue.length
        // проходим только одну половину массива
        for (index in 0 until (length / 2)) {

            val lastIndex = length - index - 1 // индекс последнего элемента
            if (stringValue[index] != stringValue[lastIndex]) {
                return false
            }
        }

        return true
    }
}
