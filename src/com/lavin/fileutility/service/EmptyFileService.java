package com.lavin.fileutility.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class EmptyFileService {
    public void emptyFile(Path currDir, String[] fileNames) throws FileNotFoundException {
        for (String fileName : fileNames) {
            Path fullPath = Path.of(fileName);

            if (!Files.exists(currDir))
                throw new FileNotFoundException("File " + fileName + " not found");

            try {
                Files.writeString(fullPath, "");
            } catch (IOException e) {
                System.out.println("Cannot truncate the file: " + e.getMessage());
            }
        }
    }
}
