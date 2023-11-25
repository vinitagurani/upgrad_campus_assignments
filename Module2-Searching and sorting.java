import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //ques1: find a pair in array with a given sum
        pairSum((new int [] {0, -1, 2, -3, 1}), 2);

        //ques2: max profit in stocks
        int [] arr = {7, 1, 5, 3, 6, 4};
        System.out.println ("Max profit in stocks: "+stocks(arr));

        //ques3: maximum product of sub-array
        System.out.println ("The max product of the sub-array is: "+maximumProduct(arr));

        //ques4: maximum continuous sum
        System.out.println ("The maximum sum of sub array: "+maxSum(arr));

        //ques5: find the minimum in rotated sorted array
        int [] arr2 = { 0, -1, 2, -3, 1};
        System.out.println ("The minimum element in the rotated sorted array is: "+minimumRotated(arr2));

        //ques6: search for a element in the sorted rotated array
        System.out.println ("element found at: "+findInRotated(arr2,3));

        //ques7: triplet
        triplet(arr2,0);
        
        //ques8: merge two halves of an array
        int[] arr4 = { 1,2,3,5};
        sort (arr4,0,arr4.length-1);
        System.out.println(Arrays.toString(arr4));

        //ques9: find the missing number
        missingNum(arr4);

        //ques10: find the first repeating element
        int [] arr5 = {1, 8, 2, 2, 2, 3, 4, 7, 8};
        System.out.println ("The first repeating element is "+firstReap(arr5));
    }
    public static int firstReap(int [] arr) {
        int [] temp = new int [arr.length];
        for (int i =0; i<temp.length;i++) {
            temp[i] = arr[i];
        }
        //sorting the temp array by selection sort
        for (int i = 0; i< temp.length-1;i++) {
            int min = i;
            for (int j= i+1;j<temp.length;j++) {
                if (temp[j]<temp[min])
                    min = j;
            }
            swapping (min,i,temp);
        }
        System.out.println (Arrays.toString(temp));
        for (int i = 0;i<arr.length;i++) {
            if (countOccurences(temp,0,arr.length-1,arr[i])>1)
                return arr[i];
        }
        return -10;
    }
    public static int countOccurences (int [] arr, int start, int end, int key) {
        int index = binarySearch(arr,start,end,key);
        if (index == -1)
            return 0;
        int count = 1;
        int left = index-1;
        int rigth= index+1;
        while (left>=0 && arr[left] == key)
        {
            count++;
            left--;
        }
        while (rigth<arr.length && arr[rigth]==key) {
            count++;
            rigth++;
        }
        return count;

    }
    public static void missingNum (int [] arr) {
        int []temp = new int [arr.length+1];
        for (int i = 0;i<temp.length;i++) {
            temp[i] =0;
        }
        for (int i = 0;i<arr.length; i++) {
            temp [arr[i]-1] =1;
        }
        for (int i=0;i<temp.length;i++) {
            if (temp[i] == 0)
                System.out.println (i+1);
        }
    }

    public static void sort (int [] arr, int start,int end) {
        if (start<end) {
           int m = start+(end-start)/2;
            sort (arr, start, m);
            sort (arr, m+1,end);
            merge (arr, start,m,end);
        }
    }
    public static void merge (int [] arr, int start, int m, int end) {
        int [] L = new int [m-start+1];
        int [] R = new int [end-m];
        for (int i = 0;i<L.length;i++) {
            L[i] =arr[start+i];
        }
        for (int i = 0;i<R.length;i++) {
            R[i] = arr[m+1+i];
        }
        int i = 0, j=0, k =0;
        while (i<L.length && j<R.length) {
            if (L[i]<R[j]) {
                arr[k] = L[i];
                i++;
                k++;
            }
            else if (L[i]>R[j]) {
                arr[k] = R[j];
                j++;
                k++;
            }
        }
        while (i<L.length) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j<R.length) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
   
    public static void triplet (int []arr, int sum) {
        // sorting using insertion sort
        for (int i = 1;i<arr.length;i++) {
            int j = i;
            while (j>0 && arr[j]<arr[j-1]) {
                swapping (j,j-1,arr);
                j--;
            }
        }
        for (int i = 0; i<arr.length; i++) {
            int l= i+1;
            int r = arr.length-1;
            while (l<r) {
                if (arr[l]+arr[i]+arr[r]== sum) {
                    System.out.println("The triplet is " + arr[i] + " "+arr[l] + " " + arr[r]);
                    return;
                }
                else if (arr[l]+arr[i]+arr[r]<sum)
                    l++;
                else
                    r--;
            }
        }
    }
    public static int findInRotated(int [] array, int key) {
        int p = pivot (array,0,array.length-1);
        if (p == -1)
            return binarySearch(array,0,array.length-1,key);
        if (array[p] == key)
            return p;
        if (key<array[0])
            return binarySearch(array,p+1,array.length-1,key);
        return binarySearch(array,0,p-1,key);
    }
    public static int binarySearch (int [] array, int start, int end, int key) {
        if (start > end ) {
            return -1;
        }
            int mid = start + (end - start) / 2;
            if (array[mid] == key)
                return mid;
            else if (key <array[mid])
               return binarySearch(array, start, mid-1,key);
            else
                return binarySearch(array,mid+1,end,key);
    }
    public static int minimumRotated (int [] arr) {
        int p = pivot (arr,0,arr.length-1);
        return arr[p+1];
    }
    public static int pivot (int []arr, int start, int end) {
        if (start>end)
            return -1;
        if (start == end)
            return start;
        int mid = start+(end-start)/2;
        if (arr[mid] <arr[mid-1])
            return mid-1;
        if (arr[mid]>arr[mid+1])
            return mid;
        if (arr[start] <arr[mid])
            return pivot(arr,mid+1, end);
        return pivot (arr, start, mid-1);
    }
    public static int maxSum (int [] arr) {
        int maxReal = Integer.MIN_VALUE;
        int max = 0;
        for (int i = 0;i<arr.length;i++) {
            max += arr[0];
            maxReal = Math.max (maxReal,max);
            if (max < 0)
                max =0;
        }
        return maxReal;
    }
    public static int maximumProduct (int [] arr) {
        int max = arr[0];
        int min = arr[0];
        int maxReal = arr[0];
        for (int i = 1;i<arr.length;i++) {
            int temp = Math.max (arr[i], Math.max(arr[i]*max, arr[i]*min));
            min = Math.min (arr[i], Math.min(arr[i]*max, arr[i]*min));
            max = temp;
            maxReal = Math.max (arr[i], max);
        }
        return maxReal;
    }
    public static int stocks (int [] arr) {
        int buy = arr[0];
        int maxProfit = 0;
        for (int i = 1;i<arr.length;i++) {
            if (arr[i]<buy)
                buy = arr[i];
            else if (arr[i]-buy>maxProfit) {
                maxProfit = arr[i]-buy;
            }
        }
        return maxProfit;
    }
    public static void swapping (int a , int b, int [] arr ) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] =temp;
    }
    public static void pairSum (int [] arr, int sum) {
        //sorting the array with selection sort method
        for (int i = 0;i<arr.length;i++) {
            int min = i;
            for (int j = i+1; j<arr.length;j++) {
                if (arr[j]<arr[min])
                    min = j;
            }
            swapping (min,i,arr);
        }
        int i = 0; int j = arr.length-1;
        while (i<j) {
            if (arr[i]+arr[j]== sum)
            {
                System.out.println ("Pair found:" +arr[i]+" "+arr[j]);
                return;
            }
            else if (arr[i]+arr[j] <sum)
                i++;
            else
                j--;
        }
    }
}
