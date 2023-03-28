package sort

fun main(){
    val arr = intArrayOf(7,5,9,0,3,1,6,2,4,8)
    val sortedArr = insertionSort(arr)
    for (element in sortedArr) {
        print("$element ")
    }
}

fun insertionSort(arr: IntArray): IntArray {
    for(i in 1 until arr.size){
        var insertIndex = i
        for(j in i-1 downTo  0){
            //삽입이 가능하다면 스와핑
            if(arr[j] > arr[j+1]){
                val temp = arr[j]
                arr[j] = arr[j+1]
                arr[j+1] = temp
            } else {
                break
            }
        }
    }
    return arr
}