import java.util.*;

class Solution {
    public long solution(long n) {
        String str = String.valueOf(n);
        
        Character[] ch = new Character[str.length()];
        
        for (int i = 0; i < str.length(); i++) {
            ch[i] = str.charAt(i);
        }
        
        Arrays.sort(ch, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder(ch.length);
        for (char c : ch) {
            sb.append(c);
        }
        
        return Long.parseLong(sb.toString());
    }
}