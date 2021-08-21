/* 
    Author: Aman Patel
    Date: 22-08-2021
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

private class Fillomio2 {
    fun solveTestCase() {
        //TODO: Solve the question

        val n = readInt()

        val matrix = Array(n) { Array(n) { -1 } }
        for (i in 0 until n) {
            matrix[i][i] = readInt()
        }

        for (i in 0 until n) {
            var count = matrix[i][i] - 1

            val num = matrix[i][i]
            var (row, col) = listOf(i, i)
            while (true) {
                if (count == 0)
                    break

                if ((col - 1) >= 0 && matrix[row][col - 1] == -1) {
                    matrix[row][col - 1] = num
                    col--
                }else {
                    matrix[row + 1][col] = num
                    row++
                }

                count--
            }
        }

        for (i in 0 until n) {
            for (j in 0..i) {
                out.print("${matrix[i][j]} ")
            }
            out.println()
        }
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        Fillomino()
            .solveTestCase()
    }

    out.flush()
}