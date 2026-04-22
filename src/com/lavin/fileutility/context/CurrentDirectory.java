package com.lavin.fileutility.context;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CurrentDirectory {
    private static Path currentDir;

    public CurrentDirectory() {
        if (currentDir == null)
            currentDir = Paths.get(System.getProperty("user.dir"));
    }

    public Path getCurrentDir() {
        return currentDir;
    }

    public void setCurrentDir(Path newDir) {
        currentDir = newDir;
    }
}

