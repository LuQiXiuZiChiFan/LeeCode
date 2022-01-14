package leetcode.editor.cn;

//给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：timePoints = ["23:59","00:00"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：timePoints = ["00:00","23:59","00:00"]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 2 <= timePoints <= 2 * 10⁴ 
// timePoints[i] 格式为 "HH:MM" 
// 
//
// 
//
// 注意：本题与主站 539 题相同： https://leetcode-cn.com/problems/minimum-time-difference/ 
// Related Topics 数组 数学 字符串 排序 👍 5 👎 0

import java.util.List;

public class Five69nqc{
    public static void main(String[] args) {
        Solution solution = new Five69nqc().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) {
            return 0;
        }
        boolean[] minuteFlag = new boolean[1440];
        for (String time : timePoints) {
            String[] t = time.split(":");
            int min = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
            if (minuteFlag[min]) {
                return 0;
            }
            minuteFlag[min] = true;
        }
        return helper(minuteFlag);
    }

    private int helper(boolean[] minuteFlag) {
        int minDiff = minuteFlag.length - 1;
        int prev = -1;
        int first = minuteFlag.length - 1;
        int last = -1;
        for (int i = 0; i < minuteFlag.length ; i++) {
            if (minuteFlag[i]) {
                if (prev >= 0) {
                    minDiff = Math.min(i - prev, minDiff);
                }
                prev = i;
                first = Math.min(first, i);
                last = Math.max(i, last);
            }
        }
        minDiff = Math.min(first + 1440 - last, minDiff);
        return minDiff;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}