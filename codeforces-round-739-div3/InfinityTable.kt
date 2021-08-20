/* 
    Author: Aman Patel
    Date: 18-08-2021
*/

import java.io.PrintWriter
import java.util.StringTokenizer
import java.io.File
import kotlin.math.abs
import kotlin.math.sqrt

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

private class CF739 {

    fun solveTestCase() {
        //TODO: Solve the question

        val k = readLong()

        var (l, r) = listOf(1L, 32000L)
        while (r - l > 1L) {
            val mid = l + ((r - l) / 2L)

            if ((mid * mid) < k)
                l = mid
            else
                r = mid
        }

        val powOf = if ((l * l) >= k) l else r

        val lastEle = powOf * powOf
        val firstEle = lastEle - ((2L * powOf) - 2L)

        val rawRow = k - firstEle + 1

        var row = minOf(rawRow, powOf)
        val col = if (rawRow <= powOf) (powOf) else (2L * powOf) - rawRow

        out.println("$row $col")


    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        CF739()
            .solveTestCase()
    }

    out.flush()
}