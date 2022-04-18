public class Test {
    public static void main(String[] args) {
        int[] a = {1,2,4};
        int[] b = {};
        int x = 4;
        int forward = 3;
        int back = 2;
        Warmup test = new Warmup();
        Stack test2 = new Stack();

        int res = test.backtrackingSearch(a,x,forward,back,test2);

        int res_2 = test.consistentBinSearch(a,4,test2);

        System.out.print(res_2);
    }

}
