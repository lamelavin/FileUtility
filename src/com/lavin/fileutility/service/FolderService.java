package com.lavin.fileutility.service;

import java.io.IOException;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FolderService {
    public void createFolder(String[] folderNames) throws FileAlreadyExistsException {
//        Path fullPath;
        for (String folderName : folderNames) {
            Path path = Path.of(folderName);
            Path absPath = path.toAbsolutePath();
//            System.out.println(absPath);

//            fullPath = currentDir.resolve(folderName);

            if (Files.exists(absPath) && Files.isDirectory(absPath))
                throw new FileAlreadyExistsException("Folder " + folderName + " already exists");

            try {
                Files.createDirectories(absPath);
            } catch (IOException e) {
                System.out.println("Failed to create folder: " + e.getMessage());
            }
        }
    }
}
