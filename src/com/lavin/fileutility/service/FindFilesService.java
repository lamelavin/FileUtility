package com.lavin.fileutility.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FindFilesService {
    public void findFiles(Path currDir, String filename) throws FileNotFoundException {
        if (!Files.exists(currDir))
            throw new FileNotFoundException("Path doesn't exists");

        try (Stream<Path> paths = Files.walk(currDir)) {
            paths.filter(Files::isRegularFile)
                    .filter(path -> path.getFileName().toString().toLowerCase().contains(filename.toLowerCase()))
            .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }
    }
}
