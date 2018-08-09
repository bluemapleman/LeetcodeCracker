
/*
An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

Example 1:
Input: 
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: 
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.
Note:

The length of image and image[0] will be in the range [1, 50].
The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
*/

public class FloodFill
{
    // BFS
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] ans=image;

        int oldColor=image[sr][sc];
        if(oldColor==newColor)
            return ans;
        
        ArrayDeque<Point> queue=new ArrayDeque<>();
        
        queue.add(new Point(sr,sc,oldColor));
        while(!queue.isEmpty()) {
            Point p=queue.poll();
            image[p.x][p.y]=newColor;
            // down
            if(p.x<image.length-1 && image[p.x+1][p.y]==oldColor)
                queue.add(new Point(p.x+1,p.y,oldColor));
            // up
            if(p.x>0 && image[p.x-1][p.y]==oldColor)
                queue.add(new Point(p.x-1,p.y,oldColor));
            // right
            if(p.y<image[0].length-1 && image[p.x][p.y+1]==oldColor)
                queue.add(new Point(p.x,p.y+1,oldColor));
            // left
            if(p.y>0 && image[p.x][p.y-1]==oldColor)
                queue.add(new Point(p.x,p.y-1,oldColor));
        }
        return ans;
    }
}

class Point{
    int x,y,val;
    Point(int x,int y,int val){
        this.x=x;
        this.y=y;
        this.val=val;
    }
    
}