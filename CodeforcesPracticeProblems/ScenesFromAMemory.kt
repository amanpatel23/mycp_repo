/* 
    Author: Aman Patel
    Date: 23-09-2021
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

private class CFV741 {
    fun solveTestCase() {
        //TODO: Solve the question

        val k = readInt()
        val str = readLn()
        val composites = listOf(1, 4, 6, 8, 9) // 1 is not composite
        val digitSet = mutableSetOf<Int>()
        for (char in str) {
            digitSet.add(char - '0')
        }

        for (x in composites) {
            if (digitSet.contains(x)) {
                out.println(1)
                out.println(x)
                return
            }
        }

        val possiblePrimes = setOf(23, 37, 53, 73)
        for (i in 0 until k) {
            var num = 10 * (str[i] - '0')
            for (j in (i + 1) until k) {
                val d = str[j] - '0'
                num += d
                if (!possiblePrimes.contains(num)) {
                    out.println(2)
                    out.println(num)
                    return
                }
                num -= d
            }
        }
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        CFV741()
            .solveTestCase()
    }

    out.flush()
}