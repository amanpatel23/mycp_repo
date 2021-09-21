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

private class SlayTheDragon {
    fun solveTestCase() {
        //TODO: Solve the question

        val n = readInt()
        var sum = 0L
        val strengths = mutableListOf<Long>()
        for (i in 0 until n) {
            strengths.add(readLong())
            sum += strengths[i]
        }
        val m = readInt()
        val monsters = Array(m) { Pair(readLong(), readLong()) }

        strengths.sort()
        for (monster in monsters) {
            val (defence, attack) = listOf(monster.first, monster.second)
            var (l, r) = listOf(0, n - 1)
            fun check1(idx: Int): Boolean {
                return (strengths[idx] <= defence)
            }
            while (r - l > 1) {
                val mid = l + ((r - l) / 2)
                if (check1(mid))
                    l = mid
                else
                    r = mid
            }

            fun goldCoins(idx: Int): Long {
                return maxOf(0, defence - strengths[idx]) + maxOf(0, attack - (sum - strengths[idx]))
            }

            val result = minOf(goldCoins(l), goldCoins(r))
            out.println(result)
        }
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        SlayTheDragon()
            .solveTestCase()
    }

    out.flush()
}