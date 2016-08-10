import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

// HashSet
// HashMap
//iterate through HashMap

public class PalindromePerm {
	
	String s;
	
	public static boolean isPalindrome(String s){
		int l = s.length();
		
		for (int i = 0; i < (int)(l/2 - 1);i++) {
			if (s.charAt(i) != s.charAt(l-1 -i)){
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPalindromePerm(String s) {
		Map<Character, Boolean> memo = new HashMap<Character,Boolean>();
		
		//Filling the occurrences map
		// We store a boolean: true ioi appears odd times
		for (int i = 0; i< s.length(); i++) {
			if (memo.containsKey(s.charAt(i))) {
				memo.put(s.charAt(i), !memo.get(s.charAt(i)));
			}
			else {
				memo.put(s.charAt(i), false);
			}
		}
		
		//Check criteria: one odd occurrence maximum
		int numberOdd = 0;
		for (Map.Entry<Character, Boolean> occurrences : memo.entrySet()) {
			if (!occurrences.getValue()) {
				numberOdd++;
				if (numberOdd > 1) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean isPalindromeSet(String s) {
		HashSet<Character> oddCharacters = new HashSet<Character>();
		
		//Keeping track of the characters with odd occurrences
		for (int i = 0; i< s.length(); i++) {
			if (oddCharacters.contains(s.charAt(i))) {
				oddCharacters.remove(s.charAt(i));
			}
			else {
				oddCharacters.add(s.charAt(i));
			}
		}
		//Check criteria: one odd occurrence maximum
		return oddCharacters.size() <= 1;

	}
	
	public static void main(String[] args) {
		String s = "hejilljjjeh";
		Character c = s.charAt(0);
		System.out.println("Check PalPerm = " + isPalindromePerm(s));
		
	}
}
