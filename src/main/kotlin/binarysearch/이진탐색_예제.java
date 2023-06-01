package binarysearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 이진 탐색: 데이터가 정렬되어 있어야만 사용할 수 있는 알고리즘
 */
public class 이진탐색_예제 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 원소의 개수
        int target = sc.nextInt();  // 찾고자 하는 숫자

        // 배열의 원소들 입력받기
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int targetIndex = binarySearch(arr, target, 0, n - 1);
        System.out.println(targetIndex);
    }

    private static int binarySearch(int[] arr, int target, int start, int end) {
        // 시작점이 끝점을 넘어간다면 -1 반환
        if(start > end) return -1;

        // 중간점 정의
        int mid = (start + end) / 2;

        // 중간점이 현재 찾는 값이라면
        if(arr[mid] == target) {
            return mid;
        } else if(arr[mid] > target) {
            return binarySearch(arr, target, start, mid - 1);
        } else {
            return binarySearch(arr, target, mid + 1, end);
        }
    }
}
