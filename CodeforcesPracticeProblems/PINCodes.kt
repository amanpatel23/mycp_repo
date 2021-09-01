/* 
    Author: Aman Patel
    Date: 01-09-2021
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

private class PINCodes {
    fun solveTestCase() {
        //TODO: Solve the question

        val n = readInt()

        val pinCodes = Array(n) { "" }
        val freq = mutableMapOf<String, Int>()
        val check = mutableSetOf<String>()

        for (i in 0 until n) {
            val pin = readLn()
            freq.putIfAbsent(pin, 0)
            freq[pin] = freq[pin]!! + 1
            check.add(pin)
            pinCodes[i] = pin
        }

        var resultCount = 0
        val resultMap = mutableMapOf<String, MutableList<String>>()
        for ((k, v) in freq) {
            resultCount += (v - 1)
            resultMap[k] = mutableListOf()
            resultMap[k]!!.add(k)

            for (i in 2..v) {
                var idx = 0
                var digit = '0'
                while (true) {
                    val tempStr = StringBuilder()
                    tempStr.append(k)
                    tempStr[idx] = digit
                    if (!check.contains(tempStr.toString())) {
                        resultMap[k]!!.add(tempStr.toString())
                        check.add(tempStr.toString())
                        break
                    }

                    digit++
                    if ((digit - '0') >= 10) {
                        idx++
                        digit = '0'
                    }
                }
            }
        }

        val resultStr = Array(n) { "" }
        for ((k, _) in resultMap) {
            var idx = 0
            for ((i, pinCode) in pinCodes.withIndex()) {
                if (pinCode == k) {
                    resultStr[i] = resultMap[k]!![idx]
                    idx++
                }
            }
        }

        out.println(resultCount)
        for (str in resultStr)
            out.println(str)
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        PINCodes()
            .solveTestCase()
    }

    out.flush()
}