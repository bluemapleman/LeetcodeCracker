
/*
Suppose we abstract our file system by a string in the following manner:

The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

dir
    subdir1
    subdir2
        file.ext
The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.

We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).

Given a string representing the file system in the above format, return the length of the longest absolute path to file in the abstracted file system. If there is no file in the system, return 0.

Note:
The name of a file contains at least a . and an extension.
The name of a directory or sub-directory will not contain a ..
Time complexity required: O(n) where n is the size of the input string.

Notice that a/aa/aaa/file1.txt is not the longest file path, if there is another path aaaaaaaaaaaaaaaaaaaaa/sth.png.
*/
class Solution {
    public static int lengthLongestPath(String input) {
        int ans=Integer.MIN_VALUE;
        // no file in path
        if(!input.contains("."))
            return 0;
        
        // only a file
        if(!input.contains("\n"))
            return input.length();
        
        
        String[] splitedStrs=input.split("\n");
        for(int i=0;i<splitedStrs.length;i++) {
            String str=splitedStrs[i];
            // is file
            if(str.contains(".")) {
                String concatStr=new String(str);
                // count number of \t to judge level of this file
                int tableSignCount=countCharsequenceCount(str, "\t");
                // track back to find parent directory all the way to the top level directory
                
                int orderOfParent=1;
                int index=i;
                while(concatStr.startsWith("\t") && index>=0) {
                    String currentOne=splitedStrs[index];
                    // find parent directory
                    if(!currentOne.contains(".") && countCharsequenceCount(currentOne, "\t")==tableSignCount-orderOfParent) {
                        concatStr=currentOne+"/"+concatStr;
                        orderOfParent++;
                    }
                    index--;
                }
                concatStr=concatStr.replace("\t", "");
                if(concatStr.length()>ans)
                    ans=concatStr.length();
            }
        }
        
        
        return ans;
    }
    
    public static int countCharsequenceCount(String s,String charsequence) {
        int i=-1;
        int count=0;
        while((i=s.indexOf(charsequence,i+1))!=-1) {
            count++;
        }
        
        return count;
    }
}

