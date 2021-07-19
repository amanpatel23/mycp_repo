/* 
    Author: Aman Patel
    Date: 19-07-2021
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

private const val int_max = (1e9).toInt()
private const val int_min = (-1e9).toInt()

private class PreparingOlympiad {
    fun solveTestCase() {
        //TODO: Solve the question

        val (n, l, r, x) = readIntList()
        val difficulties = readIntArray(n)

        fun check(totalProb: Int, totalDiff: Int, leastDiff: Int, maxDiff: Int): Boolean {

            if (!((totalProb >= 2) && (totalDiff in l..r) && (maxDiff - leastDiff >= x)))
                return false

            return true
        }

        fun totoalWays(i: Int, totalProb: Int, totalDiff: Int, leastDiff: Int, maxDiff: Int): Long {

            if (i == n) {
                if (check(totalProb, totalDiff, leastDiff, maxDiff))
                    return 1L

                return 0L
            }

            return totoalWays(i + 1, totalProb, totalDiff, leastDiff, maxDiff) +
                    totoalWays(
                        i + 1,
                        1 + totalProb,
                        difficulties[i] + totalDiff,
                        minOf(leastDiff, difficulties[i]),
                        maxOf(maxDiff, difficulties[i])
                    )
        }

        val result = totoalWays(0, 0, 0, int_max, int_min)
        out.println(result)
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        PreparingOlympiad()
            .solveTestCase()
    }

    out.flush()
}