package dynamicprogramming

import java.util.*
import kotlin.math.*

fun main(){
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()

    val foodStore = IntArray(n)
    for(i in foodStore.indices){
        foodStore[i] = sc.nextInt()
    }

    val dp = IntArray(n)
    dp[0] = foodStore[0]; dp[1] = max(foodStore[0], foodStore[1])
    for(i in 2 until n){
        dp[i] = max(dp[i-1], dp[i-2] + foodStore[i])
    }

    println(dp[n-1])
}