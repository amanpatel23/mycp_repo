/* 
    Author: Aman Patel
    Date: 04-09-2021
*/

import java.io.PrintWriter
import java.util.StringTokenizer
import java.io.File
import kotlin.math.abs

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

private class DZYLovesChemistry2 {

    fun power(_a: Long, _b: Long): Long {

        var (a, b) = listOf(_a, _b)
        var result = 1L
        while (b > 0) {
            if (b and 1 == 1L) {
                result *= a
                b--
            }

            a *= a
            b = (b shr 1)
        }

        return result
    }

    fun solveTestCase() {
        //TODO: Solve the question

        val (n, m) = readIntList()
        val parent = Array(n + 1) { -it }

        fun find(i: Int): Int {
            if (parent[i] < 0)
                return i

            parent[i] = find(parent[i])
            return parent[i]
        }

        fun union(parent1: Int, parent2: Int) {
            if (abs(parent[parent1]) >= abs(parent[parent2])) {
                parent[parent1] += parent[parent2]
                parent[parent2] = parent1
            }else {
                parent[parent2] += parent[parent1]
                parent[parent1] = parent2
            }
        }

        var connectedComp = n
        for (i in 0 until m) {
            val (a, b) = readIntList()
            val parent1 = find(a)
            val parent2 = find(b)

            if (parent1 == parent2)
                continue

            union(parent1, parent2)
            connectedComp -= 1
        }

        val result = power(2L, (n - 0L - connectedComp))
        out.println(result)
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        DZYLovesChemistry2()
            .solveTestCase()
    }

    out.flush()
}