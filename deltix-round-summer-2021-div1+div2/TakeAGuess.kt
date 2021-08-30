/* 
    Author: Aman Patel
    Date: 30-08-2021
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

private class TakeAGuess {
    fun solveTestCase() {
        //TODO: Solve the question

        val (n, k) = readIntList()

        val nums = mutableListOf<Int>()
        var a = firstStep(nums)
        for (i in 4..n) {
            out.println("and ${i - 1} $i"); out.flush()
            val andVal = readInt()
            out.println("or ${i - 1} $i"); out.flush()
            val orVal = readInt()

            val b = andVal + orVal - a
            nums.add(b)
            a = b
        }

        nums.sort()
        val result = nums[k - 1]
        out.println("finish $result")
    }

    fun firstStep(nums: MutableList<Int>): Int {
        out.println("and 1 2"); out.flush()
        val firstAnd = readInt()
        out.println("or 1 2"); out.flush()
        val firstOr = readInt()

        out.println("and 2 3"); out.flush()
        val secondAnd = readInt()
        out.println("or 2 3"); out.flush()
        val secondOr = readInt()

        out.println("and 1 3"); out.flush()
        val thirdAnd = readInt()
        out.println("or 1 3"); out.flush()
        val thirdOr = readInt()

        val x = firstAnd + firstOr;
        val y = secondAnd + secondOr;
        val z = thirdAnd + thirdOr

        val a = (x + z - y) / 2;
        val b = (x + y - z) / 2;
        val c = (y + z - x) / 2
        nums.addAll(listOf(a, b, c))

        return c
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        TakeAGuess()
            .solveTestCase()
    }

    out.flush()
}