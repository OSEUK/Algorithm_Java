/**
 * BAEKJOON ONLINE JUDGE
 * 문제 이름 : 사다리
 * 문제 번호 : 2022
 * 난이도 : GOLD IV
 */

package baekjoon.binarysearch.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2022 {
    static double x, y, c;

    // 알맞은 높이를 가지는 넓이 찾기
    public static boolean findWidth(double width){
        double xHeight = Math.sqrt(x*x - width*width);
        double yHeight = Math.sqrt(y*y - width*width);

        double height = (xHeight * yHeight) / (xHeight + yHeight);

        return height >= c;
    }

    // 이분 탐색 진행
    public static double solution(){
        double left = 0;
        double right = Math.min(x, y);

        // 수가 소수점 여섯째 까지 주어지므로 1e-6 보다 작게 차이가 날 경우 종료
        while (right - left > 0.000001){
            double mid = (left + right) / 2;

            if (findWidth(mid)){
                left = mid;
            }
            else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Double.parseDouble(st.nextToken());
        y = Double.parseDouble(st.nextToken());
        c = Double.parseDouble(st.nextToken());

        System.out.printf("%.3f", solution());
    }
}
