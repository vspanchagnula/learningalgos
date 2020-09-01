package learning;

// Input: points = [[1,1],[3,4],[-1,0]] Output: 7
// Explanation: One optimal path is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]  

// Min time would be using diagonal path and calc would be min  calculated points plus  difference between them
public class MinimumTimeVisitingAllPoints {
	
	
	 public  int minTimeToVisitAllPoints(int[][] points)
     {
         if(points.length == 0)
         {
             return 0;
         }

         int time = 0;
         int sourceX = points[0][0];
         int sourceY = points[0][1];
         for (int i = 1; i < points.length; i++)
         {
             int destinationX = points[i][0];
             int destinationY = points[i][1];
             time += CalculateTimeBetweenPoints(sourceX, sourceY, destinationX, destinationY);

             sourceX = destinationX;
             sourceY = destinationY;
         }

         return time;
     }

     private int CalculateTimeBetweenPoints(int sourceX, int sourceY, int destinationX, int destinationY)
     {
         int time = 0;
         int diffX = Math.abs(sourceX - destinationX);
         int diffY = Math.abs(sourceY - destinationY);

         int diagonalMove = Math.min(diffX, diffY);
         time = diagonalMove + Math.abs(diffX - diffY);
         return time;
     }
     
     public static void main(String []args) {
    	 MinimumTimeVisitingAllPoints minimumTimeVisitingAllPoints = new MinimumTimeVisitingAllPoints();
    	 int time = minimumTimeVisitingAllPoints.minTimeToVisitAllPoints(new int[][] { {1,1},{3,4},{-1,0}});
		System.out.println( time );
		 
	 }
 }

