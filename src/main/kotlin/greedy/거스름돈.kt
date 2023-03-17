package greedy

import java.util.Scanner

fun main(){
    val sc = Scanner(System.`in`)
    //받아야할 거스름돈을 입력받는다.
    var n = sc.nextInt()
    //가지고 있는 동전들 정의
    val coins = arrayOf(500, 100, 50, 10)

    var count = 0
    for(coin in coins){
        when(n / coin){
            0 -> continue   //이 동전으로는 거슬러줄 수 없다면 패스
            else -> {
                count += n / coin   //이 동전으로 거슬러준 개수를 더한다.
                n %= coin           //거슬러주고 남은 금액을 적용
            }
        }
    }

    println(count)
}