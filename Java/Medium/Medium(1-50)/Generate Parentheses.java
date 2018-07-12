
/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

*/
package medium1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月14日
 */
public class GenerateParentheses
{
    public static void main(String[] args)
    {
        for(String str:generateParenthesis(5))
            System.out.println(str);
    }
    public static List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<String>();
        if(n==0)
                return res;
        else if(n==1) {
                res.add("()");
                return res;
        }else if(n==2) {
                res.add("()()");
                res.add("(())");
                return res;
        }else {
                Set<String> set=new HashSet<String>();
                for(String str:generateParenthesis(n-1)) {
                    str="("+str;
                    StringBuilder builder=new StringBuilder(str);
                    for(int i=1;i<str.length();i++) {
                        builder=new StringBuilder(str).insert(i,')');
                        if(builder.charAt(i-1)==')') continue;
                        set.add(builder.toString());
                    }
                }
                for(String str:set)
                    res.add(str);
        }
        
        
        return res;
    }
}

