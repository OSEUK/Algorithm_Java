package codetree.samsung;

public class RotateTest {
    static final int SIZE = 5;
    static int[][] arr = new int[SIZE][SIZE];
    static int[][] arr2 = new int[2][3];
    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                arr[i][j] = (i * SIZE) + j + 1;
            }
        }

        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 3; j++){
                arr2[i][j] = (i * 2) + j + 1;
            }
        }

        rotateNMpart(arr2, 1, 1);

        print(arr);
    }

    public static void rotateNMpart(int[][] arr, int sx, int sy){
        int n = arr.length;
        int m = arr[0].length;
        int[][] temp = new int[m][n];

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                temp[j][n - i - 1] = arr[i + sx][j + sy];
            }
        }

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                arr2[i + sx][j + sy] = temp[i][j];
            }
        }
    }
    public static int[][] rotate90part(int sx, int sy, int len){
        int[][] temp = new int[len][len];


        for (int i = sx; i < sx + len; i++){
            for (int j = sy; j < sy + len; j++){
                int ox = i - sx;
                int oy = j - sy;

                int rx = oy;
                int ry = len - ox - 1;
                temp[rx][ry] = arr[i][j];
            }
        }

        for (int i = sx; i < sx + len; i++){
            for (int j = sy; j  < sy + len; j++){
                arr[i][j] = temp[i - sx][j - sy];
            }
        }

        return arr;
    }

    public static int[][] rotate90(int[][] arr){
        int len = arr.length;
        int[][] temp = new int[len][len];
        for (int i = 0; i < len; i++){
            for (int j = 0; j < len; j++){
                temp[j][len - i - 1] = arr[i][j];
            }
        }

        return temp;

    }


    public static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
