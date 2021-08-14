/* 
    Author: Aman Patel
    Date: 14-08-2021
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

private class GregAndArray {
    fun solveTestCase() {
        //TODO: Solve the question

        val (n, m, k) = readIntList()
        val nums = readLongArray(n)

        val types = Array(m) { Array(3) { 0 } }
        for (i in 0 until m) {
            var (l, r, d) = readIntList()
            l--; r--
            types[i][0] = l; types[i][1] = r; types[i][2] = d
        }

        val temp = Array(m + 1) { 0 }
        for (i in 0 until k) {
            var (l, r) = readIntList()
            l--; r--
            temp[l] += 1
            temp[r + 1] -= 1
        }

        val operations = Array(m) { 0 }
        var count = 0
        for (i in 0 until m) {
            count += temp[i]
            operations[i] = count
        }

        val finalArr = Array(n + 1) { 0L }
        for (i in 0 until m) {
            finalArr[types[i][0]] += (operations[i] * 1L * types[i][2])
            finalArr[types[i][1] + 1] -= (operations[i] * 1L * types[i][2])
        }

        val resultArr = Array(n) { 0L }
        var toAddBy = 0L
        for (i in 0 until n) {
            toAddBy += finalArr[i]
            resultArr[i] = nums[i] + toAddBy
        }

        out.println(resultArr.joinToString(" "))
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        GregAndArray()
            .solveTestCase()
    }

    out.flush()
}