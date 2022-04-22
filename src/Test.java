import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] a = {1, 2, 4};
        int[] b = {};
        int x = 4;
        int forward = 3;
        int back = 2;
        Stack stack = new Stack();


//        BacktrackingArray unsarray = new BacktrackingArray(stack, 12);
//        unsarray.insert(new Integer(1));
//        unsarray.insert(new Integer(7));
//        unsarray.insert(new Integer(3));
//        unsarray.insert(new Integer(-2));
//        unsarray.insert(new Integer(-4));
//        unsarray.insert(new Integer(-11));
//        unsarray.insert(new Integer(-1));
//        unsarray.insert(new Integer(2));
//        unsarray.insert(new Integer(5));
//        System.out.println(Arrays.toString(unsarray.arr));
//
//
//        System.out.println(unsarray.successor(0));
//        System.out.println(unsarray.predecessor(0));
//        unsarray.print();


        Stack stack2 = new Stack();
        // sorted array obj
        BacktrackingSortedArray soArray = new BacktrackingSortedArray(stack2, 10);
        soArray.print();
        soArray.insert(6);
        soArray.insert(7);
        soArray.insert(2);
        soArray.insert(3);
        soArray.insert(-4);
        soArray.insert(-1);
        soArray.insert(-19);
//        soArray.print();
//        System.out.println("");
//        System.out.println(soArray.maximum());
//        System.out.println(soArray.minimum());
        soArray.print();
        soArray.backtrack();
        soArray.backtrack();
        soArray.backtrack();
        soArray.print();
        soArray.delete(2);
        soArray.print();
        soArray.backtrack();
        soArray.print();




    }

}
