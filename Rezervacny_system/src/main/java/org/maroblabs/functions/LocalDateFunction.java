package org.maroblabs.functions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateFunction {

    public static LocalDate convertStringToLocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, formatter);
    }

}
