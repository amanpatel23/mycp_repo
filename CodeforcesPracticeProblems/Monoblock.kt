/*
    Author: Aman Patel
    Date: 08-11-2022
*/

import java.io.PrintWriter
import java.io.File
import java.util.*

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

private class Test {
    fun solveTestCase() {

        var (n, m) = readIntList()
        val arr = readIntArray(n)
        var ans : Long = 0
        for (i in 1 until n) {
            if (arr[i] != arr[i - 1]) ans += (i * 1L * (n - i))
        }
        ans += (n * 1L * (n + 1) / 2)
        while (m-- > 0) {
            var (ii, x) = readIntList()
            ii--
            if (ii > 0 && arr[ii] != arr[ii - 1]) ans -= (ii * 1L * (n - ii))
            if (ii < n - 1 && arr[ii] != arr[ii + 1]) ans -= ((ii + 1) * 1L * (n - ii - 1))
            arr[ii] = x
            if (ii > 0 && arr[ii] != arr[ii - 1]) ans += (ii * 1L * (n - ii))
            if (ii < n - 1 && arr[ii] != arr[ii + 1]) ans += ((ii + 1) * 1L * (n - ii - 1))
            out.println(ans)
        }
    }
}

fun main(args: Array<String>) {

    var t = 1
    // t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        Test()
            .solveTestCase()
    }

    out.flush()
}