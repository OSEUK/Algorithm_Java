/**
 * BAEKJOON ONLINE JUDGE
 * 문제 이름 : 수 이어 쓰기 2
 * 문제 번호 : 1790
 * 난이도 : GOLD V
 */

package baekjoon.binarysearch.gold;
import java.util.*;
import java.io.*;
public class BOJ1790 {
    static int N, K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        long target = 0;
        long numLen = 1;
        long numCnt = 9;

        while (K > numCnt * numLen){
            K -= (numLen * numCnt);
            target += numCnt;

            numLen++;
            numCnt *= 10;
        }

        target = (target + 1) + (K-1)/numLen;

        if (target > N) {
            System.out.println(-1);
        }
        else{
            int idx = (int)((K-1)%numLen);
            System.out.println(String.valueOf(target).charAt(idx));
        }
    }


}
