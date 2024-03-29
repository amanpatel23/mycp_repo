/* 
    Author: Aman Patel
    Date: 03-09-2021
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

private class ChessCheater {
    fun solveTestCase() {
        //TODO: Solve the question

        val (n, k) = readIntList()
        val str = readLn()

        val diff = mutableListOf<Int>()
        var noOfSubsequences = 0
        var prev = -1
        var totalWins = 0
        var i = 0
        while (true) {
            if (i >= n)
                break

            if (str[i] == 'W') {
                if (prev != -1)
                    diff.add(i - prev - 1)
                totalWins++
                prev = i
                i++
                while (true) {

                    if (i >= n || str[i] == 'L') {
                        noOfSubsequences++
                        break
                    }

                    totalWins++
                    prev = i
                    i++
                }
            }

            i++
        }

        diff.sort()
        var x = minOf(k, (n - totalWins))

        var result = (2 * totalWins) - noOfSubsequences
        for (currDiff in diff) {
            if (currDiff > x)
                break

            result += ((2 * currDiff) + 1)
            x -= currDiff
        }

        result += ((2 * x) - if (totalWins == 0) 1 else 0)
        result = maxOf(result, 0)
        out.println(result)
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        ChessCheater()
            .solveTestCase()
    }

    out.flush()
}