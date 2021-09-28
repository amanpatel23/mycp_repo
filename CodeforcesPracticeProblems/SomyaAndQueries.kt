/* 
    Author: Aman Patel
    Date: 28-09-2021
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

private class SonyaAndQueries {
    fun solveTestCase() {
        //TODO: Solve the question

        val freq = mutableMapOf<Long, Int>()

        repeat(readInt()) {
            val data = readLn().split(' ')
            val sign = data[0]
            val numStr = data[1]
            if (sign == "?") {
                val k = binaryToLong(numStr)
                val result = freq[k]?.let { freq[k]!! } ?: 0
                out.println(result)
            } else {
                val num = numStr.toLong()
                val pattern = pattern(num)
                if (sign == "+") {
                    freq.putIfAbsent(pattern, 0)
                    freq[pattern] = freq[pattern]!! + 1
                } else {
                    freq[pattern] = freq[pattern]!! - 1
                }
            }
        }
    }

    fun pattern(_num: Long): Long {
        var num = _num
        var result = 0L
        var i = 0
        while (num > 0) {
            val digit = (num % 10).toInt()
            if (digit and 1 == 1)
                result = result.or(1L shl i)

            num /= 10
            i++
        }

        return result
    }

    fun binaryToLong(s: String): Long {
        var result = 0L
        val n = s.length
        var idx = 0
        for (i in (n - 1) downTo 0) {
            if (s[i] == '1') {
                result = result.or(1L shl idx)
            }
            idx++
        }

        return result
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        SonyaAndQueries()
            .solveTestCase()
    }

    out.flush()
}