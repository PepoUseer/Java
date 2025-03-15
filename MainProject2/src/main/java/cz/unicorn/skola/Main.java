package cz.unicorn.skola;

import cz.unicorn.skola.consts.TextHelper;
import cz.unicorn.skola.functions.Odcitanie;
import cz.unicorn.skola.functions.Scitanie;

import java.util.Scanner;

public class Main {

    private static final String EXIT = "exit";

    public static void main(String[] args) {

        Scitanie scitanie = new Scitanie();
        Odcitanie odcitanie = new Odcitanie();
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        String input1;
        String input2;
        String action;

        System.out.println("Zadajte text ( alebo napíšte 'exit' pre ukončenie):");

        while (true) {
            input1 = main.returnScannerValue(TextHelper.FIRST_NUMBER, scanner);
            if (EXIT.equalsIgnoreCase(input1)) {
                System.out.println("Ukončujem program...");
                break;
            }

            input2 = main.returnScannerValue(TextHelper.SECOND_NUMBER, scanner);
            if (EXIT.equalsIgnoreCase(input2)) {
                System.out.println("Ukončujem program...");
                break;
            }

            action = main.returnScannerValue("AKCE", scanner);
            if (EXIT.equalsIgnoreCase(action)) {
                System.out.println("Ukončujem program...");
                break;
            }

            System.out.println("Zadali ste: " + action);

            if ("+".equalsIgnoreCase(action)) {
                System.out.println("Sčítam...");
                int vysledok = scitanie.scitanie(Integer.valueOf(input1), Integer.valueOf(input2));
                System.out.println("Sčítaný výsledok: " + vysledok);
            }

            if ("-".equalsIgnoreCase(action)) {
                System.out.println("Odčítam...");
                int vysledok = odcitanie.odcitanie(Integer.valueOf(input1), Integer.valueOf(input2));
                System.out.println("Odčítaný výsledok: " + vysledok);
            }


            System.out.println("Pokračujem ďalej");
        }

        scanner.close();
    }

    private String returnScannerValue(String input, Scanner scanner) {
        System.out.println(input);
        return scanner.nextLine();
    }

}