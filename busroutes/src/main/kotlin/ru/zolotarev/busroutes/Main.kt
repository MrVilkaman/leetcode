package ru.zolotarev.busroutes


fun main(args: Array<String>) {

    val firstArg = args.getOrNull(0)

    when {
        firstArg in arrayOf("-h", "help") -> showHelp()
        firstArg in arrayOf("-r", "routes") -> showAllRoutes()
        firstArg != null -> createAndStartServer(firstArg)
        else -> throw IllegalArgumentException("Expected one arg with path to folder with ${DB_FILE_NAME}. For more info use -h")
    }
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
    println("")
    println("Version 0.1")
}