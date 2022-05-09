

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
        // for backtracking operation
        stack.push(node);
        stack.push(0);
        is_redo = false;
        
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



    }

    public void delete(Node node) {
        // TODO: implement your code here
        //change is_redo to false
        is_redo = false;
        stack.push(node);

        // there are 3 cases to consider
        BacktrackingBST.Node node_parent = node.parent;
        // case 1
        if(node.left == null && node.right == null){ // 0 children

            stack.push(1);
            if(node_parent == null ){
                root = null;
            }else{
                if(node_parent.left.key == node.key){
                    node_parent.left = null;
                }else{
                    node_parent.right = null;
                }
            }

            // case2 left child
        } else if (node.left != null && node.right == null ) {

            stack.push(2);
            
            if(node_parent == null){
                root = node.left;
            } else if (node_parent.left.key == node.key) {
                node_parent.left = node.left;
            }else{
                node_parent.right = node.left;
            }
            //set parent to node complete this pleas...........
            node.left.parent = node_parent;

            // case2 right child
        } else if (node.right != null && node.left == null) {

            stack.push(2);
            
            if(node_parent == null){
                root = node.right;
            } else if (node_parent.left.key == node.key) {
                node_parent.left = node.right;

            }else {
                node_parent.right = node.right;
            }

            node.right.parent = node_parent;
              // case 4, there are two children
        }else {
            Node successor = successor(node);
            stack.push(successor);
            stack.push(node.key);
            stack.push(3);

            delete(successor);
            stack.pop();
            stack.pop();
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
            successor = node.parent;
            System.out.println(successor.getKey());
            while(successor != null && node == successor.right){
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
            while(predecessor != null && node == predecessor.left){
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
        // check if stack is empty
        is_redo = true;
        int backtrackType = (int) stack.pop();
        if(backtrackType == 0){
            Node node = (Node) stack.pop();
            // for retrack operation
            redoStack.push(node);
            redoStack.push(0);
            Node parentNode = node.parent;
            if(parentNode == null){
                root = null;
            }else if(parentNode.key > node.key){
                parentNode.left = null;
            }else parentNode.right = null;

        } else if (backtrackType == 1 || backtrackType == 2) {
            Node node = stack.pop();

            if(node.right.parent != null)  node.right.parent = node;
            if( node.left.parent != null)   node.left.parent = node;

            redoStack.push(node);
            redoStack.push(1);
            Node parentNode = node.parent;
            if(parentNode == null){
                root = node;
            } else if (parentNode.key > node.key) {
                parentNode.left = node;
            }else parentNode.right = node;

            // case 3 of backtracking
        }else{
            int nodeKey = (int) stack.pop();
            Node successor = (Node) stack.pop();
            Node node = (Node) stack.pop();
            node.key  = nodeKey;

            redoStack.push(node);
            redoStack.push(1);

            if(successor.parent == null){
                // check parent
                root = node;
            } else if (successor.parent.key > successor.key) {
                if (successor.parent.left != null) {
                    successor.parent.left.parent = successor;
                    successor.parent.left = successor;
                } else {
                    successor.parent.left = successor;
                }
            }else {
                if (successor.parent.right != null) {
                    successor.parent.right.parent = successor;
                    successor.parent.right = successor;
                } else {
                    successor.parent.right = successor;
                }
            }

        }

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
