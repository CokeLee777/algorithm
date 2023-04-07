package dynamicprogramming

import java.util.*
import kotlin.math.*

fun main(){
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    when(n){
        1 -> println(1)
        2 -> println(3)
        else -> {
            val dp = IntArray(n)
            dp[0] = 1; dp[1] = 3
            for(i in 2 until n){
                dp[i] = (dp[i-1] + 2 * dp[i-2]) % 796796
            }
            println(dp[n-1])
        }
    }


}