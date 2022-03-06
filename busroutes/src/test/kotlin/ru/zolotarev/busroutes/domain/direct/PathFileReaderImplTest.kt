package ru.zolotarev.busroutes.domain.direct

import org.assertj.core.api.Assertions
import org.junit.Test
import java.io.File


class PathFileReaderImplTest() {

    private val case: PathFileReader = PathFileReaderImpl()

    @Test
    fun testReadFile() {
        val toURI = File("src/main/assets/routes.txt").toURI()


        case.readFile(toURI) {
            val toList = it.toList()
            Assertions.assertThat(toList)
                .containsSequence(
                    "0 0 1 2 3 4",
                    "1 3 1 6 5",
                    "2 0 6 4"
                )
        }
    }
}