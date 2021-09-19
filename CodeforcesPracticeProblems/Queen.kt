/* 
    Author: Aman Patel
    Date: 18-09-2021
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

private class Queen {
    fun solveTestCase() {
        //TODO: Solve the question

        val n = readInt()
        val adjList = mutableListOf<MutableList<Int>>()
        for (i in 0 until n)
            adjList.add(mutableListOf())

        val respects = Array(n) { 0 }
        for (i in 0 until n) {
            var (p, c) = readIntList()
            if (p == -1)
                continue
            p--
            respects[i] = c
            adjList[p].add(i)
        }

        val result = mutableListOf<Int>()
        for (i in 0 until n) {
            if (respects[i] == 1 && (adjList[i].filter { respects[it] == 0 }.count() == 0)) {
                result.add(i + 1)
            }
        }

        out.print(if (result.size == 0) -1 else result.joinToString(" "))
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        Queen()
            .solveTestCase()
    }

    out.flush()
}