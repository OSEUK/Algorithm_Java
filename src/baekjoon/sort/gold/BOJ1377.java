/**
 * BAEKJOON ONLINE JUDGE
 * 문제 이름 : 버블 소트
 * 문제 번호 : 1377
 * 난이도 : GOLD II
 */

package baekjoon.sort.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Pair implements Comparable<Pair>{
    int value, originalIndex;

    Pair(int value, int originalIndex){
        this.value = value;
        this.originalIndex = originalIndex;
    }

    @Override
    public int compareTo(Pair o){
        return this.value - o.value;
    }
}
public class BOJ1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Pair[] arr = new Pair[N];

        for (int i = 0; i < N; i++){
            int value = Integer.parseInt(br.readLine());
            arr[i] = new Pair(value, i);
        }

        Arrays.sort(arr);

        int maxMove = 0;
        for (int i = 0; i < N; i++){
            int move = arr[i].originalIndex -  i;
            if (move > maxMove){
                maxMove = move;
            }
        }

        System.out.println(maxMove + 1);
    }
}
