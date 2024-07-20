package liveCodingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class P3 {
    private static final String FILE1_PATH = "src/file1.txt";
    private static final String FILE2_PATH = "src/file2.txt";
    private static final String OUTPUT_PATH = "output.txt";

    private static BlockingQueue<String> queue1 = new LinkedBlockingQueue<>();
    private static BlockingQueue<String> queue2 = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException {
        Thread reader1 = new Thread(new FileReaderTask(FILE1_PATH, queue1));
        Thread reader2 = new Thread(new FileReaderTask(FILE2_PATH, queue2));
        Thread writer = new Thread(new FileWriterTask());

        reader1.start();
        reader2.start();
        writer.start();

        reader1.join();
        reader2.join();

        queue1.put("EOF");
        queue2.put("EOF");
        writer.join();

        System.out.println("File processing completed.");
    }

    private static class FileReaderTask implements Runnable {
        private String filePath;
        private BlockingQueue<String> queue;

        FileReaderTask(String filePath, BlockingQueue<String> queue) {
            this.filePath = filePath;
            this.queue = queue;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (!line.trim().isEmpty()) {
                        String[] words = line.split("\\s+");
                        for (String word : words) {
                            queue.put(word);
                        }
                    }
                    queue.put("\n");
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class FileWriterTask implements Runnable {
        @Override
        public void run() {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_PATH))) {
                String word1 = null;
                String word2 = null;
                boolean newLine = false;
                while (true) {
                    if (word1 == null) {
                        word1 = queue1.take();
                    }
                    if (word1.equals("EOF")) {
                        break;
                    }
                    if (newLine && !word1.equals("\n")) {
                        writer.write("\n");
                        newLine = false;
                    }
                    if (!word1.equals("\n")) {
                        writer.write(word1);
                        writer.write(" ");
                        if (word1.endsWith(".") || word1.endsWith("?") || word1.endsWith("!")) {
                            newLine = true;
                        }
                    }
                    word1 = null;

                    if (word2 == null) {
                        word2 = queue2.take();
                    }
                    if (word2.equals("EOF")) {
                        break;
                    }
                    if (newLine && !word2.equals("\n")) {
                        writer.write("\n");
                        newLine = false;
                    }
                    if (!word2.equals("\n")) {
                        writer.write(word2);
                        writer.write(" ");
                        if (word2.endsWith(".") || word2.endsWith("?") || word2.endsWith("!")) {
                            newLine = true;
                        }
                    }
                    word2 = null;
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}