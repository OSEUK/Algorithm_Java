/**
 * BAEKJOON ONLINE JUDGE
 * 문제 이름 : LCD Test
 * 문제 번호 : 2290
 * 난이도 : SILVER II
 */

package baekjoon.simulation.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ2290 {
    static int s;
    static String n;
    static char[][] lcd;

    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        n = st.nextToken();

        // LCD 디스플레이의 전체 크기 계산
        int height = 2 * s + 3;
        int width = (s + 2) * n.length() + n.length() - 1;
        lcd = new char[height][width];

        // LCD 배열을 공백으로 초기화
        for(int i = 0; i < height; i++) {
            Arrays.fill(lcd[i], ' ');
        }

        // 각 숫자별로 LCD 표현 생성
        for(int i = 0; i < n.length(); i++) {
            int num = n.charAt(i) - '0';
            drawNumber(num, i * (s + 3), 0);
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                sb.append(lcd[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void drawNumber(int num, int x, int y) {
        switch(num) {
            case 0:
                drawHorizontal(x, y, true);           // 상단
                drawVertical(x, y, true, true);       // 좌상단, 우상단
                drawHorizontal(x, y + s + 1, false);  // 중단
                drawVertical(x, y + s + 1, true, true); // 좌하단, 우하단
                drawHorizontal(x, y + 2*s + 2, true); // 하단
                break;
            case 1:
                drawVertical(x, y, false, true);      // 우상단
                drawVertical(x, y + s + 1, false, true); // 우하단
                break;
            case 2:
                drawHorizontal(x, y, true);           // 상단
                drawVertical(x, y, false, true);      // 우상단
                drawHorizontal(x, y + s + 1, true);   // 중단
                drawVertical(x, y + s + 1, true, false); // 좌하단
                drawHorizontal(x, y + 2*s + 2, true); // 하단
                break;
            case 3:
                drawHorizontal(x, y, true);           // 상단
                drawVertical(x, y, false, true);      // 우상단
                drawHorizontal(x, y + s + 1, true);   // 중단
                drawVertical(x, y + s + 1, false, true); // 우하단
                drawHorizontal(x, y + 2*s + 2, true); // 하단
                break;
            case 4:
                drawVertical(x, y, true, true);       // 좌상단, 우상단
                drawHorizontal(x, y + s + 1, true);   // 중단
                drawVertical(x, y + s + 1, false, true); // 우하단
                break;
            case 5:
                drawHorizontal(x, y, true);           // 상단
                drawVertical(x, y, true, false);      // 좌상단
                drawHorizontal(x, y + s + 1, true);   // 중단
                drawVertical(x, y + s + 1, false, true); // 우하단
                drawHorizontal(x, y + 2*s + 2, true); // 하단
                break;
            case 6:
                drawHorizontal(x, y, true);           // 상단
                drawVertical(x, y, true, false);      // 좌상단
                drawHorizontal(x, y + s + 1, true);   // 중단
                drawVertical(x, y + s + 1, true, true); // 좌하단, 우하단
                drawHorizontal(x, y + 2*s + 2, true); // 하단
                break;
            case 7:
                drawHorizontal(x, y, true);           // 상단
                drawVertical(x, y, false, true);      // 우상단
                drawVertical(x, y + s + 1, false, true); // 우하단
                break;
            case 8:
                drawHorizontal(x, y, true);           // 상단
                drawVertical(x, y, true, true);       // 좌상단, 우상단
                drawHorizontal(x, y + s + 1, true);   // 중단
                drawVertical(x, y + s + 1, true, true); // 좌하단, 우하단
                drawHorizontal(x, y + 2*s + 2, true); // 하단
                break;
            case 9:
                drawHorizontal(x, y, true);           // 상단
                drawVertical(x, y, true, true);       // 좌상단, 우상단
                drawHorizontal(x, y + s + 1, true);   // 중단
                drawVertical(x, y + s + 1, false, true); // 우하단
                drawHorizontal(x, y + 2*s + 2, true); // 하단
                break;
        }
    }

    // 가로선 그리기
    static void drawHorizontal(int x, int y, boolean draw) {
        if(!draw) return;
        for(int i = 0; i < s; i++) {
            lcd[y][x + 1 + i] = '-';
        }
    }

    // 세로선 그리기
    static void drawVertical(int x, int y, boolean left, boolean right) {
        for(int i = 0; i < s; i++) {
            if(left) lcd[y + 1 + i][x] = '|';
            if(right) lcd[y + 1 + i][x + s + 1] = '|';
        }
    }
}
