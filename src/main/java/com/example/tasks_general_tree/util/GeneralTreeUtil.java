package com.example.tasks_general_tree.util;


import com.example.tasks_general_tree.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class GeneralTreeUtil {

    public static void printTree(TreeNode<?> node, String appender) {
        if(node.getParent()!=null){
            System.out.println(appender + node.getData());
        }
        for (TreeNode<?> child : node.getChildren()) {
            printTree(child, appender + appender);
        }
    }


    public static String printTreeToString(TreeNode<?> node, String appender,StringBuilder sb) {
        if(node.getParent()!=null){
            sb.append(appender + node.getData()).append("\n");
        }
        for (TreeNode<?> child : node.getChildren()) {
            printTreeToString(child, appender + appender,sb);
        }
        if(node.getChildren().isEmpty()){
            System.out.println("this node is the end = "+ node.getData());
            return sb.toString();
        }
        return sb.toString();
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
