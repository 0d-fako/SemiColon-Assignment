import java.util.Scanner;
import java.util.Arrays;

public class StudentGrade {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentGrade studentGrade = new StudentGrade();
        


	System.out.print("Welcome to the Student Grade App");
	
        System.out.print("Please enter how many students are in your class: ");
        int numberOfStudents = input.nextInt();
        System.out.print("Please enter how many subjects are taught in your class: ");
        int numberOfSubjects = input.nextInt();
        int[] numbers = studentGrade.getNumberOfStudentsAndSubjects(numberOfStudents, numberOfSubjects);
        int[][] students = studentGrade.collectScoresForEveryStudentAndSubject(numbers);
        int[][] results = studentGrade.askQuestionsForStudents(students, input);
        studentGrade.displaySummary(results);
        
        
        
    }

   