
/*
Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

Note:
The length of A and B will be between 1 and 10000.
*/

class Solution {
    public int repeatedStringMatch(String A, String B) {
        int count=1;
    String repeatStr="";
    // if B is shorter than A, then if A repeats two times and B is still not a substring of repeated String, then B will never be.
    if(B.length()<=A.length()) {
      if(A.equals(B))
        return 1;
      else
        if(A.contains(B))
          return 1;
        else
          return (A+A).contains(B)?2:-1;
    }else {
      // move one step more, B may cover one more A (A needs to repeat once more)
      int maxOverlappingACount=B.length()/A.length();
      int leftCount=B.length()%A.length();
      // B can at most overlaps maxOverlappingACount along with 1 or 2 more character determined by leftCount
      if(leftCount>0)
        count=maxOverlappingACount+1;
      else
        count=maxOverlappingACount;
      
      for(int i=0;i<count;i++)
        repeatStr+=A;
      
      if(repeatStr.contains(B))
        return count;
      else if((repeatStr+A).contains(B))
        return count+1;
      else
        return -1;
    }
}

