import java.io.PrintWriter
import java.util.StringTokenizer
import java.util.*
import java.io.File

private val checkOnlineJudge = System.getProperty("ONLINE_JUDGE") == null
private val INPUT = if (checkOnlineJudge) File("src/input.txt").inputStream() else System.`in`
private val OUTPUT = if (checkOnlineJudge) File("src/output.txt").outputStream() else System.out

private val bufferedReader = INPUT.bufferedReader()
private val outputWriter = PrintWriter(OUTPUT, false)
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

private class SoldierAndCards {
    fun solveTestCase(): Unit {
        //TODO: Solve the question

        val n = readInt()
        val s1: Queue<Int> = LinkedList<Int>()
        val s2: Queue<Int> = LinkedList<Int>()

        val k1 = readInt()
        //outputWriter.println("k1: $k1")
        for (i in 0 until k1) {
            s1.add(readInt())
        }

        val k2 = readInt()
        //outputWriter.println("k2: $k2")
        for (i in 0 until k2) {
            s2.add(readInt())
        }

        var flag = true;
        var limit = (1e6).toInt()
        var count = 0
        while (limit-- > 0) {

            if (s1.size == 0) {
                outputWriter.println("$count 2")
                flag = false
                break
            } else if (s2.size == 0) {
                outputWriter.println("$count 1")
                flag = false
                break
            }

            val s1Front = s1.poll()
            val s2Front = s2.poll()
            //outputWriter.println("$s1Front $s2Front  ")
            if (s1Front > s2Front  ) {
                s1.add(s2Front )
                s1.add(s1Front)
            } else {
                s2.add(s1Front)
                s2.add(s2Front )
            }
            count++

        }

        if (flag)
            outputWriter.println("-1")
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        SoldierAndCards()
            .solveTestCase()
    }

    outputWriter.flush()
}