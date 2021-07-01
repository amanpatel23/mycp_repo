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

private class Sweets {
    fun solveTestCase(): Int {
        //TODO: Solve the question

        val (n, k) = readIntList()
        val str = read()

        val qq: Queue<Int> = LinkedList()
        var liked = 0
        for (i in 0 until n) {
            if (str[i] == '1')
                liked += 1

            qq.add(i)
        }

        var maxEaten = 0
        if (liked >= 1) {
            if (str[qq.poll()] == '1')
                liked -= 1

            maxEaten += 1
        }

        while (qq.isNotEmpty() && liked > 0) {
            for (i in 1 until k) {
                val ele = qq.poll()
                qq.add(ele)
            }

            if (str[qq.poll()] == '1')
                liked -= 1

            maxEaten += 1
        }

        return maxEaten
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        outputWriter.println(
            Sweets()
                .solveTestCase()
        )
    }

    outputWriter.flush()
}