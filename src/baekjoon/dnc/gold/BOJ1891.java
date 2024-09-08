/**
 * BAEKJOON ONLINE JUDGE
 * 문제 이름 : 사분면
 * 문제 번호 : 1891
 * 난이도 : GOLD IV.
 */
package baekjoon.dnc.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1891 {
    static String quadrant;
    static int d;
    static long x, y;
    static long newX = 0, newY = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        d = Integer.parseInt(st.nextToken());
        quadrant = st.nextToken();

        st = new StringTokenizer(br.readLine());
        y = Long.parseLong(st.nextToken());
        x = Long.parseLong(st.nextToken());

        long size = 1L << d;
        findLocation(0, 0, 0, size, size);

        newX -= x;
        newY += y;

        if (newX >= 0 && newX < size && newY >= 0 && newY < size){
            System.out.println(determineQuadrant(d, newX, newY));
        } else{
            System.out.println(-1);
        }
    }

    public static void findLocation(int index, long lx, long ly, long rx, long ry) {
        if (index == d) {  // 모든 경로를 따라갔다면 좌표 저장
            newX = lx;
            newY = ly;
            return;
        }

        int num = quadrant.charAt(index) - '0';  // 사분면 번호 추출
        if (num == 1) {
            findLocation(index + 1, lx, (ly + ry) / 2, (lx + rx) / 2, ry);
        } else if (num == 2) {
            findLocation(index + 1, lx, ly, (lx + rx) / 2, (ly + ry) / 2);
        } else if (num == 3) {
            findLocation(index + 1, (lx + rx) / 2, ly, rx, (ly + ry) / 2);
        } else if (num == 4) {
            findLocation(index + 1, (lx + rx) / 2, (ly + ry) / 2, rx, ry);
        }
    }

    public static String determineQuadrant(int length, long x, long y) {
        if (length == 0) return "";
        long half = 1L << (length - 1);

        if (x < half && y >= half) {
            return "1" + determineQuadrant(length - 1, x, y - half);
        } else if (x < half && y < half) {
            return "2" + determineQuadrant(length - 1, x, y);
        } else if (x >= half && y < half) {
            return "3" + determineQuadrant(length - 1, x - half, y);
        } else {
            return "4" + determineQuadrant(length - 1, x - half, y - half);
        }
    }

}
