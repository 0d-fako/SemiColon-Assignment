import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class pangramCheckerTest{

	@Test
	public void testPangramTester() {

		//Given
		PangramChecker pangramChecker = new PangramChecker();
		String input = "The  quick brown fox jumps over the lazy dog";

		//Action
		boolean result = pangramChecker.isPangram(input);

		//Check
		assertEquals(result, true);
		
	}

}