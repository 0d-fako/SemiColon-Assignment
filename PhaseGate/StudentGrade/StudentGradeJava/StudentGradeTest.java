import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;

public class StudentGradeTest {
    
    
    @Test
    public void testNumberOfPasses() {
        StudentGrade studentGrade = new StudentGrade();
        int[][] mockScores = {
            {60, 70, 80},
            {40, 50, 30},
            {55, 65, 45}
        };
        
        int[] result = studentGrade.numberOfPasses(0, mockScores);
        
        assertArrayEquals(new int[]{2, 1, 0}, result);
    }





    @Test
    public void testGetQuestionsForStudents() {
    StudentGrade studentGrade = new StudentGrade();
    
    
    Scanner mockScanner = new Scanner("75\n80\n90\n");
    int[][] mockScores = new int[1][3];
    
    int[][] result = studentGrade.getQuestionsForStudents(mockScores, mockScanner);
    
    assertArrayEquals(new int[]{75, 80, 90}, result[0]);
    }



    @Test
    public void testInvalidScoreInput() {
    StudentGrade studentGrade = new StudentGrade();
    

    Scanner mockScanner = new Scanner("110\n75\n80\n90\n");
    int[][] mockScores = new int[1][3];
    
    int[][] result = studentGrade.getQuestionsForStudents(mockScores, mockScanner);
    
    assertArrayEquals(new int[]{75, 80, 90}, result[0]);
    }


      @Test
    public void testFindStudentPosition() {
        StudentGrade studentGrade = new StudentGrade();
        
        int[] positions1 = {3, 1, 2};
        assertEquals(2, studentGrade.findStudentPosition(positions1, 1));
       
        int[] positions2 = {1, 2, 3};
        assertEquals(1, studentGrade.findStudentPosition(positions2, 0));
        
        int[] positions3 = {2, 3, 1};
        assertEquals(3, studentGrade.findStudentPosition(positions3, 2));
        
        int[] positions4 = {2, 3, 4};
        assertEquals(-1, studentGrade.findStudentPosition(positions4, 5));
    }

}