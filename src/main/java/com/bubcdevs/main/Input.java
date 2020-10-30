import java.util.Scanner;

import java.util.Scanner;
public class Input {
    // Initialize the variables
    Scanner scanner;

    public String[] input() {
        // Make a input object
        Input input = new Input();
        // Create the scanner object
        input.createTheScanner();
        // Get the file path from the user
        String filePath = input.getFilePath();
        // Verify user input and check their operating System
        String operatingSystem = input.verify(filePath);
        // Thank the user or tell them their file path sucks
        input.informTheUserOfTheCurrentStatus(operatingSystem);
        // Return the file path and the OS
        return new String[]{operatingSystem, filePath};

    }

    // Create the scanner object
    public void createTheScanner(){
        scanner = new Scanner(System.in);
    }

    // Get the file path from the user
    public String getFilePath() {
        // When someone drags a file into a terminal window, it will automatically paste the file path.
        System.out.println("Please drag and drop your \".db\" file into this window and press enter");
        String filePath = scanner.nextLine();
        // Return the file path
        return filePath;
    }

    // verify that the input is valid and return what OS they are using
    public String verify(String filePath) {
        // Declare the empty operating system string
        String operatingSystem;

        // Unix based filesystems always begin with a "/"
        if (filePath.startsWith("/")) {
            operatingSystem = "Unix";
        } else {
            // Windows based filesystems always begin with "(letter):\\""
            if (filePath.indexOf(":\\") == 1) {
                operatingSystem = "Windows";
            } else {
                operatingSystem = "Invalid Input";
            }
        }
        // Check if it is a real ".db" file
        if (filePath.endsWith(".db")) {
            return operatingSystem;
        } else {
            return "Invalid Input";
        }

    }

    // Tell the user wether it worked or not
    public void informTheUserOfTheCurrentStatus(String operatingSystem) {
        // If it was labeled as invalid
        if (operatingSystem == "Invalid Input") {
            // Tell them that it didn't work
            System.out.println("Sorry, that didn't work");
        } else {
            // If it was labeled as valid
            // Print out that it worked, and what OS they are using.
            System.out.println("Great! That worked, you are using a "+operatingSystem+" based filesystem.");
        }
    }


}
