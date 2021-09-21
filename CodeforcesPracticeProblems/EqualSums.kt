/* 
    Author: Aman Patel
    Date: 21-09-2021
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

private class EqualSums {
    fun solveTestCase() {
        //TODO: Solve the question

        val k = readInt()
        val seqSet = mutableListOf<MutableList<Pair<Int, Int>>>()
        val seqSum = mutableListOf<Int>()
        for (i in 0 until k)
            seqSet.add(mutableListOf())
        for (i in 0 until k) {
            var sum = 0
            val numSet = mutableSetOf<Int>()
            val n = readInt()
            for (j in 0 until n) {
                var num = readInt()
                sum += num
                if (!numSet.contains(num)) {
                    numSet.add(num)
                    seqSet[i].add(Pair(num, j))
                }
            }
            seqSum.add(sum)
        }

        val result = mutableListOf<Triple<Int, Int, Int>>()
        for (i in 0 until k) {
            for (x in seqSet[i]) {
                result.add(Triple(seqSum[i] - x.first, i + 1, x.second + 1))
            }
        }

        result.sortBy { it.first }
        val len = result.size
        for (i in 0 until (len - 1)) {
            if (result[i].first == result[i + 1].first) {
                out.println("YES")
                out.println("${result[i].second} ${result[i].third}")
                out.println("${result[i + 1].second} ${result[i + 1].third}")
                return
            }
        }

        out.println("NO")
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        EqualSums()
            .solveTestCase()
    }

    out.flush()
}