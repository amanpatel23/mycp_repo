/* 
    Author: Aman Patel
    Date: 09-09-2021
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
fun mul(a: Long, b: Long): Long {
    return (a * b) % mod
}

fun add(a: Long, b: Long): Long {
    return (a + b) % mod
}

fun power(_a: Long, _b: Long): Long {
    var (a, b) = listOf(_a, _b)
    var result = 1L
    while (b > 0) {
        if (b and 1 == 1L) {
            result = mul(result, a)
            b--
        }

        a = mul(a, a)
        b = b shr 1
    }

    return (result % mod)
}

private class MinNumOfSteps {
    fun solveTestCase() {
        //TODO: Solve the question

        val str = readLn()
        val n = str.length
        var result = 0L
        var aCount = 0L
        var i = 0
        while (true) {
            if (i >= n)
                break

            if (str[i] == 'a') {
                aCount++
                i++
                continue
            }

            var bCount = 0L
            while (true) {
                if (i >= n || str[i] == 'a') {
                    i--
                    break
                }

                bCount++
                i++
            }

            result = add(result, mul(bCount, (power(2, aCount) - 1)))
            i++
        }

        out.println(result)
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        MinNumOfSteps()
            .solveTestCase()
    }

    out.flush()
}