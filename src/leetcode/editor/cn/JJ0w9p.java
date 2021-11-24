package leetcode.editor.cn;

//给定一个非负整数 x ，计算并返回 x 的平方根，即实现 int sqrt(int x) 函数。 
//
// 正数的平方根有两个，只输出其中的正数平方根。 
//
// 如果平方根不是整数，输出只保留整数的部分，小数部分将被舍去。 
//
// 
//
// 示例 1: 
//
// 
//输入: x = 4
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: x = 8
//输出: 2
//解释: 8 的平方根是 2.82842...，由于小数部分将被舍去，所以返回 2
// 
//
// 
//
// 提示: 
//
// 
// 0 <= x <= 2³¹ - 1 
// 
//
// 
//
// 注意：本题与主站 69 题相同： https://leetcode-cn.com/problems/sqrtx/ 
// Related Topics 数学 二分查找 👍 3 👎 0

public class JJ0w9p{
    public static void main(String[] args) {
        Solution solution = new JJ0w9p().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
/*        if(x<1){
            return 0;
        }
        int left = 1;
        int right = x;
        while(left<right&&right-left>1){
            int mid = left+(right-left)/2;
            if(x/mid==mid){
                return mid;
            }else if(x/mid>mid){
                left = mid;
            }else{
                right=mid;
            }
        }
        return left;*/

        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                if ((mid + 1) > x / (mid + 1)) {
                    return mid;
                }
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}