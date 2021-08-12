/* 
    Author: Aman Patel
    Date: 12-08-2021
*/

import java.io.PrintWriter
import java.util.StringTokenizer
import java.io.File
import kotlin.math.abs

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

private class SuffixOperations {
    fun solveTestCase() {
        //TODO: Solve the question

        val n = readInt()
        val nums = readIntArray(n)

        var result = 0L
        for (i in 0 until (n - 1)) {
            result += abs(nums[i] - nums[i + 1])
        }

        var toDecreament = maxOf(abs(nums[0] - nums[1]), abs(nums[n - 1] - nums[n - 2]))
        for (i in 1 until (n - 1)) {
            toDecreament = maxOf(
                toDecreament,
                abs(nums[i] - nums[i - 1]) + abs(nums[i] - nums[i + 1]) - abs(nums[i - 1] - nums[i + 1])
            )
        }

        val finalResult = result - toDecreament
        out.println(finalResult)
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        SuffixOperations()
            .solveTestCase()
    }

    out.flush()
}