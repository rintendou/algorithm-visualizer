package src.java.algorithms;

import src.java.new_gui.MainGUI;
import src.java.new_gui.Visualizer;

/* 
This algorithm incorporated with the animation was very difficult to do using the traditional way so I had to use an in-place algorithm from online to help me. Still the same time complexity, but less space complexity.
Credits: https://www.geeksforgeeks.org/in-place-merge-sort/
https://stackoverflow.com/questions/2571049/how-to-sort-in-place-using-the-merge-sort-algorithm
https://www.interviewkickstart.com/learn/in-place-merge-sort
*/
public class MergeSort implements Runnable {
    private Integer[] toBeSorted;
    private MainGUI f;

    public MergeSort(Integer[] toBeSorted, MainGUI f) {
        this.toBeSorted = toBeSorted;
        this.f = f;
    }

    public void sort(Integer[] toBeSorted) {
        sort(toBeSorted, 0, toBeSorted.length - 1);
    }

    public void sort(Integer[] toBeSorted, int first, int last) {
        int mid, left, right;
        int temp;

        if (last <= first) return;

        mid = (first + last) / 2;

        // Splitting selected array into subarrays.
        sort(toBeSorted, first, mid); 
        sort(toBeSorted, mid + 1, last);

        left = first; // Setting pointer divider
        right = mid + 1; // Setting pointer divider

        if (toBeSorted[mid] <= toBeSorted[right]) return; // Skip merge when applicable

        while (left <= mid && right <= last) {
            if (toBeSorted[left] <= toBeSorted[right]) left++; // Start from left, increment point w/ no change.
            else { // Start from right, rotate left ... right value pointers and correct them.
                temp = toBeSorted[right]; // Preparing to swap with left.
                for (int i = right - left; i > 0; i--) toBeSorted[left + i] = toBeSorted[left + i -1];
                toBeSorted[left] = temp; // Actual swap
                /* Incrementing all pointers up, this causes the actual shift of all elements in the animation. */
                left++;
                mid++;
                right++;
            }
            f.redraw(toBeSorted, mid, right, left);
            try {
                Thread.sleep(Visualizer.delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Whatever parts remain are in place and will merge with no problems.
        }
	}

    
    @Override
    public void run() {
        sort(toBeSorted);
        System.out.println("Sorted via Merge Sort");
        Visualizer.sorting = false;
    }
}

