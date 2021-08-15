/* 
    Author: Aman Patel
    Date: 15-08-2021
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

private class CF738 {
    fun solveTestCase() {
        //TODO: Solve the question

        val n = readInt()
        val str = readLn()

        if (str[0] == '?') {

            val result1 = StringBuilder()
            val result2 = StringBuilder()
            var impefectness1 = 0
            var imperfectness2 = 0

            result1.append('R')
            result2.append('B')

            for (i in 1 until n) {
                if (str[i] == '?') {
                    result1.append(if (result1[i - 1] == 'R') 'B' else 'R')
                    result2.append(if (result2[i - 1] == 'R') 'B' else 'R')
                    continue
                }

                result1.append(str[i])
                result2.append(str[i])

                if (result1[i] == result1[i - 1])
                    impefectness1++
                if (result2[i] == result2[i - 1])
                    imperfectness2++
            }

            if (impefectness1 <= imperfectness2)
                out.println(result1.toString())
            else
                out.println(result2.toString())
            //out.println(result2)
        } else {

            val result = StringBuilder()
            result.append(str[0])

            for (i in 1 until n) {
                if (str[i] == '?') {
                    result.append(if (result[i - 1] == 'R') 'B' else 'R')
                    continue
                }

                result.append(str[i])
            }

            out.println(result.toString())
        }
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        CF738()
            .solveTestCase()
    }

    out.flush()
}