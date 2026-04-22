package com.lavin.fileutility.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class EraseFolderService {
    public void eraseFolder(String[] foldersNames) throws FileNotFoundException {
        for (String folderName : foldersNames) {
            Path path = Path.of(folderName);
            Path absPath = path.toAbsolutePath();

            if (!(Files.exists(absPath) && Files.isDirectory(absPath)))
                throw new FileNotFoundException("Folder " + folderName + " not found");

            try {
                Files.delete(absPath);
            } catch (IOException e) {
                System.out.println("Cannot delete a non-empty folder! use -f to delete if forcefully");
            }
        }
    }
}
