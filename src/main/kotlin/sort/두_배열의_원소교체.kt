package sort

import java.util.Scanner

fun main(){
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val k = sc.nextInt()
    //두 개의 배열 입력받기
    sc.nextLine()

    val arrA = IntArray(n)
    for(i in 0 until n){
        arrA[i] = sc.nextInt()
    }
    val arrB = IntArray(n)
    for(i in 0 until n){
        arrB[i] = sc.nextInt()
    }

    //두 배열 정렬: 배열 A는 오름차순, 배열 B는 내림차순
    arrA.sort()
    arrB.sortDescending()

    //앞에서부터 차례대로 스와핑
    for(i in 0 until k){
        val temp = arrA[i]
        arrA[i] = arrB[i]
        arrB[i] = temp
    }

    print(arrA.sum())
}
