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

private class AquaMoonAndStrangeSort {
    fun solveTestCase(): String {
        //TODO: Solve the question
        val n = readInt()
        val nums = mutableListOf<Int>()
        val beforeSorting = mutableMapOf<Int, Pair<Int, Int>>()
        val afterSorting = mutableMapOf<Int, Pair<Int, Int>>()
        val set = mutableSetOf<Int>()

        var temp: Int
        for (i in 0 until n) {
            temp = readInt()
            nums.add(temp)
            beforeSorting.putIfAbsent(temp, Pair(0, 0))
            if (i and 1 == 1) {
                beforeSorting[temp] = Pair(beforeSorting[temp]!!.first + 1, beforeSorting[temp]!!.second)
            } else {
                beforeSorting[temp] = Pair(beforeSorting[temp]!!.first, beforeSorting[temp]!!.second + 1)
            }

            set.add(temp)
        }

        //outputWriter.println(beforeSorting)
        nums.sort()
        for (i in 0 until n) {
            afterSorting.putIfAbsent(nums[i], Pair(0, 0))
            if (i and 1 == 1) {
                afterSorting[nums[i]] = Pair(afterSorting[nums[i]]!!.first + 1, afterSorting[nums[i]]!!.second)
            } else {
                afterSorting[nums[i]] = Pair(afterSorting[nums[i]]!!.first, afterSorting[nums[i]]!!.second + 1)
            }
        }

        //outputWriter.println(afterSorting)
        var flag = true
        for (ele in set) {
            if (!(beforeSorting[ele]!!.first == afterSorting[ele]!!.first && beforeSorting[ele]!!.second == afterSorting[ele]!!.second)) {
                flag = false
                break
            }
        }


        return (if (flag) "YES" else "NO")
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        outputWriter.println(
            AquaMoonAndStrangeSort()
                .solveTestCase()
        )
    }

    outputWriter.flush()
}