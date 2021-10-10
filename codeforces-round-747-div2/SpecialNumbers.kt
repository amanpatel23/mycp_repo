/* 
    Author: Aman Patel
    Date: 08-10-2021
*/

import java.io.PrintWriter
import java.util.StringTokenizer
import java.io.File
import java.lang.StringBuilder

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

private const val mod = (1e9 + 7).toLong()
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

private class CF747 {
    fun solveTestCase() {
        //TODO: Solve the question

        val (n, k) = readLongList()
        val binary = getBinary(k)

        var result = 0L
        for ((i, bit) in binary.withIndex()) {
            if (bit == '0')
                continue
            val pow = pow(n, i.toLong())
            result = (result + pow) % mod
        }

        out.println(result)
    }

    fun getBinary(_k: Long): String {
        var k = _k
        val result = StringBuilder()
        while (k > 0) {
            if (k and 1 == 0L)
                result.append(0)
            else
                result.append(1)

            k /= 2
        }

        return result.toString()
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        CF747()
            .solveTestCase()
    }

    out.flush()
}