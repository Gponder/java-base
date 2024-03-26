package com.gponder.enc.hash;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Test {

    public static void main(String[] args) {
        Path filePath = Paths.get("/ubuntu-22.04.4-live-server-amd64.iso");
        String sha256 = getFileSHA256(filePath);
        System.out.println("SHA-256: " + sha256);
    }

    public static String getFileSHA256(Path filePath) {
        try (FileInputStream fis = new FileInputStream(filePath.toFile())) {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                md.update(buffer, 0, bytesRead);
            }
            byte[] hashBytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (IOException | NoSuchAlgorithmException e) {
            throw new RuntimeException("Error calculating SHA-256 for file: " + filePath, e);
        }
    }

}
