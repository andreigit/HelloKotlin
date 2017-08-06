import java.io.File
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

    try {
        val fileHelper = FileHelper()
        fileHelper.processFile(file)
    }
    catch (ex: Exception) {
        println("Error occurs during file processing: ${ex.message}")
        exitProcess(1)
    }

    exitProcess(0)
}

class FileHelper {
    fun processFile(file: File, charset: Charset = Charsets.UTF_8) {
        for (line in file.readLines(charset)) {
            println(line)
        }
    }
}