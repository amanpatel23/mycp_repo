/*
    Author: Aman Patel
    Date: 08-11-2022
*/

import java.io.PrintWriter
import java.io.File
import java.util.*

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

private class MashaAndABeautifulTree {
    fun solveTestCase() {

        val m = readInt()
        val arr = readIntArray(m)
        var step = 2
        var ans = 0
        while (step <= m) {
            val half = step / 2
            for (i in 0 until m step step) {
                if (arr[i] > arr[i + half]) {
                    ans++
                    var xx = half
                    var ii = i
                    while (xx-- > 0) {
                        val temp = arr[ii]
                        arr[ii] = arr[ii + half]
                        arr[ii + half] = temp
                        ii++
                    }
                }
            }
            step *= 2
        }

        for (i in 1..m) {
            if (arr[i - 1] != i) {
                out.println(-1)
                return
            }
        }

        out.println(ans)
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        MashaAndABeautifulTree()
            .solveTestCase()
    }

    out.flush()
}