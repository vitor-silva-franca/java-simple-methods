import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;

public class TextFileManipulation {

    public static void main(String[] args) {
        //createFile();
        //writeFile();
        //readFile();
        //deleteFile();
        //renameFile();
        //listFiles();
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

    }

    public static void decompressFile() {

    }

    public static void encryptFile() {

    }

    public static void decryptFile() {

    }


}
