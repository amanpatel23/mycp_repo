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

private class DreamoonLikesPermutations2 {
    fun solveTestCase() {
        //TODO: Solve the question

        val n = readInt()
        val nums: MutableList<Int> = mutableListOf()
        for (i in 0 until n) {
            nums.add(readInt())
        }

        val maxEle: Int? = nums.maxOrNull()
        val left = mutableListOf<Int>()
        val right = mutableListOf<Int>()
        left.addAll(nums.subList(0, maxEle!!))
        right.addAll(nums.subList(maxEle!!, n))

        left.sort()
        right.sort()

        var firstFlag = true
        if (!(check(left) && check(right))) {
            firstFlag = false
        }

        left.clear()
        right.clear()

        left.addAll(nums.subList(0, (n - maxEle!!)))
        right.addAll(nums.subList((n - maxEle!!), n))

        left.sort()
        right.sort()

        var secondFlag = true
        if (!(check(left) && check(right))) {
            secondFlag = false
        }

        if (firstFlag && secondFlag) {
            if (maxEle != (n - maxEle)) {
                out.println("2")
                out.println("$maxEle ${n - maxEle}")
                out.println("${n - maxEle} $maxEle")
            } else {
                out.println("1")
                out.println("$maxEle ${n - maxEle}")
            }
        } else if (firstFlag) {
            out.println("1")
            out.println("$maxEle ${n - maxEle}")
        } else if (secondFlag) {
            out.println("1")
            out.println("${n - maxEle} $maxEle")
        } else {
            out.println("0")
        }
    }

    fun check(arr: MutableList<Int>): Boolean {
        for ((index, value) in arr.withIndex()) {
            //out.println("$value $index")
            if (value != index + 1)
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

        DreamoonLikesPermutations2()
            .solveTestCase()
    }

    out.flush()
}