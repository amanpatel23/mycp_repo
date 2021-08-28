/* 
    Author: Aman Patel
    Date: 28-08-2021
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

private class StringModification {
    fun solveTestCase() {
        //TODO: Solve the question

        val n = readInt()
        val str = readLn()

        val modifiedStrings = mutableListOf<Pair<String, Int>>()
        for (k in 1..n) {
            val tempStr = StringBuilder()
            tempStr.append(str.subSequence((k - 1), n))
            if ((n and 1 == 0 && k and 1 == 0) || (n and 1 == 1 && k and 1 == 1)) {
                tempStr.append(str.subSequence(0, (k - 1)).reversed())
            } else {
                tempStr.append(str.subSequence(0, (k - 1)))
            }

            modifiedStrings.add(Pair(tempStr.toString(), k))
        }

        modifiedStrings.sortWith(compareBy({ it.first }, { it.second }))

        out.println(modifiedStrings[0].first)
        out.println(modifiedStrings[0].second)
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        StringModification()
            .solveTestCase()
    }

    out.flush()
}