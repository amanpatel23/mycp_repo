/* 
    Author: Aman Patel
    Date: 27-09-2021
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

private class ChrisAndMagicSquare {
    fun solveTestCase() {
        //TODO: Solve the question

        val n = readInt()
        val square = Array(n) { Array(n) { -1L } }
        for (i in 0 until n) {
            square[i] = Array(n) { readLong() }
        }

        if (n == 1) {
            out.println(1)
            return
        }

        val unBlocked = mutableSetOf<Long>()
        val blocked = mutableSetOf<Long>()

        // rows
        for (i in 0 until n) {
            var flag = false
            var sum = 0L
            for (j in 0 until n) {
                if (square[i][j] == 0L)
                    flag = true
                sum += square[i][j]
            }
            if (flag) blocked.add(sum) else unBlocked.add(sum)
        }

        // columns
        for (j in 0 until n) {
            var flag = false
            var sum = 0L
            for (i in 0 until n) {
                if (square[i][j] == 0L)
                    flag = true
                sum += square[i][j]
            }
            if (flag) blocked.add(sum) else unBlocked.add(sum)
        }

        // diagonals
        var (i, j) = listOf(0, 0)
        var (flag1, flag2) = listOf(false, false)
        var (sum1, sum2) = listOf(0L, 0L)
        while (i < n) {
            // first
            if (square[i][j] == 0L)
                flag1 = true
            sum1 += square[i][j]

            // second
            if (square[i][n - j - 1] == 0L)
                flag2 = true
            sum2 += square[i][n - j - 1]

            i++; j++
        }

        if (flag1) blocked.add(sum1) else unBlocked.add(sum1)
        if (flag2) blocked.add(sum2) else unBlocked.add(sum2)

        out.println(if ((blocked.size == unBlocked.size) && (blocked.size == 1) && (unBlocked.first() - blocked.first() > 0)) (unBlocked.first() - blocked.first()) else -1)
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        ChrisAndMagicSquare()
            .solveTestCase()
    }

    out.flush()
}