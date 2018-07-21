/*

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

http://www.leetcode.com/static/images/problemset/rainwatertrap.png

The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
*/

class Solution {
    // to keep finding higher bar to directly calculate trapping water
	public int trap(int[] height) {
		if(height.length==0)
			return 0;
		
		int ans=0;
		int highestBarIndex=findGreatestArrayEleIndex(height);
		// from left end to highest bar
		// find first bar first
		int lastBarIndex=0;
		for(int i=0;i<highestBarIndex;i++) {
			if(height[i]>0) {
				lastBarIndex=i;
				break;
			}
		}
		// find higher bar or bar that has same height
		while(lastBarIndex<highestBarIndex) {
			for(int i=lastBarIndex+1;i<=highestBarIndex;i++) {
				System.out.println("i:"+i+",lastbarIndex:"+lastBarIndex);
				// find a higher bar
				if(height[i]>=height[lastBarIndex]) {
					// assume no bar between these two bars
					ans+=(i-lastBarIndex-1)*height[lastBarIndex];
					// remove bar part
					for(int j=lastBarIndex+1;j<i;j++)
						ans-=height[j];
					lastBarIndex=i;
					break;
				}
			}
		}
		
		// from right end to highest bar
		for(int i=height.length-1;i>=0;i--) {
			if(height[i]>0) {
				lastBarIndex=i;
				break;
			}
		}
		while(lastBarIndex>highestBarIndex) {
			for(int i=lastBarIndex-1;i>=highestBarIndex;i--) {
				// find a higher bar
				if(height[i]>=height[lastBarIndex]) {
					// assume no bar between these two bars
					ans+=(lastBarIndex-i-1)*height[lastBarIndex];
					// remove bar part
					for(int j=lastBarIndex-1;j>i;j--)
						ans-=height[j];
					lastBarIndex=i;
					break;
				}
			}
		}
		return ans;
	}
	
	public int findGreatestArrayEleIndex(int[] arr) {
		int max=Integer.MIN_VALUE,maxIndex=-1;
		// deal with first window to find max value in the window in order to simplify comparisons in later window
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>=max) {
				max=arr[i];
				maxIndex=i;
			}
		}
		return maxIndex;
	}
	
	// exceeds time limit: time complexity is not certain, mainly depends on highest bar in the height[]
//	public int trap(int[] height) {
//		int ans=0;
//		int maxHeight=Integer.MIN_VALUE;
//		for(Integer ele:height)
//			if(ele>maxHeight)
//				maxHeight=ele;
//		
//		int layer=maxHeight;
//		// iterate over each layer upward, the lower layer's slot where water can be trapped would be filled before continuing with upper layer 
//		for(int i=0;i<layer;i++) {
//			// both first and last slot won't be able to trap water
//			for(int j=1;j<height.length-1;j++) {
//				// if there is a bar behind, explore further
//				if(height[j]==i && height[j-1]>i) {
//					int possibleWidth=1;
//					boolean noEndBarFlag=false;
//					while(j+possibleWidth<height.length && height[j+possibleWidth]==i) {
//						// no end bar, all water would be leaked (equals to no trapping water)
//						if(j+possibleWidth==height.length-1) {
//							noEndBarFlag=true;
//						}
//						possibleWidth++;
//					}
//					if(!noEndBarFlag) {
//						// x water can be trapped in this slot
//						ans+=possibleWidth;
////						System.out.println("a "+possibleWidth+" width slot in layer "+i+", starting from "+j);
//						j+=possibleWidth;
//					}
//				}
//			}
//			// fill slot in layer j
//			for(int j=0;j<height.length;j++) {
//				if(height[j]==i)
//					height[j]=i+1;
//			}
//		}
//		return ans;
//	}
}
