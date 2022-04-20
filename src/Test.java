import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] a = {1, 2, 4};
        int[] b = {};
        int x = 4;
        int forward = 3;
        int back = 2;
        Stack stack = new Stack();

        BacktrackingArray unsarray = new BacktrackingArray(stack, 5);
        unsarray.insert(new Integer(1));
        unsarray.insert(new Integer(2));
        unsarray.insert(new Integer(7));
        unsarray.insert(new Integer(3));
        System.out.println(Arrays.toString(unsarray.arr));

        unsarray.delete(new Integer(1));
        System.out.println(Arrays.toString(unsarray.arr) + "first  delete");
        unsarray.delete(new Integer(2));
        System.out.println(Arrays.toString(unsarray.arr)  + "second  delete");

        unsarray.backtrack();
        System.out.println(Arrays.toString(unsarray.arr) + "first  backtrack");
        unsarray.backtrack();


        System.out.println(Arrays.toString(unsarray.arr) + "second  backtrack");
        System.out.println(unsarray.Volume);
        System.out.println(unsarray.search(3));




    }

}
