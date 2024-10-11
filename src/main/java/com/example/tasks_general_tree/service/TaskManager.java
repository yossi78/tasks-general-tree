package com.example.tasks_general_tree.service;

import com.example.tasks_general_tree.model.Task;
import com.example.tasks_general_tree.model.TreeNode;
import com.example.tasks_general_tree.util.GeneralTreeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class TaskManager {

    private TreeNode<Task> root ;
    private Map<String,TreeNode> taskMap ;

    public TaskManager(){
        this.root=new TreeNode<>(new Task("root",LocalDateTime.now()));
        this.taskMap=new HashMap<>();
    }

    public Task addTask(String name) throws IllegalAccessException {
        if(taskMap.containsKey(name)){
            log.warn("the task with name of :"+name + " is already exists");
            throw  new IllegalAccessException();
        }
        Task newTask =new Task(name, LocalDateTime.now());
        TreeNode newTreeNode = new TreeNode(newTask);
        root.addChild(newTreeNode);
        taskMap.put(name,newTreeNode);
        log.debug("The name of :" + name + " has been added successfully");
        return newTask;
    }


    public Task addSubTask(String parentName,String name) throws IllegalAccessException {
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
        return newSubTask;
    }


    public void removeTask(String name) throws IllegalAccessException {
        if(!taskMap.containsKey(name) ){
            log.warn("name not exists :"+name);
            throw  new IllegalAccessException();
        }
        TreeNode treeNodeToRemove = taskMap.get(name);
        root.removeChild(treeNodeToRemove);
        taskMap.remove(treeNodeToRemove);
    }



    public  void printTree(){
        GeneralTreeUtil.printTree(this.root, " ");
    }

    public  String printTreeToString(){
        return GeneralTreeUtil.printTreeToString(this.root, " ",new StringBuilder());
    }




}
