package com.company.linkedlist;

public class BinarySearchTree {


        public static int findClosestValueInBst(BST tree, int target) {
            // Write your code here.
            return findClosestValueInBst(tree,target,tree.value);
        }

        //Doing it recursively
        public static int findClosestValueInBst(BST tree, int target,int closest){
            if(Math.abs(target - closest) > Math.abs(target - tree.value)){
                return closest = tree.value;
            }
            if(target < tree.value && tree.left != null){
                return findClosestValueInBst(tree.left,target,closest);
            }else if(target > tree.value && tree.right != null){
                return findClosestValueInBst(tree.right,target,closest);
            }else{
                return closest;
            }
        }



        //Doing it Iteratively
        public static int findClosestValueInBst2(BST tree, int target, int closest){
            BST currentNode = tree;
            while(currentNode != null){
                if(Math.abs(target - closest) > Math.abs(target - currentNode.value)){
                    closest = currentNode.value;
                }

                if(target < currentNode.value){
                    currentNode = currentNode.left;
                }else if(target > currentNode.value){
                    currentNode = currentNode.right;
                }else{
                    break;
                }
            }
            return closest;
        }



        static class BST {
            public int value;
            public BST left;
            public BST right;

            public BST(int value) {
                this.value = value;
            }
        }

}
