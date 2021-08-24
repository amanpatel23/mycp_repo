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

private class CF740 {
    fun solveTestCase() {
        //TODO: Solve the question

        val n = readInt()
        val nums = Array(n + 1) { 0 }
        for (i in 1..n) {
            nums[i] = readInt()
        }

        var resultCount = 0
        var i = 1
        while (true) {
            var swaps = 0
            if (i and 1 == 1) {
                for (j in 1..(n - 2)) {
                    if (j and 1 == 0) {
                        if (nums[j] > nums[j + 1])
                            swaps++
                        continue
                    }
                    if (nums[j] > nums[j + 1]) {
                        nums[j] = nums[j + 1].also { nums[j + 1] = nums[j] }
                        swaps++
                    }
                }

                if (nums[n - 1] > nums[n])
                    swaps++
            } else {
                if (nums[1] > nums[2])
                    swaps++
                
                for (j in 2 until n) {
                    if (j and 1 == 1) {
                        if (nums[j] > nums[j + 1]) {
                            swaps++
                            continue
                        }
                    }
                    if (nums[j] > nums[j + 1]) {
                        nums[j] = nums[j + 1].also { nums[j + 1] = nums[j] }
                        swaps++
                    }
                }
            }

            if (swaps == 0)
                break

            resultCount++
            i++
        }

        out.println(resultCount)
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        CF740()
            .solveTestCase()
    }

    out.flush()
}