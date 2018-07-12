
/*
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.


*/
package easy2;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月29日
 */
public class FirstBadVersion
{
    public static void main(String[] args)
    {
        System.out.println(firstBadVersion(3));
        
    }
    
    
    /* The isBadVersion API is defined in the parent class VersionControl.
    boolean isBadVersion(int version); */
    public static int firstBadVersion(int n) {
        if(isBadVersion(1))
            return 1;
        int middle=n/2;
        int start=1,end=n;
        while(middle>=start && middle<=end) {
            if(isBadVersion(middle)) {
                if(middle==start)
                    if(isBadVersion(start))
                        return start;
                
                if(!isBadVersion(middle-1))
                    return middle;
                
                end=middle;
            }else if(isBadVersion(middle+1))
                return middle+1;
            else
                start=middle;
            middle=(int)(start/2.0+end/2.0);
        }
        return -1;
    }
    
    public static boolean isBadVersion(int n) {
        if(n>=3)
            return true;
        else return false;
    }
}




