/* 
    Author: Aman Patel
    Date: 28-07-2021
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

private class StringEquality {
    fun solveTestCase() {
        //TODO: Solve the question

        val (n, k) = readIntList()
        val a = readLn()
        val b = readLn()

        val aFreq = Array(26) { 0 }
        val bFreq = Array(26) { 0 }

        for (i in 0 until n) {
            aFreq[a[i] - 'a']++
            bFreq[b[i] - 'a']++
        }

        var prev = 0
        var flag = true
        for (i in 0..25) {
            var temp1 = prev + aFreq[i]
            val temp2 = bFreq[i]
            if (temp1 >= temp2) {
                val min = minOf(temp1, temp2)
                temp1 -= min
                prev = temp1
                if (prev % k != 0) {
                    flag = false
                    break
                }
            } else {
                flag = false
                break
            }
        }

        if (flag)
            out.println("YES")
        else
            out.println("NO")
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        StringEquality()
            .solveTestCase()
    }

    out.flush()
}