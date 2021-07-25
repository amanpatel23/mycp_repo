/* 
    Author: Aman Patel
    Date: 25-07-2021
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

private const val mod = (1e9 + 7).toLong()
private fun pow(a: Long, b: Long): Long {
    var (a, b) = listOf(a, b)
    var result = 1L
    while (b > 0) {
        if ((b and 1L) != 0L) {
            result = result * a % mod
        }

        a = a * a % mod
        b = b shr 1
    }

    return result
}

private const val N = (1e6).toInt()
private val fact = Array(N + 5) { 0L }
private val invFact = Array(N + 5) { 0L }
private fun init() {

    // making of fact arr...
    fact[0] = 1
    for (i in 1..N) {
        fact[i] = 1L * i * fact[i - 1] % mod
    }

    // making of invFact arr...
    invFact[N] = pow(fact[N], mod - 2L)
    for (i in (N - 1) downTo 0) {
        invFact[i] = 1L * (i + 1) * invFact[i + 1] % mod
    }
}

private fun nCr(n: Int, r: Int): Long {
    if (r > n || n < 0 || r < 0)
        return 0L

    return fact[n] * invFact[r] % mod * invFact[n - r] % mod
}

private class BeautifulNumbers {
    fun solveTestCase() {
        //TODO: Solve the question

        val (a, b, n) = readIntList()

        var result = 0L
        for (i in 0..n) {
            val sum = (a * i) + (b * (n - i))
            if (check(sum, a, b)) {
                result = (result + nCr(n, i)) % mod
            }
        }

        out.println(result)
    }

    fun check(sum: Int, a: Int, b: Int): Boolean {

        var sum = sum
        while (sum > 0) {
            val digit = sum % 10
            if (!(digit == a || digit == b))
                return false
            sum /= 10
        }

        return true
    }
}

fun main(args: Array<String>) {

    init()
    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        BeautifulNumbers()
            .solveTestCase()
    }

    out.flush()
}