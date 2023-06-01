package binarysearch;

import java.util.Scanner;

public class 떡볶이_떡_만들기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 떡의 개수
        int m = sc.nextInt();   // 요청한 떡의 최소 길이

        int[] store = new int[n];
        int end = 0;
        for(int i = 0; i < n; i++) {
            int height = sc.nextInt();
            if(height > end) end = height;
            store[i] = height;
        }

        int maxHeight = 0;
        int start = 0;
        while(start <= end) {
            int mid = (start + end) / 2;
            // 떡 자르기
            int totalLeft = 0;
            for(int i = 0; i < store.length; i++) {
                int left = store[i] - mid;
                if(left > 0) totalLeft += left;
            }

            // 최소 높이가 충족되었다면
            if(totalLeft >= m) {
                if(mid > maxHeight) maxHeight = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(maxHeight);
    }
}
