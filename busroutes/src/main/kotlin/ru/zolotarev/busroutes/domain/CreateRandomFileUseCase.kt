package ru.zolotarev.busroutes.domain

import java.io.BufferedWriter
import java.io.File
import kotlin.random.Random


class CreateRandomFileUseCase {

    companion object {
        const val MAX_STEP_COUNT = 1_000
    }

    operator fun invoke(fileName: String, lineCount: Int) {
        val file = File(fileName)
        if (file.exists()) {
            file.delete()
        }


        file.parentFile.mkdirs()
        if (!file.createNewFile()) {
            println("Can`t create New File")
            return
        }

        file.bufferedWriter().use { out ->
            out.generateFile(lineCount)
        }
        println("New File was created (${file.absolutePath})")
    }

    private fun BufferedWriter.generateFile(lineCount: Int) {
        val uniqueWay = LinkedHashSet<Int>(MAX_STEP_COUNT)
        val random = Random.Default
        val line = StringBuilder()

        for (wayId in 0 until lineCount) {
            line.append(wayId).append(' ')

            uniqueWay.clear()
            for (stepIndex in 0..MAX_STEP_COUNT) {
                val newValue = random.nextInt(0, Int.MAX_VALUE)
                // записываем только уникальные значения
                if (uniqueWay.add(newValue)) {
                    line.append(newValue).append(' ')
                }
            }
            line.removeSuffix(" ")
            // записываем в файл
            write(line.toString())
            newLine()

            // готовим буфер для новый строки
            line.clear()
        }
    }
}