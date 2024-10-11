//package com.example.tasks_general_tree.service;
//
//
//import com.example.tasks_general_tree.model.Task;
//import com.example.tasks_general_tree.model.TreeNode;
//import com.example.tasks_general_tree.util.GeneralTreeUtil;
//import com.sun.source.tree.Tree;
//
//import java.time.LocalDateTime;
//
//public class GeneralTreeExample {
//    public static void main(String[] args) {
//        // Create the root node
//        Task rootTask = new Task("root",LocalDateTime.now());
//        TreeNode<Task> root = new TreeNode<>(rootTask);
//
//
//        // Create child tasks
//        Task childTask1 = new Task("Child 1",LocalDateTime.now());
//        Task childTask2 = new Task("Child 2",LocalDateTime.now());
//        Task childTask3 = new Task("Child 3",LocalDateTime.now());
//
//
//        // Create child nodes
//        TreeNode<Task> child1 = new TreeNode<>(childTask1);
//        TreeNode<Task> child2 = new TreeNode<>(childTask2);
//        TreeNode<Task> child3 = new TreeNode<>(childTask3);
//
//        // Add children to root
//        root.addChild(child1);
//        root.addChild(child2);
//        root.addChild(child3);
//
//
//        // Create grandchildren tasks
//        Task grandChildTask1 = new Task("GrandChild 1",LocalDateTime.now());
//        Task grandChildTask2 = new Task("GrandChild 2",LocalDateTime.now());
//        Task grandChildTask3 = new Task("GrandChild 3",LocalDateTime.now());
//
//
//        // Add grandchildren
//        TreeNode<Task> grandChild1 = new TreeNode<>(grandChildTask1);
//        TreeNode<Task> grandChild2 = new TreeNode<>(grandChildTask2);
//        TreeNode<Task> grandChild3 = new TreeNode<>(grandChildTask3);
//
//
//        child1.addChild(grandChild1);
//        child1.addChild(grandChild2);
//        child1.addChild(grandChild3);
//
//        // Display the tree
//        GeneralTreeUtil.printTree(root, " ");
//    }
//
//
//
//
//}
