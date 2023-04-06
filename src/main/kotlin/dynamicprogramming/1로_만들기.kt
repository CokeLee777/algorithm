package dynamicprogramming

import java.util.*
import kotlin.math.*

fun main(){
    val sc = Scanner(System.`in`)
    val x = sc.nextInt()

    //보텀업 메모이제이션 기법으로 풀이
    val dp = IntArray(x + 1)
    for(i in 2 .. x){
        //현재의 수에서 1을 빼는 경우
        dp[i] = dp[i-1] + 1
        //2로 나누어 떨어지는 경우
        if(i % 2 == 0) dp[i] = min(dp[i], dp[i/2] + 1)
        //3으로 나누어 떨어지는 경우
        if(i % 3 == 0) dp[i] = min(dp[i], dp[i/3] + 1)
        //5로 나누어 떨어지는 경우
        if(i % 5 == 0) dp[i] = min(dp[i], dp[i/5] + 1)
    }

    println(dp[x])
}