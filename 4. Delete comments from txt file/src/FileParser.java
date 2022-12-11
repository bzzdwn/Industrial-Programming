import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

enum State {START, STR_BODY, CHR_BODY, CHR_SPEC_SYMBOL, SPEC_SYMBOL, SUSPECTED_STR, SUSPECTED_COMM, ONE_STR_COMM, DEFAULT_COMM, STAR}

public class FileParser {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("input.txt");
        FileWriter fw = new FileWriter("output.txt");
        Scanner sc = new Scanner(fr);
        State state = State.START;
        StringBuilder input_str = new StringBuilder();
        StringBuilder output_str = new StringBuilder();
        while (sc.hasNextLine()) {
            input_str.append(sc.nextLine() + "\n");
        }
        String str = input_str.toString();
        for(char symbol : str.toCharArray()){
            switch (state) {
                case START:
                    if (symbol == '\'') {
                        output_str.append(symbol);
                        state = State.CHR_BODY;
                    } else if (symbol == '\"') {
                        output_str.append(symbol);
                        state = State.STR_BODY;
                    } else if (symbol == '/')
                        state = State.SUSPECTED_COMM;
                    else {
                        output_str.append(symbol);
                        state = State.START;
                    }
                    break;
                case CHR_BODY:
                    if (symbol == '\'') {
                        output_str.append(symbol);
                        state = State.START;
                    } else if (symbol == '\\') {
                        output_str.append(symbol);
                        state = State.CHR_SPEC_SYMBOL;
                    }
                    else {
                        output_str.append(symbol);
                        state = State.CHR_BODY;
                    }
                    break;
                case STR_BODY:
                    if (symbol == '\"') {
                        output_str.append(symbol);
                        state = State.SUSPECTED_STR;
                    }
                    else if (symbol == '\\') {
                        output_str.append(symbol);
                        state = State.SPEC_SYMBOL;
                    } else {
                        output_str.append(symbol);
                        state = State.STR_BODY;
                    }
                    break;
                case SPEC_SYMBOL:
                    output_str.append(symbol);
                    state = State.STR_BODY;
                    break;
                case CHR_SPEC_SYMBOL:
                    output_str.append(symbol);
                    state = State.CHR_BODY;
                    break;
                case SUSPECTED_STR:
                    if (symbol == '\"') {
                        output_str.append(symbol);
                        state = State.STR_BODY;
                    } else {
                        output_str.append(symbol);
                        state = State.START;
                    }
                    break;
                case SUSPECTED_COMM:
                    if (symbol == '/') {
                        state = State.ONE_STR_COMM;
                    } else if (symbol == '*') {
                        state = State.DEFAULT_COMM;
                    } else if (symbol == '\'') {
                        output_str.append("/" + symbol);
                        state = State.CHR_BODY;
                    }
                    else {
                        output_str.append("/");
                        state = State.START;
                    }
                    break;
                case ONE_STR_COMM:
                    if (symbol == '\n') {
                        output_str.append(symbol);
                        state = State.START;
                    } else {
                        state = State.ONE_STR_COMM;
                    }
                    break;
                case DEFAULT_COMM:
                    if (symbol == '*') {
                        state = State.STAR;
                    } else {
                        state = State.DEFAULT_COMM;
                    }
                    break;
                case STAR:
                    if (symbol == '/') {
                        state = State.START;
                    } else {
                        state = State.DEFAULT_COMM;
                    }
                    break;
            }
        }
        fw.write(output_str.toString());
        fw.close();
    }
}
