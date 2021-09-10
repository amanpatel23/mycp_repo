/* 
    Author: Aman Patel
    Date: 10-09-2021
*/

import java.io.PrintWriter
import java.util.StringTokenizer
import java.io.File
import kotlin.math.abs

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

private class MochaAndDiana1 {
    fun solveTestCase() {
        //TODO: Solve the question

        val (n, m1, m2) = readIntList()

        val mocha = Array(n) { -1 }
        val diana = Array(n) { -1 }

        for (i in 0 until m1) {
            val (a, b) = readIntList().map { it - 1 }
            val (par1, par2) = listOf(find(a, mocha), find(b, mocha))
            union(par1, par2, mocha)
        }

        for (i in 0 until m2) {
            val (a, b) = readIntList().map { it - 1 }
            val (par1, par2) = listOf(find(a, diana), find(b, diana))
            union(par1, par2, diana)
        }

        val result = mutableListOf<Pair<Int, Int>>()
        for (i in 0 until n) {
            for (j in (i + 1) until n) {
                val par1 = find(i, mocha)
                val par2 = find(j, mocha)
                val par3 = find(i, diana)
                val par4 = find(j, diana)

                if (par1 == par2 || par3 == par4)
                    continue

                union(par1, par2, mocha)
                union(par3, par4, diana)

                result.add(Pair(i + 1, j + 1))
            }
        }

        out.println(result.size)
        result.forEach {
            out.println("${it.first} ${it.second}")
        }
    }

    fun find(i: Int, arr: Array<Int>): Int {
        if (arr[i] < 0)
            return i

        val par = find(arr[i], arr)
        arr[i] = par
        return par
    }

    fun union(par1: Int, par2: Int, arr: Array<Int>) {
        if (abs(arr[par1]) >= abs(arr[par2])) {
            arr[par1] += arr[par2]
            arr[par2] = par1
        } else {
            arr[par2] += arr[par1]
            arr[par1] = par2
        }
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        MochaAndDiana1()
            .solveTestCase()
    }

    out.flush()
}