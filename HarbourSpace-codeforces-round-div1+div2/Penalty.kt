/* 
    Author: Aman Patel
    Date: 22-07-2021
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

private class Penalty {
    fun solveTestCase() {
        //TODO: Solve the question

        val s = readLn()
        val firstStr = StringBuilder()
        val secondStr = StringBuilder()
        var firstResult: Int = 10
        var secondResult: Int = 10

        for (i in 0 until 10) {
            if (s[i] != '?') {
                firstStr.append(s[i])
                secondStr.append(s[i])
                continue
            }

            if (i and 1 == 0) {
                firstStr.append("1")
                secondStr.append("0")
            } else {
                firstStr.append("0")
                secondStr.append("1")
            }
        }

        // I make win the first team
        var secondMaxWin: Int = 5
        var firstWon: Int = 0
        var secondWon: Int = 0
        for (i in 0 until 10) {
            if (i and 1 == 0) {
                if (firstStr[i] == '1')
                    firstWon++
            } else {
                if (firstStr[i] == '1')
                    secondWon++
                secondMaxWin--
            }

            if (firstWon > (secondWon + secondMaxWin)) {
                firstResult = i + 1
                break
            }
        }

        // I make win the second team
        var firstMaxWin: Int = 5
        firstWon = 0
        secondWon = 0
        for (i in 0 until 10) {
            if (i and 1 != 0) {
                if (secondStr[i] == '1')
                    secondWon++
            } else {
                if (secondStr[i] == '1')
                    firstWon++
                firstMaxWin--
            }

            if (secondWon > (firstWon + firstMaxWin)) {
                secondResult = i + 1
                break
            }
        }

        //out.println("$firstStr $secondStr")
        //out.println("$firstResult $secondResult")
        val result = minOf(firstResult, secondResult)
        out.println(result)

    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        Penalty()
            .solveTestCase()
    }

    out.flush()
}