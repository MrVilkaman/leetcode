package ru.zolotarev.hiringtask

import org.assertj.core.api.Assertions
import org.junit.Test
import ru.zolotarev.hiringtask.FineEqualsTrees.Node


class FineEqualsTreesTest {


    @Test
    fun testFindSimilar() {

        val root = Node('A',
            Node('C',
                Node('A',
                    Node('B')),
                Node('D')
            ),
            Node('B',
                Node('A'),
                Node('D',
                    Node('B')
                )
            )
        )


        val findSimilar = FineEqualsTreesImpl().findSimilar(root)

        Assertions.assertThat(findSimilar).isNotNull
        Assertions.assertThat(findSimilar!!.first)
        Assertions.assertThat(findSimilar.second)
    }
}