
/*
Note: This is a companion problem to the System Design problem: Design TinyURL.
TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
*/

// solution from: https://leetcode.com/problems/encode-and-decode-tinyurl/discuss/100268/Two-solutions-and-thoughts
public class Codec {

    static Map<String, String> url2code=new HashMap<>(),code2url=new HashMap<>();
    static String codeRange="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    
     // Encodes a URL to a shortened URL.
    //  use a six digit code to represent long URL
    public static String encode(String longUrl) {
        if(url2code.containsKey(longUrl))
            return url2code.get(longUrl);
        
        String code=null;
        Random random=new Random();
        while(!url2code.containsKey(longUrl)) {
            code="";
            for(int i=0;i<6;i++) {
                code+=codeRange.charAt(random.nextInt(codeRange.length()));
            }
            if(!code2url.containsKey(code)) {
                url2code.put(longUrl,code);
                code2url.put(code,longUrl);
            }
        }
        
        
        return "http://tinyurl.com/"+code;
    }

    // Decodes a shortened URL to its original URL.
    public static String decode(String shortUrl) {
        return code2url.get(shortUrl.substring(shortUrl.length()-6));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
