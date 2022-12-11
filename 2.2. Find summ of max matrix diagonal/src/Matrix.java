import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Matrix {
    public static int findMaxDiag(int[][] matrix, int rows, int cols){
        if (rows % 2 != 0 && cols % 2 == 0 || rows % 2 == 0 && cols % 2 != 0){
            return 0;
        } else {
            int max = Integer.MIN_VALUE;
            int sum = 0;
            for (int i = 1; i <= (rows-1); i++) {
                for (int j = 0; j < i; j++) {
                    for (int k = rows - i; k < rows; k++) {
                        if (i % 2 == (j + k) % 2 && k != j && j < k) {
                            sum += matrix[j][k];
                            k = rows;
                        }
                    }
                }
                if (sum > max) {
                    max = sum;
                }
                sum = 0;
            }
            for (int i = (rows-1); i >= 1; i--) {
                for (int j = i; j < rows; j++) {
                    for (int k = 0; k < rows - i; k++) {
                        if (i % 2 == (j + k) % 2 && k != j && j > k) {
                            sum += matrix[j][k];
                            j++ ;
                        }
                    }
                }
                if (sum > max) {
                    max = sum;
                }
                sum = 0;
            }
            return max;
        }
    }
    public static void main(String[] args) throws Exception{
        FileReader fr = new FileReader("in.txt");
        Scanner scanner = new Scanner(fr);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int matrix_1[][] = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix_1[i][j] = scanner.nextInt();
            }
        }
        System.out.println(findMaxDiag(matrix_1, rows, cols));
        fr.close();
    }
}
