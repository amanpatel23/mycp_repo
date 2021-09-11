/* 
    Author: Aman Patel
    Date: 11-09-2021
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

private class ArrayKColoring {
    fun solveTestCase() {
        //TODO: Solve the question

        val (n, k) = readIntList()
        val nums = readIntArray(n)

        var tempK = 0
        val coloring = mutableListOf<MutableSet<Int>>()
        for (i in 0 until k)
            coloring.add(mutableSetOf())

        val result = Array(n) { -1 }
        var i = 0
        var colorCount = 0
        while (i < n && colorCount < k) {
            if (coloring[tempK].contains(nums[i])) {
                tempK = (tempK + 1) % k
                colorCount++
                continue
            }

            coloring[tempK].add(nums[i])
            result[i] = tempK + 1
            tempK = (tempK + 1) % k; i++; colorCount = 0
        }

        val check = result.count { it == -1 }
        if (check > 0)
            out.println("NO")
        else {
            out.println("YES")
            out.println(result.joinToString(" "))
        }
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        ArrayKColoring()
            .solveTestCase()
    }

    out.flush()
}