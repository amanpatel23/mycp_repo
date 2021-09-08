/* 
    Author: Aman Patel
    Date: 08-09-2021
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

private const val iMax = (1e9).toInt()

private class BouncingBall {
    fun solveTestCase() {
        //TODO: Solve the question

        val (n, p, k) = readIntList()
        val str = readLn()
        val (x, y) = readIntList()

        val secondsArr = Array(n + 1) { iMax }
        for (i in p..minOf(n, (p + k - 1))) {
            var currSec = 0
            var idx = i
            while (true) {
                if (idx > n)
                    break
                if (str[idx - 1] == '0')
                    currSec += x

                idx += k
            }

            secondsArr[i] = currSec
        }

        for (i in (p + k)..n) {
            secondsArr[i] = secondsArr[i - k] - (if (str[i - k - 1] == '0') x else 0)
        }

        var toAdd = 0
        for (i in p..n) {
            secondsArr[i] += toAdd
            toAdd += y
        }

        val result = secondsArr.minOrNull()
        out.println(result)
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        BouncingBall()
            .solveTestCase()
    }

    out.flush()
}