package com.example.employeehierarchysystem.model;


import lombok.Getter;

import java.util.LinkedList;
import java.util.Queue;

@Getter
public class BinaryTree<T> {
    private TreeNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(T data) {
        if (root == null) {
            root = new TreeNode<>(data);
            return;
        }

        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode<T> current = queue.poll();

            if (current.getLeft() == null) {
                current.setLeft(new TreeNode<>(data));
                break;
            } else {
                queue.add(current.getLeft());
            }

            if (current.getRight() == null) {
                current.setRight(new TreeNode<>(data));
                break;
            } else {
                queue.add(current.getRight());
            }
        }
    }

}