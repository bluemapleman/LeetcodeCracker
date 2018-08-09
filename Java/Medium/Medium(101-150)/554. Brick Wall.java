
/*
There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.

The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.

If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.

You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.

Example:
Input: 
[[1,2,2,1],
 [3,1,2],
 [1,3,2],
 [2,4],
 [3,1,2],
 [1,3,1,1]]
Output: 2
Explanation: 

Note:
The width sum of bricks in different rows are the same and won't exceed INT_MAX.
The number of bricks in each row is in range [1,10,000]. The height of wall is in range [1,10,000]. Total number of bricks of the wall won't exceed 20,000.
*/

class Solution {
    //the height o wall is fixed, so we just need to find the number that appears most frequently.
    // the number includes sum of brick width from the start of each row
    public int leastBricks(List<List<Integer>> wall) {
        int ans=0;
        Map<Integer, Integer> map=new HashMap<>();
        for(List<Integer> row:wall) {
            int tempSum=0;
            for(Integer brick:row) {
                tempSum+=brick;
                if(map.containsKey(tempSum))
                    map.put(tempSum,map.get(tempSum)+1);
                else
                    map.put(tempSum,1);
            }
        }

//      for(Integer sum:map.keySet())
//          System.out.println(sum+"--"+map.get(sum));
        
        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2.intValue()-o1.intValue();
            }
            
        });
        for(Integer sum:map.keySet()) {
            queue.add(map.get(sum));
        }
        // remove sum that equals length of the wall
        queue.poll();
        
        int mostFreq=0;
        if(!queue.isEmpty())
            mostFreq=queue.poll();
        // all bricks are of the same width, so the line must cross all rows of bricks
        else
            return wall.size();
            
        int drawX=0;
        for(Integer sum:map.keySet()) {
            if(map.get(sum)==mostFreq) {
                drawX=sum;
                break;
            }
        }
        
        int intervalBrickCount=0;
        for(List<Integer> row:wall) {
            int tempSum=0;
            for(Integer brick:row) {
                tempSum+=brick;
                if(tempSum==drawX) {
                    intervalBrickCount++;
                    break;
                }else if(tempSum>drawX) {
                    break;
                }
            }
        }
        ans=wall.size()-intervalBrickCount;
        return ans;
    }
}