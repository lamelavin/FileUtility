package com.lavin.fileutility.service;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileService {
    public void createFile(Path currentDir, String name, String content) throws FileAlreadyExistsException {
        Path fullPath = currentDir.resolve(name);

        if (Files.exists(fullPath))
            throw new FileAlreadyExistsException("File already exists");

        try {
            Files.writeString(fullPath, content);
            System.out.println("File created");
        } catch (IOException ioException) {
            System.out.println("Invalid Input : " + ioException.getMessage());
        }
    }
}
