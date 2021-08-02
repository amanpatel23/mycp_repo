/*
    Author: Aman Patel
    Date: 01-08-2021
*/

import java.io.File
import java.io.PrintWriter
import java.util.*
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

private class NewsDistribution {
    var count = 0
    fun solveTestCase() {
        //TODO: Solve the question

        val (n, m) = readIntList()

        val parent = Array(n + 1) { it }
        val rank = Array(n + 1) { 0 }
        val setSize = Array(n + 1) { 1 }

        fun find(node: Int): Int {
            if (node == parent[node])
                return node

            parent[node] = find(parent[node])
            return parent[node]
        }

        fun union(parent1: Int, parent2: Int) {
            if (parent1 == parent2)
                return

            if (rank[parent1] > rank[parent2]) {
                parent[parent2] = parent1
                setSize[parent1] += setSize[parent2]
            } else {
                parent[parent1] = parent2
                setSize[parent2] += setSize[parent1]
                if (rank[parent1] == rank[parent2])
                    rank[parent2]++
            }
        }

        repeat(m) {

            var groupSize = readInt()
            if (groupSize != 0) {
                val alpha = readInt()

                groupSize--
                repeat(groupSize) {
                    val x = readInt()
                    val parent1 = find(alpha)
                    val parent2 = find(x)
                    //out.println("$parent1 $parent2")
                    union(parent1, parent2)
                }
            }
        }

        for (i in 1..n) {
            out.print("${setSize[find(i)]} ")
        }
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        NewsDistribution()
            .solveTestCase()
    }

    out.flush()
}