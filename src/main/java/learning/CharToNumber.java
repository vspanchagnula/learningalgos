package learning;

// Implement atoi which converts a char array to an integer. Input: "42" Output: 42

// Idea is to move from left to right and convert input to a decimal form result =result * 10 +(char[i] -0)
// Need to handle overflow/underflow condition since int is only 32 bit 
// TC : O(n) SC O(1)
public class CharToNumber {
	
	 public int myAtoi(char[] input) {
		 if(input.length == 0) {
			 return 0;
		 }
		 int result = 0;
		 int sign = 1;
		 for(char inputChar : input) {
			 if(inputChar > 0 || inputChar < 9) {
				 int inputValue = inputChar - '0';
				 sign = (inputChar == '-') ? -1 : 1;
				// handling overflow test case 
		            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && inputValue > 7)) { 
		                if (sign == 1) 
		                    return Integer.MAX_VALUE; 
		                else
		                    return Integer.MIN_VALUE; 
		            }         
				
				 result = result*10 + inputValue ;
			 }
		 }
		 
		return result;
	        
	    }
	 
	 public static void main(String []args) {
		 CharToNumber charToNumber = new CharToNumber();
    	 int result = charToNumber.myAtoi(new char[]{'1','3','4'});
		System.out.println( result );
		 
	 }

}
