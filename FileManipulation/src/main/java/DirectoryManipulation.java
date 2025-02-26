import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import java.util.zip.GZIPOutputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class DirectoryManipulation {

    public static void main(String[] args) {
        //createDirectory();
        //deleteDirectory();
        //renameDirectory();
        //listDirectories();
        //compressDirectory();
        //decompressDirectory();
        //encryptDirectory();
        //decryptDirectory();
    }

    public static void createDirectory() {
        File directory = new File("new_directory");
        try {
            if (directory.exists()) {
                System.out.println("Directory already exists at: " + directory.getAbsolutePath());
                return;
            }
            if (directory.mkdir()) {
                System.out.println("Directory created successfully at: " + directory.getAbsolutePath());
            } else {
                System.out.println("Failed to create directory");
            }
        } catch (SecurityException e) {
            System.err.println("Security error: No permission to create directory");
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error while creating directory");
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void deleteDirectory() {
        File directory = new File("new_directory");
        try {
            if (!directory.exists()) {
                System.out.println("Directory does not exist at: " + directory.getAbsolutePath());
                return;
            }
            if (directory.delete()) {
                System.out.println("Directory deleted successfully at: " + directory.getAbsolutePath());
            } else {
                System.out.println("Failed to delete directory");
            }
        } catch (SecurityException e) {
            System.err.println("Security error: No permission to delete directory");
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error while deleting directory");
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void renameDirectory() {
        File oldDirectory = new File("new_directory");
        File newDirectory = new File("renamed_directory");
        try {
            if (!oldDirectory.exists()) {
                System.out.println("Directory does not exist at: " + oldDirectory.getAbsolutePath());
                return;
            }
            if (oldDirectory.renameTo(newDirectory)) {
                System.out.println("Directory renamed successfully from " + oldDirectory.getAbsolutePath() + " to " + newDirectory.getAbsolutePath());
            } else {
                System.out.println("Failed to rename directory");
            }
        } catch (SecurityException e) {
            System.err.println("Security error: No permission to rename directory");
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error while renaming directory");
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void listDirectories() {
        File directory = new File(".");
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                }
            }
        } else {
            System.out.println("No directories found in the current directory");
        }
    }

    public static void compressDirectory() {
        String sourceDirPath = "new_directory";
        String outputFile = "new_directory.tar.gz";
        try {
            File sourceDir = new File(sourceDirPath);
            if (!sourceDir.exists()) {
                System.out.println("Source directory does not exist: " + sourceDirPath);
                return;
            }
            FileOutputStream fos = new FileOutputStream(outputFile);
            GZIPOutputStream gzos = new GZIPOutputStream(new BufferedOutputStream(fos));
            TarArchiveOutputStream taos = new TarArchiveOutputStream(gzos);

            taos.setLongFileMode(TarArchiveOutputStream.LONGFILE_GNU);
            taos.finish();
            taos.close();
            gzos.close();
            fos.close();

            System.out.println("Directory successfully compressed from: " + sourceDirPath);
            System.out.println("To: " + outputFile);
        } catch (IOException e) {
            System.err.println("Error compressing directory: " + e.getMessage());
        }
    }

    public static void decompressDirectory() {
        String compressedFilePath = "new_directory.tar.gz";
        String outputDirPath = "decompressed_directory";
        try {
            File outputDir = new File(outputDirPath);
            if (!outputDir.exists()) {
                outputDir.mkdirs();
            }
            FileInputStream fis = new FileInputStream(compressedFilePath);
            GZIPInputStream gzis = new GZIPInputStream(new BufferedInputStream(fis));
            TarArchiveInputStream tais = new TarArchiveInputStream(gzis);

            TarArchiveEntry entry;
            while ((entry = tais.getNextTarEntry()) != null) {
                File outputFile = new File(outputDir, entry.getName());

                try (FileOutputStream fos = new FileOutputStream(outputFile);
                     BufferedOutputStream bos = new BufferedOutputStream(fos)) {

                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = tais.read(buffer)) != -1) {
                        bos.write(buffer, 0, bytesRead);
                    }
                }
            }
            tais.close();
            gzis.close();
            fis.close();
            System.out.println("Directory successfully decompressed to: " + outputDir.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error decompressing directory: " + e.getMessage());
        }
    }

    public static void encryptDirectory() {

    }

    public static void decryptDirectory() {

    }

}
