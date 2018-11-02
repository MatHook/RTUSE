package OOPLabs.Lab8;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class lab8_4 {
    public static void main(String[] args) throws IOException {
        Writer writer;
        Scanner in = new Scanner(System.in);
        System.out.println("Input information to add: ");
        String line = in.nextLine();

        writer = new BufferedWriter(new FileWriter("textfile", true));
        writer.append(line);
        writer.close();
    }
}
