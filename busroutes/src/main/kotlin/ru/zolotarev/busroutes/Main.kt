package ru.zolotarev.busroutes

import ru.zolotarev.busroutes.domain.CreateRandomFileUseCase
import kotlin.random.Random


fun main(args: Array<String>) {

    val firstArg = args.getOrNull(0)

    when {
        firstArg in arrayOf("-h", "help") -> showHelp()
        firstArg in arrayOf("-r", "routes") -> showAllRoutes()
        firstArg in arrayOf("-g", "generate") -> generateFile(args.getOrNull(1), args.getOrNull(2))
        firstArg != null -> createAndStartServer(firstArg)
        else -> throw IllegalArgumentException("Expected one arg with path to folder with ${DB_FILE_NAME}. For more info use -h")
    }
}

fun generateFile(countStr: String?, path: String?) {
    val count = countStr?.toIntOrNull() ?: throw IllegalArgumentException("Expected lines count. For more info use -h")
    path ?: throw IllegalArgumentException("Expected  path to folder with ${DB_FILE_NAME}. For more info use -h")

    CreateRandomFileUseCase().invoke("$path/$DB_FILE_NAME", count)
}

private fun showAllRoutes() {
    println("*****")
    println("/")
    println("/api/direct //  direct route connecting the two specified stops or not.")
    println("   QueryParams: 'from', 'to' //  direct route connecting the two specified stops or not.")
    println("/docs // Show test description")
    println("*****")

}

private fun showHelp() {
    println("For start using server pass path to file with routes as first args.")
    println("For show all available routes use \"-r\"")
    println("For generate new file with routes use \"-g\" 1000 ")
    println("")
    println("Version 0.1")
}