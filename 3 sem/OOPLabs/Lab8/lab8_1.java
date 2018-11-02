package OOPLabs.Lab8;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class lab8_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;

        System.out.print("Enter information ");
        line = sc.nextLine();

        try(FileWriter writer = new FileWriter("textfile", false)) {
            writer.write(line);
            writer.append('\n');
            writer.append('E');
            writer.flush();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
