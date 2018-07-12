
/*
Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.


*/
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月18日
 */
public class DivideTwoIntegers
{
    public static void main(String[] args)
    {
        System.out.println(String.valueOf(-2147483648));
//      System.out.println(divideStr(2147483648,2));
    }
    
    public static int divide(int dividend, int divisor) {
        int sign=1;
        if(divisor==0)
            return Integer.MAX_VALUE;
        // different sign
        if((dividend<0 && divisor>0) || (dividend>0 && divisor<0)) {
            sign=-1;
            divisor=-divisor;
        }       

        return divideStr(dividend, divisor,sign);
    }
    
    // calculate quotient of two numbers with same sign
    public static int divideStr(int dividend,int divisor,int sign) {
        String answer="";
        String dividendStr=String.valueOf(dividend);
        if(dividendStr.startsWith("-")) {
            dividendStr=dividendStr.substring(1);
            divisor=-divisor;
        }
        int left=0;
        for(int i=0;i<dividendStr.length();i++) {
            int digit=Character.digit(dividendStr.charAt(i), 10);
            digit+=left;
            int temp=0;
            while(digit-divisor>=0) {
                digit-=divisor;
                temp++;
            }
            left=digit*10;
            answer+=temp;
        }
        boolean overflowFlag=false;
        if(answer.length()>10) {
            overflowFlag=true;
        }else if(answer.length()==10) {
            int firstNineDigit=Integer.parseInt(answer.substring(0, 9)),lastDigit=Character.digit(answer.charAt(answer.length()-1), 10);
            if(sign==1) {
                if(firstNineDigit>Integer.MAX_VALUE/10 || (firstNineDigit==Integer.MAX_VALUE/10 && lastDigit>Integer.MAX_VALUE%10)) {
                    overflowFlag=true;
                }
            }
            else {
                if(firstNineDigit>Integer.MAX_VALUE/10 || (firstNineDigit==Integer.MAX_VALUE/10 && lastDigit>Integer.MAX_VALUE%10+1)) {
                    overflowFlag=true;
                }
            }
        }
        
        if(sign==1)
            return overflowFlag?Integer.MAX_VALUE:Integer.parseInt(answer);
        else
            return overflowFlag?Integer.MAX_VALUE:Integer.parseInt("-"+answer);
    }
}

