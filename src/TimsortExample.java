// Example Java code for Timsort 
public class TimsortExample {
    public static int[] timsort(int[] arr) {
        int n = arr.length;

        // Divide the array into two halves 
        int mid = n / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[n - mid];

        // Copy the elements of the array into the two halves 
        for (int i = 0; i < mid; i++)
            leftArr[i] = arr[i];
        for (int i = mid; i < n; i++)
            rightArr[i - mid] = arr[i];

        // Recursively sort the halves 
        leftArr = timsort(leftArr);
        rightArr = timsort(rightArr);

        // Merge the sorted halves 
        return merge(leftArr, rightArr);
    }

    // Helper function to merge the two halves 
    public static int[] merge(int[] leftArr, int[] rightArr) {
        int i = 0, j = 0, k = 0;
        int[] arr = new int[leftArr.length + rightArr.length];

        // Copy the smallest element from either of the two halves 
        // into the result array 
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j])
                arr[k++] = leftArr[i++];
            else
                arr[k++] = rightArr[j++];
        }

        // Copy the remaining elements of leftArr[] 
        while (i < leftArr.length)
            arr[k++] = leftArr[i++];

        // Copy the remaining elements of rightArr[] 
        while (j < rightArr.length)
            arr[k++] = rightArr[j++];

        return arr;
    }
}