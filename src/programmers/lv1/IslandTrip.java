// 프로그래머스 lv1 무인도 여행
package programmers.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class IslandTrip {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] maps = br.readLine().split(" ");

        IslandTrip it = new IslandTrip();
        int[] result = it.solution(maps);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
    public int[] solution(String[] maps){
        ArrayList<Integer> results = new ArrayList<>();
        int n = maps[0].length();
        int m = maps.length;
        char[][] charArray = new char[m][n];

        for (int i = 0; i < m; i++){
            charArray[i] = maps[i].toCharArray();
        }

        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (charArray[i][j] != 'X' && !visited[i][j]){
                    results.add(bfs(i, j, n, m, charArray, visited));
                }
            }
        }
        if (results.isEmpty()){
            results.add(-1);
        }
        Collections.sort(results);

        int[] answer = new int[results.size()];
        for (int i = 0; i < results.size(); i++){
            answer[i] = results.get(i);
        }

        return answer;
    }

    private int bfs(int x, int y, int n, int m, char[][] map, boolean[][] visited){
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int result = Integer.parseInt(String.valueOf(map[x][y]));

        while(!queue.isEmpty()){
            int[] position = queue.poll();

            for (int i = 0; i < 4; i++){
                int nx = position[0] + dx[i];
                int ny = position[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n)
                    continue;

                if (!visited[nx][ny] && map[nx][ny] != 'X'){
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    result += Integer.parseInt(String.valueOf(map[nx][ny]));
                }
            }
        }

        return result;
    }
}
