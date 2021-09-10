/* 
    Author: Aman Patel
    Date: 10-09-2021
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

private class ChocolateBunny {
    fun solveTestCase() {
        //TODO: Solve the question

        val n = readInt()
        val result = Array(n + 1) { -1 }

        var maxIdx = 1
        for (i in 2..n) {
            out.println("? $maxIdx $i"); out.flush()
            val response1 = readInt()
            out.println("? $i $maxIdx"); out.flush()
            val response2 = readInt()

            if (response1 > response2) {
                result[maxIdx] = response1
                maxIdx = i
            } else {
                result[i] = response2
            }
        }

        result[maxIdx] = n

        for (i in 0..n) {
            if (i == 0)
                out.print("! ")
            else
                out.print("${result[i]} ")
        }
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        ChocolateBunny()
            .solveTestCase()
    }

    out.flush()
}