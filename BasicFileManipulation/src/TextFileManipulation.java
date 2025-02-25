import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.file.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.zip.GZIPInputStream;
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
        //decompressFile();
        //encryptFile();
        decryptFile();
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
        try {
            try (FileInputStream fileIn = new FileInputStream("example.txt.gz");
                 GZIPInputStream gzipIn = new GZIPInputStream(fileIn);
                 FileOutputStream fileOut = new FileOutputStream("decompressed.txt")) {

                byte[] buffer = new byte[1024];
                int len;

                while ((len = gzipIn.read(buffer)) > 0) {
                    fileOut.write(buffer, 0, len);
                }

                System.out.println("File decompressed successfully to: " + "decompressed.txt");

            } catch (IOException e) {
                System.out.println("Error decompressing file: " + e.getMessage());
                e.printStackTrace();
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void encryptFile() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256);
            SecretKey secretKey = keyGen.generateKey();

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            File inputFile = new File("example.txt");
            File outputFile = new File("encrypted.enc");

            try (FileInputStream inputStream = new FileInputStream(inputFile);
                 FileOutputStream outputStream = new FileOutputStream(outputFile)) {

                byte[] iv = cipher.getIV();
                if (iv != null) {
                    outputStream.write(iv);
                }

                CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream, cipher);

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    cipherOutputStream.write(buffer, 0, bytesRead);
                }
                cipherOutputStream.close();

                try (FileOutputStream keyFile = new FileOutputStream("secret.key")) {
                    keyFile.write(secretKey.getEncoded());
                }

                System.out.println("File encrypted successfully!");

            } catch (IOException e) {
                System.out.println("Error encrypting file: " + e.getMessage());
                e.printStackTrace();
            }

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
            System.out.println("Encryption error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void decryptFile() {
        try {
            File keyFile = new File("secret.key");
            byte[] keyData = new byte[(int) keyFile.length()];
            try (FileInputStream keyFis = new FileInputStream(keyFile)) {
                keyFis.read(keyData);
            }

            SecretKey secretKey = new SecretKeySpec(keyData, "AES");

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            File encryptedFile = new File("encrypted.enc");
            File decryptedFile = new File("decrypted.txt");

            try (FileInputStream inputStream = new FileInputStream(encryptedFile);
                 FileOutputStream outputStream = new FileOutputStream(decryptedFile)) {

                byte[] iv = null;
                if (cipher.getIV() != null) {
                    iv = new byte[cipher.getIV().length];
                    inputStream.read(iv);
                    IvParameterSpec ivSpec = new IvParameterSpec(iv);
                    cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
                }

                // Create decrypted output stream
                CipherInputStream cipherInputStream = new CipherInputStream(inputStream, cipher);

                // Read encrypted file and write decrypted data
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = cipherInputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                cipherInputStream.close();

                System.out.println("File decrypted successfully!");

            } catch (IOException e) {
                System.out.println("Error decrypting file: " + e.getMessage());
                e.printStackTrace();
            }

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
                 InvalidAlgorithmParameterException | IOException e) {
            System.out.println("Decryption error: " + e.getMessage());
            e.printStackTrace();
        }
    }


}
