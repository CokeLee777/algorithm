package dfsbfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 감시_피하기 {

    private static char[][] graph;
    private static boolean canAvoid;
    private static final List<Teacher> teachers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 복도의 크기 입력받기
        int n = sc.nextInt();
        sc.nextLine();
        // 그래프 초기화
        graph = new char[n][n];
        for(int i = 0; i < n; i++) {
            String[] rows = sc.nextLine().split(" ");
            for(int j = 0; j < rows.length; j++) {
                char row = rows[j].charAt(0);
                if(row == 'T') {
                    teachers.add(new Teacher(i, j));
                }
                graph[i][j] = row;
            }
        }

        // dfs 수행
        dfs(n, 0);

        if(canAvoid) System.out.println("YES");
        else System.out.println("NO");
    }

    public static void dfs(int n, int wallCount) {
        if(wallCount == 3) {
            if(!canMeet(n)) {
                canAvoid = true;
            }
        } else {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(graph[i][j] == 'X' && graph[i][j] != 'O') {
                        wallCount += 1;
                        graph[i][j] = 'O';
                        dfs(n, wallCount);
                        graph[i][j] = 'X';
                        wallCount -= 1;
                    }
                }
            }
        }
    }

    public static boolean canMeet(int n) {
        for(Teacher teacher: teachers) {
            int x = teacher.x;
            int y = teacher.y;
            // 가로 방향 확인
            int index = y - 1;
            while(index >= 0) {
                if(graph[x][index] == 'O') break;
                if(graph[x][index] == 'S') return true;
                index -= 1;
            }
            index = y + 1;
            while(index < n) {
                if(graph[x][index] == 'O') break;
                if(graph[x][index] == 'S') return true;
                index += 1;
            }

            // 세로 방향 확인
            index = x - 1;
            while(index >= 0) {
                if(graph[index][y] == 'O') break;
                if(graph[index][y] == 'S') return true;
                index -= 1;
            }
            index = x + 1;
            while(index < n) {
                if(graph[index][y] == 'O') break;
                if(graph[index][y] == 'S') return true;
                index += 1;
            }
        }

        return false;
    }

    static class Teacher {

        private final int x;
        private final int y;

        public Teacher(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}


