package com.lintcode.easy;
/**
 * 在二叉树中寻找值最大的节点并返回。
 * 给出如下一棵二叉树：

      1
   /   \
 -5     2
 / \   /  \
 0   3 -4  -5
 返回值为 3 的节点。
 * Created by liqiliang <liqiliang@baibu.la> on 2017/4/26.
 */
public class MaxNode {
    /**
     * @param root the root of binary tree
     * @return the max ndoe
     */
    public TreeNode maxNode(TreeNode root) {
        // Write your code here
        //有bug，没能有效遍历
        TreeNode maxNode;
        if (root==null)
            return null;
        if (maxNode(root.left)!=null && maxNode(root.right)!=null) {
             maxNode = maxNode(root.left).val > maxNode(root.right).val ? maxNode(root.left) : maxNode(root.right);
        }else if (maxNode(root.left)==null && maxNode(root.right)!=null){
            maxNode=maxNode(root.right);
        }else if (maxNode(root.right)==null && maxNode(root.left)!=null){
            maxNode=maxNode(root.left);
        }else {
            maxNode=root;
        }
        return maxNode;
    }


}
