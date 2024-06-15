// 프로그래머스 lv1 최소 직사각형
package programmers.kit.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmallestRectangle {
    public static int solution(int[][] sizes) {
        int w = 0, h = 0;

        for (int[] size : sizes) {
            w = Math.max(w, Math.max(size[0], size[1]));
            h = Math.max(h, Math.min(size[0], size[1]));
        }

        return w * h;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] sizes = new int[N][2];

        for (int i = 0; i < N; i++){
            String[] str = br.readLine().split(" ");
            sizes[i][0] = Integer.parseInt(str[0]);
            sizes[i][1] = Integer.parseInt(str[1]);
        }

        int result = solution(sizes);
        System.out.println(result);
    }
}
