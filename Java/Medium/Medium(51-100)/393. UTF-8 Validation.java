
/*
A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:

For 1-byte character, the first bit is a 0, followed by its unicode code.
For n-bytes character, the first n-bits are all one's, the n+1 bit is 0, followed by n-1 bytes with most significant 2 bits being 10.
This is how the UTF-8 encoding would work:

   Char. number range  |        UTF-8 octet sequence
      (hexadecimal)    |              (binary)
   --------------------+---------------------------------------------
   0000 0000-0000 007F | 0xxxxxxx
   0000 0080-0000 07FF | 110xxxxx 10xxxxxx
   0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
   0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
Given an array of integers representing the data, return whether it is a valid utf-8 encoding.

Note:
The input is an array of integers. Only the least significant 8 bits of each integer is used to store the data. This means each integer represents only 1 byte of data.

Example 1:

data = [197, 130, 1], which represents the octet sequence: 11000101 10000010 00000001.

Return true.
It is a valid utf-8 encoding for a 2-bytes character followed by a 1-byte character.
Example 2:

data = [235, 140, 4], which represented the octet sequence: 11101011 10001100 00000100.

Return false.
The first 3 bits are all one's and the 4th bit is 0 means it is a 3-bytes character.
The next byte is a continuation byte which starts with 10 and that's correct.
But the second continuation byte does not start with 10, so it is invalid.
*/


class Solution {
    public static boolean validUtf8(int[] data) {
        String[] dataStr=new String[data.length];
        for(int i=0;i<dataStr.length;i++) {
            dataStr[i]=getIntegerLeastEightBits(data[i]);
            System.out.println(dataStr[i]);
        }
        return isValidUtf8String(dataStr);
    }
    
    public static boolean isValidUtf8String(String[] dataStr) {
        for(int i=0;i<dataStr.length;) {
            String binCode=dataStr[i];
            // 1-byte character
            if(binCode.startsWith("0")) {
                return isValidUtf8String(Arrays.copyOfRange(dataStr,1,dataStr.length));
            }// 2-bytes character
            else if(binCode.startsWith("110")) {
                // ensure that i is not out of array boundary
                if(i+1<dataStr.length)
                    if(dataStr[i+1].startsWith("10")) {
                        return isValidUtf8String(Arrays.copyOfRange(dataStr,2,dataStr.length));
                    }else
                        return false;
                else
                    return false;
            }// 3-bytes character
            else if(binCode.startsWith("1110")) {
                if(i+2<dataStr.length)
                    if(dataStr[i+1].startsWith("10") && dataStr[i+2].startsWith("10")) {
                        return isValidUtf8String(Arrays.copyOfRange(dataStr,3,dataStr.length));
                    }else
                        return false;
                else
                    return false;
            }// 4-bytes character
            else if(binCode.startsWith("11110")) {
                if(i+3<dataStr.length)
                    if(dataStr[i+1].startsWith("10") && dataStr[i+2].startsWith("10") && dataStr[i+3].startsWith("10")) {
                        return isValidUtf8String(Arrays.copyOfRange(dataStr,4,dataStr.length));
                    }else
                        return false;
                else
                    return false;
            }else if(binCode.startsWith("10")){
                    return false;
            }else {
                // there can be no more than 4 '1' at the beginning of the binary code
                int countBeginningOne=0;
                for(int j=0;j<binCode.length();j++) {
                    if(binCode.charAt(j)=='1')
                        countBeginningOne++;
                    else
                        break;
                }
                if(countBeginningOne>4)
                    return false;
                else
                    return true;
            }
                
        }
        
        return true;
    }
    
    public static String getIntegerLeastEightBits(int integer) {
        String binCode=Integer.toBinaryString(integer);
        while(binCode.length()<8) {
            binCode="0"+binCode;
        }
        
        if(binCode.length()>8)
            binCode=binCode.substring(binCode.length()-8);
        
        return binCode;
    }
}

