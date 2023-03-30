package greedy

import java.util.Scanner

fun main(){
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val fears = IntArray(n)
    for(i in 0 until n){
        fears[i] = sc.nextInt()
    }

    //공포도 값을 오름차순으로 정렬
    fears.sort()

    var peopleOfGroup = 0
    var numberOfGroup = 0
    for(fear in fears){
        peopleOfGroup += 1
        if(fear <= peopleOfGroup){
            numberOfGroup++
            peopleOfGroup = 0
        }
    }

    print(numberOfGroup)
}