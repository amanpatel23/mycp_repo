/* 
    Author: Aman Patel
    Date: 27-09-2021
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

private class BooksQueries {
    fun solveTestCase() {
        //TODO: Solve the question

        val q = readInt()
        var (l, r) = listOf(0, 0)
        val resultMap = mutableMapOf<Int, Int>()
        for (i in 0 until q) {
            val data = readLn().split(' ')
            val dir = data[0]
            val idx = data[1].toInt()

            if (i == 0) {
                resultMap[idx] = 0
                continue
            }

            when (dir) {
                "L" -> {
                    l--
                    resultMap[idx] = l
                }
                "R" -> {
                    r++
                    resultMap[idx] = r
                }
                else -> {
                    val pos = resultMap[idx]!!
                    val result = minOf(r - pos, pos - l)
                    out.println(result)
                }
            }
        }

    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        BooksQueries()
            .solveTestCase()
    }

    out.flush()
}