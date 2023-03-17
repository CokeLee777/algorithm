package greedy

import java.util.Scanner
import kotlin.math.max

fun main(){
    val sc = Scanner(System.`in`)
    val n = sc.nextInt(); val m = sc.nextInt()

    //리스트의 요소들을 입력받는다
    val cards = mutableListOf<MutableList<Int>>()
    for(i in 0 until n){
        cards.add(mutableListOf())
        for(j in 0 until m){
            cards[i].add(sc.nextInt())
        }
    }

    var maxValue = 0
    for (card in cards) {
        //이때 까지의 가장 큰 수와 현재 행의 가장 작은 수와 비교
        maxValue = max(maxValue, card.min())
    }

    println(maxValue)
}