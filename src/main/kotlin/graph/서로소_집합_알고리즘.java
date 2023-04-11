package graph;

import java.util.*;

public class 서로소_집합_알고리즘 {

    private static int[] parent;

    public static int findParent(int x){
        if(parent[x] == x) return x;
        return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //노드의 개수
        int m = sc.nextInt();   //간선의 개수

        //부모 테이블 자기 자신으로 초기화
        parent = new int[n+1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }

        //간선정보 입력받기
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            unionParent(a, b);
        }

        //각 원소가 속한 집합 출력
        for(int i = 1; i <= n; i++){
            System.out.print(findParent(i) + " ");
        }
        System.out.println();

        //부모 테이블 내용 출력
        for(int i = 1; i <= n; i++){
            System.out.print(parent[i] + " ");
        }
    }
}
