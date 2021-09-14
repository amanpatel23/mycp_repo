/* 
    Author: Aman Patel
    Date: 14-09-2021
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

private class EqualizeThemAll {

    data class ResDesc(val type: Int, val i: Int, val j: Int)

    fun solveTestCase() {
        //TODO: Solve the question

        val n = readInt()
        val nums = mutableListOf<Int>()
        for (i in 0 until n)
            nums.add(readInt())

        val maxFreqKey = nums.groupBy { it }.maxByOrNull { it.value.size }?.key
        val idx = nums.indexOf(maxFreqKey)

        val result = mutableListOf<ResDesc>()
        for (i in (idx - 1) downTo 0) {
            if (nums[i] == maxFreqKey)
                continue
            result.add(ResDesc((if (nums[i] > maxFreqKey!!) 2 else 1), i, i + 1))
        }

        for (i in (idx + 1) until n) {
            if (nums[i] == maxFreqKey)
                continue
            result.add(ResDesc((if (nums[i] > maxFreqKey!!) 2 else 1), i, i - 1))
        }

        out.println(result.size)
        result.forEach {
            out.println("${it.type} ${it.i + 1} ${it.j + 1}")
        }
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        EqualizeThemAll()
            .solveTestCase()
    }

    out.flush()
}