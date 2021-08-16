/* 
    Author: Aman Patel
    Date: 16-08-2021
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

private class AsSimpleAsOneAndTwo {
    fun solveTestCase() {
        //TODO: Solve the question

        val str = readLn()
        val n = str.length

        val resultIdx = mutableListOf<Int>()

        var i = 0
        while (i < n) {

            if (str[i] == 'w') {
                if (str.subSequence(maxOf(0, i - 1), minOf(n, i + 4)) == "twone") {
                    resultIdx.add(i + 2)
                    i += 4
                    continue
                } else {
                    if (str.subSequence(maxOf(0, i - 1), minOf(n, i + 2)) == "two") {
                        resultIdx.add(i + 1)
                        i += 2
                        continue
                    }
                }
            } else if (str[i] == 'n') {
                if (str.subSequence(maxOf(0, i - 1), minOf(n, i + 2)) == "one") {
                    resultIdx.add(i + 1)
                    i += 2
                    continue
                }
            }

            i++
        }

        out.println(resultIdx.size)
        out.println(resultIdx.joinToString(" "))
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        AsSimpleAsOneAndTwo()
            .solveTestCase()
    }

    out.flush()
}