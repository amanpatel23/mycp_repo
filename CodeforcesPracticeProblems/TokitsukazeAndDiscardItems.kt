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

private class TokitsukazeAndDiscardItems {
    fun solveTestCase() {
        //TODO: Solve the question

        val n = readLong()
        val m = readInt()
        val k = readLong()
        val specialItems = Array(m) { readLong() }

        var totalRemoved = 0
        var result = 0
        var i = 0
        fun boxType(i: Int): Long {
            return (specialItems[i] - totalRemoved + (k - 1)) / k
        }

        while (true) {
            if (i >= m)
                break

            val boxType = boxType(i)
            var j = i
            var currRemoved = 0
            while (true) {

                if (j >= m)
                    break

                val currBoxType = boxType(j)
                if (currBoxType == boxType) currRemoved++ else break
                j++
            }

            result++
            totalRemoved += currRemoved
            i = j
        }

        out.println(result)
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        TokitsukazeAndDiscardItems()
            .solveTestCase()
    }

    out.flush()
}