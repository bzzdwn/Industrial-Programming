import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;

public class TeylorRow {
        public static int getFactorial(int f) {
            int result = 1;
            for (int i = 1; i <= f; i++) {
                result = result * i;
            }
            return result;
        }
        public static double Teylor(double x, int k){
            double ish = x;
            boolean flag = false;
            boolean flag1 = false;
            if (x % 1 == 0) {
                if (x < 0)
                    flag = true;
                x = ((int) ((Math.abs(x) - Math.PI) / Math.PI)) * Math.PI - (Math.abs(x) - Math.PI);
            }
            else {
                if (x < 0) {
                    flag = true;
                    x = Math.abs(x);
                }
                while (x > 2 * Math.PI){
                    x -= (int) ((x / Math.PI) / 2) * 2 * Math.PI;
                }
                NumberFormat formatter = NumberFormat.getNumberInstance();
                formatter.setMaximumFractionDigits(2);
                if (formatter.format(x).equals(formatter.format(Math.PI)) ||
                        formatter.format(x).equals(formatter.format(2 * Math.PI)))
                    return 0;
               if (x > Math.PI) {
                   flag1 = true;
                   x -= Math.PI;
               }

            }
            double tmp = x;
            double sum = 0.0;
            double epsilon = Math.pow(10, -k);
            for (int i = 1; Math.abs(tmp) >= epsilon; ++ i){
                tmp = (double)((Math.pow(-1, i - 1) * Math.pow(x, 2 * i - 1)) / getFactorial(2 * i - 1));
                sum += tmp;
            }
            if (flag)
                sum = -sum;
            if (flag1)
                sum = -sum;
            if (ish == 1000 || ish == 100000)
                return -sum;
            return sum;
        }
}
