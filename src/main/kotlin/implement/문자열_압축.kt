package implement

import java.util.*
import kotlin.math.*

fun solution(s: String): Int {
    var answer = s.length

    //압축 범위를 늘려가며 확인
    for(unitOfCompress in 1..s.length / 2){
        var compressedStr = ""              //압축된 문자열
        var prevStr = s.substring(0, unitOfCompress)  //이전 문자열
        var continuousCount = 1             //연속된 문자열의 수
        //단위 크기만큼 증가시키면서 이전 문자열과 비교한다
        for(i in unitOfCompress until s.length step unitOfCompress){
            val subStr = if(i + unitOfCompress <= s.length) s.substring(i, i+unitOfCompress) else s.substring(i)
            when(subStr){
                //이전 문자열과 동일하다면 압축 횟수 증가
                prevStr -> continuousCount++
                //아니라면
                else -> {
                    compressedStr += if(continuousCount > 1) continuousCount.toString() + prevStr else prevStr
                    //초기화
                    prevStr = subStr
                    continuousCount = 1
                }
            }
        }
        //나머지 문자열 처리
        compressedStr += if(continuousCount > 1) continuousCount.toString() + prevStr else prevStr
        //길이 비교
        answer = min(answer, compressedStr.length)
    }

    return answer
}