/* 
    Author: Aman Patel
    Date: 01-08-2021
*/

import java.io.PrintWriter
import java.util.StringTokenizer
import java.io.File
import java.lang.StringBuilder

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

private class CF736 {
    fun solveTestCase() {
        //TODO: Solve the question

        val n = readInt()
        val enemy = StringBuilder(readLn())
        var george = StringBuilder(readLn())

        var result = 0
        for ((i, char) in george.withIndex()) {
            if (char == '0')
                continue

            if (enemy[i] == '0') {
                result += 1
                enemy[i] = '2'
            } else if ((i - 1 >= 0) && enemy[i - 1] == '1') {
                result += 1
                enemy[i - 1] = '2'
            } else if ((i + 1 < n) && enemy[i + 1] == '1') {
                result += 1
                enemy[i + 1] = '2'
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

        CF736()
            .solveTestCase()
    }

    out.flush()
}