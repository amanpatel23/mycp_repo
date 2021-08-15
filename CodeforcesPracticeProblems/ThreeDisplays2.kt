/* 
    Author: Aman Patel
    Date: 15-08-2021
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

private const val iMax = (1e9).toInt()

private class ThreeDisplays2 {
    fun solveTestCase() {
        //TODO: Solve the question

        val n = readInt()
        val fontSizes = readIntArray(n)
        val costs = readIntArray(n)

        var result = iMax
        for (j in 1 until (n - 1)) {
            val mid = fontSizes[j]
            val midCost = costs[j]

            var leftCost = iMax
            for (i in 0 until j) {
                val left = fontSizes[i]
                if (left < mid)
                    leftCost = minOf(leftCost, costs[i])
            }

            var rightCost = iMax
            for (k in (j + 1) until n) {
                val right = fontSizes[k]
                if (right > mid)
                    rightCost = minOf(rightCost, costs[k])
            }

            result = minOf(result, (leftCost + midCost + rightCost))
        }

        out.println(if (result == iMax) "-1" else result)
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        ThreeDisplays2()
            .solveTestCase()
    }

    out.flush()
}