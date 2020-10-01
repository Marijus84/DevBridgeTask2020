//    Implement a method that prints all dates between two given years that remain the same if numbers of the date are reversed.
//
//        Method signature:
//static void printBonusDatesBetween(int fromYear, int toYear)
//
//        It should print dates in interval from fromYear (inclusive) to toYear (exclusive) that satisfy the condition.
//
//        For example, calling printBonusDatesBetween(2010, 2015) should print:
//        2010-01-02
//        2011-11-02

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        printBonusDatesBetween(2010, 2015);
    }

    static void printBonusDatesBetween(int fromYear, int toYear) {

        if (Pattern.matches("^[0-9]{4}$", String.valueOf(fromYear)) && Pattern.matches("^[0-9]{4}$", String.valueOf(fromYear))) {

            LocalDate dateFrom = LocalDate.parse(fromYear + "-01-01");
            LocalDate dateTo = LocalDate.parse(toYear + "-01-01");

            ArrayList<String> palindromes = new ArrayList<>();

            for (LocalDate dayInCheck = dateFrom; dayInCheck.isBefore(dateTo); dayInCheck = dayInCheck.plusDays(1)) {
                String dayStringified = dayInCheck.toString();
                String trimmedDate = dayInCheck.toString().replaceAll("(?i)-", "");
                if (trimmedDate.charAt(0) == trimmedDate.charAt(7) && trimmedDate.charAt(1) == trimmedDate.charAt(6) &&
                        trimmedDate.charAt(2) == trimmedDate.charAt(5) && trimmedDate.charAt(3) == trimmedDate.charAt(4)) {
                    palindromes.add(dayStringified);
                }
            }

            for (String palindrome : palindromes) {
                System.out.println(palindrome);
            }
        } else
            System.out.println("Start and end year must be number consisting of 4 digits");
    }
}

