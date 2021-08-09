/* 
    Author: Aman Patel
    Date: 09-08-2021
*/

import java.io.PrintWriter
import java.util.StringTokenizer
import java.io.File

private val checkOnlineJudge = System.getProperty("ONLINE_JUDGE") == null
private val INPUT = if (checkOnlineJudge) File("src/input.txt").inputStream() else System.`in`
private val OUTPUT = if (checkOnlineJudge) File("src/output.txt").outputStream() else System.out

private val bufferedReader = INPUT.bufferedReader()
private val out = PrintWriter(OUTPUT, false)
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

private const val iMax = 1e9.toInt()

private class CandyBox {
    fun solveTestCase() {
        //TODO: Solve the question

        val n = readInt()

        val typeToFreq = mutableMapOf<Int, Int>()
        for (i in 0 until n) {
            val type = readInt()
            typeToFreq.putIfAbsent(type, 0)
            typeToFreq[type] = typeToFreq[type]!! + 1
        }

        val sortedMap = typeToFreq.toList().sortedByDescending { (_, v) -> v }.toMap()

        var result = 0
        var prev = iMax
        for ((_, v) in sortedMap) {
            val toTake = maxOf(0, minOf(prev - 1, v))
            result += toTake
            prev = toTake
        }

        out.println(result)
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        CandyBox()
            .solveTestCase()
    }

    out.flush()
}