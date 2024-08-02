package programmers.skilltest;

public class lv3_2 {
    public static int[][] solution(int n, int[][] build_frame) {
        int[][] frame = new int[n+1][n+1];

        for (int i = 0; i < build_frame.length; i++){
            int[] f = build_frame[i];
            int x = f[0];
            int y = f[1];
            int struct = f[2];
            int isIstallOrRemove = f[3];

            // 바닥에 보?
            if (y == 0 && struct == 1) continue;
            // 기둥인데 떠있으면?
            if (y != 0 && struct == 0 && frame[x][y-1] == 0) continue;
            // 보인데 왼쪽에 기둥 아니면?
            if (struct == 1 && (frame[x][y] != 1 || frame[x][y-1] != 1)) continue;


        }

        return new int[][]{{1,2}, {2, 2}};
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] build_frame = {
                {1, 0, 0, 1},
                {1, 1, 1, 1},
                {2, 1, 0, 1},
                {2, 2, 1, 1},
                {5, 0, 0, 1},
                {5, 1, 0, 1},
                {4, 2, 1, 1},
                {3, 2, 1, 1}
        };

        System.out.println(solution(n, build_frame));
    }
}