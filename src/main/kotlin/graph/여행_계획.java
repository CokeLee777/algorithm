package graph;

import java.util.*;

public class 여행_계획 {

    private static int[] parent;

    private static int findParent(int x){
        if(parent[x] == x) return x;
        return parent[x] = findParent(parent[x]);
    }

    private static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //여행지의 수
        int m = sc.nextInt();   //여행 계획에 속한 도시의 수

        //부모 테이블 자기 자신으로 초기화
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int input = sc.nextInt();
                if(input == 1){
                    unionParent(i, j);
                }
            }
        }

        int prev = sc.nextInt() - 1;
        for(int i = 1; i < m; i++){
            int now = sc.nextInt() - 1;
            if(findParent(prev) != findParent(now)){
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
