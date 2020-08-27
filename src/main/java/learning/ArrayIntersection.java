package learning;

import java.util.Arrays;
import java.util.HashMap;

// Find elements that are common in 2 arrays, unsorted
// TC : O(n+m), SC : O(min(m,n)) since we use hashmap
public class ArrayIntersection {

	public int[] intersect(int[] nums1, int[] nums2){
		  HashMap<Integer,Integer> numMap = new HashMap();
	        for(int i : nums1){
	              numMap.put(i, numMap.getOrDefault(i, 0) + 1);
	        }
	        int j =0;
	        int result[] = new int[nums1.length];
	        for(int i: nums2){
	            int count = numMap.getOrDefault(i, 0);
	            if(count >= 1 ){
	                numMap.put(i,numMap.get(i)-1);
	                result[j] = i;
	                j++;
	            }
	        }
	        return result;
		
	}
	public static void main(String[] args) {
		ArrayIntersection arrayIntersection = new ArrayIntersection();
		System.out.println(arrayIntersection.intersectSorted(new int[] {3,4},new int[] {1,2,3,4}));
	}
	// If sorted arrays then this approach is better 
	// TC O(nlogn+mlogm) SC : O(logn+logm)
	
	public int[] intersectSorted(int[] nums1, int[] nums2) {
	    Arrays.sort(nums1);
	    Arrays.sort(nums2);
	    int i = 0, j = 0, k = 0;
	    while (i < nums1.length && j < nums2.length) {
	        if (nums1[i] < nums2[j]) {
	            ++i;
	        } else if (nums1[i] > nums2[j]) {
	            ++j;
	        } else {
	            nums1[k++] = nums1[i++];
	            ++j;
	        }
	    }
	    return Arrays.copyOfRange(nums1, 0, k);
	}
}
