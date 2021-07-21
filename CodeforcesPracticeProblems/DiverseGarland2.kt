/* 
    Author: Aman Patel
    Date: 21-07-2021
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

private class DiverseGarland2 {
    fun solveTestCase() {
        //TODO: Solve the question

        val n = readInt()
        val s = readLn()

        val dpTable = Array(n + 1) { Array(3) { 0 } }
        for (i in 1..n) {
            dpTable[i][0] = 1 + minOf(dpTable[i - 1][1], dpTable[i - 1][2])
            dpTable[i][1] = 1 + minOf(dpTable[i - 1][0], dpTable[i - 1][2])
            dpTable[i][2] = 1 + minOf(dpTable[i - 1][0], dpTable[i - 1][1])

            when (s[i - 1]) {
                'R' -> dpTable[i][0] -= 1
                'G' -> dpTable[i][1] -= 1
                'B' -> dpTable[i][2] -= 1
            }
        }

        val resultCount = minOf(dpTable[n][0], dpTable[n][1], dpTable[n][2])
        val resultStr = StringBuilder()
        var prevChar = when {
            dpTable[n][0] <= minOf(dpTable[n][1], dpTable[n][2]) -> 'R'
            dpTable[n][1] <= minOf(dpTable[n][0], dpTable[n][2]) -> 'G'
            else -> 'B'
        }

        //out.println(prevChar)
        resultStr.append(prevChar)
        for (i in (n - 1) downTo 1) {
            val currChar = when (prevChar) {
                'R' -> if (dpTable[i][1] <= dpTable[i][2]) 'G' else 'B'
                'G' -> if (dpTable[i][0] <= dpTable[i][2]) 'R' else 'B'
                else -> if (dpTable[i][0] <= dpTable[i][1]) 'R' else 'G'
            }

            resultStr.append(currChar)
            prevChar = currChar
        }


        out.println(resultCount)
        out.println(resultStr.reverse().toString())
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        DiverseGarland2()
            .solveTestCase()
    }

    out.flush()
}