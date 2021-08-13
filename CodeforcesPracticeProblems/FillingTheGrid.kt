/* 
    Author: Aman Patel
    Date: 13-08-2021
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

private const val mod = (1e9 + 7).toLong()
private fun pow(a: Long, b: Long): Long {
    var (a, b) = listOf(a, b)
    var result = 1L
    while (b > 0) {
        if ((b and 1L) != 0L) {
            result = result * a % mod
        }

        a = a * a % mod
        b = b shr 1
    }

    return result
}

private class FillingTheGrid {
    fun solveTestCase() {
        //TODO: Solve the question

        val (r, c) = readIntList()

        val grid = Array((r + 5)) { Array((c + 5)) { -1 } }

        for (i in 1..r) {
            val x = readInt()
            grid[i][x + 1] = 0
            for (j in 1..x) grid[i][j] = 1
        }

        for (j in 1..c) {
            val x = readInt()
            if (grid[x + 1][j] == 1) return out.println("0")

            grid[x + 1][j] = 0
            for (i in 1..x) {
                if (grid[i][j] == 0) return out.println("0")
                grid[i][j] = 1
            }
        }

        var resultCells = 0L
        for (i in 2..r) {
            for (j in 2..c) {
                if (grid[i][j] == -1)
                    resultCells++
            }
        }

        val result = pow(2L, resultCells)
        out.println(result)
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        FillingTheGrid()
            .solveTestCase()
    }

    out.flush()
}