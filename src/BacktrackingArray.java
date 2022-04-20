

public class BacktrackingArray implements Array<Integer>, Backtrack {
    public Stack stack;
    public int Volume = 0;
    public int[] arr;
    // TODO: implement your code here

    // Do not change the constructor's signature
    public BacktrackingArray(Stack stack, int size) {
        this.stack = stack;
        arr = new int[size];
    }

    @Override
    public Integer get(int index) {
        // TODO: implement your code here
        // validate if index is legal??
        int res = this.arr[index];
        return res;
    }

    @Override
    public Integer search(int k) {
        // TODO: implement your code here
        for(int i = 0; i < Volume; i++ ){
            if(arr[i] == k) return i;
        }

        return -1; // temporal return command to prevent compilation error
    }

    @Override
    public void insert(Integer x) {
        // TODO: implement your code here

        if (this.Volume == this.arr.length) {
            throw new RuntimeException("The Array is full!!");
        }

        int[] meta = {0, this.Volume, x.intValue()};

        this.stack.push(meta);
        this.arr[this.Volume] = x.intValue();

        this.Volume = this.Volume + 1;

    }

    @Override
    public void delete(Integer index) {
        // TODO: implement your code here
        // delete with theta(n)

        // validate when arr is empty??

        int[] meta = {1, index.intValue(), this.arr[index.intValue()]};
        this.stack.push(meta);

        for(int i = index.intValue(); i < this.arr.length - 1; i++ ){
            this.arr[i] = this.arr[i + 1];

        }

        this.Volume = this.Volume - 1;

    }

    @Override
    public Integer minimum() {
        // TODO: implement your code here

        if(Volume == 0){
            throw new RuntimeException("Array Is Empt!");
        }
        int min_value = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[min_value] > arr[i]){
                min_value = i;
            }
        }
        return min_value; // temporal return command to prevent compilation error
    }

    @Override
    public Integer maximum() {
        // TODO: implement your code here

        if(Volume == 0){
            throw new IllegalArgumentException("Array Is Empty");
        }
        int max_value = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[max_value] < arr[i]){
                max_value = i;
            }
        }
        return max_value; // temporal return command to prevent compilation error
    }

    // help finction
    private int abs_value(int val){
        if ( val < 0) return -val;
        return val;
    }
    @Override
    public Integer successor(Integer index) {
        // TODO: implement your code here
        //validate if array length is 1 or 0 ??

        if(index >= Volume){
            throw new RuntimeException("The Index Is Illegal!!");
        }

        int minDiff = Integer.MAX_VALUE;
        int suc = 0;

        for(int i = 0; i < Volume; i++){
            if(arr[i] > arr[index]  && abs_value(arr[i] - arr[index]) < minDiff){
                minDiff = abs_value(arr[i] - arr[index]);

                suc = i;
            }
        }

        return suc; // temporal return command to prevent compilation error
    }

    @Override
    public Integer predecessor(Integer index) {
        // TODO: implement your code here
        if(index >= Volume){
            throw new RuntimeException("The Index Is Illegal!!");
        }

        int minDiff = Integer.MAX_VALUE;
        int suc = 0;

        for(int i = 0; i < Volume; i++){
            if(arr[i] < arr[index]  && abs_value(arr[i] - arr[index]) < minDiff){
                minDiff = abs_value(arr[i] - arr[index]);

                suc = i;
            }
        }

        return suc; // temporal return command to prevent compilation error
    }

    @Override
    public void backtrack() {
        // TODO: implement your code here
        // validate when stack is empty??

        int [] stackPop = (int[]) this.stack.pop();
        if(stackPop[0] == 0){
            this.Volume = this.Volume - 1;
        } else if (stackPop[0] == 1) {
            for(int i = this.Volume ; i > stackPop[1]; i--){
                this.arr[i] = this.arr[i - 1];
            }

            this.arr[stackPop[1]] = stackPop[2];
            this.Volume = this.Volume + 1;
        }
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
        for(int i = 0; i < Volume; i++) {
            System.out.print(arr[i]+" ");
        }
    }

}
