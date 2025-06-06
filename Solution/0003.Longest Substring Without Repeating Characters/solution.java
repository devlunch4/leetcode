import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
          Set<Object> set = new HashSet<>();
        int strLength = s.length();
        int begin = 0;
        int end = 0;
        int res = 0;
        while (end < strLength) {
            if (set.contains(s.charAt(end))) {
                set.remove(s.charAt(begin++));
            } else {
                set.add(s.charAt(end++));
                res = Math.max(res, end - begin);
            }
        }
        return res;
    }
}
