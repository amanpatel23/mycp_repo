/* 
    Author: Aman Patel
    Date: 20-07-2021
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

private const val mod = (1e9 + 7).toInt()

private class ConstanzesMachine {
    fun solveTestCase() {
        //TODO: Solve the question

        val s = readLn()
        val n = s.length

        val dp = Array(n) { -1L }
        fun totalMessages(i: Int): Long {

            if (i >= n)
                return 1L

            if (dp[i] != -1L)
                return dp[i]

            if (s[i] == 'w' || s[i] == 'm')
                return 0L

            if (i + 1 < n) {
                if ((s[i] == 'u' && s[i] == s[i + 1]) || (s[i] == 'n' && s[i] == s[i + 1])) {
                    dp[i] = (totalMessages(i + 1) % mod + totalMessages(i + 2) % mod) % mod
                    return dp[i]
                }
            }

            dp[i] = totalMessages(i + 1) % mod
            return dp[i]
        }

        val result = totalMessages(0)
        out.print(result)
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        ConstanzesMachine()
            .solveTestCase()
    }

    out.flush()
}