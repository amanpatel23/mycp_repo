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

private class HarbourSpace {
    fun solveTestCase() {
        //TODO: Solve the question

        val s = readLn()
        val t = readLn()

        val sLen = s.length
        val tLen = t.length

        val chip = t[0]
        val initialPos = mutableListOf<Int>()
        for (i in 0 until sLen) {
            if (s[i] == chip)
                initialPos.add(i)

        }

        for (idx in initialPos) {
            for (i in idx until minOf(sLen, (idx + tLen))) {
                val tempString = StringBuilder()
                tempString.append(s.substring(idx, i + 1))
                //out.println(tempString)
                val leftLen = tLen - ((i + 1) - idx)
                tempString.append(s.substring(maxOf(0, i - leftLen), i).reversed())
                //out.println(tempString)
                if (tempString.toString() == t) {
                    out.println("YES")
                    return
                }
            }
        }

        out.println("NO")
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        HarbourSpace()
            .solveTestCase()
    }

    out.flush()
}