package graph;

import java.util.*;

public class 어두운_길 {

    private static int[] parent;
    private static List<House> houses = new ArrayList<>();

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
        int n = sc.nextInt();
        int m = sc.nextInt();

        //부모 테이블 초기화
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        //도로 정보 입력받기
        int totalCost = 0;
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();

            houses.add(new House(a, b, cost));
            totalCost += cost;
        }

        Collections.sort(houses);

        int realCost = 0;
        for(House house: houses){
            int x = house.getX();
            int y = house.getY();
            int cost = house.getCost();

            //사이클이 발생하지 않는다면
            if(findParent(x) != findParent(y)){
                unionParent(x, y);
                realCost += cost;
            }
        }

        System.out.println(totalCost - realCost);
    }

    static class House implements Comparable<House> {

        private int x;
        private int y;
        private int cost;

        public House(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        public int getX(){
            return this.x;
        }

        public int getY(){
            return this.y;
        }

        public int getCost(){
            return this.cost;
        }

        @Override
        public int compareTo(House other){
            return this.cost - other.cost;
        }
    }
}
