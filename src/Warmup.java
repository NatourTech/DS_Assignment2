

public class Warmup {
    public static int backtrackingSearch(int[] arr, int x, int forward, int back, Stack myStack) {
        // TODO: implement your code here

        int i = 0;
        int forward_ = forward;
        int back_ = back;
        while(i < arr.length){
            if(arr[i] == x){

                // g vc testtttt
                int q = 3;

                /// end the test
                return i;
            }


            if(forward_ == 0) {

                for(int j = 1; j  <= back; j++ ){
                    i = i - 1;
                    myStack.pop();
                }

                forward_ = forward;
            }

            myStack.push(arr[i]);
            forward_ = forward_ - 1;
            i = i + 1;


        }


    	return -1; // temporal return command to prevent compilation error
    }

    public static int consistentBinSearch(int[] arr, int x, Stack myStack) {
        // TODO: implement your code here
    	
    	// Your implementation should contain a this line:
    	int inconsistencies = Consistency.isConsistent(arr);
    	
    	return -987; // temporal return command to prevent compilation error
    }
    
}

