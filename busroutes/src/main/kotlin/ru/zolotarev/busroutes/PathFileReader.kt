package ru.zolotarev.busroutes

import java.io.File
import java.net.URI


interface PathFileReader {

    fun readFile(uri: URI, block: (Sequence<String>) -> Unit)
}

class PathFileReaderImpl : PathFileReader {

    override fun readFile(uri: URI, block: (Sequence<String>) -> Unit) {
        File(uri).useLines(block = block)
    }
}