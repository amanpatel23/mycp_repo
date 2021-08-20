/* 
    Author: Aman Patel
    Date: 20-08-2021
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

private val twosPower = mutableListOf<String>()

private fun init() {
    for (i in 0..62) {
        twosPower.add((1L shl i).toString())
    }
}

private class MakeAPowerOfTwo {

    fun solveTestCase() {
        //TODO: Solve the question

        val a = readInt().toString()

        var resultMoves = 15
        for (b in twosPower) {
            val matched = util(a, b)
            val toDelete = a.length - matched
            val toAdd = b.length - matched

            val currMoves = toDelete + toAdd
            resultMoves = minOf(resultMoves, currMoves)
        }

        out.println(resultMoves)
    }

    fun util(a: String, b: String): Int {

        val (lenA, lenB) = listOf(a.length, b.length)
        var count = 0

        var (idx, i) = listOf(0, 0)
        while (idx < lenB) {

            if (i >= lenA)
                break

            if (b[idx] == a[i]) {
                count++
                idx++
            }

            i++
        }

        return count
    }

}

fun main(args: Array<String>) {

    init()

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        MakeAPowerOfTwo()
            .solveTestCase()
    }

    out.flush()
}