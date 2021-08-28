/* 
    Author: Aman Patel
    Date: 28-08-2021
*/

import java.io.PrintWriter
import java.util.StringTokenizer
import java.io.File
import kotlin.math.abs

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

private class SillyMistake {
    fun solveTestCase() {
        //TODO: Solve the question

        val n = readInt()
        val days = readIntArray(n)

        if (n and 1 == 1) {
            out.println("-1")
            return
        }

        val entrance = mutableSetOf<Int>()
        val departure = mutableSetOf<Int>()
        val result = mutableListOf<Int>()
        var flag = true
        for (status in days) {
            if (status > 0) {
                if (entrance.contains(status)) {
                    flag = false
                    break
                }

                entrance.add(status)
            } else {
                if (!entrance.contains(abs(status)) || departure.contains(status)) {
                    flag = false
                    break
                }

                departure.add(status)
            }

            if (entrance.size == departure.size) {
                result.add((2 * entrance.size))
                entrance.clear(); departure.clear()
            }
        }

        if (entrance.size != 0) {
            flag = false
        }

        if (flag) {
            out.println(result.size)
            out.println(result.joinToString(" "))
        } else {
            out.println("-1")
        }
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        SillyMistake()
            .solveTestCase()
    }

    out.flush()
}