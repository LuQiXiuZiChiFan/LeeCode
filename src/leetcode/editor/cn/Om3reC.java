package leetcode.editor.cn;

//在字典（单词列表） wordList 中，从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列： 
//
// 
// 序列中第一个单词是 beginWord 。 
// 序列中最后一个单词是 endWord 。 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典 wordList 中的单词。 
// 
//
// 给定两个长度相同但内容不同的单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 
//的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0。 
//
// 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
//
// 
//
// 注意：本题与主站 127 题相同： https://leetcode-cn.com/problems/word-ladder/ 
// Related Topics 广度优先搜索 哈希表 字符串 👍 3 👎 0

import java.util.*;

public class Om3reC{
    public static void main(String[] args) {
        Solution solution = new Om3reC().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        Set<String> notVisit = new HashSet<>(wordList);
        int length = 1;
        queue1.add(beginWord);
        while (!queue1.isEmpty()) {
            String word = queue1.remove();
            if (word.equals(endWord)) {
                return length;
            }

            List<String> neighbors = getNeighbors(word);
            for (String neighbor : neighbors) {
                if (notVisit.contains(neighbor)) {
                    queue2.add(neighbor);
                    notVisit.remove(neighbor);
                }
            }

            if (queue1.isEmpty()) {
                length++;
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return 0;
    }

    private List<String> getNeighbors(String word) {
        List<String> neighbors = new LinkedList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char old = chars[i];
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (old != ch) {
                    chars[i] = ch;
                    neighbors.add(new String(chars));
                }
            }
            chars[i] = old;
        }
        return neighbors;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}