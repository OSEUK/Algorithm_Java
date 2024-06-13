package programmers.kit.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class FailedAthletes {
    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = makeHashMap(participant);

        eliminateComplete(completion, map);

        String key = "";
        for (String s : map.keySet()) {
            key = s;
        }

        return key;
    }

    // 해시맵 생성
    private static HashMap<String, Integer> makeHashMap(String[] participant) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : participant) {
            if (!map.containsKey(s)){
                map.put(s, 1);
            }
            else {
                int count = map.get(s);
                map.put(s, count + 1);
            }
        }
        return map;
    }
    // 완주한 선수들 제거
    private static void eliminateComplete(String[] completion, HashMap<String, Integer> map) {
        for (String s : completion) {
            int count = map.get(s);
            if (count > 1){
                map.put(s, count - 1);
            }
            else{
                map.remove(s);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] participant = br.readLine().split(" ");
        String[] completion = br.readLine().split(" ");

        System.out.println(solution(participant, completion));
    }
}
