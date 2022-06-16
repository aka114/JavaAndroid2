package algoritmsAndStructures.lesson6;

import java.util.Random;

public class Main {

    public static class Tree {
        public class TreeNode {
            private int val;
            public TreeNode leftChild;
            public TreeNode rightChild;

            public TreeNode(int val) {
                this.val = val;
            }

            @Override
            public String toString() {
                return String.format("TN(%s)", val);
            }
        }
        private TreeNode root;
        public Tree() {
            root = null;
        }
        public void insert(int val) {
            TreeNode node = new TreeNode(val);
            if (root == null) {
                root = node;
            } else {
                TreeNode current = root;
                TreeNode parent;
                while (true) {
                    parent = current;
                    if (val < current.val) {
                        current = current.leftChild;
                        if (current == null) {
                            parent.leftChild = node;
                            return;
                        }
                    } else if (val > current.val){
                        current = current.rightChild;
                        if (current == null) {
                            parent.rightChild = node;
                            return;
                        }
                    } else {
                        return;
                    }
                }

            }
        }
        public int find(int val) {
            TreeNode current = root;
            while (current.val != val) {
                if (val < current.val)
                    current = current.leftChild;
                else
                    current = current.rightChild;

                if (current == null)
                    return 0;
            }
            return current.val;
        }
        private void inOrderTravers(TreeNode current) {
            if (current != null) {
                System.out.println(current);
                inOrderTravers(current.leftChild);
                inOrderTravers(current.rightChild);
            }
        }
        public void displayTree() {
            inOrderTravers(root);
        }
        public boolean delete(int val) {
            TreeNode curr = root;
            TreeNode prev = root;
            boolean isLeftChild = true;
            while (curr.val != val) {
                prev = curr;
                if (val < curr.val) {
                    isLeftChild = true;
                    curr = curr.leftChild;
                } else {
                    isLeftChild = false;
                    curr = curr.rightChild;
                }

                if (curr == null)
                    return false;
            }

            if (curr.leftChild == null && curr.rightChild == null) {
                if (curr == root) {
                    root = null;
                } else if (isLeftChild) {
                    prev.leftChild = null;
                } else {
                    prev.rightChild = null;
                }
            } else if (curr.rightChild == null) {
                if (isLeftChild) {
                    prev.leftChild = curr.leftChild;
                } else {
                    prev.rightChild = curr.leftChild;
                }
            } else if (curr.leftChild == null) {
                if (isLeftChild) {
                    prev.leftChild = curr.rightChild;
                } else {
                    prev.rightChild = curr.rightChild;
                }
            } else {
                TreeNode successor = getSuccessor(curr);
                if (curr == root) {
                    root = successor;
                } else if (isLeftChild) {
                    prev.leftChild = successor;
                } else {
                    prev.rightChild = successor;
                }
                successor.leftChild = curr.leftChild;
            }
            return true;
        }

        private TreeNode getSuccessor(TreeNode deleted) {
            TreeNode successorParent = deleted;
            TreeNode successor = deleted;
            TreeNode flag = deleted.rightChild;

            while (flag != null) {
                successorParent = successor;
                successor = flag;
                flag = flag.leftChild;
            }
            if (successor != deleted.rightChild) {
                successorParent.leftChild = successor.rightChild;
                successor.rightChild = deleted.rightChild;
            }
            return successor;
        }
        public boolean isBalansed() {
            return maxLevel() - minLevel() < 2;
        }

        private int getMaxLevel(TreeNode node) {
            if (node == null) {
                return 0;
            } else {
                return 1 + Math.max(getMaxLevel(node.leftChild), getMaxLevel(node.rightChild));
            }
        }

        private int getMinLevel(TreeNode node) {
            if (node == null) {
                return 0;
            } else if (node.leftChild == null && node.rightChild == null) {
                return 1;
            } else {
                return 1 + Math.min(getMinLevel(node.leftChild), getMinLevel(node.rightChild));
            }
        }
        public int maxLevel() {
            return getMaxLevel(this.root);
        }

        private int minLevel() {
            return getMinLevel(this.root);
        }

    }

    public static void main(String[] args) {

        int TREE_NUM = 1000;
        int NODE_NUM = 100;
        int balansedTrees = 0;
        Tree[] trees = new Tree[TREE_NUM];
        int val;
        for (int i = 0; i < TREE_NUM; i++) {
            trees[i] = new Tree();
            for (int j = 0; j < 100; j++) {
                val = (int) (Math.random() * 200 - 100);
                trees[i].insert(val);
            }
            System.out.printf("Макс. уровень %2d мин. уровень %2d%n", trees[i].maxLevel(), trees[i].minLevel());
            if(trees[i].isBalansed()) {
                balansedTrees++;
            }
        }
        System.out.println(balansedTrees);
        System.out.printf("Балансировано %.2f%n", (float)(balansedTrees / TREE_NUM * 100));
    }
}
