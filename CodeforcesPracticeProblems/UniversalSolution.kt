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

private class UniversalSolution {
    fun solveTestCase() {
        //TODO: Solve the question

        val str = readLn()
        val strLen = str.length
        var (r, p, s) = listOf(0, 0, 0)
        for (char in str) {
            when (char) {
                'R' -> r++
                'P' -> p++
                'S' -> s++
            }
        }

        val maxFreq = maxOf(r, p, s)
        val resultStr = StringBuilder()
        var resultStrLen = 0
        var prev = 'o'
        if (r >= maxFreq) {
            prev = 'P'
            for (i in 0 until maxFreq) {
                resultStr.append(prev)
                resultStrLen++
            }
        }

        if (p >= maxFreq) {
            prev = 'S'
            for (i in 0 until maxFreq) {
                resultStr.append(prev)
                resultStrLen++
            }
        }

        if (s >= maxFreq) {
            prev = 'R'
            for (i in 0 until maxFreq) {
                resultStr.append(prev)
                resultStrLen++
            }
        }

        if (resultStrLen < strLen) {
            while (resultStrLen != strLen) {
                resultStr.append(prev)
                resultStrLen++
            }
        }

        out.println(resultStr.toString())
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        UniversalSolution()
            .solveTestCase()
    }

    out.flush()
}