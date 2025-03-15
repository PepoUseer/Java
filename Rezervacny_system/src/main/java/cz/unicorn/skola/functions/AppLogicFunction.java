package cz.unicorn.skola.functions;

import cz.unicorn.skola.consts.ClassEnum;
import cz.unicorn.skola.data.MainDataStructure;
import cz.unicorn.skola.functions.LocalDateFunction;
import cz.unicorn.skola.functions.ReservationFunctions;
import cz.unicorn.skola.functions.ScannerClassFunctions;
import cz.unicorn.skola.object.ClassTO;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class AppLogicFunction {

    public void startApplication(){
        Scanner scanner = ScannerClassFunctions.getScanner();
        ReservationFunctions Reservationfunctions = new ReservationFunctions();

        while(true) {
            System.out.println("\n--- REZERVAČNÝ SYSTÉM 1.0 ---");
            System.out.println("1 - Vytvoriť rezerváciu");
            System.out.println("2 - Zobraziť rezervácie danej triedy");
            System.out.println("3 - Ukončiť program");
            System.out.print("Vyber možnosť: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    CreateReservation(scanner, Reservationfunctions);
                    break;
                case "2":
                    displayReservations(scanner);
                    break;
                case "3":
                    System.out.println("Ukončujem program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Neplatná voľba. Skúste to znova.");
            }
        }
    }

    private void CreateReservation(Scanner scanner, ReservationFunctions reservationFunctions) {
        ClassEnum reservedClass = null;
        while (reservedClass == null) {
            System.out.println("Použi jedno z následujúcich: " + Arrays.toString(ClassEnum.values()));
            try {
                reservedClass = ClassEnum.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Neplatná trieda. Skúste to znova.");
            }
        }

        String dateFrom = null;
        while (dateFrom == null) {
            System.out.println("Zadaj čas od DD/MM/YYYY: ");
            try {
                dateFrom = scanner.nextLine();
                LocalDateFunction.convertStringToLocalDate(dateFrom);
            } catch (IllegalArgumentException e) {
                System.out.println("Neplatný formát dát. Skúste to znova.");
                dateFrom = null;
            }
        }

        String dateTo = null;
        while (dateTo == null) {
            System.out.println("Zadaj čas do DD/MM/YYYY: ");
            try {
                dateTo = scanner.nextLine();
                LocalDateFunction.convertStringToLocalDate(dateTo);
            } catch (IllegalArgumentException e) {
                System.out.println("Neplatný formát dát. Skúste to znova.");
                dateTo = null;
            }
        }

        System.out.print("Zadaj svoje meno: ");
        String name = scanner.nextLine();

        System.out.println("Sú dáta správne? ANO/NIE");
        System.out.println("Trieda: " + reservedClass);
        System.out.println("Čas od: " + dateFrom);
        System.out.println("Čas do: " + dateTo);
        String confirmation = scanner.nextLine();

        if ("ANO".equalsIgnoreCase(confirmation)) {
            reservationFunctions.createReservation(
                    LocalDateFunction.convertStringToLocalDate(dateFrom),
                    LocalDateFunction.convertStringToLocalDate(dateTo),
                    name,
                    reservedClass
            );
            System.out.println("Rezervácia bola úspešne vytvorená");
        } else {
            System.out.println("Rezervácia nebola vytvorená");
        }
    }

    private void displayReservations(Scanner scanner) {
        System.out.println("Zadaj triedu k zobrezeniu rezervácie: " + Arrays.toString(ClassEnum.values()));
        String reservedClass = scanner.nextLine();

        ClassTO classTo = MainDataStructure.mainData.get(ClassEnum.valueOf(reservedClass));
        if (classTo != null && !classTo.getReservations().isEmpty()) {
            System.out.println("\n--- Rezervácia pre triedu: " + reservedClass + " ---");
            classTo.getReservations().forEach(it ->
                    System.out.println("Dátum od: " + it.getDateFrom() + " / Dátum do: " + it.getDateTo() + " / Kto: " + it.getName())
            );
        } else {
            System.out.println("Pre túto triedu nie sú žiadne rezervácie");
        }
    }
}
