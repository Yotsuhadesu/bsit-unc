package MergeSort;

public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {
        // base case
        if (left >= right) return;
        // find mid
        int mid = (left + right) / 2;
        // recursive calls
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        // merge
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        // calculate lengths
        int n1 = mid - left + 1;
        int n2 = right - mid;
        // create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];
        // fill temp arrays
        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];
        // merge back into arr
        int i = 0;
        int j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        // copy remaining elements
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        // call mergeSort
        mergeSort(arr, 0, arr.length - 1);
        // print result
        for (int n : arr)
            System.out.print(n + " ");
    }
}