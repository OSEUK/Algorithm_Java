/**
 * Programmers
 * 문제 이름 : 요격 미사일
 * 난이도 : Lv2
 */
package programmers.kit.greedy;

import java.util.*;
public class Missile {
    public int solution(int[][] targets) {
        // 출력 미사일 개수
        int answer = 1;
        // (s,e) 에서 e 기준으로 정리
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        // 처음 e값으로 이전 발사 미사일 설정
        int missile = targets[0][1];

        //
        for (int i = 1; i < targets.length; i++){
            if (targets[i][0] < missile){
                continue;
            }
            missile = targets[i][1];
            answer++;
        }

        return answer;

    }

}
