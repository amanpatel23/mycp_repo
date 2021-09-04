/* 
    Author: Aman Patel
    Date: 04-09-2021
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

private const val N = 50

private class DZYLovesChemistry {

    val adjList = mutableListOf<MutableList<Int>>()
    val visited = Array(N) { false }

    fun createGraph() {
        for (i in 0 until N)
            adjList.add(mutableListOf())
    }

    fun addEdge(a: Int, b: Int) {
        adjList[a].add(b)
        adjList[b].add(a)
    }

    fun power(_a: Long, _b: Long): Long {

        var (a, b) = listOf(_a, _b)
        var result = 1L
        while (b > 0) {
            if (b and 1 == 1L) {
                result *= a
                b--
            }

            a *= a
            b = (b shr 1)
        }

        return result
    }

    fun solveTestCase() {
        //TODO: Solve the question

        createGraph()

        val (_, m) = readIntList()
        for (i in 0 until m) {
            val (a, b) = readIntList().map { it - 1 }
            addEdge(a, b)
        }

        var result = 1L
        for (i in 0 until N) {
            val tempVisited = Array(N) { false }
            val count = dfs(i, tempVisited)
            result *= (if (count >= 2) power(2L, count - 1) else 1)
        }

        out.println(result)
    }

    fun dfs(i: Int, tempVisited: Array<Boolean>): Long {

        if (tempVisited[i] || visited[i])
            return 0L

        visited[i] = true; tempVisited[i] = true

        var ans = 1L
        for (x in adjList[i]) {
            ans += dfs(x, tempVisited)
        }

        tempVisited[i] = false
        return ans
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        DZYLovesChemistry()
            .solveTestCase()
    }

    out.flush()
}