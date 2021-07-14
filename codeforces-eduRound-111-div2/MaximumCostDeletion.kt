import java.io.PrintWriter
import java.util.StringTokenizer
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

private class EDU111 {
    fun solveTestCase() {
        //TODO: Solve the question

        val (n, a, b) = readIntList()
        val s = readLn()

        if (b >= 0) {
            val result = n * (a + b)
            outputWriter.println(result)
        } else {

            val ones = mutableListOf<Int>()
            val zeroes = mutableListOf<Int>()

            var i = 0
            while (i < n) {
                val tempChar = s[i]
                var tempLen = 0
                while (i < n && s[i] == tempChar) {
                    tempLen++
                    i++
                }

                if (tempChar == '1') {
                    ones.add(tempLen)
                } else {
                    zeroes.add(tempLen)
                }
            }

            var result = 0
            if (zeroes.size <= ones.size) {
                for (x in zeroes) {
                    result += ((a * x) + b)
                }

                val onesLen = n - zeroes.sum()
                result += ((a * onesLen) + b)
            } else {
                for (x in ones) {
                    result += ((a * x) + b)
                }

                val zeroesLen = n - ones.sum()
                result += ((a * zeroesLen) + b)
            }

            outputWriter.println(result)
        }
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        EDU111()
            .solveTestCase()
    }

    outputWriter.flush()
}