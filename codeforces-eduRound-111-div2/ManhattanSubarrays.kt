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

private class ManhattanSubarrays {
    fun solveTestCase() {
        //TODO: Solve the question

        val n = readInt()
        val nums = readIntArray()

        var result = 0L
        for (i in 0 until n) {
            val tempNums = mutableListOf<Int>()
            for (j in i until minOf((i + 4), n)) {
                tempNums.add(nums[j])
                if (check(tempNums)) result++
                else break
            }
        }

        outputWriter.println(result)
    }

    fun check(tempNums: MutableList<Int>): Boolean {

        val len = tempNums.size
        var a: Int
        var b: Int
        var c: Int
        for (i in 0 until len) {
            a = tempNums[i]
            for (j in (i + 1) until len) {
                b = tempNums[j]
                for (k in (j + 1) until len) {
                    c = tempNums[k]
                    if (b in a..c || b in c..a)
                        return false
                }
            }
        }

        return true
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        ManhattanSubarrays()
            .solveTestCase()
    }

    outputWriter.flush()
}