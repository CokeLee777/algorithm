package greedy

import java.util.Scanner

fun main(){
    val sc = Scanner(System.`in`)
    var n = sc.nextInt(); val k = sc.nextInt()

    var answer = 0
    while(n >= k){
        when(n % k){
            0 -> {
                n /= k
                answer += 1
            }
            else -> {
                n -= 1
                answer += 1
            }
        }
    }

    //아직 1이되지 않았다면
    while(n > 1){
        n -= 1
        answer += 1
    }

    println(answer)
}