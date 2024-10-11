package com.example.tasks_general_tree.service;

import com.example.tasks_general_tree.model.Task;
import com.example.tasks_general_tree.model.TreeNode;
import com.example.tasks_general_tree.util.GeneralTreeUtil;
import lombok.extern.slf4j.Slf4j;
import java.time.LocalDateTime;
import java.util.HashMap;
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
        if(!taskMap.containsKey(parentName) || taskMap.containsKey(name) ){
            log.warn("Parent not exists or the task with name of :"+name + " is already exists");
            throw  new IllegalAccessException();
        }
        TreeNode parent =taskMap.get(parentName);
        Task newSubTask = new Task(name,LocalDateTime.now());
        TreeNode newTreeNode = new TreeNode(newSubTask);
        parent.addChild(newTreeNode);
        taskMap.put(name,newTreeNode);
        log.debug("The name of :" + name + " has been added successfully");
    }





    public static void main(String[] args) throws IllegalAccessException {
        TaskManager taskManager = new TaskManager();

        taskManager.addTask("Child 1");
        taskManager.addTask("Child 2");
        taskManager.addTask("Child 3");

        taskManager.addSubTask("Child 1","GrandChild 1");
        taskManager.addSubTask("Child 1","GrandChild 2");
        taskManager.addSubTask("Child 1","GrandChild 3");


        taskManager.addSubTask("GrandChild 1","GrantGrandChild 1");
        taskManager.addSubTask("GrandChild 1","GrantGrandChild 2");
        taskManager.addSubTask("GrandChild 1","GrantGrandChild 3");
        taskManager.addSubTask("GrandChild 1","GrantGrandChild 4");

        GeneralTreeUtil.printTree(taskManager.root, " ");
    }


}
