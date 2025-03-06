import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryFileManipulation {

    public static void main(String[] args) {
        String filename = "example.bin";
        String data = "Hello, World!";

        //writeBinaryFile(filename, data);
        //readBinaryFile(filename);
    }

    public static void writeBinaryFile(String filename, String data) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            fos.write(data.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readBinaryFile(String filename) {
        try (FileInputStream fis = new FileInputStream(filename)) {
            int byteData;
            while ((byteData = fis.read()) != -1) {
                System.out.print((char) byteData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
