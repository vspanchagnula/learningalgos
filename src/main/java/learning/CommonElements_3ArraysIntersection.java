package learning;

/**
 * 
 * Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order, return a sorted array of only the integers that appeared in all three arrays.
 *
 * Time comp : O(n1 + n2 + n3)
 */
public class CommonElements_3ArraysIntersection {
	
	public static void main(String[] args) {
		CommonElements_3ArraysIntersection obj = new CommonElements_3ArraysIntersection();
		obj.intersection(new int[] {1,2,3},new int[] {1,2,4},new int[] {1,2,3});
	}
	
	void intersection(int[] arr1,int[] arr2,int[] arr3) {
		int a=0,b=0,c=0;
		while(a < arr1.length && b < arr2.length && c < arr3.length) {
			if(arr1[a] == arr2[b] && arr2[b] == arr3[c]) {
				System.out.println(arr1[a]);
				a++; b++; c++;
			}else if(arr1[a] < arr2[b])
				a++;
			else if (arr2[b] < arr3[c])
				b++;
			else
				c++;
		}
		
	}

}
