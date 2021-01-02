package com.wei.study.java.algorithm.tree;

import java.util.LinkedList;
import java.util.Stack;

public class TreeTest {

    public static TreeNode create() {
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        TreeNode n11 = new TreeNode(11);
        TreeNode n12 = new TreeNode(12);

        root.left = n2;
        root.right = n3;

        n2.left = n4;
        n2.right = n5;

        n5.left = n7;

        n3.right = n6;
        n3.left = n12;

        n4.left = n8;
        n4.right = n9;

        n9.left = n10;

        n8.right = n11;

        return root;
    }

    /**
     * 层次遍历
     *
     * @param root
     */
    public static void levelPrint(TreeNode root) {

        if (root == null) {
            return;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            System.out.print(node.value + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

    }

    public static void firstPrint1(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        firstPrint1(root.left);
        firstPrint1(root.right);
    }

    public static void firstPrint2(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.value + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public static void firstPrint3(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {

            while (node != null) {
                System.out.print(node.value + " ");
                stack.push(node);
                node = node.left;
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    public static void midPrint1(TreeNode root) {
        if (root == null) {
            return;
        }
        midPrint1(root.left);
        System.out.print(root.value + " ");
        midPrint1(root.right);
    }

    public static void midPrint2(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {

            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.print(node.value + " ");
                node = node.right;
            }
        }
    }

    public static void lastPrint1(TreeNode root) {
        if (root == null) {
            return;
        }
        lastPrint1(root.left);
        lastPrint1(root.right);
        System.out.print(root.value + " ");
    }

    public static void lastPrint2(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;

        TreeNode preNode = null;

        while (!stack.isEmpty() || node != null) {

            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            if(node.right == null || node.right == preNode) {
                System.out.print(node.value + " ");
                preNode = node;
                node = null;
            } else {
                stack.push(node);
                node = node.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode tree = create();
        levelPrint(tree);
        System.out.println();

        System.out.println("前");
        firstPrint1(tree);
        System.out.println();
        firstPrint2(tree);
        System.out.println();
        firstPrint3(tree);
        System.out.println();

        System.out.println("中");
        midPrint1(tree);
        System.out.println();
        midPrint2(tree);
        System.out.println();

        System.out.println("后");
        lastPrint1(tree);
        System.out.println();
        lastPrint2(tree);

        System.out.println();
    }
}
