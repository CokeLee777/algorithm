package greedy

import java.util.*
import kotlin.math.*

fun main(){
    val sc = Scanner(System.`in`)
    val str = sc.nextLine()
    //연속된 숫자들에 대해서 리스트로 뽑고, 원소가 없는 배열을 제외한 배열의 수 구하기
    val countOfZeros = str.split("1").count { it.isNotEmpty() }
    val countOfOnes = str.split("0").count { it.isNotEmpty() }
    //둘 중에 뒤집는 수가 적은 것을 반환
    println(min(countOfZeros, countOfOnes))
}