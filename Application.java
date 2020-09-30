import java.time.LocalDate;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        printBonusDatesBetween(2010, 2015);
    }

    static void printBonusDatesBetween(int fromYear, int toYear) {

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
    }
}

