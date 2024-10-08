package com.example.tasks_general_tree.service;


import com.example.tasks_general_tree.model.TreeNode;
import com.example.tasks_general_tree.util.GeneralTreeUtil;

public class GeneralTreeExample {
    public static void main(String[] args) {
        // Create the root node
        TreeNode<String> root = new TreeNode<>("Root");

        // Create child nodes
        TreeNode<String> child1 = new TreeNode<>("Child 1");
        TreeNode<String> child2 = new TreeNode<>("Child 2");
        TreeNode<String> child3 = new TreeNode<>("Child 3");

        // Add children to root
        root.addChild(child1);
        root.addChild(child2);
        root.addChild(child3);

        // Add grandchildren
        TreeNode<String> grandChild1 = new TreeNode<>("GrandChild 1");
        TreeNode<String> grandChild2 = new TreeNode<>("GrandChild 2");
        TreeNode<String> grandChild3 = new TreeNode<>("GrandChild 3");
        child1.addChild(grandChild1);
        child1.addChild(grandChild2);
        child1.addChild(grandChild3);

        // Display the tree
        GeneralTreeUtil.printTree(root, " ");
    }




}
