package leetcode.editor.cn;

//给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。 
//
// 
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2
//解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
// 
//
// 示例 2 : 
//
// 
//输入:nums = [1,2,3], k = 3
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// 
// -10⁷ <= k <= 10⁷ 
// 
// 
//
// 
//
// 注意：本题与主站 560 题相同： https://leetcode-cn.com/problems/subarray-sum-equals-k/ 
// Related Topics 数组 哈希表 前缀和 👍 23 👎 0

import java.util.HashMap;
import java.util.Map;

public class QTMn0o{
    public static void main(String[] args) {
        Solution solution = new QTMn0o().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumToCount = new HashMap<>();
        sumToCount.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            count += sumToCount.getOrDefault(sum - k, 0);
            sumToCount.put(sum, sumToCount.getOrDefault(sum, 0) + 1);
        }
        return  count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}