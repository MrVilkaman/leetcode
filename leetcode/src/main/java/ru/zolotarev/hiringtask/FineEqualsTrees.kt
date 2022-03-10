package ru.zolotarev.hiringtask


/**
 * Есть
// class Node {
//     char value; // 'A'-'Z'
//     Optional<Node> left;
//     Optional<Node> right;
// }
//
//       A
//     /   \
//    C     B
//   / \   / \
//   A D   A  D
//  /          \
// B            C


 */
interface FineEqualsTrees {

    data class Node(
        val value: Char, // 'A'-'Z'
        val left: Node? = null,
        val right: Node? = null
    )

    fun findSimilar(root: Node): Pair<Node, Node>?
}

typealias ResultPair = Pair<FineEqualsTrees.Node, String>

class FineEqualsTreesImpl : FineEqualsTrees {

    override fun findSimilar(root: FineEqualsTrees.Node): Pair<FineEqualsTrees.Node, FineEqualsTrees.Node>? {
        val result = ArrayList<ResultPair>()
        printValue(root, result)

        val list: List<ResultPair>? = result.groupBy { item ->
            item.second
        }.filterValues { 2 <= it.size }.values.firstOrNull()

        if (list == null) {
            return null
        }

        return list[0].first to list[1].first

    }

    // 11 -> ABCD
    // 21 -> ABCD
    // 22 -> ABCD
    // 31 -> AB
    // 32 -> D
    // 33 -> A
    // 34 -> DC
    // 41 -> B
    // 42 -> C

    // 41 -> B
    // 31 -> AB
    // 32 -> D
    // 21 -> ABCD


    private fun printValue(root: FineEqualsTrees.Node, result: MutableList<ResultPair>): MutableSet<Char> {
        val newSet = hashSetOf(root.value)

        if (root.left != null) {
            newSet += printValue(root.left, result)
        }

        if (root.right != null) {
            newSet += printValue(root.right, result)
        }

        result.add(root to newSet.printValue())

        return newSet
    }

    private fun MutableSet<Char>.printValue(): String {
        return this.toSortedSet().joinToString(separator = "") { it.toString() }
    }

}






