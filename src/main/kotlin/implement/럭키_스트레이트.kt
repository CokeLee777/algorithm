package implement

import java.util.*
import kotlin.math.*

fun main(){
    val sc = Scanner(System.`in`)
    val n = sc.nextLine()

    var left = 0; var right = n.length - 1
    var sum = 0
    while(left < right){
        sum += (n[left].digitToInt() - n[right].digitToInt())
        left++; right--
    }

    when(sum){
        0 -> println("LUCKY")
        else -> println("READY")
    }
}