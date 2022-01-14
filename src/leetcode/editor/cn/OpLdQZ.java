package leetcode.editor.cn;

//给定一个二叉搜索树的 根节点 root 和一个整数 k , 请判断该二叉搜索树中是否存在两个节点它们的值之和等于 k 。假设二叉搜索树中节点的值均唯一。 
//
// 
//
// 示例 1： 
//
// 
//输入: root = [8,6,10,5,7,9,11], k = 12
//输出: true
//解释: 节点 5 和节点 7 之和等于 12
// 
//
// 示例 2： 
//
// 
//输入: root = [8,6,10,5,7,9,11], k = 22
//输出: false
//解释: 不存在两个节点值之和为 22 的节点
// 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点个数的范围是 [1, 10⁴]. 
// -10⁴ <= Node.val <= 10⁴ 
// root 为二叉搜索树 
// -10⁵ <= k <= 10⁵ 
// 
//
// 
//
// 注意：本题与主站 653 题相同： https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 哈希表 双指针 二叉树 👍 7 👎 0

import java.util.Stack;

public class OpLdQZ {
    public static void main(String[] args) {
        Solution solution = new OpLdQZ().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
   /* public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }*/

    class Solution {
        public boolean findTarget(TreeNode root, int k) {
            if (root == null) {
                return false;
            }
            BSTIterator iterNext = new BSTIterator(root);
            BSTIteratorReverse iterPrev = new BSTIteratorReverse(root);
            int next = iterNext.next();
            int prev = iterPrev.next();
            while (next != prev) {
                if (next + prev == k) {
                    return true;
                } else if (next + prev < k) {
                    next = iterNext.next();
                }else{
                    prev = iterPrev.next();
                }
            }
            return false;
        }
    }
     class BSTIterator{
        TreeNode cur;
        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            cur = root;
            stack = new Stack<>();
        }

        public boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }
        public int next(){
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            int val = cur.val;
            cur = cur.right;
            return val;
        }
    }
    class BSTIteratorReverse{
        TreeNode cur;
        Stack<TreeNode> stack;

        public BSTIteratorReverse(TreeNode root) {
            cur = root;
            stack = new Stack<>();
        }

        public boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }
        public int next(){
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            int val = cur.val;
            cur = cur.left;
            return val;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
