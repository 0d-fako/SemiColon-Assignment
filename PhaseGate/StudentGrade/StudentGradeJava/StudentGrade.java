import java.util.Scanner;
import java.util.Arrays;

public class StudentGrade {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        StudentGrade studentGradeApp = new StudentGrade();

        System.out.println("Welcome to the Student Grade App");
        
        System.out.print("Please enter how many students are in your class: ");
        int totalStudentCount = inputScanner.nextInt();
        System.out.print("Please enter how many subjects are taught in your class: ");
        int totalSubjectCount = inputScanner.nextInt();
        
	int[][] studentScores = new int[totalStudentCount][totalSubjectCount];
    	int[][] processedStudentScores = studentGradeApp.getQuestionsForStudents(studentScores, inputScanner);
    	studentGradeApp.displaySummary(processedStudentScores);

    }
    
    public int[][] getQuestionsForStudents(int[][] studentScores, Scanner inputScanner) {
        for (int studentIndex = 0; studentIndex < studentScores.length; studentIndex++) {
            System.out.println("\nPlease provide score for student " + (studentIndex + 1));
            for (int subjectIndex = 0; subjectIndex < studentScores[studentIndex].length; subjectIndex++) {
                System.out.print("Please provide score for subject " + (subjectIndex + 1) + ": ");
                int studentScore = inputScanner.nextInt();
                if (studentScore >= 0 && studentScore <= 100) {
                    studentScores[studentIndex][subjectIndex] = studentScore;
                } else {
                    System.out.println("error, invalid input: number must be between 0 and 100. Try again...");
                    subjectIndex--;
                }
            }
        }
        return studentScores;
    }
    
    public void displaySummary(int[][] studentScores) {
        double[] studentAverages = new double[studentScores.length];
        int[] studentPositions = new int[studentScores.length];
        
        for (int studentIndex = 0; studentIndex < studentScores.length; studentIndex++) {
            int totalScore = 0;
            for (int score : studentScores[studentIndex]) {
                totalScore += score;
            }
            studentAverages[studentIndex] = (double) totalScore / studentScores[studentIndex].length;
            studentPositions[studentIndex] = studentIndex + 1;
        }
        
        for (int passIndex = 0; passIndex < studentAverages.length - 1; passIndex++) {
            for (int compareIndex = 0; compareIndex < studentAverages.length - passIndex - 1; compareIndex++) {
                if (studentAverages[compareIndex] < studentAverages[compareIndex + 1]) {
                    
                    double tempAverage = studentAverages[compareIndex];
                    studentAverages[compareIndex] = studentAverages[compareIndex + 1];
                    studentAverages[compareIndex + 1] = tempAverage;
                    
                    int tempPosition = studentPositions[compareIndex];
                    studentPositions[compareIndex] = studentPositions[compareIndex + 1];
                    studentPositions[compareIndex + 1] = tempPosition;
                }
            }
        }
        
        System.out.println("=========================================================================================================");
        displayHeader(studentScores);
        System.out.println("=========================================================================================================");
        
        for (int studentIndex = 0; studentIndex < studentScores.length; studentIndex++) {
            int totalStudentScore = 0;
            System.out.print("Student " + (studentIndex + 1) + "\t");
            
            for (int subjectIndex = 0; subjectIndex < studentScores[studentIndex].length; subjectIndex++) {
                System.out.print(studentScores[studentIndex][subjectIndex] + "\t\t");
                totalStudentScore += studentScores[studentIndex][subjectIndex];
            }
            
            double studentAverage = (double) totalStudentScore / studentScores[studentIndex].length;
            int studentPosition = 0;
            for (int positionIndex = 0; positionIndex < studentPositions.length; positionIndex++) {
                if (studentPositions[positionIndex] == studentIndex + 1) {
                    studentPosition = positionIndex + 1;
                    break;
                }
            }
            System.out.printf("%d\t\t%.2f\t\t  %d%n", totalStudentScore, studentAverage, studentPosition);
        }
        
        System.out.println("==========================================================================================================");
        System.out.println("\n");
        subjectSummary(studentScores);
    }
    
    public void displayHeader(int[][] studentScores) {
        System.out.print("Students\t");
        for (int subjectIndex = 0; subjectIndex < studentScores[0].length; subjectIndex++) {
            System.out.print("Subject " + (subjectIndex + 1) + "\t");
        }
        System.out.println("TOTAL\t\tAVERAGE\t\tPOSITION");
    }
    
    public void subjectSummary(int[][] studentScores) {
        System.out.println("===========================================================");
        System.out.println("Subject summary");
        for (int subjectIndex = 0; subjectIndex < studentScores[0].length; subjectIndex++) {
            decideForEachSubject(subjectIndex, studentScores);
        }
    }
    
    public void decideForEachSubject(int subjectIndex, int[][] studentScores) {
        int largestScore = studentScores[0][subjectIndex];
        int largestScoreStudentIndex = 0;
        int smallestScore = studentScores[0][subjectIndex];
        int smallestScoreStudentIndex = 0;
        int totalSubjectScore = 0;
        
        for (int studentIndex = 0; studentIndex < studentScores.length; studentIndex++) {
            if (studentScores[studentIndex][subjectIndex] > largestScore) {
                largestScore = studentScores[studentIndex][subjectIndex];
                largestScoreStudentIndex = studentIndex;
            }
            if (studentScores[studentIndex][subjectIndex] < smallestScore) {
                smallestScore = studentScores[studentIndex][subjectIndex];
                smallestScoreStudentIndex = studentIndex;
            }
            totalSubjectScore += studentScores[studentIndex][subjectIndex];
        }
        
        double subjectAverage = (double) totalSubjectScore / studentScores.length;
        System.out.println("Subject " + (subjectIndex + 1));
        System.out.println("highest scoring is:   student " + (largestScoreStudentIndex + 1) + " scoring: " + largestScore);
        System.out.println("lowest scoring is:    student " + (smallestScoreStudentIndex + 1) + " scoring: " + smallestScore);
        System.out.printf("Total score: %d%nAverage score: %.2f%n", totalSubjectScore, subjectAverage);
        
        int[] passAndFail = numberOfPasses(subjectIndex, studentScores);
        System.out.println("Number of passes: " + passAndFail[0] + "\nNumber of fails: " + passAndFail[1]);
        System.out.println("===========================================================");
    }
    
    public int[] numberOfPasses(int subjectIndex, int[][] studentScores) {
        int passingStudentCount = 0;
        int failingStudentCount = 0;
        
        for (int studentIndex = 0; studentIndex < studentScores.length; studentIndex++) {
            if (studentScores[studentIndex][subjectIndex] >= 50) {
                passingStudentCount++;
            } else {
                failingStudentCount++;
            }
        }
        
        return new int[]{passingStudentCount, failingStudentCount, subjectIndex};
    }
}
