package com.bubcdevs.converter;

import java.util.Scanner;

public class Input {
    Scanner scanner;

    public String[] input() {
        Input input = new Input();
        input.createTheScanner();
        String filePath = input.getFilePath();
        String operatingSystem = input.verify(filePath);
        input.currentStatus(operatingSystem);

        return new String[]{operatingSystem, filePath};

    }

    public void createTheScanner(){
        scanner = new Scanner(System.in);
    }

    public String getFilePath() {
        // When someone drags a file into a terminal window, it will automatically paste the file path.
        System.out.println("Drag and drop your \".db\" file into this window and press enter.");
        String filePath = scanner.nextLine();
        return filePath;
    }

    // Verify that the input is valid and return what OS they are using.
    public String verify(String filePath) {
        String operatingSystem;

        // Unix based filesystems always begin with a "/"
        if (filePath.startsWith("/")) {
            operatingSystem = "Unix";
        } else {
            // Windows based filesystems always begin with "(letter):\\""
            if (filePath.indexOf(":\\") == 1) {
                operatingSystem = "Windows";
            } else {
                operatingSystem = "Invalid com.bubcdevs.converter.Input";
            }
        }
        // Check if it is a real ".db" file
        if (filePath.endsWith(".db")) {
            return operatingSystem;
        } else {
            return "Invalid com.bubcdevs.converter.Input";
        }

    }

    public void currentStatus(String operatingSystem) {
        if (operatingSystem == "Invalid com.bubcdevs.converter.Input") {
            System.out.println("Invalid input or failed process. Try again.");
        } else {
            System.out.println("Valid input. Process successful. You are using a "+operatingSystem+" based filesystem.");
        }
    }


}
