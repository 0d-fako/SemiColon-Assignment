package classtasks;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
public class TimeToWordsConverter {
    public static String convertTimeToWords(LocalTime time) {
        String[] hours = {
                "twelve", "one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine", "ten", "eleven"
        };

        String[] minutes = {
                "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
                "seventeen", "eighteen", "nineteen", "twenty", "tw