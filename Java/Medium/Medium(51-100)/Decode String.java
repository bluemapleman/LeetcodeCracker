
/*
Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:
s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".


*/
package medium2;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月6日
 */
public class DecodeString
{
    public static String decodeString(String s) {
        if(!s.contains("["))
            return s;
        
        while(s.contains("[")) {
            int leftBracket=-1;
            while((leftBracket=s.indexOf("[",leftBracket+1))!=-1) {
                int rightBracket=-1;
                boolean decodeFlag=false;
                while((rightBracket=s.indexOf("]",rightBracket+1))!=-1) {
                    String sub=s.substring(leftBracket+1,rightBracket);
                    if(!(sub.contains("[") || sub.contains("]"))) {
                        decodeFlag=true;
                        System.out.println("left:"+leftBracket+",right:"+rightBracket);
                        
                        int count=0;
                        for(int i=leftBracket-1,digit=1;i>=0;i--,digit*=10) {
                            char ch=s.charAt(i);
                            if(Character.isDigit(ch))
                                count+=digit*Character.digit(ch, 10);
                            else
                                break;
                        }
                        String temp=new String(s.substring(0,leftBracket-String.valueOf(count).length()));
                        for(int i=0;i<count;i++)
                            temp+=sub;
                        temp+=s.substring(rightBracket+1,s.length());
                        s=temp;
                        
                        break;
                    }
                }
                if(decodeFlag)
                    break;
            }
        }
    
        
        return s;
    }
    
    public static void main(String[] args)
    {
        String test="2[a3[b2[c]]]ef3[a2[tt]]";
        System.out.println(decodeString(test));
    }
}

