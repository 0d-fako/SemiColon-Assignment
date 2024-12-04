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
}