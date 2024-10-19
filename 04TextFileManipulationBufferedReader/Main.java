import java.io.*;

public class BufferedReaderTextFile {
    public static void main(String[] args) throws Exception {
		File mamamoFile = new File("Kazuu1211File.txt");
        BufferedReader br = new BufferedReader(new FileReader(mamamoFile));
        String st;
        while((st = br.readLine()) != null) {
            System.out.println(st);
        }
    }
}
