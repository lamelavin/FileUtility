package com.lavin.fileutility.service;

import com.lavin.fileutility.context.CurrentDirectory;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SwitchDirectoryService {
    public void switchDirectory(CurrentDirectory currDir, String[] args) throws Exception {
        String name = args[0];

        Path base = currDir.getCurrentDir();
        Path path = base.resolve(name).normalize();

        if (!Files.exists(path))
            throw new FileNotFoundException("Directory doesn't exists");

        if (!Files.isDirectory(path))
            throw new Exception("Not a directory");

        currDir.setCurrentDir(path);
        System.out.println("Switched to : " + path);
    }
}
