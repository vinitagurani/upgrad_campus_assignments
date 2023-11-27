import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
    //ques1: find a pair with given difference, first method = by binary search, T(n) = O(nlogn)
        //S(n) = 1
        int diff = 10;
        int [] arr1= {90, 70, 20, 80, 50};
        Arrays.sort(arr1);
        for (int i = 0;i<arr1.length-1;i++) {
            int key = arr1[i]+diff;
            int idx = binarySearch(arr1,0, arr1.length-1,key);
            if (idx != -1)
                System.out.println ("pair found by binary search: "+arr1[i]+" "+arr1[idx]);
        }

    //ques2: another method of above question by using 2 pointers, T(n)=O(n) better S(n) = 1
        int [] arr2 = {5, 20, 3, 2, 50, 80};
        insertionSort(arr2);
        findPair(arr2,78);

        //ques3: common elements in three arrays, method 1= by 2 pointer technique T(n) = O(n) to be moew precise O(2n)
        // S(n) = O(n)
        int []arr3 ={1, 5, 10, 20, 40, 80};
        int [] arr4 = {6, 7, 20, 80, 100};
        int []arr5 = {3, 4, 15, 20, 30, 70, 80, 120};
        int [] temp;
        temp = commonElements(arr3, arr4);
        int [] result = new int [Math.min(temp.length,arr5.length)];
        result = commonElements(temp,arr5);
        System.out.println ("The common elements using two pointer technique are "+ Arrays.toString(result));

        //ques4 : method 2 = using three pointer technique T(n) = O(n) better
        commonElements2(arr3,arr4,arr5);

        //ques5: finding ceiling of a given value method 1: linear search
        // T(n)= O(n)
        System.out.println ("The ceiling using linear method: "+ceiling(new int[] {1, 2, 8, 10, 10, 12, 19}, 3));

        //ques6: method 2 = using binary search T(n) = O(logn)
        int [] arr6 = {1, 2, 8, 10, 10, 12, 19};
        if (ceiling2(arr6,0,arr6.length-1,3) == -1)
            System.out.println ("ceiling doesn't exist");
        else
            System.out.println ("The ceiling using binary search is: "+arr6[ceiling2(arr6,0,arr6.length-1,3)]);

        //ques7: finding the pivot element in the rotated array, method 1: linear search T(n) = O(n)
        int [] arr7 = {1, 3, 50, 10, 9, 7, 6};

        System.out.println ("The pivot using linear search is: "+pivot(arr7));

        //ques8: method 2 - binary search T(n) = O(logn)
        int ind = pivot2(arr7, 0,arr7.length-1);
        System.out.println ("The pivot using binary search is: "+arr7[ind]);

        //quest9: largest pair sum: method 1: two nested loops= T(n) = O(n^2)
        int [] arr8 = {12, 34, 10, 6, 40};
        int maxSum = 0;
        for (int i = 0;i<arr8.length-1;i++) {
            for (int j = i+1;j<arr8.length;j++) {
                int sum = (arr8[i]+arr8[j]);
                maxSum = Math.max (maxSum,sum );
            }
        }
        System.out.println ("The largest pair sum using nested loop is "+maxSum);

        //ques10: method 2: T(n) = O(n)
        largestpair(arr8);
         // ques11: fixed point
        int [] arr9 = {-10, -5, 0, 2, 4};
        for (int i = 0;i<arr9.length;i++) {
            if (arr9[i] == i)
                System.out.println ("The fixed point in the array by using linear search is "+arr9[i]);
        }

        //ques12:method 2 using  binary search
        System.out.println ("The fixed point using binary search: "+fixedPoint(arr9, 0,arr9.length-1));
        //ques13: print k closest elements to a given value
        closest ((new int [] {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56}), 35,4); // using linear and binar methods 
    } // end of main function.
      public static int crossOverLinear (int [] arr, int x) {
        int crossover = 0;
        if (x<= arr[0])
            crossover=0;
        else if (x>= arr[arr.length-1])
            crossover = arr.length-1;
        else {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] <= x && arr[i + 1] > x)
                    crossover = i;
            }
        }
        return crossover;
    }
    public static int crossoverBinary (int []arr, int start, int end, int x)
    {
        int crossover;
        if (x<= arr[start])
            crossover= start;
        else if (x> arr[end])
            crossover = end;
        else {
            int mid = start+ (end-start)/2;
            if (x>=arr[mid] && arr[mid+1]>x) {
                crossover = mid;
            }
            else if (arr[mid]<x)
                crossover =crossoverBinary(arr,mid+1,end,x);
            else
                crossover = crossoverBinary(arr,start,mid-1,x);
        }
        return crossover;
    }
    public static void closest (int [] arr, int x, int k) {
        //int l = crossOverLinear(arr,x);
        int l = crossoverBinary(arr,0,arr.length-1,x);
        int r = l+1;
        int count = 0;
        if (arr[l] == x)
            l--;
        while (l>=0 && r<arr.length && count <k){
            if (x-arr[l] < arr[r]-x) {
                System.out.print (arr[l--] +" ");
                count ++;
            }
            else {
                System.out.print(arr[r++] + " ");
                count++;
            }
        }
        while (l>=0 && count <k)
        {
            System.out.print(arr[l--] +" ");
            count ++;
        }
        while (r<arr.length && count<k) {
            System.out.print (arr[r++]+" ");
            count ++;
        }
    }
      public static int fixedPoint(int [] arr, int start, int end) {
        if (start<=end) {
            int mid = start + (end-start)/2;
            if (mid == arr[mid])
                return mid;
            int res;
            res = fixedPoint(arr, mid+1,end);
            if (res != -1)
                return res;
           return fixedPoint(arr,start,mid-1);
           // if (res != -1)

        }
        return -1;
    }
    public static void largestpair (int [] arr) {
        int j = 0;
        int maxSum = 0;
        for (int i = 1;i<arr.length;i++) {
            int sum = arr[i]+arr[j];
            maxSum =Math.max (maxSum,sum);
            if (arr[j]<arr[i])
                j= i;
        }
        System.out.println ("The largest pair sum using 1st and 2nd largest elements is "+maxSum);
    }
    public static int pivot2 (int []arr, int start, int end) {
        if(start == end )
            return start;
        if (end == start+1 && arr[end] >= arr[start])
            return end;
        if (end == start+1 && arr[start] >= arr[end])
            return start;

        int mid = start+(end-start)/2;

        if (arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])
            return mid;
        else if (arr[mid] >arr[mid-1] && arr[mid] <arr[mid+1])
            return pivot2 (arr,mid+1,end);
        else
            return pivot2 (arr,start,mid-1);
    }
    public static int pivot (int [] arr) {
        int max = arr[0];
        for (int i = 1;i<arr.length;i++ ) {
            if (max<arr[i])
                max = arr[i];
        }
        return max;
    }
    public static int ceiling2 (int [] arr, int start, int end, int x) {
        if (x <= arr[start])
            return start;
        if (x>arr[end])
            return -1;
        int mid = start +(end-start)/2;

        if (arr[mid]==x)
            return  mid;
        else if (arr[mid]<x)
        {
            if (mid+1 <=end && arr[mid+1] >=x)
                return mid+1;
            else
                return ceiling2(arr,mid+1,end,x);
        }
        else
        {
            if (arr[mid-1]<x && mid-1>= start)
                return mid;
            else
                return ceiling2(arr,start,mid-1,x);
        }

    }
    public static int ceiling (int [] arr, int x) {
        if (x <= arr[0])
            return arr[0];
        for (int i = 0;i<arr.length;i++) {
            if (arr[i]<x && arr[i+1]>=x)
                return arr[i+1];
        }
        return -1;

    }
    public static void commonElements2 (int [] arr1, int[]arr2, int[]arr3) {
        int i = 0, j=0,k=0;
        System.out.print ("The common elements by using 3 pointer techniques are : ");
        while (i<arr1.length &&j<arr2.length&& k<arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                System.out.print (arr1[i] +" ");
                i++;
                j++;
                k++;
            }
            else if (arr1[i]<arr2[j])
                i++;
            else if (arr2[j] <arr3[k])
                j++;
            else
                k++;
        }
        System.out.println ();
    }
    public static int [] commonElements (int [] arr1, int [] arr2) {
        int i = 0;
        int j = 0;
        int k = 0;
        int [] temp = new int [Math.min(arr1.length,arr2.length)];
       // int [] temp = new int [100];
        while (i<arr1.length && j<arr2.length) {
            if(arr1[i] == arr2[j]) {
                temp[k] = arr1[i];
                i++;
                j++;
                k++;
            }
            else if (arr1[i]<arr2[j])
                i++;
            else
                j++;
        }
        return temp;
    }
    public static void findPair (int [] arr, int diff) // sorted array to be given
    {
        int l= 0;
        int r = 1;
        int diffTemp;
        while (l<r) {
            diffTemp = arr[r]-arr[l];
            if (diff == diffTemp) {
                System.out.println ("Pair found by two pointer technique: "+arr[l]+" "+arr[r]);
                return;
            }
            else if (diffTemp<diff)
               r++;
            else
               l++;
        }
    }
    public static void swapping (int [] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void bubbleSort (int [] arr) { // T(n) = O(n^2)
        for (int i = 0;i<arr.length;i++) {
            for (int j = 0;j<arr.length-1;j++) {
                if (arr[j]>arr[j+1])
                    swapping(arr,j,j+1);
            }
        }
    }
    public static void selectionSort (int [] arr) {
        for (int i = 0;i<arr.length;i++) {
            int min = i;
            for (int j = i;j<arr.length;j++) {
                if (arr[min]>arr[j])
                    min = j;
            }
            swapping (arr, min,i);
        }
    }
    public static void insertionSort (int [] arr) {
        for (int i = 1;i<arr.length; i++) {
            int j = i;
            while (j>0 && arr[j]<arr[j-1]) {
                swapping (arr, j,j-1);
                j--;
            }
        }
    }

    public static int binarySearch (int [] arr, int start, int end, int key) {
        while (start<end) {
            int mid = start+(end-start)/2;
            if (arr[mid] == key)
                return mid;
            else if (key>arr[mid])
                start= mid+1;
            else
                end = mid-1;

        }
        return -1;
    }
}
