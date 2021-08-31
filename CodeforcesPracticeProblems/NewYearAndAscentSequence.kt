/* 
    Author: Aman Patel
    Date: 31-08-2021
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

private const val iMin = (-1e9).toInt()
private const val iMax = (1e9).toInt()

private class NewYearAndAscentSequence {
    fun solveTestCase() {
        //TODO: Solve the question

        val n = readInt()
        val nonDescending = mutableListOf<Boolean>()
        val minAndMax = mutableListOf<Pair<Int, Int>>()
        for (i in 0 until n) {
            val len = readInt()
            var minVal = iMax;
            var maxVal = iMin
            var flag = false
            for (j in 0 until len) {
                val num = readInt()
                if (num > minVal)
                    flag = true
                minVal = minOf(minVal, num)
                maxVal = maxOf(maxVal, num)
            }

            nonDescending.add(flag)
            if (!flag)
                minAndMax.add(Pair(minVal, maxVal))
        }

        val nonDescendingCount = nonDescending.count { it }
        minAndMax.sortBy { it.second }
        val len = n - nonDescendingCount

        var result = 0L
        result += (nonDescendingCount * 1L * n)
        for (i in 0 until len) {

            val minVal = minAndMax[i].first
            result += nonDescendingCount
            var (l, r) = listOf(0, len - 1)
            fun check(mid: Int): Boolean {
                if (minAndMax[mid].second > minVal)
                    return true
                return false
            }
            while (r - l > 1) {
                val mid = l + ((r - l) / 2)
                if (check(mid))
                    r = mid
                else
                    l = mid + 1
            }

            if (check(l))
                result += (len - l)
            else if (check(r))
                result += (len - r)
        }

        out.println(result)
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        NewYearAndAscentSequence()
            .solveTestCase()
    }

    out.flush()
}