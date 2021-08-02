/* 
    Author: Aman Patel
    Date: 01-08-2021
*/

import java.io.PrintWriter
import java.util.StringTokenizer
import java.io.File
import java.lang.StringBuilder

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

private class CF736 {
    fun solveTestCase() {
        //TODO: Solve the question

        val (n, m) = readIntList()

        val friendships = Array(n) { 0 }
        var countOfOnes = 0
        for (i in 0 until m) {
            var (a, b) = readIntList()
            a--
            b--
            if (a < b)
                friendships[a]++
            else
                friendships[b]++
        }

        for (i in 0 until n) {
            if (friendships[i] == 0)
                countOfOnes += 1
        }

        val q = readInt()
        repeat(q) {
            when (readInt()) {
                1 -> {
                    //out.println("hey")
                    var a = readInt()
                    var b = readInt()
                    //out.println("$a $b")
                    a--
                    b--

                    if (a > b) {
                        friendships[b]++
                        if (friendships[b] == 1)
                            countOfOnes--
                    }
                    else {
                        friendships[a]++
                        if (friendships[a] == 1)
                            countOfOnes--
                    }
                }
                2 -> {
                    //out.println("hey2")
                    var a = readInt()
                    var b = readInt()
                    //out.println("$a $b")
                    a--
                    b--

                    if (a < b) {
                        friendships[a]--
                        if (friendships[a] == 0)
                            countOfOnes++
                    }
                    else {
                        friendships[b]--
                        if (friendships[b] == 0)
                            countOfOnes++
                    }
                }
                else -> {
                    //out.println("hey3")
                    out.println(countOfOnes)
                }
            }
            //out.println(friendships.joinToString(" "))
        }
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        CF736()
            .solveTestCase()
    }

    out.flush()
}