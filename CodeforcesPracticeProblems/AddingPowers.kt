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

private class AddingPowers {

    val setBitsPos = Array(64) { 0 }

    fun solveTestCase() {
        //TODO: Solve the question

        val (n, k) = readIntList()
        val nums = readLongArray(n)

        var flag = true
        for (ele in nums) {
            if (ele == 0L)
                continue

            if (!check(ele, k)) {
                flag = false
                break
            }
        }

        if (flag)
            outputWriter.println("YES")
        else
            outputWriter.println("NO")
    }

    fun check(num: Long, k: Int): Boolean {

        var idx = 0
        var x = num
        while (x > 0) {
            if (x % k == 0L) {
                idx++
                x /= k
                continue
            }
            if (x % k == 1L) {
                if (setBitsPos[idx] >= 1)
                    return false
                setBitsPos[idx]++
                idx++
                x /= k
                continue
            }
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

        AddingPowers()
            .solveTestCase()
    }

    outputWriter.flush()
}