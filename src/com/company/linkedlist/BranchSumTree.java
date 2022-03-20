package com.company.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class BranchSumTree {

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        // Write your code here.
        List<Integer> sums = new ArrayList<>();
        calculateBranchSums(root, 0, sums);
        return sums;
    }

    public static void calculateBranchSums(BinaryTree root, int runningSum, List<Integer> sums){
        if(root == null) return;

        int newRunningSum = runningSum + root.value;
        if(root.left == null && root.right == null){
            sums.add(newRunningSum);
            return;
        }

        calculateBranchSums(root.left,newRunningSum,sums);
        calculateBranchSums(root.right, newRunningSum, sums);
    }
}
