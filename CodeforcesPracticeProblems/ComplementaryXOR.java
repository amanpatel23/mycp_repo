/*
    Author: Ian Nepomniachtchi
    Date: 09-11-2022
*/

import java.io.PrintWriter
import java.io.File
import java.util.*

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

private class ComplemetaryXOR {
    fun solveTestCase() {

        val n = readInt()
        val straa = read()
        val strbb = read()
        val arr = booleanArrayOf(false, false)
        for (i in 0 until n) {
            val idx = (straa[i] - '0').xor(strbb[i] - '0')
            arr[idx] = true
            if (arr[0] && arr[1]) {
                out.println("NO")
                return
            }
        }
        val list = mutableListOf<IntArray>()
        var temp = 0
        for (i in 0 until n) {
            if (straa[i] == '1') {
                if (i != 0) temp = temp.xor(1)
                list.add(intArrayOf(i + 1, i + 1))
            }
        }
        val atFirst = temp.xor(strbb[0] - '0')
        if (atFirst == 1) list.addAll(
            listOf(
                intArrayOf(1, 1),
                intArrayOf(2, n),
                intArrayOf(1, n)
            )
        )
        out.println("YES")
        out.println(list.size)
        for (xx in list) out.println(xx.joinToString(separator = " "))
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        ComplemetaryXOR()
            .solveTestCase()
    }

    out.flush()
}