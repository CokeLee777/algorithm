package implement

import java.util.*
import kotlin.math.*

fun main(){
    val sc = Scanner(System.`in`)
    val s = sc.nextLine()

    val sortedS = s.toCharArray().sorted().joinToString("")
    var number = 0

    var answer = ""
    for(i in sortedS.indices){
        if(!sortedS[i].isDigit()){
            answer = sortedS.substring(i) + number
            break
        }
        number += sortedS[i].digitToInt()
    }

    println(answer)
}