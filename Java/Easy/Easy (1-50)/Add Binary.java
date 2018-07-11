/*
# Add Binary

Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".

- My Answer

*/
package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月12日
 */
public class AddBinary
{

    public static void main(String[] args)
    {
        System.out.println("----------");
        System.out.println(addBinary("101111", "10"));

    }
    
    public static String addBinary(String a, String b) {
        List<Character> list=new ArrayList<Character>();
        
        char[] arrA,arrB;
        
        char[] tempA=a.toCharArray(),tempB=b.toCharArray();
        int len=Math.max(tempA.length, tempB.length);
        if(len==tempA.length) {
            arrA=tempA;
            arrB=new char[len];
            for(int i=0;i<len;i++) {
                if(i<tempB.length) {
                    arrB[len-i-1]=tempB[tempB.length-i-1];
                }else
                    arrB[len-i-1]='0';
            }
        }
        else {
            arrB=tempB;
            arrA=new char[len];
            for(int i=0;i<len;i++) {
                if(i<tempA.length) {
                    arrA[len-i-1]=tempA[tempA.length-i-1];
                }else
                    arrA[len-i-1]='0';
            }
        }
        
        boolean jinwei=false;
        
        for(int i=len-1;i>=0;i--) {
            if(arrA[i]=='1' && arrB[i]=='1' && jinwei==true) {
                list.add('1');
                jinwei=true;
            }
            else if(arrA[i]=='1' && arrB[i]=='1' && jinwei==false) {
                list.add('0');
                jinwei=true;
            }
            else if((arrA[i]=='1' || arrB[i]=='1') && jinwei==true) {
                list.add('0');
                jinwei=true;
            }
            else if((arrA[i]=='1' || arrB[i]=='1') && jinwei==false) {
                list.add('1');
            }
            else if((arrA[i]=='0' && arrB[i]=='0') && jinwei==true) {
                list.add('1');
                jinwei=false;
            }
            else{
                list.add('0');
            }
        }

        char[] result;
        
        if(jinwei==false) {
            result=new char[len];
            for(int i=0;i<len;i++)
                result[len-i-1]=list.get(i);
        }else {
            result=new char[len+1];
            for(int i=0;i<len;i++)
                result[len-i]=list.get(i);
            result[0]='1';
        }
        
        return new String(result);
    }
}


