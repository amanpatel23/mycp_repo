/* 
    Author: Aman Patel
    Date: 17-09-2021
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

private class Test {
    fun solveTestCase() {
        //TODO: Solve the question
        val n = readInt()
        val nums = readIntArray(n)

        val numsFreq = mutableListOf<Pair<Int, Int>>()
        var i = 0
        var currEle = nums[i]
        var currFreq = 0
        while (true) {
            if (i >= n) {
                numsFreq.add(Pair(currEle, currFreq))
                break
            }

            if (nums[i] != currEle) {
                numsFreq.add(Pair(currEle, currFreq))
                currEle = nums[i]
                currFreq = 0
            }

            currFreq++
            i++
        }

        val len = numsFreq.size
        var (result, currResult) = listOf(numsFreq[0].second, numsFreq[0].second)
        var (max, min) = listOf(numsFreq[0].first, numsFreq[0].first)
        i = 1
        while (i < len) {
            max = maxOf(max, numsFreq[i].first)
            min = minOf(min, numsFreq[i].first)

            if (max - min > 1) {
                result = maxOf(result, currResult)
                if (abs(numsFreq[i].first - numsFreq[i - 1].first) <= 1) {
                    currResult = numsFreq[i].second + numsFreq[i - 1].second
                    max = maxOf(numsFreq[i].first, numsFreq[i - 1].first)
                    min = minOf(numsFreq[i].first, numsFreq[i - 1].first)
                } else {
                    currResult = numsFreq[i].second
                    max = numsFreq[i].first
                    min = numsFreq[i].first
                }
            }else {
                currResult += numsFreq[i].second
            }

            i++
        }

        result = maxOf(result, currResult)
        out.println(result)
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        Test()
            .solveTestCase()
    }

    out.flush()
}