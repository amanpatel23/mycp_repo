/* 
    Author: Aman Patel
    Date: 21-07-2021
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

private const val iMax = (1e9).toInt()

private class DiverseGarland {
    fun solveTestCase() {
        //TODO: Solve the question

        val n = readInt()
        val s = readLn()
        val colors = charArrayOf('R', 'G', 'B')

        var resultCount = 0
        val resultStr = StringBuilder()
        resultStr.append(s[0])

        if (n == 1) {
            out.println(resultCount)
            out.println(resultStr)
            return
        }

        for (i in 1 until (n - 1)) {
            if (s[i] == resultStr.last()) {
                resultCount++
                for (color in colors) {
                    if (color != resultStr.last() && color != s[i + 1]) {
                        resultStr.append(color)
                        break
                    }
                }
                continue
            }

            resultStr.append(s[i])
        }

        if (s[n - 1] == resultStr.last()) {
            resultCount++
            for (color in colors) {
                if (color != resultStr.last()) {
                    resultStr.append(color)
                    break
                }
            }
        } else
            resultStr.append(s[n - 1])

        out.println(resultCount)
        out.println(resultStr.toString())
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        DiverseGarland()
            .solveTestCase()
    }

    out.flush()
}