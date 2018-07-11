/*
# 13. Roman to Integer

Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

- My Answer
*/

package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月9日
 */
public class RomanToInteger
{

    public static void main(String[] args)
    {
        
        
        System.out.println(romanToInt("CXLXXIV"));
        

    }
    
     public static int romanToInt(String s) {
        Map<String, Integer> map=new HashMap<String, Integer>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        
        if(s.length()==1)
            return map.get(s);
        
        int sum=0;
        int partSum=0;
        for(int i=0;i<s.length();i++) {
            String single=s.substring(i,i+1);
            if(partSum==0)
                partSum+=map.get(single);
            for(int j=i+1;j<s.length();j++,i++) {
                String afterSingle=s.substring(j,j+1);
                //It's a 4 or 9
                if(map.get(afterSingle)>map.get(single)) {
                    partSum=map.get(afterSingle)-partSum;
                    i++;
                    break;
                }
                // keep on adding
                else if(map.get(afterSingle)==map.get(single)) {
                    partSum+=map.get(single);
                    continue;
                }
                else {
                    break;
                }
            }
            System.out.println("sum:"+sum+",partSum:"+partSum);
            sum+=partSum;
            partSum=0;
        }
        
        return sum;
     }

}
