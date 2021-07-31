/* 
    Author: Aman Patel
    Date: 31-07-2021
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

private class TheChildAndToy {
    fun solveTestCase() {
        //TODO: Solve the question

        val (n, m) = readIntList()
        val energyArr = Array(n) { 0 }
        val energyList = mutableListOf<Pair<Int, Int>>()

        for (i in 0 until n) {
            val energyVal = readInt()
            energyArr[i] = energyVal
            energyList.add(Pair(energyVal, i))
        }

        val thread = mutableListOf<MutableList<Int>>()
        for (i in 0 until n) {
            thread.add(i, mutableListOf())
        }

        for (i in 0 until m) {
            var (a, b) = readIntList()
            a--
            b--
            addThread(thread, a, b)
        }

        energyList.sortByDescending { it.first }
        val removed = Array(n) { false }

        var resutl = 0
        for (ele in energyList) {
            val part = ele.second
            for (connectedParts in thread[part]) {
                if (removed[connectedParts])
                    continue
                resutl += energyArr[connectedParts]
            }

            removed[part] = true
        }

        out.println(resutl)
    }

    fun addThread(thread: MutableList<MutableList<Int>>, a: Int, b: Int) {
        thread[a].add(b)
        thread[b].add(a)
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        TheChildAndToy()
            .solveTestCase()
    }

    out.flush()
}