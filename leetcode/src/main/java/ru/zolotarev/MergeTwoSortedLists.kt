package ru.zolotarev


/** https://leetcode.com/problems/merge-two-sorted-lists/ */
interface MergeTwoSortedLists {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode?
}

data class ListNode(var `val`: Int, var next: ListNode? = null)

/** 278 ms	36 MB*/
class MergeTwoSortedListsRecursive : MergeTwoSortedLists {

    override fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 != null) {
            return if (list2 == null) {
                ListNode(list1.`val`, mergeTwoLists(list1.next, null))
            } else {
                if (list1.`val` < list2.`val`) {
                    ListNode(list1.`val`, mergeTwoLists(list1.next, list2))
                } else {
                    ListNode(list2.`val`, mergeTwoLists(list1, list2.next))
                }
            }
        }

        if (list2 != null) {
            return ListNode(list2.`val`, mergeTwoLists(null, list2.next))
        }

        return null
    }
}

/** 160 ms	35 MB*/
class MergeTwoSortedListsWithModifySource : MergeTwoSortedLists {

    override fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        return when {
            list1 == null && list2 != null -> list2.also { it.next = mergeTwoLists(null, list2.next) }
            list1 != null && list2 == null -> list1.also { it.next = mergeTwoLists(list1.next, null) }
            list1 != null && list2 != null -> {
                if (list1.`val` < list2.`val`) {
                    list1.also { it.next = mergeTwoLists(list1.next, list2) }
                } else {
                    list2.also { it.next = mergeTwoLists(list1, list2.next) }
                }
            }
            else -> null
        }
    }
}
