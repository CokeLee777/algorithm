package binarysearch;

import java.util.Scanner;

public class 고정점_찾기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] numbers = new int[n];
        for(int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        int start = 0;
        int end = n - 1;
        while(start <= end) {
            int mid = (start + end) / 2;

            if(numbers[mid] == mid) {
                System.out.println(mid);
                return;
            } else if(numbers[mid] > mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(-1);
    }
}
