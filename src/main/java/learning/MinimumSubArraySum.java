package learning;

/**
 * 
 * Maintain a pointer starting from left and keep incrementing it as soon as sum 
 * calculates so far exceeds given sum.
 *
 * Time complexity O(n) space O(1)
 */
class MinimumSubArraySum {
    public int minSubArrayLen(int s, int[] nums) {
         int sum = 0;
        int minlen = 0;
        int k= 0;
        for(int i=0;i< nums.length;i++){
          
            while(sum< s){
                
                sum = sum + nums[k];
                    k++;
            }
            if(sum == s){
            	minlen =   Math.max(minlen, k-i-1);
                break;
            }else{
                 sum = 0;
            k = i+1;
            }
           
        }
        return minlen;
    }
    
    // Driver code 
    public static void main(String[] args) 
    { 
    	MinimumSubArraySum minimumSubArraySum = new MinimumSubArraySum();
    	System.out.println(minimumSubArraySum.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}