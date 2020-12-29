package console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleReader {
    private final Scanner scanner = new Scanner(System.in);
    private static ConsoleReader reader;

    private ConsoleReader() {

    }


    public static ConsoleReader getInstanse() {
        if (reader == null) {
            reader = new ConsoleReader();
            return reader;
        } else {
            return reader;
        }

    }

    public String readString() throws IOException {
        return scanner.nextLine();
    }

    public int readInt() throws IOException {
        return Integer.parseInt(scanner.nextLine());
    }

}
