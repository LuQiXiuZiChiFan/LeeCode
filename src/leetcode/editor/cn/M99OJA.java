package leetcode.editor.cn;

//给定一个字符串 s ，请将 s 分割成一些子串，使每个子串都是 回文串 ，返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "google"
//输出：[["g","o","o","g","l","e"],["g","oo","g","l","e"],["goog","l","e"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出：[["a"]  
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 131 题相同： https://leetcode-cn.com/problems/palindrome-partitioning/ 
// Related Topics 字符串 动态规划 回溯 👍 11 👎 0

import java.util.ArrayList;
import java.util.List;

public class M99OJA{
    public static void main(String[] args) {
        Solution solution = new M99OJA().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[][] partition(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        helper(s, 0, path, res,dp);
        String[][] result = new String[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            result[i] = new String[res.get(i).size()];
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = res.get(i).get(j);//大量的get操作需要使用ArrayList，使用LinkedList会超时
            }
        }
        return result;
    }

    private void helper(String str, int start, List<String> substrings, List<List<String>> res,boolean[][] dp) {
        if (start == str.length()) {
            res.add(new ArrayList<>(substrings));
            return;
        }
        for (int i = start; i < str.length(); i++) {
            if (dp[start][i]) {
                substrings.add(str.substring(start, i + 1));
                helper(str,i+1,substrings, res,dp);
                substrings.remove(substrings.size()-1);
            }
        }
    }

    /*private boolean isPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}