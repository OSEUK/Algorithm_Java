package swea.d3;

import java.util.Scanner;

public class SW1244 {
    static int max;
    static String n;
    static int change;
    static int len;

    public static void main(String args[]) throws Exception
    {
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
        //System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {

            n = sc.next();
            change = sc.nextInt();
            len = n.length();

            if (change > len){
                change = len + (change - len) % 2;
            }

            max = 0;
            char[] arr = n.toCharArray();
            dfs(arr, 0, 0);

            System.out.println("#" + test_case + " " + max);
        }
    }

    private static void dfs(char[] arr, int start, int count){

        if (count == change){
            max = Math.max(max, Integer.parseInt(new String(arr)));
            return;
        }

        for (int i = start; i < len - 1; i++){
            for (int j = i + 1; j < len; j++){
                swap(arr, i, j);

                dfs(arr, i, count + 1);

                swap(arr, i, j);
            }
        }
    }

    private static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
