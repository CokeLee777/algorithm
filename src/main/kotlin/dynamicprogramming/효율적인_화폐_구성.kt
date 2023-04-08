package dynamicprogramming

import java.util.*
import kotlin.math.*

fun main(){
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val m = sc.nextInt()

    val coins = IntArray(n)
    for(i in coins.indices){
        coins[i] = sc.nextInt()
    }

    val dp = IntArray(m + 1){ 10001 }
    dp[0] = 0
    for(i in 0 until n){
        for(j in coins[i]..m){
            //(i - k)원을 만드는 방법이 존재하는 경우
            if(dp[j - coins[i]] != 10001){
                //만들 수 있는 경우의 수 중에서 최소의 동전 개수로 초기화
                dp[j] = min(dp[j], dp[j - coins[i]] + 1)
            }
        }
    }

    when(dp[m]){
        10001 -> println(-1)
        else -> println(dp[m])
    }

}