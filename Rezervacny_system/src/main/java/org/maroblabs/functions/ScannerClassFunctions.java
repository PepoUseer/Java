package org.maroblabs.functions;

import java.util.Scanner;

public class ScannerClassFunctions {

    public static Scanner getScanner() {
        return new java.util.Scanner(System.in);
    }

    public String scannTerminal(String input, Scanner scanner) {
        System.out.print(input);
        return scanner.nextLine();
    }
}

