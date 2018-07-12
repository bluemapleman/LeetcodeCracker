
/*
Given an array of characters, compress it in-place.

The length after compression must always be smaller than or equal to the original array.

Every element of the array should be a character (not int) of length 1.

After you are done modifying the input array in-place, return the new length of the array.


Follow up:

Could you solve it using only O(1) extra space?


Example 1:
Input:
["a","a","b","b","c","c","c"]

Output:
Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

Explanation:
"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
Example 2:
Input:
["a"]

Output:
Return 1, and the first 1 characters of the input array should be: ["a"]

Explanation:
Nothing is replaced.
Example 3:
Input:
["a","b","b","b","b","b","b","b","b","b","b","b","b"]

Output:
Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].

Explanation:
Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
Notice each digit has it's own entry in the array.
Note:
- All characters have an ASCII value in [35, 126].
- 1 <= len(chars) <= 1000.




*/
package easy2;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月7日
 */
public class StringCompression
{
    public int compress(char[] chars) {
        char beforeChar='@';
        int index=0;
        int count=1;
        for(int i=0;i<chars.length;i++) {
            char presentChar=chars[i];
            for(int j=0;j<chars.length;j++) {
                System.out.print(chars[j]);
            }
            System.out.println();
            System.out.println("before:"+beforeChar+",present:"+presentChar);
            System.out.println();
            
            if(beforeChar!='@') {
                // next char is the same as present char 
                if(beforeChar==presentChar) {
                    count++;
                    if(i==chars.length-1) {
                        fillCharArr(chars, index, count);
                        break;
                    }
                }else {
                    // put number after char
                    if(count==1) {
                        beforeChar=presentChar;
                        index++;
                        continue;
                    }else if(count<10) {
                        chars[++index]=Character.forDigit(count, 10);
                    }else {
                        index+=fillCharArr(chars,index, count)+1;
                    }
                    
                    chars[++index]=presentChar;
                    count=1;
                    beforeChar=presentChar;
                    if(i==chars.length-1) {
                        if(count!=1)
                            chars[++index]=chars[i];
                    }
                }
            }else{ // first char
                beforeChar=presentChar;
            }
        }
        for(int j=0;j<chars.length;j++) {
            System.out.print(chars[j]);
        }
        return index;
    }
    
    // return number of count chars
    public int fillCharArr(char[] chars,int start,int count) {
        if(count==1)
            return 1;
        int temp=count;
        // attention: number of char must be filled in order from left to right
        // so we first need to know how many digits are in number
        int digitNum=0;
        while(temp!=0) {
            digitNum++;
            temp/=10;
        }
        temp=count;
        for(int j=0;j<digitNum;j++) {
            int yushu=temp%10;
            chars[start+digitNum-j]=Character.forDigit(yushu, 10);
            temp/=10;
        }
        return digitNum;
    }
    
//  public int compress(char[] chars) {
//      Map<Character, Integer> map=new HashMap<Character,Integer>();
//      for(int i=0;i<chars.length;i++) {
//          char key=chars[i];
//          if(map.containsKey(key))
//              map.put(key, map.get(key)+1);
//          else
//              map.put(key, 1);
//      }
//      
//      int answer=0;
//      Set<Character> set=map.keySet();
//      for(Character key:set) {
//          int value=map.get(key);
//          if(value==1)
//              chars[answer++]=key;
//          else {
//              chars[answer]=key;
//              if(value>=10) {
//                  int temp=value;
//                  // attention: number of char must be filled in order from left to right
//                  // so we first need to know how many digits are in number
//                  int digitNum=0;
//                  while(temp!=0) {
//                      digitNum++;
//                      temp/=10;
//                  }
//                  temp=value;
//                  for(int i=0;i<digitNum;i++) {
//                      int yushu=temp%10;
//                      chars[answer+digitNum-i]=Character.forDigit(yushu, 10);
//                      temp/=10;
//                  }
//                  answer+=digitNum+1;
//              }else {
//                  chars[answer+1]=Character.forDigit(value,10);
//                  answer+=2;
//              }
//              
//          }
//          for(int i=0;i<chars.length;i++)
//              System.out.print(chars[i]);
//          System.out.println();
//      }
//        return answer;
//    }
}

