/*
    Author: Aman Patel
    Date: 21-08-2021
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

private val twoKBeautiful = mutableListOf<Int>()

private class NearestBeautifulNumber {

    fun fill(digit1: Int, digit2: Int, maxNum: Int, len: Int, pos: Int, num: Int) {

        if (pos >= len) {
            if (num != maxNum)
                twoKBeautiful.add(num)
            return
        }

        fill(digit1, digit2, maxNum, len, pos + 1, (num * 10) + digit1)
        fill(digit1, digit2, maxNum, len, pos + 1, (num * 10) + digit2)
    }

    fun init() {

        for (len in 2..9) {
            for (i in 1..9) {
                for (j in 0..9) {

                    if (i == j)
                        continue
                    // maxNum
                    var maxNum = i
                    for (idx in 1 until len) {
                        maxNum = (maxNum * 10) + i
                    }

                    fill(i, j, maxNum, len, 1, i)
                }
            }
        }

        twoKBeautiful.sort()
        twoKBeautiful.add((1e9).toInt())
    }

    fun solveTestCase() {
        //TODO: Solve the question

        val (num, k) = readIntList()
        val numStr = num.toString()
        val len = numStr.length

        var tempNum = num
        val uniqueDigits = mutableSetOf<Int>()
        while (tempNum > 0) {
            uniqueDigits.add(tempNum % 10)
            tempNum /= 10
        }

        if (uniqueDigits.size == 1) {
            out.println(num)
            return
        }

        if (k == 1) {
            var resultDigit = (numStr[0] - '0')
            for (i in 1 until (numStr.length)) {
                val digit = (numStr[i] - '0')
                if (digit < resultDigit)
                    break
                if (digit > resultDigit) {
                    resultDigit++
                    break
                }
            }

            val result = StringBuilder()
            for (i in 0 until len) {
                result.append(resultDigit)
            }

            out.println(result.toString())
        } else {
            var (i, j) = listOf(0, 40662)

            while (j - i > 1) {
                val mid = j + ((i - j) / 2)
                if (twoKBeautiful[mid] >= num)
                    j = mid
                else
                    i = mid
            }

            if (twoKBeautiful[i] >= num)
                out.println(twoKBeautiful[i])
            else
                out.println(twoKBeautiful[j])
        }
    }
}

fun main(args: Array<String>) {

    NearestBeautifulNumber().init()

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        NearestBeautifulNumber()
            .solveTestCase()
    }

    out.flush()
}