
/*
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.


*/
package medium1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月12日
 */
public class IntegertoRoman
{
    public static void main(String[] args)
    {
        System.out.println(new IntegertoRoman().intToRoman(57));
    }
    
    Map<Integer,String> map=new HashMap<Integer,String>();
    
    public String intToRoman(int num) {
        map.put(1,"I");map.put(5,"V");map.put(10,"X");
        map.put(50,"L");map.put(100,"C");map.put(500,"D");map.put(1000,"M");
        String answer="";
        int radix=1;
        List<String> list=new ArrayList<String>();
        while(num!=0) {
            int digit=num%10;
            list.add(digit(digit,radix));
            radix*=10;
            num/=10;
        }
        
        for(int i=list.size()-1;i>=0;i--)
            answer+=list.get(i);
        
        return answer;
    }
    
    public String digit(int num,int radix) {
        if(num==4)
            return map.get(radix)+map.get(radix*5);
        if(num==9)
            return map.get(radix)+map.get(radix*10);
        if(num<5) {
            String str="";
            for(int i=0;i<num;i++) {
                str+=map.get(radix);
            }
            return str;
        }else {
            String str=map.get(radix*5);
            for(int i=0;i<num-5;i++) {
                str+=map.get(radix);
            }
            return str;
        }
    }
}

