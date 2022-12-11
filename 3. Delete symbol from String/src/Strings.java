import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Strings {
    public static void InsertSymbol(String name, String k, String symbol_to_insert) throws Exception{
        FileReader fr = new FileReader(name);
        Scanner scanner = new Scanner(fr);
        FileWriter fw = new FileWriter("out_inserted.txt");
        while(scanner.hasNextLine()){
            String str = scanner.nextLine();
            if (str.lastIndexOf(k) > 0)
                fw.write(str.replaceAll(k, k + symbol_to_insert) + "\n");
            else
                fw.write(str + "\n");
        }
        fr.close();
        fw.close();
    }
    public static void DeleteSymbol(String name, String symbol_to_delete) throws Exception{
        FileReader fr = new FileReader(name);
        FileWriter fw = new FileWriter("out_deleted.txt");
        Scanner scanner = new Scanner(fr);
        boolean flag = false;
        while(scanner.hasNextLine()){
            String str = scanner.nextLine();
            if (str.lastIndexOf(symbol_to_delete) > 0)
                fw.write(str.replaceAll(symbol_to_delete, "") + "\n");
                flag = true;
        }
        //if (!flag) fw.write("there is no symbol " + symbol_to_delete + " in this string\n");
        fr.close();
        fw.close();
    }
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        String name = "in.txt";
        //int value = scanner.nextInt();
       /* if (){
            String symbol = scanner.nextLine();
            DeleteSymbol(name, symbol);*/
        //} else  {
            String symbol = scanner.nextLine();
            String k = scanner.nextLine();
            InsertSymbol(name, k, symbol);
        //}
    }
}
