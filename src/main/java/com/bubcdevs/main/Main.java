package com.bubcdevs.main;

public class Main {
    
    public static void main(String[] args) {
        Window window = Window.getWindow();
        Input input = new Input();
        String[] filePathList = input.input();
        operatingSystem = filePathList[0];
        filePath = filePathList[1];
    }
}
