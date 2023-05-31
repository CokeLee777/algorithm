package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 안테나 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 집의 수

        // 각 위치에 존재하는 집 넣기
        List<Integer> houses = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            houses.add(sc.nextInt());
        }

        Collections.sort(houses);

        System.out.println(houses.get((n - 1) / 2));
    }
}
