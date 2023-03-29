package sort

fun main(){
    val arr = intArrayOf(7, 5, 9, 0, 3, 1, 6, 2, 4, 8)
    quickSort(arr, 0, arr.size - 1)
    for (element in arr) {
        print("$element ")
    }
}

fun quickSort(arr: IntArray, start: Int, end: Int) {
    //더 이상 분할할 수 없으면 종료
    if(start >= end) return
    val pivot = start
    var left = start + 1
    var right = end
    while(left <= right){
        //피벗보다 큰 데이터를 찾을때까지 반복
        while(left <= end && arr[left] <= arr[pivot]) left++
        //피벗보다 작은 데이터를 찾을때까지 반복
        while(start < right && arr[right] >= arr[pivot]) right--
        //엇갈렸다면 작은 데이터와 피벗을 교체
        if(left > right){
            arr.swap(pivot, right)
        }
        //엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
        else {
            arr.swap(left, right)
        }
        //분할 이후 왼쪽 부분와 오른쪽 부분에서 각각 정렬 수행
        quickSort(arr, start, right-1)
        quickSort(arr, right+1, end)
    }
}

fun IntArray.swap(index1: Int, index2: Int){
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}