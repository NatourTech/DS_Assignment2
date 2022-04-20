import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] a = {1, 2, 4};
        int[] b = {};
        int x = 4;
        int forward = 3;
        int back = 2;
        Stack stack = new Stack();

        BacktrackingArray unsarray = new BacktrackingArray(stack, 12);
        unsarray.insert(new Integer(1));
        unsarray.insert(new Integer(7));
        unsarray.insert(new Integer(3));
        unsarray.insert(new Integer(-2));
        unsarray.insert(new Integer(-4));
        unsarray.insert(new Integer(-11));
        unsarray.insert(new Integer(-1));
        unsarray.insert(new Integer(2));
        unsarray.insert(new Integer(5));
        System.out.println(Arrays.toString(unsarray.arr));


        System.out.println(unsarray.successor(0));
        System.out.println(unsarray.predecessor(0));
        unsarray.print();





    }

}
