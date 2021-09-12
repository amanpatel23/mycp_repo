/* 
    Author: Aman Patel
    Date: 12-09-2021
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

private class CFGlobal16 {
    fun solveTestCase() {
        //TODO: Solve the question

        val n = readInt()
        val row1 = readLn()
        val row2 = readLn()

        // checker functions
        fun checkZeroOne(i: Int): Boolean {
            return ((row1[i] == '0' && row2[i] == '1') || (row1[i] == '1' && row2[i] == '0'))
        }

        fun checkZeroZero(i: Int): Boolean {
            return (row1[i] == '0' && row2[i] == '0')
        }

        fun checkOneOne(i: Int): Boolean {
            if (i < 0 || i >= n)
                return false
            return (row1[i] == '1' && row2[i] == '1')
        }

        var result = 0
        val oneOneTaken = mutableListOf<Int>()
        for (i in 0 until n) {
            when {
                checkZeroOne(i) -> result += 2
                checkZeroZero(i) -> {
                    if (checkOneOne(i - 1) && !oneOneTaken.contains(i - 1)) {
                        result += 2
                        oneOneTaken.add(i - 1)
                    } else if (checkOneOne(i + 1) && !oneOneTaken.contains(i + 1)) {
                        result += 2
                        oneOneTaken.add(i + 1)
                    } else
                        result += 1
                }
            }
        }

        out.println(result)
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        CFGlobal16()
            .solveTestCase()
    }

    out.flush()
}