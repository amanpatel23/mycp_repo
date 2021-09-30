
/* 
    Author: Aman Patel
    Date: 30-09-2021
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

private class CFGlobal15 {
    fun solveTestCase() {
        //TODO: Solve the question

        val n = readInt()
        val ranks = Array(n) { IntArray(5) { _ -> 0 } }
        for (i in 0 until n) {
            for (j in 0 until 5) {
                ranks[i][j] = readInt()
            }
        }

        var superior = 0
        for (i in 1 until n) {
            var count = 0
            for (j in 0 until 5) {
                if (ranks[superior][j] < ranks[i][j]) {
                    count++
                }
            }

            superior = if (count < 3) i else superior
        }

        var flag = true
        for (i in 0 until n) {
            if (i == superior)
                continue

            var count = 0
            for (j in 0 until 5) {
                if (ranks[superior][j] < ranks[i][j]) {
                    count++
                }
            }

            if (count < 3) {
                flag = false
                break
            }
        }

        superior++
        out.println(if (flag) superior else -1)
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        CFGlobal15()
            .solveTestCase()
    }

    out.flush()
}