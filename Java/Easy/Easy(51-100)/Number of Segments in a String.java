
/*
Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

Please note that the string does not contain any non-printable characters.

Example:
Input: "Hello, my name is John"
Output: 5


*/
package easy2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月6日
 */
public class NumberofSegmentsinaString
{
    public int countSegments(String s) {
        if(s.length()==0)
            return 0;
        
        int result=0;
        
        String regex="\\S+";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(s);
        while(matcher.find()) {
            result++;
        }
        return result;
    }
}

