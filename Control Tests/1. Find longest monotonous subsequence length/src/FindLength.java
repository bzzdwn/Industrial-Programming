import java.util.Scanner;

public class FindLength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int last_number = scanner.nextInt();
        if (last_number == 0) {
            System.out.println(0);
            return;
        }
        int new_number = scanner.nextInt();
        if (new_number == 0) {
            System.out.println(1);
            return;
        }
        int counter_1 = 1;
        int counter_2 = 1;
        int max = 1;
        while (last_number != 0 && new_number != 0) {
            while (new_number > last_number) {
                if (new_number == 0) break;
                counter_2 = 1;
                counter_1++;
                if (counter_1 > max) {
                    max = counter_1;
                    last_number = new_number;
                    new_number = scanner.nextInt();
                } else {
                    last_number = new_number;
                    new_number = scanner.nextInt();
                }
            }
            while (new_number < last_number) {
                counter_1 = 1;
                counter_2++;
                if (new_number == 0) break;
                if (counter_2 > max) {
                    max = counter_2;
                    last_number = new_number;
                    new_number = scanner.nextInt();
                } else {
                    last_number = new_number;
                    new_number = scanner.nextInt();
                }
            }
            while (new_number == last_number){
                counter_1 = counter_2 = 1;
                last_number = new_number;
                new_number = scanner.nextInt();
            }
        }
        System.out.println(max);
    }
}
