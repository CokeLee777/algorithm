package greedy

import java.util.*

fun main(){
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()

    val coins = IntArray(n)
    for(i in 0 until n){
        coins[i] = sc.nextInt()
    }
    //동전들 정렬
    coins.sort()

    var minCost = 1
    for (coin in coins) {
        if(minCost < coin) break
        minCost += coin
    }
}