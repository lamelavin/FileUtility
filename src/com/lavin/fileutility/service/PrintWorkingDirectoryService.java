package com.lavin.fileutility.service;

import java.nio.file.Path;

public class PrintWorkingDirectoryService {
    public void printWorkingDirectory(Path currDir) {
        System.out.println(currDir);
    }
}
