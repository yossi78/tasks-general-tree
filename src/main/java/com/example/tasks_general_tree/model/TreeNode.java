package com.example.tasks_general_tree.model;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {
    private T data;
    private TreeNode<T> parent;
    private List<TreeNode<T>> children;

    public TreeNode(T data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public T getData() {
        return data;
    }

    public TreeNode<T> getParent() {
        return parent;
    }

    public void addChild(TreeNode<T> child) {
        child.parent = this;
        this.children.add(child);
    }

    public void removeChild(TreeNode<T> child) {
        child.parent = null;
        this.children.remove(child);
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }
}

