

import java.util.NoSuchElementException;

public class BacktrackingBST implements Backtrack, ADTSet<BacktrackingBST.Node> {
    private Stack stack;
    private Stack redoStack;
    private BacktrackingBST.Node root = null;
    private boolean is_redo = false;
    // Do not change the constructor's signature
    public BacktrackingBST(Stack stack, Stack redoStack) {
        this.stack = stack;
        this.redoStack = redoStack;
    }

    public Node getRoot() {
    	if (root == null) {
    		throw new NoSuchElementException("empty tree has no root");
    	}
        return root;
    }
	
    public Node search(int k) {
        // TODO: implement your code here
        // Find Node With K Value Iteratively
        BacktrackingBST.Node temp = root;
        // Base Cases: root is null or key is present at root
        while(temp != null && temp.key != k){
            // Key is greater than root's key
            if(temp.key < k){
                temp = temp.right;
            }else {
                // Key is smaller than root's key
                temp = temp.left;
            }
        }

    	return temp; // temporal return command to prevent compilation error
    }

    public void insert(Node node) {
        // TODO: implement your code here
        int [] meta = {0, node.key};
        stack.push(meta);
        BacktrackingBST.Node temp = root;
        BacktrackingBST.Node node_parent = null;
        while(temp != null){
            node_parent = temp;
            if(node.key < temp.key){
                temp = temp.left;
            }else{
                temp = temp.right;
            }
        }
        node.parent = node_parent;
        if (node_parent == null){
            root = node;
        } else if (node.key < node_parent.key) {
            node_parent.left = node;

        }else{
            node_parent.right = node;
        }

        //change is_redo to false

    }

    public void delete(Node node) {
        // TODO: implement your code here
        //change is_redo to false

        int[] meta = {1, node.key};
        stack.push(meta);
        // there are 3 cases to consider
        BacktrackingBST.Node node_parent = node.parent;

        if(node.left == null && node.right == null){ // 0/1 children
            if(node_parent == null ){
                root = null;
            }else{
                if(node_parent.left.key == node.key){
                    node_parent.left = null;
                }else{
                    node_parent.right = null;
                }
            }
            // case2...
        } else if (node.left != null && node.right == null ) {
            if(node_parent == null){
                root = node.left;
            } else if (node_parent.left.key == node.key) {
                node_parent.left = node.left;
            }else{
                node_parent.right = node.left;
            }
            node.left = node_parent;
        } else if (node.right != null && node.left == null) {
            if(node_parent == null){
                root = node.right;
            } else if (node_parent.left.key == node.key) {
                node_parent.left = node.right;

            }else {
                node_parent.right = node.right;
            }

            node.right.parent = node_parent;

        }else { // case 2, there are tow children

            System.out.println(" i'am here!!!");

            Node successor = successor(node);
            delete(successor);
            node.key = successor.key;
        }

    }

    public Node minimum() {
        // TODO: implement your code here
        BacktrackingBST.Node temp = root;

        if(root == null){
            throw new IllegalArgumentException("Tree Is Empty!!");
        }
        while(temp.left != null ){
            temp = temp.left;
        }
    	return temp; // temporal return command to prevent compilation error
    }

    public Node maximum() {
        // TODO: implement your code here
        BacktrackingBST.Node temp = root;
        if(root == null){
            throw new IllegalArgumentException("Tree Is Empty!!");
        }

        while(temp.right != null ){
            temp = temp.right;
        }

    	return temp; // temporal return command to prevent compilation error
    }

    public Node successor(Node node) {
        // TODO: implement your code here
        // validate that parent of root is null//////////
        Node successor = null;
        if(node.right != null){
            BacktrackingBST.Node temp = root;
            root = node.right;
            successor = minimum();

            root = temp;

        }else {
            //test
            System.out.println(successor.key);
            successor = node.parent;
            while(successor != null && node.key == successor.right.key){
                 node = successor;
                successor = successor.parent;
            }

        }

        if(successor == null) throw new IllegalArgumentException("There Is No Successor for this Node");

        return successor; // temporal return command to prevent compilation error
    }

    public Node predecessor(Node node) {
        // TODO: implement your code here
        Node predecessor = null;

        if(node.left != null){
            BacktrackingBST.Node temp = root;
            root = node.left;
            predecessor = maximum();
            root = temp;
        }else {
            predecessor = node.parent;
            while(predecessor != null && node.key == predecessor.left.key){
                node = predecessor;
                predecessor = predecessor.parent;
            }
        }

        if(predecessor == null) throw new IllegalArgumentException("There Is No predecessor for this Node");


    	return predecessor;
    }

    @Override
    public void backtrack() {
        // TODO: implement your code here


    }

    @Override
    public void retrack() {
        // TODO: implement your code here
    }

    public void printPreOrder(){
        // TODO: implement your code here

        //validate what to do when array is empty
        if(root == null ){
            System.out.println(" problem here");
        }else{
            // Create an empty stack and push root to it
            Stack nodeStack = new Stack();
            nodeStack.push(root);

            while(!nodeStack.isEmpty()){
                Node currNode = (Node) nodeStack.pop();
                System.out.print(currNode.key +" ");

                if (currNode.right != null){
                    nodeStack.push(currNode.right);
                }
                if(currNode.left != null){
                    nodeStack.push(currNode.left);
                }

            }

        }


    }

    @Override
    public void print() {
    	printPreOrder();
    }

    public static class Node {
    	// These fields are public for grading purposes. By coding conventions and best practice they should be private.
        public BacktrackingBST.Node left;
        public BacktrackingBST.Node right;
        
        private BacktrackingBST.Node parent;
        private int key;
        private Object value;

        public Node(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }
        
    }

}
