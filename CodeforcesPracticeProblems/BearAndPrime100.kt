/* 
    Author: Aman Patel
    Date: 02-09-2021
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

private const val iMax = (1e9).toInt()

private class BearAndPrime100 {

    val n = 100
    val primes = Array(n + 1) { true }
    val usedPrimes = mutableListOf<Int>()

    fun sieveOfEra() {

        for (i in 2 until iMax) {
            if ((i * i) > n)
                break

            if (primes[i]) {
                for (j in (i * i)..n step i) {
                    primes[j] = false
                }
            }
        }
    }

    fun init() {

        sieveOfEra()
        for (i in 2..n) {
            if (primes[i]) {
                if ((i * 2) > n)
                    break
                usedPrimes.add(i)
            }
        }
    }

    fun solveTestCase() {
        //TODO: Solve the question

        init()

        var noOfDivisors = 0
        var lastDivisor = -1
        for (prime in usedPrimes) {
            out.println(prime); out.flush()
            val response = readLn()
            if (response == "yes") {
                noOfDivisors++
                lastDivisor = prime
            }

            if (noOfDivisors >= 2)
                break
        }

        if (noOfDivisors == 0)
            out.println("prime")
        else if (noOfDivisors >= 2)
            out.println("composite")
        else {
            var tempDiv = lastDivisor * lastDivisor
            var flag = false
            while (true) {
                if (tempDiv > n)
                    break

                out.println(tempDiv); out.flush()
                val response = readLn()
                if (response == "yes") {
                    flag = true
                    break
                }

                tempDiv *= lastDivisor
            }

            if (flag)
                out.println("composite")
            else
                out.println("prime")
        }
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        BearAndPrime100()
            .solveTestCase()
    }

    out.flush()
}