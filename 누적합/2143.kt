import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun nextInt() : Int {nextToken(); return nval.toInt()}
    val t = nextInt(); val n = nextInt()
    val a = IntArray(n) {nextInt()}
    val m = nextInt()
    val b = IntArray(m) {nextInt()}
    val sumA = HashMap<Int, Int>()
    repeat(n) {i ->
        var sum = 0
        for (j in i ..< n) {
            sum += a[j]
            if (sumA[sum] == null) {
                sumA[sum] = 1
            } else {
                sumA[sum] = sumA[sum]!! + 1
            }
        }
    }
    var ans = 0L
    repeat(m) {i ->
        var sum = 0
        for (j in i ..< m) {
            sum += b[j]
            ans += sumA.getOrDefault(t - sum, 0).toLong()
        }
    }
    print(ans)
}