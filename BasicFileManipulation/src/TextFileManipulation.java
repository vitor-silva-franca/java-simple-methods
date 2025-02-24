import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.util.zip.GZIPOutputStream;

public class TextFileManipulation {

    public static void main(String[] args) {
        //createFile();
        //writeFile();
        //readFile();
        //deleteFile();
        //renameFile();
        //listFiles();
        //compressFile();
    }

    public static void createFile() {
        try {
            Path filePath = Path.of("example.txt");
            Files.createFile(filePath);
            System.out.println("File created successfully");
        } catch (FileAlreadyExistsException e) {
            System.out.println("File already exists");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("example.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile() {
        try {
            Path filePath = Path.of("example.txt");
            String content = "This is the example.txt file!\n";
            Files.writeString(filePath, content, StandardOpenOption.APPEND);
            System.out.println("Successfully wrote to the file");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void deleteFile() {
        try {
            Path filePath = Path.of("example.txt");
            Files.delete(filePath);
            System.out.println("File deleted successfully");
        } catch (NoSuchFileException e) {
            System.out.println("File does not exist");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void renameFile() {
        try {
            Path source = Path.of("example.txt");
            Path target = Path.of("exampleRenamed.txt");
            Files.move(source, target);
            System.out.println("File renamed successfully");
        } catch (NoSuchFileException e) {
            System.out.println("Source file does not exist");
        } catch (FileAlreadyExistsException e) {
            System.out.println("Target file already exists");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void listFiles() {
        try {
            Path directory = Path.of(".");  // current directory
            Files.list(directory)
                    .forEach(path -> System.out.println(path.getFileName()));
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void compressFile() {
        try {
            String fileName = "example.txt";

            Path inputPath = Path.of(fileName);
            Path outputPath = Path.of(fileName + ".gz");

            try (GZIPOutputStream gzipOut = new GZIPOutputStream(Files.newOutputStream(outputPath));
                 InputStream fileIn = Files.newInputStream(inputPath)) {

                byte[] buffer = new byte[1024];
                int len;

                while ((len = fileIn.read(buffer)) > 0) {
                    gzipOut.write(buffer, 0, len);
                }

                System.out.println("File compressed successfully to: " + outputPath);

            } catch (IOException e) {
                System.out.println("Error compressing file: " + e.getMessage());
                e.printStackTrace();
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void decompressFile() {

    }

    public static void encryptFile() {

    }

    public static void decryptFile() {

    }


}
