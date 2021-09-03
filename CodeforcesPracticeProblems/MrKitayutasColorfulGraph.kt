/* 
    Author: Aman Patel
    Date: 03-09-2021
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

private class ColorfulGraph {
    fun solveTestCase() {
        //TODO: Solve the question

        val (n, m) = readIntList()
        val adjList = mutableListOf<MutableList<Pair<Int, Int>>>()
        for (i in 0..n) {
            adjList.add(mutableListOf())
        }

        for (i in 0 until m) {
            val (a, b, c) = readIntList()
            adjList[a].add(Pair(b, c))
            adjList[b].add(Pair(a, c))
        }

        fun dfs(u: Int, v: Int, color: Int, visited: Array<Boolean>): Boolean {

            if (u == v)
                return true

            visited[u] = true

            for (x in adjList[u]) {
                if (!visited[x.first] && x.second == color) {
                    if (dfs(x.first, v, color, visited))
                        return true
                }
            }

            visited[u] = false
            return false
        }

        val q = readInt()
        repeat(q) {

            val (u, v) = readIntList()
            var result = 0
            for (i in 1..m) {
                val visited = Array(n + 1) { false }
                if (dfs(u, v, i, visited))
                    result++
            }

            out.println(result)
        }
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        ColorfulGraph()
            .solveTestCase()
    }

    out.flush()
}