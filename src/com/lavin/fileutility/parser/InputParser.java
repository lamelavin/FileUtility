package com.lavin.fileutility.parser;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    public ParsedInput parse(String input) {

        input = input.replaceAll("\\s+", " ").strip();

        List<String> tokens = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        boolean inQuotes = false;

        for (char ch : input.toCharArray()) {
            if (ch == '"') {
                inQuotes = !(inQuotes);
                continue;
            }

            if (ch == ' ' && !inQuotes) {
                tokens.add(word.toString());
                word.setLength(0);
            } else {
                word.append(ch);
            }
        }

        if (!word.isEmpty()) {
            tokens.add(word.toString());
        }

//this is for my future self - if anything goes wrong just print the tokens, I am deleting the debug print statements.

        String command = tokens.getFirst();
        String[] args = tokens.subList(1, tokens.size()).toArray(new String[0]);

        return new ParsedInput(command, args);
    }
}