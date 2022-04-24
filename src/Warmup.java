
public class Warmup {
    public static int backtrackingSearch(int[] arr, int x, int forward, int back, Stack myStack) {
        // TODO: implement your code here

        int i = 0;
        int forward_ = forward;
        int back_ = back;
        while (i < arr.length) {

            if (arr[i] == x) {
                myStack.push(arr[i]);
                return i;
            }

            if (forward_ == 0) {

                for (int j = 0; j < back; j++) {
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

        int low = 0, high = arr.length - 1;

        while (low <= high) {
            // Your implementation should contain a this line:
            int inconsistencies = Consistency.isConsistent(arr);
            int middle = (low + high) / 2;

            myStack.push(arr[middle]);

            if (inconsistencies != 0 && !myStack.isEmpty()) {
                for (int i = 0; i < inconsistencies; i++) {
                    myStack.pop();
                    middle = middle - 1;
                }
            }

            if (arr[middle] == x) {
                return middle;
            } else if (x < arr[middle]) {
                high = middle - 1;
            } else low = middle + 1;


        }

        return -1; // temporal return command to prevent compilation error
    }

}

