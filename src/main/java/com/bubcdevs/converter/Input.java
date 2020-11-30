package com.bubcdevs.converter;

import java.util.Scanner;

public class Input {
    Scanner scanner;
    String filePath;
    String operatingSystem;
    boolean verificationCheck;

    public String[] input() {
        scanner = new Scanner(System.in);
        filePath = getUserFilePath();
        operatingSystem = verify(filePath);

        return new String[]{operatingSystem, filePath};

    }

    public String getUserFilePath() {
        // When someone drags a file into a terminal window, it will automatically paste the file path.
        verificationCheck = false;
        while (!verificationCheck) {
            System.out.println("Drag and drop your \".db\" file into this window and press enter.");
            filePath = scanner.nextLine();
            verify(filePath);

            if (operatingSystem == "Invalid com.bubcdevs.converter.Input") {
                System.out.println("Invalid input or failed process. Try again.");
            } else {
                System.out.println("Valid input. Process successful. You are using a " + operatingSystem + " based filesystem.");
                verificationCheck = true;
            }
        }
        return filePath;
    }

    // Verify that the input is valid and return what OS they are using.
    public String verify(String filePath) {

        // Unix based filesystems always begin with a "/".
        if (filePath.startsWith("/")) {
            operatingSystem = "Unix";
        } else {
            // Windows based filesystems always begin with "(letter):\\".
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

    public String getFilePath() {
        return filePath;
    }

}
