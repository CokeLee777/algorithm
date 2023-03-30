package greedy

import java.util.Scanner

fun main(){
    val sc = Scanner(System.`in`)
    val numbers = sc.nextLine()

    var result = 0
    for(i in numbers.indices){
        val number = numbers[i].digitToInt()
        //결과값 또는 현재값이 1보다 작다면 더한다
        if(result <= 1 || number <= 1) result += number
        else result *= number
    }

    println(result)
}