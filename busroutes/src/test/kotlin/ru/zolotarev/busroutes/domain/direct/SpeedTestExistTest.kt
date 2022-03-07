package ru.zolotarev.busroutes.domain.direct

import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import ru.zolotarev.busroutes.DB_FILE_NAME
import java.io.File


@RunWith(Parameterized::class)
class SpeedTestExistTest(
    val x: Int,
    val y: Int,
    val res: Boolean
) : TestCase() {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf(3, 6, false),
                arrayOf(1583919729, 229791420, true),
            )
        }
    }

    @Test
    fun castToInt_impl() {
        val useCase = ExistValidWayUseCaseImpl(File("build/libs/$DB_FILE_NAME"), pathFinder = PathFinderImpl())
        val result = runBlocking {
            useCase.invoke(x, y)
        }

        Assertions.assertThat(result).isEqualTo(res)
    }

    @Test
    fun fast_impl() {
        val useCase = ExistValidWayUseCaseImpl(File("build/libs/$DB_FILE_NAME"), pathFinder = FastPathFinderImpl())
        val result = runBlocking {
            useCase.invoke(x, y)
        }

        Assertions.assertThat(result).isEqualTo(res)
    }

    @Test
    fun whileIteration_impl() {
        val useCase = ExistValidWayUseCaseImpl(File("build/libs/$DB_FILE_NAME"), pathFinder = CustomPathFinderImpl())
        val result = runBlocking {
            useCase.invoke(x, y)
        }

        Assertions.assertThat(result).isEqualTo(res)
    }
}