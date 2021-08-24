/* 
    Author: Aman Patel
    Date: 24-08-2021
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

private class KForThePriceOfOne2 {
    fun solveTestCase() {
        //TODO: Solve the question

        val (n, p, k) = readIntList()
        val costs = mutableListOf<Int>()

        for (i in 0 until n)
            costs.add(readInt())

        costs.sort()

        var grandResult = 0
        var singleBuy = 0
        var tempP: Int
        for (i in 0 until k) {
            tempP = p
            if (i == k - 1)
                singleBuy = 0
            singleBuy += costs[i]

            tempP -= singleBuy
            var currResult = if (tempP >= 0) (i + 1) else 0

            for (j in (i + k) until n step k) {
                tempP -= costs[j]
                if (tempP < 0)
                    break

                currResult += k
            }

            grandResult = maxOf(grandResult, currResult)
        }

        out.println(grandResult)
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        KForThePriceOfOne2()
            .solveTestCase()
    }

    out.flush()
}