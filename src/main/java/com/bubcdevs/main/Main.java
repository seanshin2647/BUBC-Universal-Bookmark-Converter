package com.bubcdevs.main;

public class Main {

    public static void main(String[] args) {
        Input input = new Input();
        String[] filePathList = input.input();
        String operatingSystem = filePathList[0];
        String filePath = filePathList[1];
    }
}
