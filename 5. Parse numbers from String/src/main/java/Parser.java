import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.StringTokenizer;
public class Parser {
    public static double parseString(String str){
        double result = 0.0;
        StringTokenizer st = new StringTokenizer(str, " \t\n\r,");
        while(st.hasMoreTokens()){
            String element = st.nextToken();
            if (element.matches("(([-+]?(?:\\d+(?:\\.\\d*)?|\\.\\d+)(?:[eE][-+]?\\d+)?)|([-+]?\\d+[lL]?)|([-+]?\\d+\\.\\d+[fF]?)|(PI)|(pi))")) {
                if (element.equals("PI") || element.equals("pi"))
                    result += Math.PI;
                else if (element.contains("l") || element.contains("L")) {
                    element = element.substring(0, element.length()-1);
                    double num = Long.parseLong(element);
                    result += num;
                }
                else if (element.contains("e+")) {
                    String deg = element.substring(element.indexOf("e") + 1);
                    double num = Double.parseDouble(element.substring(0,element.indexOf("e")));
                    int intodeg = Integer.parseInt(deg);
                    result += num * Math.pow(10, intodeg);
                }
                else if (element.contains("E+")) {
                    String deg = element.substring(element.indexOf("E") + 1);
                    double num = Double.parseDouble(element.substring(0,element.indexOf("E")));
                    int intodeg = Integer.parseInt(deg);
                    result += num * Math.pow(10, intodeg);
                }
                else {
                    double num = Double.parseDouble(element);
                    result += num;
                }
            }
        }

        return result;
    }
}
