package learning;

import java.util.List;

// Input: [1,[4,[6]]] Output: 27
// Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.

// TC : O(n) SC : O(d) d is depth
 
  public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        return getDepthSum(nestedList, 1);
    }
    
    private int getDepthSum(List<NestedInteger> nestedList, int curDepth){
        int sum = 0;
        for(NestedInteger ni : nestedList){
            if(ni.isInteger()){
                sum += ni.getInteger() * curDepth;
            }else {
                sum += getDepthSum(ni.getList(), curDepth+1);
            }
        }
        return sum;
    }
}
  
  interface NestedInteger {
	    
	  
      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();
 
      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();
 
      // Set this NestedInteger to hold a single integer.
      public void setInteger(int value);
 
      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
      public void add(NestedInteger ni);
 
      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
  }