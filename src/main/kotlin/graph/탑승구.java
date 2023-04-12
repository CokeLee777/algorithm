package graph;

import java.util.*;

public class 탑승구 {

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
        int g = sc.nextInt();   //탑승구의 수
        int p = sc.nextInt();   //비행기의 수

        //부모 테이블 초기화
        parent = new int[g+1];
        for(int i = 1; i <= g; i++){
            parent[i] = i;
        }

        //비행기 정보 입력받기
        int planeCount = 0;
        for(int i = 0; i < p; i++){
            int gateInfo = sc.nextInt();
            int rootGate = findParent(gateInfo);
            //루트 게이트가 0이라면 종료
            if(rootGate == 0) break;
            //아니라면 왼쪽의 집합과 합친다
            unionParent(rootGate, rootGate - 1);
            planeCount++;
        }

        System.out.println(planeCount);
    }
}
