package binarysearch;

import java.util.Scanner;

public class 부품_찾기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 부품의 개수
        int[] store = new int[n];
        for(int i = 0; i < n; i++) {
            store[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        String[] results = new String[m];
        for(int i = 0; i < m; i++) {
            int target = sc.nextInt();

            results[i] = binarySearch(store, target, 0, n - 1);
        }

        for (String result : results) {
            System.out.print(result + " ");
        }
    }

    private static String binarySearch(int[] store, int target, int start, int end) {
        if(start > end) return "no";

        int mid = (start + end) / 2;
        if(store[mid] == target) {
            return "yes";
        } else if(store[mid] > target) {
            return binarySearch(store, target, start, mid - 1);
        } else {
            return binarySearch(store, target, mid + 1, end);
        }
    }
}
