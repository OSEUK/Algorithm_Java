package programmers.skilltest;

import java.util.Arrays;

public class lv3_1 {
    public static int solution(int n, int[][] data) {
        int answer = 0;

        Arrays.sort(data);

        for (int i = 0; i < n; i++){
            int[] first = data[i];
            for (int j = i; j < n; j++){
                int[] second = data[j];

                if (first[0] == second[0] || first[1] == second[1]) continue;

                boolean canDo = true;
                for (int k = 0; k < n; k++){
                    if (k == i || k == j) continue;

                    int[] check = data[k];
                    int xMax = Math.max(first[0], second[0]);
                    int xMin = Math.min(first[0], second[0]);
                    int yMax = Math.max(first[1], second[1]);
                    int yMin = Math.min(first[1], second[1]);

                    if (check[0] > xMin && check[0] < xMax && check[1] > yMin && check[1] < yMax  ) {
                        canDo = false;
                        break;

                    }
                }

                if (canDo) answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int n = 4;
        int[][] data = {
                {0, 0},
                {1, 1},
                {0, 2},
                {2, 0}
        };

        System.out.println(solution(n, data));
    }
}
