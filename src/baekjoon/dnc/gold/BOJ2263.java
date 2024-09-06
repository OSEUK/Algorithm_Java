package baekjoon.dnc.gold;

/**
 * BAEKJOON ONLINE JUDGE
 * 문제 이름 : 트리의 순회
 * 문제 번호 : 2263
 * 난이도 : GOLD I
 * 이거 어려워서 못풀겠다..
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2263 {
    static int[] inorder;     // 중위 순회 배열
    static int[] postorder;   // 후위 순회 배열
    static int[] idx;         // 중위 순회 값의 인덱스를 저장하는 배열
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        inorder = new int[N];
        for (int i = 0; i < N; i++){
            inorder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        postorder = new int[N];
        for (int i = 0; i < N; i++){
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        idx = new int[N+1];
        // 중위 순회의 값이 배열의 어느 위치에 있는지 저장
        for (int i = 0; i < N; i++) {
            idx[inorder[i]] = i;
        }

        // 재귀 호출을 통해 전위 순회 구하기
        getPreorder(0, N - 1, 0, N - 1);

        System.out.println(sb.toString());

    }

    public static void getPreorder(int inStart, int inEnd, int postStart, int postEnd)
    {
        if (inStart > inEnd || postStart > postEnd) return;

        int root = postorder[postEnd];

        int rootIdx = idx[root];
        int leftSize = rootIdx - inStart;

        sb.append(root).append(" ");

        getPreorder(inStart, rootIdx  - 1, postStart, postStart + leftSize - 1);

        getPreorder(rootIdx + 1, inEnd, postStart + leftSize, postEnd - 1);
    }

}
