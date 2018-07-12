/*
# Excel Sheet Column Title

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:
```
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
```

- My Answer


*/
package easy1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月23日
 */
public class ExcelSheetColumnTitle
{
    public static String convertToTitle(int n) {
        String result="";
        List<Integer> list=new ArrayList<Integer>();
        while(n/26!=0) {
            list.add(n%26);
            n/=26;
        }
        
        list.add(n%26);
        
        
        System.out.println(list.size());
        for(Integer ele:list)
            System.out.print(ele+" ");
        for(int i=0;i<list.size();i++) {
            int ele=list.get(list.size()-i-1);
            result+=(char)(ele+'@');
        }
        
        while(result.contains("@")) {
            int index=result.indexOf("@");
            result=result.substring(0, index-1)+(char)(result.charAt(index-1)-1)+"Z"+result.substring(index+1);
            if(result.startsWith("@"))
                result=result.substring(1);
        }
        
        result=result.replace("@","");
        
        return result;
        
    }
}


//for(int i=0;i<list.size();i++) {
//  int ele=list.get(list.size()-i-1);
//  if(i<list.size()-1) {
//      if(ele==1)
//          result+="A";
//      else if(ele!=0)
//          result+=(char)(ele+'@');
//  }else if(ele!=0)
//      result+=(char)(ele+'@');
//}
