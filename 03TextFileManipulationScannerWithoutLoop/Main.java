import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File mamamofile = new File("Kazuu1211File.txt");
        Scanner sc = new Scanner(mamamofile);
     
        sc.useDelimiter("\\Z");
        System.out.println(sc.next());
    }
}
