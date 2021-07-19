/* 
    Author: Aman Patel
    Date: 19-07-2021
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

private class DreamoonLikesPermutations {
    fun solveTestCase() {
        //TODO: Solve the question

        val n = readInt()
        val nums = readIntArray(n)

        var firstFlga = true
        val firstLeft = Array(n) { 0 }
        val firstRight = Array(n) { 0 }
        var (firstLeftLen, firstRightLen) = listOf(0, 0)

        var i = 0
        while (true) {
            val ele = nums[i]
            if (firstLeft[ele] >= 1) {
                break
            }

            firstLeft[ele]++
            firstLeftLen++
            i++
        }

        while (i < n) {
            val ele = nums[i]
            firstRight[ele]++
            firstRightLen++
            i++
        }

        if (!(check(firstLeft, firstLeftLen) && check(firstRight, firstRightLen)))
            firstFlga = false


        var secondFlag = true
        val secondLeft = Array(n) { 0 }
        val secondRight = Array(n) { 0 }
        var (secondLeftLen, secondRightLen) = listOf(0, 0)

        i = n - 1
        while (true) {
            val ele = nums[i]
            if (secondRight[ele] >= 1)
                break

            secondRight[ele]++
            secondRightLen++
            i--
        }

        while (i >= 0) {
            val ele = nums[i]
            secondLeft[ele]++
            secondLeftLen++
            i--
        }

        if (!(check(secondLeft, secondLeftLen) && check(secondRight, secondRightLen)))
            secondFlag = false

        if (firstFlga && secondFlag) {
            if (firstLeftLen != secondLeftLen) {
                out.println("2")
                out.println("$firstLeftLen $firstRightLen")
                out.println("$secondLeftLen $secondRightLen")
            } else {
                out.println("1")
                out.println("$firstLeftLen $firstRightLen")
            }
        } else if (firstFlga) {
            out.println("1")
            out.println("$firstLeftLen $firstRightLen")
        } else if (secondFlag) {
            out.println("1")
            out.println("$secondLeftLen $secondRightLen")
        } else {
            out.println("0")
        }
    }

    fun check(arr: Array<Int>, len: Int): Boolean {

        for (i in 1..len) {
            if (arr[i] != 1)
                return false
        }

        return true
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        DreamoonLikesPermutations()
            .solveTestCase()
    }

    out.flush()
}