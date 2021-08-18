/* 
    Author: Aman Patel
    Date: 18-08-2021
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

private class PuttingBricksInTheWall {
    fun solveTestCase() {
        //TODO: Solve the question

        val n = readInt()
        val grid = Array(n) { CharArray(n) }

        for (i in 0 until n) {
            grid[i] = readLn().toCharArray()
        }

        val firstSum = (grid[0][1] - '0') + (grid[1][0] - '0')
        val secondSum = (grid[n - 2][n - 1] - '0') + (grid[n - 1][n - 2] - '0')

        when {
            ((firstSum == 0 && secondSum == 2) || (firstSum == 2 && secondSum == 0)) -> {
                out.println(0)
            }

            ((firstSum == 0 && secondSum == 0) || (firstSum == 2 && secondSum == 2)) -> {
                out.println(2)
                out.println("${n - 1} $n")
                out.println("$n ${n - 1}")
            }

            (firstSum == 0 && secondSum == 1) -> {
                out.println(1)
                if (grid[n - 2][n - 1] == '0') {
                    out.println("${n - 1} $n")
                }else {
                    out.println("$n ${n - 1}")
                }
            }

            (firstSum == 1 && secondSum == 0) -> {
                out.println(1)
                if (grid[0][1] == '0') {
                    out.println("1 2")
                }else {
                    out.println("2 1")
                }
            }

            (firstSum == 1 && secondSum == 2) -> {
                out.println(1)
                if (grid[0][1] == '1') {
                    out.println("1 2")
                }else {
                    out.println("2 1")
                }
            }

            (firstSum == 2 && secondSum == 1) -> {
                out.println(1)
                if (grid[n - 2][n - 1] == '1') {
                    out.println("${n - 1} $n")
                }else {
                    out.println("$n ${n - 1}")
                }
            }

            (firstSum == 1 && secondSum == 1) -> {
                out.println(2)
                if (grid[0][1] == '1') {
                    out.println("1 2")
                }else {
                    out.println("2 1")
                }

                if (grid[n - 2][n - 1] == '0') {
                    out.println("${n - 1} $n")
                }else {
                    out.println("$n ${n - 1}")
                }
            }
        }
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        PuttingBricksInTheWall()
            .solveTestCase()
    }

    out.flush()
}