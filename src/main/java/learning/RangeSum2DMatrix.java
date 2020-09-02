package learning;
// Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
// TC : O(m*n) for pre computation and O(1) for query execution SC : O(mn)

// Idea is to pre calculate cumulative sum and store it in array with size rows+1, col+1 

public class RangeSum2DMatrix {
	
	int[][] preCalculatedResult;
	
	public void numMatrix(int[][] matrix) {
	    if (matrix.length == 0 || matrix[0].length == 0) return;
	    preCalculatedResult = new int[matrix.length + 1][matrix[0].length + 1];
	    for (int r = 0; r < matrix.length; r++) {
	        for (int c = 0; c < matrix[0].length; c++) {
	            preCalculatedResult[r + 1][c + 1] = preCalculatedResult[r + 1][c] + preCalculatedResult[r][c + 1] + matrix[r][c] - preCalculatedResult[r][c];
	        }
	    }
	}
	public int sumRegion(int row1, int col1, int row2, int col2) {
		return preCalculatedResult[row2+1][col2+1] - preCalculatedResult[row1][col2+1] - 
				preCalculatedResult[row2+1][col1] + preCalculatedResult[row1][col1];
	}
	
	 // Driver code 
    public static void main(String[] args) 
    { 
    	RangeSum2DMatrix rangeSum2DMatrix = new RangeSum2DMatrix();
//    	System.out.println(minimumSubArraySum.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }

}
