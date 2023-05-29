package dfsbfs;

import java.util.*;

public class 인구_이동 {

    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {1, -1, 0, 0};
    private static int[][] graph;
    private static int n, l, r;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 땅의 크기
        n = sc.nextInt();
        // 두 나라의 인구 차이 l명 이상 r명 이하
        l = sc.nextInt();
        r = sc.nextInt();

        // 각 나라의 인구수 입력받기
        graph = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        // dfs 수행
        int populationMovements = 0;
        while(true) {
            int populationMovementCountPerDay = 0;
            boolean[][] visited = new boolean[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(!visited[i][j] && canPopulationMovement(i, j)) {
                        List<Country> temp = new ArrayList<>();
                        dfs(i, j, visited, temp);
                        setPopulation(temp);
                        populationMovementCountPerDay++;
                    }
                }
            }

            if(populationMovementCountPerDay == 0) break;
            populationMovements += 1;
        }

        System.out.println(populationMovements);
    }

    private static boolean canPopulationMovement(int x, int y) {
        for(int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx < 0 || nx >= n || ny < 0 || ny >= n)
                continue;
            int populationDiff = Math.abs(graph[x][y] - graph[nx][ny]);
            if(populationDiff >= l && populationDiff <= r) {
                return true;
            }
        }
        return false;
    }

    private static void setPopulation(List<Country> temp) {
        int totalSize = temp.size();
        int totalPopulation = 0;
        for(Country country : temp) {
            totalPopulation += country.getPopulation();
        }

        int dividedPopulation = totalPopulation / totalSize;
        for(Country country : temp) {
            int x = country.getX();
            int y = country.getY();

            graph[x][y] = dividedPopulation;
        }
    }

    private static void dfs(int x, int y, boolean[][] visited, List<Country> temp) {
        visited[x][y] = true;
        temp.add(new Country(x, y, graph[x][y]));

        // 네 방향 모두 확인
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 벽이라면 무시
            if(nx < 0 || nx >= n || ny < 0 || ny >= n)
                continue;
            // 이미 방문한 나라라면 무시
            if(visited[nx][ny]) continue;
            // 인구 차이가 l명 이상 r명 이하가 아니라면 무시
            int populationDiff = Math.abs(graph[x][y] - graph[nx][ny]);
            if(populationDiff >= l && populationDiff <= r) {
                dfs(nx, ny, visited, temp);
            }

        }
    }

    static class Country {

        private final int x;
        private final int y;
        private final int population;

        public Country(int x, int y, int population) {
            this.x = x;
            this.y = y;
            this.population = population;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getPopulation() {
            return population;
        }
    }
}
