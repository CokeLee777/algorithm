package greedy

import java.util.*

fun main(){
    val sc = Scanner(System.`in`)
    val n = sc.nextInt(); val m = sc.nextInt()

    val balls = IntArray(n)
    val numberOfBallWeights = IntArray(m+1)
    for(i in 0 until n){
        val ballWeight = sc.nextInt()
        balls[i] = ballWeight
        numberOfBallWeights[ballWeight]++
    }

    //우선 같은 무게의 조합까지 계산
    var numberOfCombination = n * (n-1) / 2
    //무게가 중복되는 조합을 제거
    for (numberOfBall in numberOfBallWeights) {
        if(numberOfBall == 0) continue
        numberOfCombination -= (numberOfBall * (numberOfBall - 1)) / 2
    }

    println(numberOfCombination)
}