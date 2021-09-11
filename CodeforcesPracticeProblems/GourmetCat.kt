/* 
    Author: Aman Patel
    Date: 11-09-2021
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

private class GourmetCat {
    fun solveTestCase() {
        //TODO: Solve the question

        var (a, b, c) = readLongList()

        var (l, r) = listOf(0, (3e8).toInt())
        fun check(x: Int): Boolean {
            val reqFish = 3 * x
            val otherReq = 2 * x
            return (a >= reqFish && minOf(b, c) >= otherReq)
        }
        while (r - l > 1) {
            val mid = l + ((r - l) / 2)
            if (check(mid))
                l = mid
            else
                r = mid
        }

        val resultWeeks = if (check(r)) r else l
        a -= (3L * resultWeeks); b -= (2L * resultWeeks); c -= (2L * resultWeeks)
        var resultDays = 0
        for (day in 0 until 7) {
            var (tA, tB, tC) = listOf(a, b, c)
            var currDays = 0
            var idx = day
            var flag = true
            while (flag) {
                when (idx) {
                    0, 3, 6 -> if (tA > 0) {
                        tA--
                        currDays++
                    } else
                        flag = false

                    1, 5 -> if (tB > 0) {
                        tB--
                        currDays++
                    } else
                        flag = false

                    2, 4 -> if (tC > 0) {
                        tC--
                        currDays++
                    } else
                        flag = false
                }

                idx = (idx + 1) % 7
            }

            resultDays = maxOf(resultDays, currDays)
        }

        val result = (7 * resultWeeks) + resultDays
        out.println(result)
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        GourmetCat()
            .solveTestCase()
    }

    out.flush()
}