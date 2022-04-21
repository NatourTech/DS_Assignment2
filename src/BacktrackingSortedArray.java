

public class BacktrackingSortedArray implements Array<Integer>, Backtrack {
    private Stack stack;
    public int[] arr; // This field is public for grading purposes. By coding conventions and best practice it should be private.
    // TODO: implement your code here

    private int volume = 0;

    // Do not change the constructor's signature
    public BacktrackingSortedArray(Stack stack, int size) {
        this.stack = stack;
        arr = new int[size];
    }
    
    @Override
    public Integer get(int index){
        // TODO: implement your code here

        // TODO:validate if index is legal??
        int res = arr[index];
    	return res; // temporal return command to prevent compilation error
    }

    @Override
    public Integer search(int k) {
        // TODO: implement your code here
        int low = 0, high = volume - 1;

        while(low <= high){

            int middle = (low + high) / 2;

            if(arr[middle] == k){
                return middle;
            }else if ( k < arr[middle]){
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

    	return -1; // temporal return command to prevent compilation error
    }

    @Override
    public void insert(Integer x) {
        // TODO: implement your code here
        if(volume >= arr.length){
            throw new RuntimeException("The Array is full!!");
        }

        int i = volume;
        while( i > 0 && arr[i - 1]  > x){
            arr[i] = arr[i - 1];
            i = i - 1;
        }

        int[] meta = {0,i,x};
        arr[i] = x;
        stack.push(meta);
        volume = volume + 1;

    }

    @Override
    public void delete(Integer index) {
        // TODO: implement your code here
        if(volume == 0 || index > volume - 1 || index < 0){
            throw new RuntimeException("index not valid, or array is empty pleas check!!");
        }
        int[] meta = {1,index, arr[index]};
        for(int i = index; i < volume; i ++ ){
            arr[i] = arr[i+1];
        }
        stack.push(meta);
        volume = volume - 1;
    }

    @Override
    public Integer minimum() {
        // TODO: implement your code here

        if(volume == 0){
            throw new RuntimeException("Array Is Empt!");
        }
    	return arr[0];
    }

    @Override
    public Integer maximum() {
        if(volume == 0){
            throw new RuntimeException("Array Is Empt!");
        }
        return arr[volume - 1];
    }

    @Override
    public Integer successor(Integer index) {
        // TODO: implement your code here
    	return null; // temporal return command to prevent compilation error
    }

    @Override
    public Integer predecessor(Integer index) {
        // TODO: implement your code here
    	return null; // temporal return command to prevent compilation error
    }

    @Override
    public void backtrack() {
        // TODO: implement your code here
    }

    @Override
    public void retrack() {
		/////////////////////////////////////
		// Do not implement anything here! //
		/////////////////////////////////////
    }

    @Override
    public void print() {
        // TODO: implement your code here

        for(int i = 0; i < volume; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    
}
