package binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 공유기_설치 {

    private static final List<Integer> houses = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 집의 개수
        int c = sc.nextInt();   // 공유기의 개수

        for(int i = 0; i < n; i++) {
            houses.add(sc.nextInt());
        }

        Collections.sort(houses);

        int start = 1;  // 가능한 최소 거리
        int end = houses.get(n - 1) - houses.get(0);    // 가능한 최대 거리
        int result = 0;

        while(start <= end) {
            int mid = (start + end) / 2;
            // 첫째집에는 무조건 공유기를 설치
            int now = houses.get(0);
            int count = 1;
            // 현재위치 + 가능한 거리의 중간값을 이용해서 공유기를 설치
            for(int i = 1; i < n; i++) {
                if(houses.get(i) >= now + mid) {
                    now = houses.get(i);
                    count += 1;
                }
            }

            // c개 이상의 공유기를 설치할 수 있다면, 거리 증가
            if(count >= c) {
                start = mid + 1;
                result = mid;
            }
            // 아니라면 거리 감소
            else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}
