import java.util.Scanner;
import java.io.*;
import java.text.*;
public class Matrix {
    public static void findIncreasingColumns(int[][]matrix, int rows, int cols){
        System.out.println("INCREASING ROWS:");
        boolean flag = true;
        int counter = 0;
        for (int i = 0; i < cols; i++) {
            for (int j = 1; j < rows; j++) {
                if (matrix[j][i] < matrix[j-1][i]){
                    flag = false;
                }
            }
            if (flag){
                System.out.println(i);
                counter++;
            }
            flag = true;
        }
        if (counter == 0){
            System.out.println("Here is no increasing rows");
        }
    }

    public static void findDecreasingColumns(int[][]matrix, int rows, int cols){
        System.out.println("DECREASING ROWS:");
        boolean flag = true;
        int counter = 0;
        for (int i = 0; i < cols; i++) {
            for (int j = 1; j < rows; j++) {
                if (matrix[j][i] > matrix[j-1][i]){
                    flag = false;
                }
            }
            if (flag){
                counter++;
                System.out.println(i);
            }
            flag = true;
        }
        if (counter == 0){
            System.out.println("Here is no decreasing rows");
        }
    }
    public static void main(String[] args) throws Exception {
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
        findIncreasingColumns(matrix_1, rows, cols);
        findDecreasingColumns(matrix_1, rows, cols);
        fr.close();
    }
}
