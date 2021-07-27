/* 
    Author: Aman Patel
    Date: 27-07-2021
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

private class AddToNeighbourAndRemove {
    fun solveTestCase() {
        //TODO: Solve the question

        val n = readInt()
        val nums = readIntArray(n)

        val prefixSum = nums.runningFold(0) { sum, num -> sum + num }

        var globalResult = n - 1
        for (i in 1..n) {
            var currResult = i - 1
            val toMatchWith = prefixSum[i]
            var (sum, count) = listOf(0, 0)
            var flag = true
            for (j in i until n) {
                sum += nums[j]
                count++
                if (sum > toMatchWith) {
                    flag = false
                    break
                }
                if (sum == toMatchWith) {
                    currResult += (count - 1)
                    sum = 0
                    count = 0
                }
            }

            if (flag && sum == 0)
                globalResult = minOf(globalResult, currResult)
        }

        out.println(globalResult)
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        AddToNeighbourAndRemove()
            .solveTestCase()
    }

    out.flush()
}