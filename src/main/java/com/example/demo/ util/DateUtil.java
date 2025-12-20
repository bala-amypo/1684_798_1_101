
package com.example.demo.util;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateUtil {

    /**
     * Checks if the given date is in the future compared to today.
     * @param date LocalDate to check
     * @return true if date is in the future
     */
    public static boolean isFutureDate(LocalDate date) {
        return date.isAfter(LocalDate.now());
    }

    /**
     * Returns current timestamp
     * @return LocalDateTime.now()
     */
    public static LocalDateTime now() {
        return LocalDateTime.now();
    }
}
