package labs.lab7;

public class Main {

	/**
	 * Given a string, returns true if it is a nesting of one or more pairs of parentheses, like "(())" or "((()))". 
	 * If there are any other characters besides parentheses in the string, return false.
	 * 
	 * @param str	the string to check for nested parentheses. str.length() will always be > 0.
	 * @return		true if the string is a nesting or 1 or more pairs of parentheses
	 */
	public static boolean problem1_nested(String str) {
		int left = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '('){
				left++;
			}else if (c == ')'){
				left--;
			}else {
				return false;
			}
		}
		if (left == 0){
			return true;
		}
		return false; // FIX ME
	}


	/**
	 * We'll say that a "double" in a string is two instances of a char, separated by a char. 
	 * So in "AxA", the A's make a double. Doubles can overlap, so "AxAxA" contains 3 doubles -- 2 for A and 1 for x. 
	 * This method recursively computes the number of doubles in the given string.
	 * 
	 * @param str	the string to check for doubles
	 * @return		the number of doubles in the given string
	 */
	public static int problem2_countDoubles(String str) {
		if (str.length()<=2){
			return 0;
		}
		char pastTwo = str.charAt(0);
		char pastOne = str.charAt(1);
		int count = 0;
		for (int i = 2; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == pastTwo){
				count++;
			}
			pastTwo = pastOne;
			pastOne = c;
		}
		return count; // FIX ME
	}


	/**
	 * Given a string and a non-empty substring (sub), computes recursively if at least n copies of sub 
	 * appear in the string somewhere, possibly with overlapping.
	 * 
	 * @param str	the string to check for copies
	 * @param sub	the substring to look for in the string
	 * @param n		the number of copies to look for in the string (will always be non-negative)
	 * @return		true if at least n copies of sub appear in the string somewhere, with overlapping
	 */
	public static boolean problem3_countCopies(String str, String sub, int n) {

//		String result = str.replaceAll(sub,"");
//		System.out.println(result);
//		int count = (str.length()-result.length())/sub.length();
		int count = count(str,0,sub);
		if (n<= count){
			return true;
		}
		return false; // FIX ME
	}
	private static int count(String str, int begin,String sub){
		int len = sub.length();
		if (str.length()-begin < len){
			return 0;
		}
		if (str.substring(begin,len+begin).equals(sub)){
			return 1+count(str,begin+1,sub);
		}else {
			return count(str,begin+1,sub);
		}
	}
}