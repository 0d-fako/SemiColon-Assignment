import java.util.Scanner;
import java.util.Arrays;

public class StudentGrade {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentGrade studentGrade = new StudentGrade();

        System.out.println("Welcome to the Student Grade App");
        
        System.out.print("Please enter how many students are in your class: ");
        int numberOfStudents = input.nextInt();
        System.out.print("Please enter how many subjects are taught in your class: ");
        int numberOfSubjects = input.nextInt();
        
        int[] numbers = studentGrade.getNumberOfStudentsAndSubjects(numberOfStudents, numberOfSubjects);
        int[][] students = studentGrade.getScoresForEveryStudentAndSubject(numbers);
        int[][] results = studentGrade.getQuestionsForStudents(students, input);
        studentGrade.displaySummary(results);
    }

    public int[] getNumberOfStudentsAndSubjects(int numberOfStudents, int numberOfSubjects) {
        return new int[]{numberOfStudents, numberOfSubjects};
    }
    
    public int[][] getScoresForEveryStudentAndSubject(int[] numbers) {
        return new int[numbers[0]][numbers[1]];
    }
    
    public int[][] getQuestionsForStudents(int[][] numbers, Scanner input) {
        for (int row = 0; row < numbers.length; row++) {
            System.out.println("\nentering score for student " + (row + 1));
            for (int column = 0; column < numbers[row].length; column++) {
                System.out.print("entering score for subject " + (column + 1) + ": ");
                int answer = input.nextInt();
                if (answer >= 0 && answer <= 100) {
                    numbers[row][column] = answer;
                } else {
                    System.out.println("error, invalid input: number must be between 0 and 100. Try again...");
                    column--;
                }
            }
        }
        return numbers;
    }
    
    public void displaySummary(int[][] numbers) {
        double[] averages = new double[numbers.length];
        int[] positions = new int[numbers.length];
        
       
        for (int i = 0; i < numbers.length; i++) {
            int total = Arrays.stream(numbers[i]).sum();
            averages[i] = (double) total / numbers[i].length;
            positions[i] = i + 1;
        }
        
        
        for (int i = 0; i < averages.length - 1; i++) {
            for (int j = 0; j < averages.length - i - 1; j++) {
                if (averages[j] < averages[j + 1]) {
                    
                    double tempAvg = averages[j];
                    averages[j] = averages[j + 1];
                    averages[j + 1] = tempAvg;
                    
                    int tempPos = positions[j];
                    positions[j] = positions[j + 1];
                    positions[j + 1] = tempPos;
                }
            }
        }
        
        System.out.println("=========================================================================================================");
        displayHeader(numbers);
        System.out.println("=========================================================================================================");
        
        for (int row = 0; row < numbers.length; row++) {
            int total = 0;
            System.out.print("Student " + (row + 1) + "\t");
            
            for (int column = 0; column < numbers[row].length; column++) {
                System.out.print(numbers[row][column] + "\t\t");
                total += numbers[row][column];
            }
            
            double average = (double) total / numbers[row].length;
            int position = 1;
            for (int i = 0; i < positions.length; i++) {
                if (positions[i] == row + 1) {
                    position = i + 1;
                    break;
                }
            }
            System.out.printf("%d\t\t%.2f\t\t  %d%n", total, average, position);
        }
        
        System.out.println("==========================================================================================================");
        System.out.println("\n");
        subjectSummary(numbers);
    }
    
    public void displayHeader(int[][] numbers) {
        System.out.print("Students\t");
        for (int column = 0; column < numbers[0].length; column++) {
            System.out.print("Subject " + (column + 1) + "\t");
        }
        System.out.println("TOTAL\t\tAVERAGE\t\tPOSITION");
    }
    
    public void subjectSummary(int[][] numbers) {
        System.out.println("===========================================================");
        System.out.println("Subject summary");
        for (int row = 0; row < numbers[0].length; row++) {
            decideForEachSubject(row, numbers);
        }
    }
    
    public void decideForEachSubject(int row, int[][] numbers) {
        int largest = numbers[0][row];
        int largestIndex = 0;
        int smallest = numbers[0][row];
        int smallestIndex = 0;
        int total = 0;
        
        for (int column = 0; column < numbers.length; column++) {
            if (numbers[column][row] > largest) {
                largest = numbers[column][row];
                largestIndex = column;
            }
            if (numbers[column][row] < smallest) {
                smallest = numbers[column][row];
                smallestIndex = column;
            }
            total += numbers[column][row];
        }
        
        double average = (double) total / numbers.length;
        System.out.println("Subject " + (row + 1));
        System.out.println("highest scoring is:   student " + (largestIndex + 1) + " scoring: " + largest);
        System.out.println("lowest scoring is:    student " + (smallestIndex + 1) + " scoring: " + smallest);
        System.out.printf("Total score: %d%nAverage score: %.2f%n", total, average);
        
        int[] passAndFail = numberOfPasses(row, numbers);
        System.out.println("Number of passes: " + passAndFail[0] + "\nNumber of fails: " + passAndFail[1]);
        System.out.println("===========================================================");
    }
    
    public int[] numberOfPasses(int row, int[][] numbers) {
        int pass = 0;
        int fail = 0;
        
        for (int column = 0; column < numbers.length; column++) {
            if (numbers[column][row] >= 50) {
                pass++;
            } else {
                fail++;
            }
        }
        
        return new int[]{pass, fail, row};
    }
}