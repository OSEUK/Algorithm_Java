package codetree.samsung;

public class RotateTest {
    static final int SIZE = 5;
    public static void main(String[] args) {
        int[][] arr = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                arr[i][j] = (i * SIZE) + j + 1;
            }
        }

        arr = rotate90part(arr, 0, 0, 3);

        print(arr);
    }

    public static int[][] rotate90part(int[][] arr, int sx, int sy, int len){
        int[][] temp = new int[len][len];


        for (int i = 0; i < len; i++){
            for (int j = 0; j < len; j++){
                temp[j][len-i-1] = arr[sx + i][sy + j];
            }
        }

        for (int i = 0; i < len; i++){
            for (int j = 0; j  < len; j++){
                arr[sx + i][sy + j] = temp[i][j];
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
