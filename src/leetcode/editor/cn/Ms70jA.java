package leetcode.editor.cn;

//给定一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：nums = [3,10,5,25,2,8]
//输出：28
//解释：最大运算结果是 5 XOR 25 = 28. 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,4]
//输出：6
// 
//
// 示例 4： 
//
// 
//输入：nums = [8,10,2]
//输出：10
// 
//
// 示例 5： 
//
// 
//输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
//输出：127
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// 0 <= nums[i] <= 2³¹ - 1 
// 
// 
// 
//
// 
//
// 进阶：你可以在 O(n) 的时间解决这个问题吗？ 
//
// 
//
// 注意：本题与主站 421 题相同： https://leetcode-cn.com/problems/maximum-xor-of-two-
//numbers-in-an-array/ 
// Related Topics 位运算 字典树 数组 哈希表 👍 11 👎 0

public class Ms70jA{
    public static void main(String[] args) {
        Solution solution = new Ms70jA().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
     class TrieNode {
        public TrieNode[] childern;

        public TrieNode() {
            childern = new TrieNode[2];
        }
    }

    private TrieNode buildTrie(int[] nums) {
        TrieNode root = new TrieNode();
        for (int num : nums) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.childern[bit] == null) {
                    node.childern[bit] = new TrieNode();
                }
                node = node.childern[bit];
            }
        }
        return root;
    }
    public int findMaximumXOR(int[] nums) {
        TrieNode root = buildTrie(nums);
        int max = 0;
        for (int num : nums) {
            TrieNode node = root;
            int xor = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.childern[1 - bit] != null) {
                    xor = (xor << 1) + 1;
                    node = node.childern[1 - bit];
                } else {
                    xor = xor << 1;
                    node = node.childern[bit];
                }
            }
            max = Math.max(max, xor);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}