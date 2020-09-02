package learning;

// Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
// Output: "leetcode"
public class RestoreString {

	 public String restoreString(String s, int[] indices) {
	        char[] charString = new char[s.length()];
	        
	        for(int i=0; i< s.length();i++){
	            charString[indices[i]] = s.charAt(i);
	        }
	        return String.valueOf(charString);
	        
	    }
	 public static void main(String []args) {
		 RestoreString restoreString = new RestoreString();
		String restoreString2 = restoreString.restoreString("codeleet", new int[]{4,5,6,7,0,2,1,3});
		System.out.println( restoreString2 );
		 
	 }
}
