package com.lavin.fileutility.service;

import com.lavin.fileutility.customexceptions.InvalidFlagException;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.util.*;

public class SortService {

    public static final String BLUE = "\u001B[34m";
    public static final String RESET = "\u001B[0m";

    public void sort(Path currDir, String[] flag) throws IOException, InvalidFlagException {
//        Path path = Path.of(currDir.toString());

        if (flag[0].equalsIgnoreCase("-d")) {

            List<Path> files = new ArrayList<>();

            try (DirectoryStream<Path> stream = Files.newDirectoryStream(currDir)) {
                for (Path file : stream) {
                    files.add(file);
                }
            }

            Map<Path, FileTime> map = new HashMap<>();

            for (Path file : files) {
                map.put(file, Files.getLastModifiedTime(file));
            }

            files.sort((f1, f2) -> map.get(f2).compareTo(map.get(f1)));

            for (Path file : files) {
                if (Files.isDirectory(file)) {
                    System.out.println(BLUE + file.getFileName() + RESET);
                } else {
                    System.out.println(file.getFileName());
                }
            }
        }
        else if (flag[0].equalsIgnoreCase("-alpha")) {
            List<Path> files = new ArrayList<>();

            try (DirectoryStream<Path> stream = Files.newDirectoryStream(currDir)) {
                for (Path file : stream) {
                    files.add(file);
                }
            }

            if (flag.length > 1 && flag[1].equalsIgnoreCase("reversed")) {
                files.sort(Comparator.comparing((Path f) -> f.getFileName().toString().toLowerCase()).reversed());
            } else {
                files.sort(Comparator.comparing(f -> f.getFileName().toString().toLowerCase()));
            }

            for (Path file : files) {
                if (Files.isDirectory(file)) {
                    System.out.println(BLUE + file.getFileName() + RESET);
                } else {
                    System.out.println(file.getFileName());
                }
            }

        }
        else {
            throw new InvalidFlagException("Invalid flag " + flag[0]);
        }
    }
}
