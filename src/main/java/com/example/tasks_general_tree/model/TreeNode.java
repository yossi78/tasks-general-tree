package com.example.tasks_general_tree.model;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {
    private T data;
    private TreeNode<T> parent;
    private List<TreeNode<T>> children;

    // Constructor
    public TreeNode(T data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    // Getters and Setters
    public T getData() {
        return data;
    }

    public TreeNode<T> getParent() {
        return parent;
    }

    // Add a child to the current node
    public void addChild(TreeNode<T> child) {
        child.parent = this;
        this.children.add(child);
    }

    // Remove a child from the current node
    public void removeChild(TreeNode<T> child) {
        child.parent = null;
        this.children.remove(child);
    }

    // Get children
    public List<TreeNode<T>> getChildren() {
        return children;
    }

    // Check if the node is a leaf
    public boolean isLeaf() {
        return children.isEmpty();
    }
}

