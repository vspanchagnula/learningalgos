package learning;

import java.util.Stack;

// Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path

// 1. Looks like a directory apporach so to start off break string into individual units using / as delimiter
// 2. Loop through string array and process each based on type of string and add to stack.
// 3. If ".." then have to pop the stack since it should give parent
// 4. Once you have stack loop through it and process result by appending "/" to each element

// TC: O(n) SC : O(n)
public class AbsolutePathSimplification {
	
	  public String simplifyPath(String path) {
		  if(null == path || path.equals("")) {
			  return path;
		  }
		  String[] components = path.split("/");
		  Stack<String> stack = new Stack<String>();
		  
		  for(String directory : components) {
			  if(directory.isEmpty() || directory.equals(".")) {
				  continue;
			  }else if(directory.equals("..")) {
				  if(!stack.isEmpty()) {
					  stack.pop();
				  }
			  }else {
				  stack.add(directory);
			  }
		  }
		  
		// Stich together all the directory names together    
	        StringBuilder result = new StringBuilder();
	        for (String dir : stack) {
	            result.append("/");
	            result.append(dir);
	        }
	        
	        return result.length() > 0 ? result.toString() : "/" ;
		  
	  }
	  
	  public static void main(String []args) {
		  AbsolutePathSimplification absolutePathSimplification= new AbsolutePathSimplification();
		  String result = absolutePathSimplification.simplifyPath("/home//foo/..");
		  System.out.println(result);
		  
	  }

}
