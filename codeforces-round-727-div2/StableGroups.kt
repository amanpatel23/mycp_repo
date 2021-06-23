import java.io.PrintWriter
import java.util.StringTokenizer
import java.util.*
import java.io.File
import kotlin.math.ceil

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

private class StableGroups {
    fun solveTestCase(): Int {
        //TODO: Solve the question

        var (n, k, x) = readLongList()

        val eleList: List<Long> = readLongList().sorted()
        val resultArr = mutableListOf<Long>()
        for (i in 1 until n) {
            val temp: Long = eleList[i.toInt()] - eleList[(i - 1).toInt()]
            if (temp > x) {
                val toAdd = (eleList[i.toInt()] - eleList[(i - 1).toInt()] - 1) / x
                resultArr.add(toAdd)
            }
        }

        resultArr.sort()
        //outputWriter.println(resultArr)
        val len = resultArr.size
        var result = len + 1
        for (i in 0 until len) {
            k -= resultArr[i]
            if (k < 0)
                break
            else
                result -= 1
        }

        return result
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        outputWriter.println(
            StableGroups()
                .solveTestCase()
        )
    }

    outputWriter.flush()
}