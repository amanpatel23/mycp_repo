import java.io.PrintWriter
import java.util.StringTokenizer
import java.util.*
import java.io.File

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

private class BallInBerland {
    fun solveTestCase(): Long {
        //TODO: Solve the question

        val (a, b, k) = readIntList()

        val boys = Array(a) { 0 }
        val girls = Array(b) { 0 }
        val pairs = Array(k) { Pair(-1, -1) }

        var temp: Int
        for (i in 0 until k) {
            temp = readInt()
            temp--
            boys[temp]++
            pairs[i] = Pair(temp, -1)
        }

        for (i in 0 until k) {
            temp = readInt()
            temp--
            girls[temp]++
            pairs[i] = Pair(pairs[i].first, temp)
        }

        var result = 0L
        var x = k
        for (i in 0 until k) {
            val ai = pairs[i].first
            val bi = pairs[i].second

            boys[ai]--
            girls[bi]--
            x--

            val ans: Int = x - boys[ai] - girls[bi]
            result += ans.toLong()
        }

        return result
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        outputWriter.println(
            BallInBerland()
                .solveTestCase()
        )
    }

    outputWriter.flush()
}