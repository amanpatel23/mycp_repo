/* 
    Author: Aman Patel
    Date: 23-07-2021
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

private class WonderfulColoring2 {
    fun solveTestCase() {
        //TODO: Solve the question

        val (n, k) = readIntList()
        val nums = mutableListOf<Pair<Int, Int>>()
        val unnecessary = mutableMapOf<Int, Int>()
        for (i in 0 until n) {
            val num = readInt()
            nums.add(Pair(num, i))
            unnecessary.putIfAbsent(num, -k)
            unnecessary[num] = unnecessary[num]!! + 1
        }

        nums.sortBy { it.first }
        val result = Array(n) { 0 }

        var totalUnnecessary = 0
        for ((_, v) in unnecessary) {
            if (v > 0)
                totalUnnecessary += v
        }

        //out.println(unnecessary)
        val temp = n - totalUnnecessary
        //out.println(temp)
        var toLeave = temp % k
        //out.println(toLeave)
        var currColor = 0
        for (ele in nums) {
            val value = ele.first
            val idx = ele.second

            if (unnecessary[value]!! > 0) {
                unnecessary[value] = unnecessary[value]!! - 1
                continue
            }

            if (toLeave > 0) {
                toLeave--
                continue
            }

            result[idx] = currColor + 1
            currColor = (currColor + 1) % k
        }

        for (i in 0 until n)
            out.print("${result[i]} ")

        out.println()
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        WonderfulColoring2()
            .solveTestCase()
    }

    out.flush()
}