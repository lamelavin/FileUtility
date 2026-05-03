package com.lavin.fileutility.service;

import com.lavin.fileutility.context.CurrentDirectory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ListDirectoryService {
    public static final String BLUE = "\u001B[34m";
    public static final String RESET = "\u001B[0m";

//    public void listDirectory(String directoryName) throws FileNotFoundException {
//
//        Path fullPath = Path.of(directoryName);
//        Path absPath = fullPath.toAbsolutePath();
//
//        if (!Files.exists(absPath))
//            throw new FileNotFoundException("Directory not found");
//
//        if (!Files.isDirectory(absPath))
//            throw new FileNotFoundException("Not a directory");
//
//        try (DirectoryStream<Path> stream = Files.newDirectoryStream(absPath)) {
//            for (Path entry : stream) {
//                if (Files.isDirectory(entry)) {
//                    System.out.println(BLUE + entry.getFileName() + "    " + RESET);
//                } else {
//                    System.out.println(entry.getFileName());
//                }
//            }
//        } catch (IOException e) {
//            System.out.println("Failed to list directory: " + absPath);
//            e.printStackTrace();
//        }
//    }

    public void listDirectory(String directoryName, String flag) throws FileNotFoundException {

        CurrentDirectory ctx = new CurrentDirectory(); // safe now (no reset)

        Path base = ctx.getCurrentDir();
        Path absPath;

        if (directoryName.equals(".")) {
            absPath = base;
        } else {
            absPath = base.resolve(directoryName).normalize();
        }

        if (!Files.exists(absPath))
            throw new FileNotFoundException("Directory not found");

        if (!Files.isDirectory(absPath))
            throw new FileNotFoundException("Not a directory");

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(absPath)) {
            for (Path entry : stream) {
                if (!flag.equalsIgnoreCase("-h")) {
                    if (Files.isHidden(entry))
                        continue;
                }
                if (Files.isDirectory(entry)) {
                    System.out.println(BLUE + entry.getFileName() + "    " + RESET);
                } else {
                    System.out.println(entry.getFileName());
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to list directory: " + absPath);
            e.printStackTrace();
        }
    }
}
