import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            analyzeFile();
        }
        catch (IOException e) {
            System.out.println("An error occurred while trying to access the file: " + e.getMessage());
        }
    }
    
    public static void analyzeFile() throws IOException {
        File file = new File("Kazuu1211.txt");
        if (!file.exists()) {
            System.out.println("File not found: " + file.getAbsolutePath());
            return;
        }

        int wordCount = 0;
        int sentenceCount = 0;
        int longestWordLength = 0;
        String longestWord = null;

        // Read and analyze the file
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] wordArray = line.split("\\s+");
                wordCount += wordArray.length;

                for (String word : wordArray) {
                    String trimmedWord = word.replaceAll("^[\\W_]+|[\\W_]+$", "");
                    int wordLength = trimmedWord.length();

                    if (wordLength > longestWordLength) {
                        longestWordLength = wordLength;
                        longestWord = trimmedWord;
                    }

                    char lastChar = word.charAt(word.length() - 1);
                    if (lastChar == '.' || lastChar == '?' || lastChar == '!') {
                        sentenceCount++;
                    }
                }
            }
        }

        // Write the uppercase version to a new file
        File newFile = new File("Kazuu1211Uppercase.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(newFile))) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(line.toUpperCase());
                    writer.newLine();
                }
            }
        }

        printResults(wordCount, sentenceCount, longestWord);
    }
    
    public static void printResults(int wordCount, int sentenceCount, String longestWord) {
        System.out.printf("==========================\n");
        System.out.printf("%-15s\t:  %d\n", "Word Count", wordCount);
        System.out.printf("%-15s\t:  %d\n", "Sentence Count", sentenceCount);
        System.out.printf("%-15s\t:  %s\n", "Longest Word", longestWord != null ? longestWord : "N/A");
    }
}
