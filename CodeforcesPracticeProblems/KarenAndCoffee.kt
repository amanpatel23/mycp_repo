/* 
    Author: Aman Patel
    Date: 24-08-2021
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

private const val maxLimit = (2e5).toInt()

private class KarenAndCoffee {
    fun solveTestCase() {
        //TODO: Solve the question

        val (n, k, q) = readIntList()

        val admissibleArr = Array(maxLimit + 5) { 0 }
        val prefixArr = Array(maxLimit + 5) { 0 }
        val ansArr = Array(maxLimit + 5) { 0 }

        for (i in 0 until n) {
            val (l, r) = readIntList()
            admissibleArr[l]++
            admissibleArr[r + 1]--
        }

        for (i in 1..maxLimit) {
            prefixArr[i] = prefixArr[i - 1] + admissibleArr[i]
        }

        for (i in 1..maxLimit) {
            ansArr[i] = ansArr[i - 1] + if (prefixArr[i] >= k) 1 else 0
        }

        repeat(q) {
            val (a, b) = readIntList()
            val ans = ansArr[b] - ansArr[a - 1]
            out.println(ans)
        }
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        KarenAndCoffee()
            .solveTestCase()
    }

    out.flush()
}