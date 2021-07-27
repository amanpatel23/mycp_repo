/* 
    Author: Aman Patel
    Date: 27-07-2021
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

private class NEKOsMazeGame {
    fun solveTestCase() {
        //TODO: Solve the question

        val (n, q) = readIntList()
        val cells = Array<Pair<Int, Int>>(q) { Pair(readInt() - 1, readInt() - 1) }

        val grid = Array(2) { Array(n) { 0 } }
        var totalBlockage = 0

        fun check(i: Int, j: Int): Int {

            var count = 0
            if (i == 0) {
                if (grid[1][j] == 1)
                    count++
                if (j - 1 >= 0 && grid[1][j - 1] == 1)
                    count++
                if (j + 1 < n && grid[1][j + 1] == 1)
                    count++
            } else {
                if (grid[0][j] == 1)
                    count++
                if (j - 1 >= 0 && grid[0][j - 1] == 1)
                    count++
                if (j + 1 < n && grid[0][j + 1] == 1)
                    count++
            }

            return count
        }

        for (cell in cells) {
            val (i, j) = listOf(cell.first, cell.second)
            if (grid[i][j] == 0) {
                grid[i][j] = 1
                totalBlockage += check(i, j)
            } else {
                grid[i][j] = 0
                totalBlockage -= check(i, j)
            }

            if (totalBlockage == 0)
                out.println("YES")
            else
                out.println("NO")
        }
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        NEKOsMazeGame()
            .solveTestCase()
    }

    out.flush()
}