package app_java_3;

import java.io.FileWriter;
import java.io.IOException;

public class D {
    public static void main(String[] args) {
        // Use try-with-resources for auto-close (optional but recommended)
        try (FileWriter fw = new FileWriter("D:\\upsc\\t4.txt", false)) {
            fw.write(97);              // writes 'a' (ASCII 97)
            fw.write("100");           // writes "100"
            fw.write(new char[]{'a', 'b', 'c'});  // writes "abc"

            System.out.println("File written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
