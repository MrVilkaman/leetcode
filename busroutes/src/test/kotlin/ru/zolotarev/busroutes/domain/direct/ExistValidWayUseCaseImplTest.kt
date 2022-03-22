package ru.zolotarev.busroutes.domain.direct

import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions
import org.junit.Test
import ru.zolotarev.busroutes.DB_FILE_NAME
import java.io.File


class ExistValidWayUseCaseTest {

    private lateinit var useCase: ExistValidWayUseCase


    @Test
    fun simpleCase() {
        useCase = ExistValidWayUseCaseImpl(File("src/main/resources/$DB_FILE_NAME"))
        val result = runBlocking {
            useCase.invoke(3, 6)
        }

        Assertions.assertThat(result).isTrue
    }
}