package ru.zolotarev

import org.assertj.core.api.AbstractAssert
import org.assertj.core.api.Assertions
import org.junit.Test


class MergeTwoSortedListsImplTest {


    private val case: MergeTwoSortedLists

    init {
        // case = MergeTwoSortedListsRecursive()
        case = MergeTwoSortedListsWithModifySource()
    }

    @Test
    fun example1() {
        val list1 = ListNode(1, ListNode(2, ListNode(4)))
        val list2 = ListNode(1, ListNode(3, ListNode(4)))

        val result = case.mergeTwoLists(list1, list2)

        ListNodeAssert(result)
            .hasNext(1)
            .hasNext(1)
            .hasNext(2)
            .hasNext(3)
            .hasNext(4)
            .withoutNext(4)
    }

    @Test
    fun example2() {

        val result = case.mergeTwoLists(null, null)

        Assertions.assertThat(result).isNull()
    }

    @Test
    fun example3() {

        val result = case.mergeTwoLists(null, ListNode(0))

        ListNodeAssert(result).withoutNext(0)
    }

    @Test
    fun example4() {
        val list1 = ListNode(1, ListNode(2, ListNode(4)))
        val list2 = null

        val result = case.mergeTwoLists(list1, list2)

        ListNodeAssert(result)
            .hasNext(1)
            .hasNext(2)
            .withoutNext(4)
    }

    @Test
    fun example5() {
        val list1 = null
        val list2 = ListNode(1, ListNode(2, ListNode(4)))

        val result = case.mergeTwoLists(list1, list2)

        ListNodeAssert(result)
            .hasNext(1)
            .hasNext(2)
            .withoutNext(4)
    }

    @Test
    fun example6() {
        val list1 = ListNode(1, ListNode(2, ListNode(4)))
        val list2 = ListNode(3)

        val result = case.mergeTwoLists(list1, list2)

        ListNodeAssert(result)
            .hasNext(1)
            .hasNext(2)
            .hasNext(3)
            .withoutNext(4)
    }


}

private class ListNodeAssert(actual: ListNode?) : AbstractAssert<ListNodeAssert, ListNode>(actual, ListNodeAssert::class.java) {

    private fun checkValue(value: Int): ListNodeAssert {
        if (actual.`val` != value) {
            failWithMessage("Значения не совпадают: ${actual.`val`} вместо $value")
        }
        return this
    }


    fun hasNext(value: Int): ListNodeAssert {
        if (actual.next == null) {
            failWithMessage("Нет ссылки на следующий")
        }
        checkValue(value)
        return ListNodeAssert(actual.next)
    }

    fun withoutNext(value: Int): ListNodeAssert {
        if (actual.next != null) {
            failWithMessage("Следующего быть не должно: ${actual.next}")
        }
        checkValue(value)
        return this
    }
}