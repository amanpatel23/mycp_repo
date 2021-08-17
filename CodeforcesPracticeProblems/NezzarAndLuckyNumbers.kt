/* 
    Author: Aman Patel
    Date: 17-08-2021
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

private class NezzarAndLuckyNumber {

    val table = Array(15) { Array(100) { false } }

    fun isSum(j: Int, d: Int, dp: Array<Int>): Boolean {

        if (j == 0) {
            return true
        }

        if (dp[j] != -1)
            return dp[j] == 1

        var ans = false
        for (x in 1..j) {
            if (check(x, d))
                ans = ans or isSum(j - x, d, dp)
        }

        dp[j] = if (ans) 1 else 0
        return (dp[j] == 1)
    }

    fun check(_j: Int, d: Int): Boolean {

        var j = _j
        while (j > 0) {
            val digit = j % 10
            if (digit == d) {
                return true
            }

            j /= 10
        }

        return false
    }

    fun init() {
        for (i in 2..9) {
            val dp = Array(100) { -1 }
            for (j in i..(10 * i)) {
                table[i][j] = isSum(j, i, dp)
            }
        }
    }

    fun solveTestCase() {
        //TODO: Solve the question

        init()

        var t = readInt()
        while (t-- > 0) {

            val (q, d) = readIntList()
            val nums = readIntArray(q)

            if (d == 1) {
                for (i in 0 until q)
                    out.println("YES")
                continue
            }

            for (i in 0 until q) {
                if (nums[i] < (10 * d))
                    out.println(if (table[d][nums[i]]) "YES" else "NO")
                else
                    out.println("YES")
            }
        }
    }
}

fun main(args: Array<String>) {

    //NezzarAndLuckyNumber().init()

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        NezzarAndLuckyNumber()
            .solveTestCase()
    }

    out.flush()
}