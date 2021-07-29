import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

public class LoadingInTextFile {

    public static void main(String[] args) throws FileNotFoundException {
        File textfile = new File("./src/main/java/sometext.txt");
        System.out.println(textfile.getAbsolutePath());
        Scanner scanner = new Scanner(textfile);
        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
    }
}
