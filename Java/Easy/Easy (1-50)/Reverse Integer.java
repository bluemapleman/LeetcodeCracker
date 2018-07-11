/*

# Reverse Integer

Given a 32-bit signed integer, reverse digits of an integer.

Example 1:
```
Input: 123
Output:  321
```
Example 2:
```
Input: -123
Output: -321
```
Example 3:
```
Input: 120
Output: 21
```
Note:

Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.


- My Answer

*/
class Solution{
    public int reverse(int x){
        if(x==0)
            return 0;
        if(x==Integer.MIN_VALUE)
                return 0;
        int reversePart=x;
        // consider minus
        if(x<0)
            reversePart=-x;
        List<Integer> list=new ArrayList<Integer>();
        while(reversePart!=0){
            int yushu=reversePart%10;
            reversePart/=10;
            list.add(yushu);
        }
        
        //if reversed number starts with 0(s),remove them first
        while(list.get(0)==0) {
                list.remove(0);
        }
        int sum=0;
        for(int index=0;index<list.size();index++){
            System.out.println("sum:"+sum);
                if(sum>Integer.MAX_VALUE/10)
                    return 0;
                sum*=10;
            sum+=list.get(index);
        }
        
        if(x<0)
              return -sum;
        return sum;
    }
}
