package learning;

import java.util.LinkedHashMap;
import java.util.Map;

// Longest Substring with At Most K Distinct Characters
// TC : O(n) SC O(k) for map
public class LongestSubstringWithDistinctChar {
	
	public static void main(String[] args) {
		LongestSubstringWithDistinctChar longestSubstringWithDistinctChar = new LongestSubstringWithDistinctChar();
		System.out.println(longestSubstringWithDistinctChar.lengthOfLongestSubstringKDistinct("eceb",2));
	}
	  public int lengthOfLongestSubstringKDistinct(String s, int k) { int n = s.length();
	    if (n*k == 0) return 0;

	    // sliding window left and right pointers
	    int left = 0;
	    int right = 0;
	    // hashmap character -> its rightmost position 
	    // in the sliding window
	    LinkedHashMap<Character, Integer> hashmap = new LinkedHashMap<Character, Integer>(k + 1);

	    int max_len = 1;

	    while (right < n) {
	      Character character = s.charAt(right);
	      // if character is already in the hashmap -
	      // delete it, so that after insert it becomes
	      // the rightmost element in the hashmap
	      if (hashmap.containsKey(character))
	        hashmap.remove(character);
	      hashmap.put(character, right++);

	      // slidewindow contains k + 1 characters
	      if (hashmap.size() == k + 1) {
	        // delete the leftmost character
	        Map.Entry<Character, Integer> leftmost = hashmap.entrySet().iterator().next();
	        hashmap.remove(leftmost.getKey());
	        // move left pointer of the slidewindow
	        left = leftmost.getValue() + 1;
	      }

	      max_len = Math.max(max_len, right - left);
	    }
	    return max_len;
	  }

}
