import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;

public class StudentGradeTest {
    @Test
    public void testGetNumberOfStudentsAndSubjects() {
        StudentGrade studentGrade = new StudentGrade();
        int[] result = studentGrade.getNumberOfStudentsAndSubjects(3, 4);
        
        assertArrayEquals(new int[]{3, 4}, result);
    }
    
    
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
}