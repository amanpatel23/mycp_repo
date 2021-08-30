/* 
    Author: Aman Patel
    Date: 29-08-2021
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

private class DeltixRoundSummer {
    fun solveTestCase() {
        //TODO: Solve the question

        val n = readInt()
        val nums = IntArray(n)
        val evenIndexs = mutableListOf<Int>()
        val oddIndexes = mutableListOf<Int>()
        var (noOfOdds, noOfEvens) = listOf(0, 0)
        for (i in 0 until n) {
            val num = readInt()
            nums[i] = num

            if (num and 1 == 0) {
                evenIndexs.add(i)
                noOfEvens++
            } else {
                oddIndexes.add(i)
                noOfOdds++
            }
        }

        fun evenAtEvenIdx(): Long {
            var result = 0L
            var i = 0
            for (idx in evenIndexs) {
                result += (abs(i - idx))
                i += 2
            }

            return result
        }

        fun oddAtEvenIdx(): Long {
            var result = 0L
            var i = 0
            for (idx in oddIndexes) {
                result += (abs(i - idx))
                i += 2
            }

            return result
        }


        if (abs(noOfEvens - noOfOdds) > 1) {
            out.println("-1")
        } else {
            val result = when {
                (noOfEvens == noOfOdds) -> {
                    minOf(evenAtEvenIdx(), oddAtEvenIdx())
                }
                (noOfEvens > noOfOdds) -> {
                    evenAtEvenIdx()
                }
                else -> oddAtEvenIdx()
            }

            out.println(result)
        }
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        DeltixRoundSummer()
            .solveTestCase()
    }

    out.flush()
}