import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Stack redoStack = new Stack();
        BacktrackingBST tree = new BacktrackingBST(stack, redoStack);

        BacktrackingBST.Node node1 = new BacktrackingBST.Node(12,null);
        BacktrackingBST.Node node2 = new BacktrackingBST.Node(6,null);
        BacktrackingBST.Node node3 = new BacktrackingBST.Node(1,null);
        BacktrackingBST.Node node4 = new BacktrackingBST.Node(29,null);
        BacktrackingBST.Node node5 = new BacktrackingBST.Node(17,null);
        BacktrackingBST.Node node6 = new BacktrackingBST.Node(33,null);
        BacktrackingBST.Node node7 = new BacktrackingBST.Node(30,null);
        BacktrackingBST.Node node8 = new BacktrackingBST.Node(46,null);

        tree.insert(node1);
        tree.insert(node2);
        tree.insert(node3);
        tree.insert(node4);
        tree.insert(node5);
        tree.insert(node6);
        tree.insert(node7);
        tree.insert(node8);
        tree.print();
        System.out.println("|");

//        System.out.println(tree.search(120) + " | null");
//        System.out.println(tree.search(12).getKey());

        //Successor of node1(12)
        System.out.println(tree.minimum().getKey());
        System.out.println(tree.successor(node3).getKey() + "  successor");
//        System.out.println(tree.predecessor(node6).getKey() + "    predecessor");
        tree.delete(node1);

        tree.print();
        System.out.println("|");


    }

}
