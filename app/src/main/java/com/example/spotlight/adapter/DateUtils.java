package com.example.spotlight.adapter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
public class DateUtils {
    private static final List<String> DATE_FORMATS = Arrays.asList(
            "yyyy-MM-dd",
            "dd/MM/yyyy",
            "dd-MM-yyyy",
            "MM/dd/yyyy",
            "dd MMMM yyyy",
            "yyyy-MM-dd'T'HH:mm:ss"
    );

    public static String formatDate(String dateString) {
        if (dateString == null || dateString.isEmpty()) return "";

        for (String format : DATE_FORMATS) {
            try {
                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(format);
                LocalDate date = LocalDate.parse(dateString, inputFormatter);
                DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("EEE d MMM yyyy", Locale.FRENCH);
                return date.format(outputFormatter);
            } catch (DateTimeParseException e) {
                // Essayer le format suivant
            }
        }

        // Si aucun format ne correspond, retourner la chaîne originale
        return dateString;
    }
}