
/*
Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:
Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]


*/
package easy2;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月8日
 */
public class NumberofBoomerangs
{   
    // First build a matrix that contains all distance data between pairwise points.
    // Then iterate over every point to see how many other points have the same distance from it, and count them all;
    public static int numberOfBoomerangs(int[][] points) {
        int count=0;
        
        int rows=points.length,columns=points[0].length;
        
        double[][] distanceMatrix=new double[rows][rows];
        for(int i=0;i<rows;i++) {
                int[] currentPoint=points[i];
                for(int j=i+1;j<rows;j++) {
                    double distance=getDistance(currentPoint, points[j]);
                    distanceMatrix[i][j]=distance;
                    distanceMatrix[j][i]=distance;
                }
        }
        
        
        
        for(int i=0;i<rows;i++) {
                Map<Double, Integer> distanceMap=new HashMap<Double,Integer>();
                for(int j=0;j<rows;j++) {
                    double key=distanceMatrix[i][j];
                    if(distanceMap.containsKey(key)) {
                        distanceMap.put(key, distanceMap.get(key)+1);
                    }else
                        distanceMap.put(key, 1);
                }
                for(Double distance:distanceMap.keySet()) {
                    int value=distanceMap.get(distance);
                    if(value>=2) {
                        count+=getCombination(value, 2)*2;
                    }
                }
        }
        
        return count;
    }
    
    public static double getDistance(int[] point1,int[] point2) {
        return Math.sqrt(Math.pow(point1[0]-point2[0], 2)+Math.pow(point1[1]-point2[1], 2));
    }
    
    public static int getCombination(int m,int n) {
        BigInteger denominator=new BigInteger("1"),numerator=new BigInteger("1");
        int temp=n;
        while(temp-->0) {
            numerator=numerator.multiply(BigInteger.valueOf(m--));
        }
        temp=n;
        while(temp-->0) {
            denominator=denominator.multiply(BigInteger.valueOf(n--));
        }
        
        return numerator.divide(denominator).intValue();
    }
}

