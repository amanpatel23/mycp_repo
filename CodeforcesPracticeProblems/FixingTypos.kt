/* 
    Author: Aman Patel
    Date: 11-08-2021
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

private class FixingTypos {
    fun solveTestCase() {
        //TODO: Solve the question

        val str = StringBuilder(readLn())
        var len = str.length

        val firstProcessing = StringBuilder()
        var (prevChar1, prevChar2) = listOf('0', '0')
        for (i in 0 until len) {
            val currChar = str[i]
            if (currChar == prevChar2 && prevChar1 == prevChar2)
                continue

            firstProcessing.append(currChar)
            prevChar1 = prevChar2
            prevChar2 = currChar
        }

        len = firstProcessing.length
        val secondProcessing = StringBuilder()
        var i = 0
        while (true) {
            if (i + 4 > len)
                break

            val subString = firstProcessing.subSequence(i, i + 4)
            //out.println(subString)
            if (check(subString.toString())) {
                secondProcessing.append("${subString[0]}${subString[1]}${subString[3]}")
                i += 4
                continue
            }

            secondProcessing.append(firstProcessing[i])
            i++
        }

        while (i < len) {
            secondProcessing.append(firstProcessing[i])
            i++
        }

        out.println(secondProcessing)
    }

    fun check(str: String): Boolean {
        return ((str[0] == str[1]) && (str[2] == str[3]))
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        FixingTypos()
            .solveTestCase()
    }

    out.flush()
}