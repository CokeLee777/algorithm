package sort

fun main(){
    val arr = intArrayOf(7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2)
    countingSort(arr)
}

fun countingSort(arr: IntArray) {
    val sortedArr = IntArray(10)

    for (element in arr) {
        sortedArr[element] += 1
    }

    for(i in 0..9){
        for(j in 0 until sortedArr[i]){
            print("$i ")
        }
    }
}
