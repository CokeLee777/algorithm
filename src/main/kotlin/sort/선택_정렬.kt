package sort

fun main(){
    val arr = intArrayOf(7,5,9,0,3,1,6,2,4,8)
    val sortedArr = selectionSort(arr)
    for (element in sortedArr) {
        print("$element ")
    }
}

fun selectionSort(arr: IntArray): IntArray {
    for(i in arr.indices){
        var minIndex = i
        for(j in i+1 until arr.size){
            //더 작은 원소가 나온다면
            if(arr[j] < arr[minIndex]){
                minIndex = j
            }
        }
        //스와핑
        val temp = arr[i]
        arr[i] = arr[minIndex]
        arr[minIndex] = temp
    }
    return arr
}