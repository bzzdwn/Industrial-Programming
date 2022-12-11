import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.regex.*;

public class Regular {
    public static void main(String[] args) throws Exception{
        FileReader fr = new FileReader("in.txt");
        Scanner scanner = new Scanner(fr);
        while (scanner.hasNextLine()){
            String str = scanner.nextLine();
            Pattern pattern = Pattern.compile("(^|[ ,])(-?\\d+([.]\\d+)?)([ ,]|$)");
            Matcher matcher = pattern.matcher(str);
            while(matcher.find())
                System.out.println(matcher.group(2));
        }
        fr.close();
    }
}
