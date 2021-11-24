package leetcode.editor.cn;

//给定两个字符串 s 和 t 。返回 s 中包含 t 的所有字符的最短子字符串。如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。 
//
// 如果 s 中存在多个符合条件的子字符串，返回任意一个。 
//
// 
//
// 注意： 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC" 
//解释：最短子字符串 "BANC" 包含了字符串 t 的所有字符 'A'、'B'、'C' 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3： 
//
// 
//输入：s = "a", t = "aa"
//输出：""
//解释：t 中两个字符 'a' 均应包含在 s 的子串中，因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//
// 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ 
//
// 
//
// 注意：本题与主站 76 题相似（本题答案不唯一）：https://leetcode-cn.com/problems/minimum-window-
//substring/ 
// Related Topics 哈希表 字符串 滑动窗口 👍 11 👎 0

import java.util.HashMap;

public class M1oyTv{
    public static void main(String[] args) {
        Solution solution = new M1oyTv().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> charToCount = new HashMap<>();
        for (char ch : t.toCharArray()) {
            charToCount.put(ch, charToCount.getOrDefault(ch, 0)+1);
        }

        int count = charToCount.size();//count 的使用需要学习
        int start=0,end=0,minStart=0,minEnd=0;
        int minLength = Integer.MAX_VALUE;
        while (end < s.length() || (count == 0 && end == s.length())) {
            if (count > 0) {
                char endCh = s.charAt(end);
                if (charToCount.containsKey(endCh)) {
                    charToCount.put(endCh,charToCount.get(endCh)-1);
                    if(charToCount.get(endCh)==0){
                        count--;
                    }
                }
                end++;
            }else{
                if(end-start<minLength){
                    minLength = end - start;
                    minStart=start;
                    minEnd = end;
                }
                char startCh = s.charAt(start);
                if (charToCount.containsKey(startCh)) {
                    charToCount.put(startCh, charToCount.get(startCh) + 1);
                    if (charToCount.get(startCh) == 1) {
                        count++;
                    }
                }
                start++;
            }
        }
        return minLength < Integer.MAX_VALUE ? s.substring(minStart, minEnd) : "";
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}