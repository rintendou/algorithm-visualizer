public class Sort {
    private int[] arr;

    public Sort(int[] arr) {
        this.arr = arr;
    }
    
    public void beginSelectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {  
            int minNum = i;  
            for (int j = i + 1; j < arr.length; j++) {  
                if (arr[j] < arr[minNum]) {  
                    minNum = j;  
                }  
            }  
            int temp = arr[minNum]; // Swapping.
            arr[minNum] = arr[i];  
            arr[i] = temp;  
        }  
    }
}

