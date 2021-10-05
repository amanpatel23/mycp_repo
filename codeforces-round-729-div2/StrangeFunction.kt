/* 
    Author: Aman Patel
    Date: 05-10-2021
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

private const val mod = (1e9 + 7).toInt()
private fun gcd(a: Long, b: Long): Long {
    if (b == 0L)
        return a
    return gcd(b, a % b)
}

private fun lcm(a: Long , b: Long): Long {
    return ((a * b) / gcd(a, b))
}

private class StrangeFunction {
    fun solveTestCase() {
        //TODO: Solve the question

        val n = readLong()

        var result = 0L
        var y = 2L
        var lcm = 1L
        while (true) {

            if (lcm > n)
                break

            val left = n / lcm
            lcm = lcm(lcm, y)
            val right = n / lcm

            val diff = (left - right + mod) % mod
            result = (result + (y * diff) % mod) % mod
            y++
        }

        out.println(result)
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        StrangeFunction()
            .solveTestCase()
    }

    out.flush()
}