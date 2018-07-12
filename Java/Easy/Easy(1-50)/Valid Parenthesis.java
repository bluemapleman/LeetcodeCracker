/*

# Valid Parentheses

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

- My Answer

*/
package easy;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月9日
 */
public class ValidParentheses
{   
    public static void main(String[] args)
    {
        System.out.println(isValid("[}[[(){}]][{([])}]{[([()])]}"));

    }
    
    //remove "()","{}","[]" gradually, if anything left, then it must be not valid +_+!
    public static boolean isValid(String s) {
        if(s.length()==0)
          return true;
        if(s.length()%2!=0)
          return false;
        
        String[] groups= {"()","[]","{}"};
        while(true) {
                boolean hasReplace=false;
            for(String group:groups) {
                    String newS=s.replace(group,"");
                    if(newS.length()<s.length()) {
                        hasReplace=true;
                        s=newS;
                    }
            }
            if(hasReplace==false)
                    break;
        }
        if(s.length()!=0)
                return false;
        
        return true;
    }
}

