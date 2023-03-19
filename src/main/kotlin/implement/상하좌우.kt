package implement

import java.util.Scanner

var x = 0; var y = 0

fun main(){
    val sc = Scanner(System.`in`)
    //정사각형의 가로, 세로 크기를 입력받음
    val n = sc.nextInt()
    sc.nextLine()
    //여행가의 이동 계획서를 입력받음
    val plans = sc.nextLine().split(" ")
    for (plan in plans) {
        when(plan){
            "R" -> {
                if(y + 1 >= n) continue
                y += 1
            }
            "L" -> {
                if(y - 1 < 0) continue
                y -= 1
            }
            "U" -> {
                if(x - 1 < 0) continue
                x -= 1
            }
            "D" -> {
                if(x + 1 >= n) continue
                x += 1
            }
        }
    }

    println("${x+1} ${y+1}")
}