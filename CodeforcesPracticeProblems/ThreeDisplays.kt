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

private const val iMin = (-1e9).toInt()
private const val iMax = (1e9).toInt()

private class ThreeDisplays {
    fun solveTestCase() {
        //TODO: Solve the question

        val n = readInt()
        val fontSizes = Array(n + 1) { 0 }
        fontSizes[0] = iMin
        for (i in 1..n)
            fontSizes[i] = readInt()

        val costs = Array(n + 1) { 0 }
        for (i in 1..n)
            costs[i] = readInt()

        val dp = Array(n + 1) { Array(3) { -1 } }
        var calls = 0
        fun smallestCost(i: Int, prevIdx: Int, count: Int): Int {
            calls++
            if (count == 3)
                return 0

            if (i > n)
                return iMax

            if (dp[prevIdx][count] != -1)
                return dp[prevIdx][count]

            if (fontSizes[i] <= fontSizes[prevIdx])
                return smallestCost(i + 1, prevIdx, count)

            dp[prevIdx][count] = minOf(
                smallestCost(i + 1, prevIdx, count),
                costs[i] + smallestCost(i + 1, i, count + 1)
            )

            return dp[prevIdx][count]
        }

        var result = smallestCost(1, 0, 0)
        out.println(if (result == iMax) "-1" else result)
        //out.println(calls)
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        ThreeDisplays()
            .solveTestCase()
    }

    out.flush()
}