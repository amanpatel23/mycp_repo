import java.io.PrintWriter
import java.util.StringTokenizer
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

private class ApplejactAndStorages {
    fun solveTestCase(): Unit {
        //TODO: Solve the question

        val n = readInt()
        val freq = mutableMapOf<Int, Int>()
        var temp: Int
        for (i in 0 until n) {
            temp = readInt()
            freq[temp] = freq.getOrPut(temp) { 0 } + 1
        }

        var sameFourSides = 0
        var sameTwoSides = 0
        for ((_, v) in freq) {
            sameFourSides += (v / 4)
            sameTwoSides += ((v % 4) / 2)
        }

        var ans = "NO"
        if (check(sameFourSides, sameTwoSides))
            ans = "YES"

        var tempStr: String
        var sign: String
        var x: Int
        repeat(readInt()) {
            tempStr = readLn()
            sign = tempStr.split(' ')[0]
            x = tempStr.split(' ')[1].toInt()

            //outputWriter.println(x + 1)
            val prevVal: Int
            val currVal: Int
            if (sign == "+") {
                freq[x] = freq.getOrPut(x) { 0 } + 1
                currVal = freq[x]!!
                prevVal = currVal - 1
            } else {
                freq[x] = freq[x]!! - 1
                currVal = freq[x]!!
                prevVal = currVal + 1
            }
            
            sameFourSides -= (prevVal / 4)
            sameTwoSides -= ((prevVal % 4) / 2)

            sameFourSides += (currVal / 4)
            sameTwoSides += ((currVal % 4) / 2)

            ans = if (check(sameFourSides, sameTwoSides))
                "YES"
            else
                "NO"

            outputWriter.println(ans)
        }
    }

    fun check(sameFourSidess: Int, sameTwoSides: Int): Boolean {
        return ((sameFourSidess >= 2) || (sameFourSidess >= 1 && sameTwoSides >= 2))
    }
}

fun main(args: Array<String>) {

    var t = 1
    //t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        ApplejactAndStorages()
            .solveTestCase()
    }

    outputWriter.flush()
}