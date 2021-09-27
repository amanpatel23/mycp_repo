/* 
    Author: Aman Patel
    Date: 27-09-2021
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

private class OurTanyaIsCryingOutLoud {
    fun solveTestCase() {
        //TODO: Solve the question

        val (n, k, a, b) = (1..4).map { readLong() }
        
        var x = n
        var result = 0L
        while (true) {
            if (x == 1L)
                break

            if (k > x || k == 1L) {
                result += (a * (x - 1))
                x = 1
                continue
            }

            if (x % k == 0L) {
                val div = x / k
                val costA = a * (x - div)
                result += (if (b <= costA) b else costA)
                x = div
                continue
            }

            val rem = x % k
            result += (a * rem)
            x -= rem
        }

        out.println(result)
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        OurTanyaIsCryingOutLoud()
            .solveTestCase()
    }

    out.flush()
}