public class PangramChecker{
	public static boolean isPangram(String s) {
        	if (s.length() < 26) {
            		return false;
		}
        	s = s.toLowerCase();
        	for (char i = 'a'; i <= 'z'; i++) {
            		if (s.indexOf(i) == -1) {
                		return false;
			}
        	}
        	return true;
	}
}