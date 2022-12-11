import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Matrix {
    public static boolean IsSymmetrical(int[][]matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < i; j++) {
                if (matrix[i][j] != matrix[j][i])
                    return false;
            }
        }
        return true;
    }

    public static void DeleteLocMax(int[][]matrix, int rows, int cols){
        int[][] tmp_matrix = new int[rows+2][cols+2];
        for (int i = 0; i < rows + 2; i++) {
            Arrays.fill(tmp_matrix[i], Integer.MIN_VALUE);
        }
        for (int i = 1; i < rows + 1; i++) {
            for (int j = 1; j < cols + 1; j++) {
                tmp_matrix[i][j] = matrix[i-1][j-1];
            }
        }
        for (int i = 1; i < rows + 1; i++) {
            for (int j = 1; j < cols + 1; j++) {
                if (tmp_matrix[i][j] > tmp_matrix[i+1][j+1] && tmp_matrix[i][j] > tmp_matrix[i-1][j-1] &&
                        tmp_matrix[i][j] > tmp_matrix[i-1][j+1] && tmp_matrix[i][j] > tmp_matrix[i+1][j-1] &&
                        tmp_matrix[i][j] > tmp_matrix[i][j+1] && tmp_matrix[i][j] > tmp_matrix[i][j-1] &&
                        tmp_matrix[i][j] > tmp_matrix[i+1][j] && tmp_matrix[i][j] > tmp_matrix[i-1][j]){
                    matrix[i-1][j-1] = 0;
                    tmp_matrix[i][j] = 0;
                }
            }
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

        DeleteLocMax(matrix_1, rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix_1[i][j] + "\t");
            }
            System.out.print("\n");
        }
        if (IsSymmetrical(matrix_1, rows, cols))
            System.out.println("symmetrical");
        else
            System.out.println("not symmetrical");
        fr.close();
    }
}
