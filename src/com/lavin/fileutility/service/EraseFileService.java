package com.lavin.fileutility.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class EraseFileService {
    public void eraseFile(Path currDir, String fileName) throws FileNotFoundException {
        Path fullPath = currDir.resolve(fileName);

        if (!Files.exists(fullPath))
            throw new FileNotFoundException("File " + fileName + " not found!");

        try {
            Files.delete(fullPath);
        } catch (IOException e) {
            System.out.println("Exception while erasing file: " + e.getMessage());
        }
    }
}
