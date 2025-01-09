import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun nextInt() : Int { nextToken(); return  nval.toInt() }
    val n = nextInt()
    val dp = Array(n + 1) { LongArray(10) {0L} }
    repeat(9) {
        dp[1][it + 1] = 1
    }
    if (n == 1) { print(9) }
    else {
        for (i in 2 .. n) {
            for (j in 0 .. 9) {
                when (j) {
                    0 -> { dp[i][j] = dp[i - 1][1] % 1_000_000_000 }
                    9 -> { dp[i][j] = dp[i - 1][8] % 1_000_000_000}
                    else -> { dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1] % 1_000_000_000}
                }
            }
        }
        print(dp[n].reduce {acc, s -> acc + s } % 1_000_000_000L)
    }
}