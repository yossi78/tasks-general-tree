package com.example.tasks_general_tree.util;


import com.example.tasks_general_tree.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class GeneralTreeUtil {

    // Simple method to print the tree structure
    public static void printTree(TreeNode<?> node, String appender) {
        System.out.println(appender + node.getData());
        for (TreeNode<?> child : node.getChildren()) {
            printTree(child, appender + appender);
        }
    }

    public static void depthFirstTraversal(TreeNode<?> node) {
        if (node == null) return;
        System.out.println(node.getData());
        for (TreeNode<?> child : node.getChildren()) {
            depthFirstTraversal(child);
        }
    }


    public static void breadthFirstTraversal(TreeNode<?> root) {
        if (root == null) return;

        Queue<TreeNode<?>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode<?> current = queue.poll();
            System.out.println(current.getData());

            for (TreeNode<?> child : current.getChildren()) {
                queue.add(child);
            }
        }
    }
}
