package programmers.kit.stackqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FeatureDevelopment {
    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        int n = progresses.length;
        int[] daysLeft = new int[n];

        for (int i = 0; i < n; i++){
            int progress = progresses[i];
            int speed = speeds[i];
            daysLeft[i] = (100 - progress) / speed;
            if ((100 - progress) % speed != 0)
                daysLeft[i]++;
        }

        int currentDeployDay = daysLeft[0];
        int count = 1;
        for (int i = 1; i < n; i++){
            if (daysLeft[i] <= currentDeployDay){
                count++;
            }else{
                result.add(count);
                count = 1;
                currentDeployDay = daysLeft[i];
            }

        }
        result.add(count);

        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] pro = br.readLine().split(" ");
        String[] spd = br.readLine().split( " ");

        int[] progresses = new int[pro.length];
        int[] speeds = new int[spd.length];

        for (int i = 0; i < pro.length; i++){
            progresses[i] = Integer.parseInt(pro[i]);
            speeds[i] = Integer.parseInt(spd[i]);
        }

        int[] result = solution(progresses, speeds);
        for (int res : result) {
            System.out.print(res + " ");
        }
    }

}
