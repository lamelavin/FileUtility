package com.lavin.fileutility.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class MoveOrRenameService {
    public void moveOrRename(String sourcePath, String destinationPath) throws FileNotFoundException {
        // I will write it tomorrow ~

        Path source = Path.of(sourcePath).toAbsolutePath();
        Path target = Path.of(destinationPath).toAbsolutePath();

        if (!Files.exists(source))
            throw new FileNotFoundException("Source not found");

        try {
            Path finalTarget;

            if (Files.isDirectory(target) && Files.exists(target)) {
                finalTarget = target.resolve(source.getFileName());
            }
            else if (target.endsWith("/")) {
                Files.createDirectories(target.getParent());
                System.out.println("DEBUGGING: " + target.getParent()); // for debugging
                finalTarget = target.resolve(source.getFileName());
            }
            else {
                finalTarget = target;
                Files.createDirectories(finalTarget.getParent());
            }

            Files.move(source, finalTarget, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }
    }
}
