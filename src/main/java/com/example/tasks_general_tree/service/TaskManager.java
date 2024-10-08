package com.example.tasks_general_tree.service;

import com.example.tasks_general_tree.model.Task;
import com.example.tasks_general_tree.model.TreeNode;
import com.example.tasks_general_tree.util.GeneralTreeUtil;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class TaskManager {

    private TreeNode<Task> root ;
    private Map<String,TreeNode> taskMap ;

    public TaskManager(){
        this.root=new TreeNode<>(new Task("root",LocalDateTime.now()));
        this.taskMap=new HashMap<>();
    }

    public void addTask(String name) throws IllegalAccessException {
        if(taskMap.containsKey(name)){
            log.warn("the task with name of :"+name + " is already exists");
            throw  new IllegalAccessException();
        }
        Task newTask =new Task(name, LocalDateTime.now());
        TreeNode newTreeNode = new TreeNode(newTask);
        root.addChild(newTreeNode);
        taskMap.put(name,newTreeNode);
        log.debug("The name of :" + name + " has been added successfully");
    }


    public void addSubTask(String parentName,String name) throws IllegalAccessException {
        if(taskMap.containsKey(parentName) && !taskMap.containsKey(name) ){
            log.warn("Parent not exists or the task with name of :"+name + " is already exists");
            throw  new IllegalAccessException();
        }
        TreeNode parent =taskMap.get(parentName);
        Task newSubTask = new Task(name,LocalDateTime.now());
        TreeNode newTreeNode = new TreeNode(newSubTask);
        parent.addChild(newTreeNode);
        log.debug("The name of :" + name + " has been added successfully");
    }


    public void printTree(){
        doPrintTree(this.root);
    }


    private void doPrintTree(TreeNode treeNode){
        System.out.println(treeNode.getData());
        List<TreeNode<Task>> children = treeNode.getChildren();
        for(TreeNode<Task> c:children){
            System.out.println(c.getData());
        }
        for(TreeNode<Task> c:children){
            if(!c.getChildren().isEmpty()){
                doPrintTree(c);
            }
        }
    }


    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        // Create the root node



        Task rootTask = new Task("root",LocalDateTime.now());
        TreeNode<Task> root = new TreeNode<>(rootTask);


        // Create child tasks
        Task childTask1 = new Task("Child 1",LocalDateTime.now());
        Task childTask2 = new Task("Child 2",LocalDateTime.now());
        Task childTask3 = new Task("Child 3",LocalDateTime.now());
        // Create child nodes
        TreeNode<Task> child1 = new TreeNode<>(childTask1);
        TreeNode<Task> child2 = new TreeNode<>(childTask2);
        TreeNode<Task> child3 = new TreeNode<>(childTask3);


        // Add children to root
        root.addChild(child1);
        root.addChild(child2);
        root.addChild(child3);


        // Create grandchildren tasks
        Task grandChildTask1 = new Task("GrandChild 1",LocalDateTime.now());
        Task grandChildTask2 = new Task("GrandChild 2",LocalDateTime.now());
        Task grandChildTask3 = new Task("GrandChild 3",LocalDateTime.now());


        // Add grandchildren
        TreeNode<Task> grandChild1 = new TreeNode<>(grandChildTask1);
        TreeNode<Task> grandChild2 = new TreeNode<>(grandChildTask2);
        TreeNode<Task> grandChild3 = new TreeNode<>(grandChildTask3);


        child1.addChild(grandChild1);
        child1.addChild(grandChild2);
        child1.addChild(grandChild3);

        // Display the tree
        GeneralTreeUtil.printTree(root, " ");
    }


}
