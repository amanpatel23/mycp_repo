/* 
    Author: Aman Patel
    Date: 24-07-2021
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

private class InterestingStory {
    fun solveTestCase() {
        //TODO: Solve the question

        val n = readInt()
        val frequencies = Array(n) { Array(5) { 0 } }
        for (i in 0 until n) {
            val s = readLn()
            for (char in s) {
                val idx = char - 'a'
                frequencies[i][idx]++
            }
        }

        val frequencySum = Array(n) { 0 }
        for (i in 0 until n) {
            frequencySum[i] = frequencies[i].sum()
        }

        var globalResult = 0
        for (i in 0 until 5) {
            val maxMinusRemaining = mutableListOf<Int>()
            for (j in 0 until n) {
                val max = frequencies[j][i]
                val remainingSum = frequencySum[j] - max
                maxMinusRemaining.add(max - remainingSum)
            }

            maxMinusRemaining.sortDescending()
            //out.println(maxMinusRemaining)
            var resultSum = 0
            var resultCount = 0
            for (ele in maxMinusRemaining) {
                if (resultSum + ele <= 0)
                    break

                resultSum += ele
                resultCount++
            }

            if (resultCount > globalResult)
                globalResult = resultCount
        }

        out.println(globalResult)
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        InterestingStory()
            .solveTestCase()
    }

    out.flush()
}