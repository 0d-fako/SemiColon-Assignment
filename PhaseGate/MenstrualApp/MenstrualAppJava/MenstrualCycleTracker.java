import java.util.Scanner;
import java.util.Arrays;

public class MenstrualCycleTracker {
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 2:
                return isLeapYear(year) ? 29 : 28;
            case 4: case 6: case 9: case 11:
                return 30;
            default:
                return 31;
        }
    }

    private static boolean isValidDate(int day, int month, int year) {
      
        if (year < 1900 || year > 2100) return false;
        if (month < 1 || month > 12) return false;
        if (day < 1 || day > getDaysInMonth(month, year)) return false;
        
        return true;
    }

    private static int[] addDays(int day, int month, int year, int daysToAdd) {
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
      
        if (isLeapYear(year)) {
            daysInMonths[1] = 29;
        }
        
    
        for (int i = 0; i < daysToAdd; i++) {
            day++;
            
            if (day > daysInMonths[month - 1]) {
                day = 1;
                month++;

                if (month > 12) {
                    month = 1;
                    year++;
                   
                    if (isLeapYear(year)) {
                        daysInMonths[1] = 29;
                    } else {
                        daysInMonths[1] = 28;
                    }
                }
            }
        }
        
        return new int[]{day, month, year};
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String name = "";
        int day, month, year;
        do {
            System.out.print("Please provide your name: ");
            name = scanner.nextLine();
            System.out.println("Enter last period start date (day(DD):");
            day = scanner.nextInt();
            System.out.println("Enter last period start date (month (MM):"); 
            month = scanner.nextInt();
            System.out.println("Enter last period start date (year(YYYY):");
            year = scanner.nextInt();
            
            if (!isValidDate(day, month, year)) {
                System.out.println("Invalid date. Please try again.");
            }
        } while (!isValidDate(day, month, year));
        
        System.out.println("Hello " +name);
        System.out.println("\n--- Period Flow Dates (5 days) ---");
        int currentDay = day, currentMonth = month, currentYear = year;
        for (int i = 0; i < 5; i++) {
            System.out.printf("Day %d: %02d-%02d-%d\n", (i + 1), currentDay, currentMonth, currentYear);
            
         
            int[] nextDate = addDays(currentDay, currentMonth, currentYear, 1);
            currentDay = nextDate[0];
            currentMonth = nextDate[1];
            currentYear = nextDate[2];
        }
        
        int[] unsafeStart = addDays(day, month, year, 12);
        int[] unsafeEnd = addDays(day, month, year, 16);
        
        System.out.println("\n--- Unsafe (Ovulation) Period ---");
        System.out.printf("Start: %02d-%02d-%d\n", unsafeStart[0], unsafeStart[1], unsafeStart[2]);
        System.out.printf("End: %02d-%02d-%d\n", unsafeEnd[0], unsafeEnd[1], unsafeEnd[2]);
  

        int[] nextPeriod = addDays(day, month, year, 28 + (int)(Math.random() * 3));
        
        System.out.println("\n--- Next Period Prediction ---");
        System.out.printf("Predicted Date: %02d-%02d-%d\n", nextPeriod[0], nextPeriod[1], nextPeriod[2]);
        
       
    }
}