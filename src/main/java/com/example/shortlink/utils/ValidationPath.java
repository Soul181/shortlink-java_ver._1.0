package com.example.shortlink.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationPath {
    public boolean getValidationPath(String path){
        Pattern pattern = Pattern.compile("[0-9A-Za-z]{6}");
        Matcher matcher = pattern.matcher(path);
        boolean isValidatePath = matcher.matches();
        return isValidatePath;
    }
}
