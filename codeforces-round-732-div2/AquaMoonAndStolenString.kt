import java.io.PrintWriter
import java.util.StringTokenizer
import java.util.*
import java.io.File
import java.lang.StringBuilder

private val checkOnlineJudge = System.getProperty("ONLINE_JUDGE") == null
private val INPUT = if (checkOnlineJudge) File("src/input.txt").inputStream() else System.`in`
private val OUTPUT = if (checkOnlineJudge) File("src/output.txt").outputStream() else System.out

private val bufferedReader = INPUT.bufferedReader()
private val outputWriter = PrintWriter(OUTPUT, false)
private fun readLn() = bufferedReader.readLine()!!

private fun readList() = readLn().split(' ')
private var tokenizer = StringTokenizer("")
private fun read(): String {
    while (tokenizer.hasMoreTokens().not()) tokenizer = StringTokenizer(readLn(), " ")
    return tokenizer.nextToken()
}

private fun readInt() = read().toInt()
private fun readLong() = read().toLong()
private fun readDouble() = read().toDouble()

private fun readIntList() = readList().map { it.toInt() }
private fun readLongList() = readList().map { it.toLong() }
private fun readDoubleList() = readList().map { it.toDouble() }

private fun readIntArray(n: Int = 0) =
    if (n == 0) readList().run { IntArray(size) { get(it).toInt() } } else IntArray(n) { readInt() }

private fun readLongArray(n: Int = 0) =
    if (n == 0) readList().run { LongArray(size) { get(it).toLong() } } else LongArray(n) { readLong() }

private fun readDoubleArray(n: Int = 0) =
    if (n == 0) readList().run { DoubleArray(size) { get(it).toDouble() } } else DoubleArray(n) { readDouble() }

private class AquaMoonAndStolenString {
    fun solveTestCase(): String {
        //TODO: Solve the question

        val (n, m) = readIntList()
        val freq = Array(m) { IntArray(26) { 0 } }

        for (i in 0 until n) {
            val str = readLn()
            for (j in 0 until m) {
                val idx = str[j] - 'a'
                freq[j][idx]++
            }
        }

        for (i in 0 until (n - 1)) {
            val str = readLn()
            for (j in 0 until m) {
                val idx = str[j] - 'a'
                freq[j][idx]--
            }
        }

        var result = StringBuilder()
        for (i in 0 until m) {
            for (j in 0 until 26) {
                if (freq[i][j] > 0) {
                    result.append('a' + j)
                    break
                }
            }
        }


        return result.toString()
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        outputWriter.println(
            AquaMoonAndStolenString()
                .solveTestCase()
        )
    }

    outputWriter.flush()
}