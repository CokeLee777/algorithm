package implement

import java.util.Scanner

fun main(){
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()

    var count = 0
    for(h in 0..n){
        for(m in 0..59){
            for(s in 0..59){
                if('3' in h.toString() + m.toString() + s.toString()){
                    count += 1
                }
            }
        }
    }

    println(count)
}