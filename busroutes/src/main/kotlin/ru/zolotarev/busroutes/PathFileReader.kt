package ru.zolotarev.busroutes

import java.io.File
import java.net.URI


interface PathFileReader {

    fun <T> readFile(uri: URI, block: (Sequence<String>) -> T): T
}

class PathFileReaderImpl : PathFileReader {

    override fun <T> readFile(uri: URI, block: (Sequence<String>) -> T): T {
        return File(uri).useLines(block = block)
    }
}