/* 
    Author: Aman Patel
    Date: 03-08-2021
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

private class MinimizeThePermutation {
    fun solveTestCase() {
        //TODO: Solve the question

        val n = readInt()
        val nums = Array(n + 1) { 0 }

        for (i in 1..n) {
            nums[i] = readInt()
        }

        var i = 1
        while (i <= n) {
            var ele = nums[i]
            var idx = -1

            for (j in (i + 1)..n) {
                if (nums[j] < ele) {
                    ele = nums[j]
                    idx = j
                }
            }

            if (idx == -1) {
                i++
                continue
            }

            var temp1 = nums[i]
            var temp2: Int
            nums[i] = ele
            for (k in (i + 1)..idx) {
                temp2 = nums[k]
                nums[k] = temp1
                temp1 = temp2
            }

            i = idx
        }

        for (i in 1..n)
            out.print("${nums[i]} ")
        out.println()
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        MinimizeThePermutation()
            .solveTestCase()
    }

    out.flush()
}