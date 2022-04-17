public class Test {
    public static void main(String[] args) {
        int[] a = {17,62,19,10,1,78,20,20,20,10};
        int[] b = {1};
        int x = 4;
        int forward = 3;
        int back = 2;
        Warmup test = new Warmup();
        Stack test2 = new Stack();

        int res = test.backtrackingSearch(b,x,forward,back,test2);

        System.out.print(res);
    }

}
