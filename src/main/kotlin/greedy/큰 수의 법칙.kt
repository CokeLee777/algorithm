package greedy

import java.util.Scanner

fun main(){
    //사용자로부터 정보를 입력받는다.
    val sc = Scanner(System.`in`)
    val n = sc.nextInt(); var m = sc.nextInt(); val k = sc.nextInt()
    val numbers = mutableListOf<Int>()
    for(i in 0 until n){
        numbers.add(i, sc.nextInt())
    }
    //리스트를 정렬하고 가장 큰 수와 두 번째로 큰 수를 찾는다.
    numbers.sort()
    val first = numbers[n-1]; val second = numbers[n-2]

    var answer = 0
    while(m > 0){
        for(i in 1..k){
            when(m){
                0 -> break
                else -> {
                    answer += first
                    m -= 1
                }
            }
        }
        when(m){
            0 -> break
            else -> {
                answer += second
                m -= 1
            }
        }
    }
    println(answer)
}