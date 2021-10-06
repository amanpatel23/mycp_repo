/* 
    Author: Aman Patel
    Date: 06-10-2021
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

private const val mod = 998244353

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

private class MonotonicRenumeration {
    fun solveTestCase() {
        //TODO: Solve the question

        val n = readInt()
        val nums = IntArray(n) { _ -> readInt() }

        val lastIdx = mutableMapOf<Int, Int>()
        for (i in (n - 1) downTo 0) {
            if (!lastIdx.containsKey(nums[i]))
                lastIdx[nums[i]] = i
        }

        var blocks = 0
        var i = 0
        var max = 0
        while (i < n) {
            max = maxOf(max, lastIdx[nums[i]]!!)
            if (max == i) {
                blocks++
                max = 0
            }

            i++
        }

        //out.println(lastIdx)
        val result = pow(2L, blocks - 1L)
        out.println(result)
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        MonotonicRenumeration()
            .solveTestCase()
    }

    out.flush()
}