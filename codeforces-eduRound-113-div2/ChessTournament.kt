/* 
    Author: Aman Patel
    Date: 08-09-2021
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

private class Edu113 {
    fun solveTestCase() {
        //TODO: Solve the question

        val n = readInt()
        val str = readLn()

        val resultMatrix = Array(n) { Array(n) { '0' } }
        var flag = true
        for (i in 0 until n) {
            var won = false
            for (j in 0 until n) {

                if (i == j) {
                    resultMatrix[i][j] = 'X'
                    continue
                }

                if (str[i] == '1') {
                    resultMatrix[i][j] = '='
                    resultMatrix[j][i] = '='
                } else {
                    if (str[j] == '1') {
                        resultMatrix[i][j] = '='
                        resultMatrix[j][i] = '='
                    } else {

                        if (resultMatrix[i][j] != '0') {
                            if (resultMatrix[i][j] == '+')
                                won = true
                            continue
                        }
                        if (won) {
                            resultMatrix[i][j] = '-'
                            resultMatrix[j][i] = '+'
                        } else {
                            resultMatrix[i][j] = '+'
                            resultMatrix[j][i] = '-'
                            won = true
                        }
                    }
                }
            }

            if (str[i] == '2' && !won) {
                flag = false
                break
            }
        }

        if (flag) {
            out.println("YES")
            for (i in 0 until n) {
                out.println(resultMatrix[i].joinToString(""))
            }
        } else {
            out.println("NO")
        }
    }
}

fun main(args: Array<String>) {

    var t = 1
    t = readInt()
    repeat(t) {
        //TODO: Read in each Test Case

        Edu113()
            .solveTestCase()
    }

    out.flush()
}