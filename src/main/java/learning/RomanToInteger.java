package learning;

import java.util.HashMap;
import java.util.Map;

// Convert roman to number Input: 'IV' Output: 4
// Idea is to loop through string and add num if ascending, if next number is greater than current number
// these have to be substracted and increment counter by 2 since both char's are processed

// TC : O(n) TC : O(1)
public class RomanToInteger {

	 static Map<Character, Integer> values = new HashMap<Character, Integer>();
	    
	    static {
	        values.put('M', 1000);
	        values.put('D', 500);
	        values.put('C', 100);
	        values.put('L', 50);
	        values.put('X', 10);
	        values.put('V', 5);
	        values.put('I', 1);
	    }

	    public int romanToInt(String s) {
	    	int sum =0;
	    	int i =0;
	    	int currentValue=0;
	    	while (i < s.length()) {
	    		currentValue = values.get(s.charAt(i));
	    		int nextValue = 0;
	    		if(i+1 < s.length()) {
	    			nextValue = values.get(s.charAt(i+1));	    			
	    		}
	    		if(currentValue < nextValue) {
    				sum += (nextValue - currentValue);
    				i+=2;
    			}else {
    				sum += currentValue;
    				i++;
    			}
	    	}
			return sum;
	    	
	    }
	    
	    public static void main(String[] args) {
	    	RomanToInteger romanToInteger = new RomanToInteger();
			System.out.println( romanToInteger.romanToInt("LVIII"));
		 }
}
