package swea.d4;

import java.util.Scanner;

public class SW1210 {
    private final static int[] dx = {0, 0, -1};
    private final static int[] dy = {1, -1, 0};

    static int[][] map = new int[100][100];
    static boolean[][] visited = new boolean[100][100];
    static int sx, sy;
    static int result;

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

		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            T=sc.nextInt();

            for (int i = 0; i < 100; i++){
                for (int j = 0; j < 100; j++){
                    map[i][j] = sc.nextInt();
                    if (map[i][j] == 2){
                        sx = i;
                        sy = j;
                    }
                }
            }

            visited = new boolean[100][100];
            dfs(sx, sy);
            System.out.println("#" + T + " " + result);

        }
    }

    private static boolean inRange(int x, int y){
        return 0 <= x && x < 100 && 0 <= y && y < 100;
    }
    private static void dfs(int x, int y) {
        if (x == 0) {
            result =  y;
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 2; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!inRange(nx, ny) || visited[nx][ny] || map[nx][ny] == 0) continue;

            dfs(nx, ny);
            return;
        }

        int nx = x + dx[2];
        int ny = y + dy[2];

        dfs(nx, ny);
    }
}
