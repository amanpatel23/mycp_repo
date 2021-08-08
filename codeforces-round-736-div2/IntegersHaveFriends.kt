/* 
    Author: Aman Patel
    Date: 08-08-2021
*/

import java.io.PrintWriter
import java.util.StringTokenizer
import java.io.File
import kotlin.math.abs
import kotlin.math.log2

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

private const val iMax = 1e9.toInt()

private fun gcd(a: Long, b: Long): Long {
    return if (b == 0L) a else gcd(b, a % b)
}

private class IntegersHaveFriends {
    fun solveTestCase() {
        //TODO: Solve the question

        val n = readInt()
        val nums = readLongArray(n)
        if (n == 1) {
            out.println("1")
            return
        }

        val len = n - 1
        val diff = Array(len) { 0L }
        for (i in 0 until len)
            diff[i] = abs(nums[i] - nums[i + 1])

        // creating sparse table
        val sparse = Array(len) { Array(log2(len * 1.0).toInt() + 1) { 0L } }
        for (i in 0 until len)
            sparse[i][0] = diff[i]
        for (j in 1 until iMax) {
            if (1 shl j > len)
                break

            for (i in 0 until iMax) {
                if (i + (1 shl j) - 1 >= len)
                    break

                sparse[i][j] = gcd(sparse[i][j - 1], sparse[i + (1 shl (j - 1))][j - 1])
            }
        }

        var result = 1

        // binary search
        fun check(low: Int, high: Int): Boolean {
            val l = high - low + 1
            val k = log2(l * 1.0).toInt()
            return gcd(sparse[low][k], sparse[low + l - (1 shl k)][k]) >= 2L
        }

        var (l, r) = listOf(1, len)
        while (r - l > 1) {
            val mid = l + ((r - l) / 2)
            var flag = false
            for (i in 0 until iMax) {
                if ((i + mid - 1) >= len)
                    break
                if (check(i, i + mid - 1)) {
                    flag = true
                    break
                }
            }

            if (flag)
                l = mid
            else
                r = mid
        }

        // check for r
        var flag = false
        for (i in 0 until iMax) {
            if ((i + r - 1) >= len)
                break
            if (check(i, i + r - 1)) {
                flag = true
                break
            }
        }

        if (flag)
            result = r + 1
        else {
            for (i in 0 until iMax) {
                if ((i + l - 1) >= len)
                    break
                if (check(i, i + l - 1)) {
                    flag = true
                    break
                }
            }

            if (flag)
                result = l + 1
        }

        out.println(result)
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        IntegersHaveFriends()
            .solveTestCase()
    }

    out.flush()
}