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
    
    // keep removing pairs of parenthesis until there is no one to be removed
    // O(n^2)
    public static boolean isValid1(String s) {
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
    
    // According to features of order that pair of parenthesis appears.
    // time: O(n)
    // space: O(n)
    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}

