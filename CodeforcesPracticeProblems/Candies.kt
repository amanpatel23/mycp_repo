/* 
    Author: Aman Patel
    Date: 04-09-2021
*/

import java.io.PrintWriter
import java.util.StringTokenizer
import java.io.File
import kotlin.math.log2

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

private class Candies {

    fun solveTestCase() {
        //TODO: Solve the question

        val n = readInt()
        val nums = Array(n) { readInt() }

        val maxN = log2(n.toDouble()).toInt()
        val sparseTable = Array(n) { Array(maxN + 1) { Pair(-1, -1) } }

        fun preprocessing() {

            for ((i, num) in nums.withIndex()) {
                sparseTable[i][0] = Pair(0, num)
            }

            for (j in 1..maxN) {
                for (i in 0 until n) {
                    val idx = i + (1 shl (j - 1))
                    if (idx >= n || sparseTable[idx][j - 1].first == -1)
                        break

                    val tempSum = sparseTable[i][j - 1].second + sparseTable[idx][j - 1].second
                    val first = sparseTable[i][j - 1].first +
                            sparseTable[idx][j - 1].first +
                            if (tempSum >= 10) 1 else 0
                    val second = tempSum % 10

                    sparseTable[i][j] = Pair(first, second)
                }
            }
        }

        preprocessing()

        val q = readInt()
        repeat(q) {
            var (l, r) = readIntList()
            l--; r--;

            val len = r - l + 1
            val j = log2(len.toDouble()).toInt()

            val result = sparseTable[l][j].first
            out.println(result)
        }
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        Candies()
            .solveTestCase()
    }

    out.flush()
}