package com.icefox.mianshi;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class BinaryTree2 {
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    TreeNode root;

    public BinaryTree2(int[] array) {
        root = makeBinaryTreeByArray(array, 1);
    }

    /**
     * 采用递归的方式创建一颗二叉树 传入的是二叉树的数组表示法 构造后是二叉树的二叉链表表示法
     */
    public static TreeNode makeBinaryTreeByArray(int[] array, int index) {
        if (index < array.length) {
            int value = array[index];
            if (value != 0) {
                TreeNode t = new TreeNode(value);
                array[index] = 0;
                t.left = makeBinaryTreeByArray(array, index * 2);
                t.right = makeBinaryTreeByArray(array, index * 2 + 1);
                return t;
            }
        }
        return null;
    }

    /**
     * 深度优先遍历，相当于先根遍历 采用非递归实现 需要辅助数据结构：栈
     */
    public void depthOrderTraversal() {
        if (root == null) {
            System.out.println("empty tree");
            return;
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.value + "    ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        System.out.print("\n");
    }

    /**
     * 广度优先遍历 采用非递归实现 需要辅助数据结构：队列
     */
    public void levelOrderTraversal() {
        if (root == null) {
            System.out.println("empty tree");
            return;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        int maxWitdth = 1; // 最大宽度
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            System.out.print(node.value + "    ");
            int length = 0;
            if (node.left != null) {
                queue.add(node.left);
                length++;
            }
            if (node.right != null) {
                queue.add(node.right);
                length++;
            }
        }
        System.out.print("\n");
    }

    // 获取最大深度
    public static int getMaxDepth(TreeNode root) {
        if (root == null)
            return 0;
        else {
            int left = getMaxDepth(root.left);
            int right = getMaxDepth(root.right);
            return 1 + Math.max(left, right);
        }
    }

    // 获取最大宽度  ----  深度优先遍历的一种方法
    public static int getMaxWidth(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        int maxWitdth = 1; // 最大宽度
        queue.add(root); // 入队

        while (true) {
            int len = queue.size(); // 当前层的节点个数
            if (len == 0)
                break;
            while (len > 0) {// 如果当前层，还有节点
                TreeNode t = queue.poll();
                System.out.print(t.value + "    ");
                len--;
                if (t.left != null)
                    queue.add(t.left); // 下一层节点入队
                if (t.right != null)
                    queue.add(t.right);// 下一层节点入队
            }
            maxWitdth = Math.max(maxWitdth, queue.size());
        }
        System.out.print("\n");
        return maxWitdth;
    }

    /**
     * 13 / \ 65 5 / \ \ 97 25 37 / /\ / 22 4 28 32
     */
    public static void main(String[] args) {
        int[] arr = { 0, 13, 65, 5, 97, 25, 0, 37, 22, 0, 4, 28, 0, 0, 32, 0 };
        BinaryTree2 tree = new BinaryTree2(arr);
        tree.depthOrderTraversal();
        tree.levelOrderTraversal();
        System.out.println("深度"+getMaxDepth(tree.root));
        System.out.println("宽度"+getMaxWidth(tree.root));
    }
}
