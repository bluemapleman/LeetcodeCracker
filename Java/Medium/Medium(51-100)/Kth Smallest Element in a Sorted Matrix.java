
/*
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:
matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note: 

You may assume k is always valid, 1 ≤ k ≤ n2.


*/


class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> ans=new ArrayList<>();
		
		// construct a k*k matrix first
		if(nums1.length>k)
			nums1=Arrays.copyOfRange(nums1,0,k);
		if(nums2.length>k)
			nums2=Arrays.copyOfRange(nums2,0,k);
		
		int[][] sumMatrix=new int[k][k];
		
		
		// initiate all cell with Integer.MAX_VALUE first
		for(int i=0;i<sumMatrix.length;i++) {
			Arrays.fill(sumMatrix[i], Integer.MAX_VALUE);
		}
		
		// fill valid sum into right place: the row is the index of number in nums1, the column is the index of number in nums2.
		// o(k^2)
		for(int i=0;i<nums1.length;i++) {
			for(int j=0;j<nums2.length;j++) {
				sumMatrix[i][j]=nums1[i]+nums2[j];
			}
		}
		
		
		// find kth Smallest sum in matrix
		int kthSmallestSum=kthSmallestEleinMatrix(sumMatrix, k);;
		int j=Math.min(k, nums2.length);
		// discount pairs that have sum smaller than kthSmallestSum
		for(Integer a:nums1) {
			while(j>0 && a+nums2[j-1]>=kthSmallestSum)
				j--;
			k-=j;
		}
		// collect pairs that has sum smaller than kthSmallestSum
		for(Integer a:nums1) {
			for(Integer b:nums2) {
				// if k>0, it means that there are still pairs whose sum equals kthSmallestSum and they should be collected
				// else all pairs has been collected
				if(a+b>=kthSmallestSum+(k>0?1:0))
					break;
				ans.add(new int[]{a,b});
				k-=(a+b==kthSmallestSum?1:0);
			}
		}
		
		return ans;
    }
	
	// refer to: 378. Kth Smallest Element in a Sorted Matrix 
	public int kthSmallestEleinMatrix(int[][] matrix,int k) {
		PriorityQueue<Tuple> queue=new PriorityQueue<>();
		for(int j=0;j<matrix[0].length;j++) {
			queue.add(new Tuple(0,j,matrix[0][j]));
		}

		for(int i=0;i<k-1;i++) {
			Tuple smallest=queue.poll();
			if(i<matrix.length) {
				queue.add(new Tuple(smallest.x+1,smallest.y,matrix[smallest.x+1][smallest.y]));
			}
		}
		return queue.poll().val;
	}
}




















































