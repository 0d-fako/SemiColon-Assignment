package CompoundInterest;

import java.util.Scanner;

public class CompoundInterestCalculator {
    private double initialInvestment;
    private double monthlyContribution;
    private int lengthInYears;
    private double interestRate;
    private double interestVariance;
    private String compoundFrequency;

    public CompoundInterestCalculator() {
    }

    public double calculateCompoundInterest() {
        double principal = initialInvestment;
        int numCompoundings = getCompoundingFrequency();
        double rate = interestRate / 100.0;
        int totalMonths = lengthInYears * 12;

        for (int month = 0; month < totalMonths; month++) {
            principal += monthlyContribution;


            if (month % (12 / numCompoundings) == 0) {
                principal *= (1 + (rate / numCompoundings));
            }
        }

        return principal;
    }

    private int getCompoundingFrequency() {
        switch (compoundFrequency.toLowerCase()) {
            case "daily":
                return 365;
            case "monthly":
                return 12;
            case "quarterly":
                return 4;
            case "semi-annually":
                return 2;
            case "annually":
                return 1;
            default:
                return 12;
        }
    }

    public void calculateWithVariance() {
        double baseResult = calculateCompoundInterest();
        double lowerRate = interestRate - interestVariance;
        double upperRate = interestRate + interestVariance;


        double tempRate = interestRate;

        interestRate = lowerRate;
        double lowerResult = calculateCompoundInterest();


        interestRate = upperRate;
        double upperResult = calculateCompoundInterest();


        interestRate = tempRate;

        System.out.printf("Results with %.2f%% interest rate:%n", interestRate);
        System.out.printf("Final Amount: $%.2f%n", baseResult);
        System.out.printf("Range with ±%.2f%% variance:%n", interestVariance);
        System.out.printf("Lower bound (%.2f%%): $%.2f%n", lowerRate, lowerResult);
        System.out.printf("Upper bound (%.2f%%): $%.2f%n", upperRate, upperResult);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CompoundInterestCalculator calculator = new CompoundInterestCalculator();

        System.out.println("Compound Interest Calculator");
        System.out.println("==========================");

        System.out.print("Initial Investment: $");
        calculator.initialInvestment = scanner.nextDouble();

        System.out.print("Monthly Contribution: $");
        calculator.monthlyContribution = scanner.nextDouble();

        System.out.print("Length of Time (years): ");
        calculator.lengthInYears = scanner.nextInt();

        System.out.print("Interest Rate (%): ");
        calculator.interestRate = scanner.nextDouble();

        System.out.print("Interest Rate Variance (%): ");
        calculator.interestVariance = scanner.nextDouble();

        System.out.println("Compound Frequency (daily/monthly/quarterly/semi-annually/annually): ");
        calculator.compoundFrequency = scanner.next();

        calculator.calculateWithVariance();

        scanner.close();
    }
}