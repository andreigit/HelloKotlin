import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.nio.charset.Charset
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    println("Hello, Kotlin!")

    println("Input text file name:")

    var filePath: String?
    do {
       filePath = readLine()
    } while (filePath == null)

    val file = File(filePath)
    val fileHelper = FileHelper()

    try {
        fileHelper.processFile(file)
    }
    catch (ex: Exception) {
        println("Error occurs during file processing: ${ex.message}")
        exitProcess(1)
    }

    exitProcess(0)
}

class FileHelper {
    fun processFile(file: File/*, charset: Charset = Charsets.UTF_8*/) {
        // this code reads all lines at once
//        for (line in file.readLines(charset)) {
//            println(line)
//        }

        // this code reads all lines one by one
        val fileReader = FileReader(file)
        val bufferedReader = BufferedReader(fileReader)
        try {
            for (line in bufferedReader.lines()) {
                println(line)
            }
        }
        finally {
            bufferedReader.close()
            fileReader.close()
        }
    }
}