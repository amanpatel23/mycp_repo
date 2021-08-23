/* 
    Author: Aman Patel
    Date: 23-08-2021
*/

import java.io.PrintWriter
import java.util.StringTokenizer
import java.io.File
import kotlin.math.cos

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

private class KForThePriceOfOne {
    fun solveTestCase() {
        //TODO: Solve the question

        val n = readInt();
        val p = readLong();
        val k = readInt()
        val costs = mutableListOf<Int>()
        for (i in 0 until n)
            costs.add(readInt())

        costs.sort()

        var result1 = if (p >= costs[0]) 1 else 0
        var result2 = if (p >= costs[1]) 2 else 0

        var tempP = p - costs[0]
        for (i in 2 until n step 2) {
            if (tempP < costs[i])
                break

            result1 += 2
            tempP -= costs[i]
        }

        tempP = p - costs[1]
        for (i in 3 until n step 2) {
            if (tempP < costs[i])
                break

            result2 += 2
            tempP -= costs[i]
        }

        val result = maxOf(result1, result2)
        out.println(result)
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        KForThePriceOfOne()
            .solveTestCase()
    }

    out.flush()
}