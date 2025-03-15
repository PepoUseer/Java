package org.maroblabs;

import org.maroblabs.consts.TextHelper;
import org.maroblabs.functions.Delenie;
import org.maroblabs.functions.Nasobenie;
import org.maroblabs.functions.Odcitanie;
import org.maroblabs.functions.Scitanie;

import java.util.Scanner;

public class Main {

    private static final String EXIT = "exit";

    public static void main(String[] args) {

        Scitanie scitanie = new Scitanie();
        Odcitanie odcitanie = new Odcitanie();
        Nasobenie nasobenie = new Nasobenie();
        Delenie delenie = new Delenie();
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

            if ("*".equalsIgnoreCase(action)) {
                System.out.println("Násobím...");
                int vysledok = nasobenie.nasobenie(Integer.valueOf(input1), Integer.valueOf(input2));
                System.out.println("Vynásobený výsledok: " + vysledok);
            }

            if ("/".equalsIgnoreCase(action)) {
                System.out.println("Delím...");
                int vysledok = delenie.delenie(Integer.valueOf(input1), Integer.valueOf(input2));
                System.out.println("Vydelený výsledok: " + vysledok);
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