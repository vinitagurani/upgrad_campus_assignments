import java.util.*;
class SortByValue implements Comparator <Map.Entry<Integer,Integer>> {

    @Override
    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        if (o1.getValue() == o2.getValue())
            return o1.getKey()-o2.getKey();
        return o2.getValue()-o1.getValue();
    }
}
class Node {
    int data;
    Node next;
    Node (int data) {
        this.data = data;
    }
}
class LinkedList {
    Node head;
    void push (int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
}
public class Main {
   
    public static  void main(String[] args) {
        System.out.println ("Minimum indexed Character: "+minimumIndexedChar("geeksforgeeks", "set"));
        //-----------max Difference--------------------------------------------
        System.out.println ("maximum difference: "+maxDiff(new int [] {4, 2, -3, 3, -2, -2, 8}));
        //-----------largest increasing subsequence-----------------------------
        System.out.println("longest increasing subsequence: "+longestIncreasingSub(new int [] {6, 7, 8, 3, 4, 5, 9, 10}));
        //-----------longestSubarray with sum divisible by k---------------------
        int array10[] = { 2, 7, 6, 1, 4, 5 };
        System.out.println("Length of subarray whose sum is divisible by k = " + longestSubarrWthSumDivByK(array10, 6, 3));
        //-----------number of employee under mngr
        Map<String, String> dataSet = new HashMap<String, String>();
        dataSet.put("A", "C");
        dataSet.put("B", "C");
        dataSet.put("C", "F");
        dataSet.put("D", "E");
        dataSet.put("E", "F");
        dataSet.put("F", "F");
        mngrEmp(dataSet);

        //-----------print kth distinct element--------------
        System.out.println ("distinct element "+distinctElement(new int [] {1, 2, 1, 3, 4, 2}, 2));
        //-----------group words with same set of characters
        String words[] = { "may", "student", "students", "dog", "studentssess", "god", "cat", "act", "tab", "bat", "flow", "wolf", "lambs", "amy",
                "yam", "balms", "looped", "poodle"};
        printPairs(words);
        //-----------sorting elements by frequency---------------------------------------------------------
        Vector<Integer> v =  sortBFrequency(new int [] { 2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8});
       System.out.println ("After sorting by frequency ");
       printVector(v);

        //-----------quadruple with a given sum------------------------------------------------------------
        System.out.println ("Quadruple: "+quadruple(new int []{1, 4, 5, 6 }, new int []{ 2, 3, 7, 8}, new int []{1, 4, 6, 10}, new int[]{2,4,7,8}, 30));
        //-----------pairs with given sum------------------------------------------------------------------
        System.out.println ("The number of pairs with given sum "+countPairSum(new int [] {1, 5, 7, -1},6 ));
        //-----------remove minimum elements such that no common elements occur in array-------------------
        System.out.println ("minimum elements to be removed: "+removeMinimum(new int []{1, 2, 3, 4 }, new int [] {2, 3, 4, 5, 8}));
        //-----------maximum subsets in which all elements of array can come without duplicating------------
        System.out.println ("Minimum  number of subsets: "+minimumSubsets(new int [] { 5, 6, 9, 3, 4, 3, 4}));

        //-----------print missing elements in the array in the range--------------------
        printMissing(new int [] { 1, 3, 5, 4 }, 10, 1);
        //-----------check if 2 arrays are equal------------------------------------------
        System.out.println ("Are Two Arrays Equal: "+ areArraysEqual(new int [] { 3, 5, 2, 5, 2}, new int [] { 2, 3, 5, 5, 2}));
        //-----------sum of elements that are not common----------------------------------
        System.out.println ("Sum of non common elements: "+sumNotIntersection(new int [] {1, 5, 3, 8}, new int [] {5, 4, 6, 7}));
        //-----------disjoint or not------------------------------------------------------
        System.out.println ("Two are disjoint or not: "+areDisjoint(new int [] {10, 5, 3, 4, 6}, new int [] {8, 7, 9, 3}));
        //-----------most frequent element in a array-------------------------------------
        System.out.println ("Most frequent element: "+ mostFrequent(new int [] {40,50,30,40,50,30,30}));
        //-----------maximum distance between same occurrence of element-------------------
       System.out.println ("maximum distance: "+ maximumDistance(new int [] {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2}));
        //-----------find union and intersection of 2 array elements-----------------------
        LinkedList l1 = new LinkedList();
        l1.push(1);
        l1.push(2);
        l1.push(3);
        l1.push(4);
        l1.push(5);

        LinkedList l2 = new LinkedList();
        l2.push(1);
        l2.push(3);
        l2.push(5);
        l2.push(6);

        getUnionIntersection(l1.head, l2.head);


        //-----------find if one array is subset of another array------------------------
        int [] arr1 = {1,2,3,4,5,6};
        int [] arr2 = {2,3,4};
        System.out.println ("Subset or not: "+subsetOrNot(arr1, arr2));
        //-----------count distinct elements in a window of size k-----------------------
        int [] distinct = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;
        System.out.println ("Distinct elements in a window are: ");
        countDistinctWindow(distinct, k);
        System.out.println ();
        //-----------majority element--------------- occurring more than n/2 times--------
        int [] majority = {1, 3, 3, 3, 2 };
        int n = majority.length/2;
        HashMap <Integer, Integer> countMap = new HashMap<>();
        for (int i = 0;i< majority.length;i++) {
            if (countMap.containsKey(majority[i])) {
                countMap.put(majority[i], countMap.get(majority[i]) + 1);
            }
            else
                countMap.put(majority[i] , 1);
            if (countMap.get(majority[i]) > n) {
                System.out.println ("majority element: "+ majority[i]);
            }
        }
        //-----------symmetric pairs using naive method O(n^2)
        int [][] arr = {{1,2} , {3,4} , {2,1} , {5,7}};
        for (int i = 0; i<arr.length;i++) {
            for (int j = i+1;j<arr.length;j++) {
                if ((arr[i][0] == arr[j][1])  && (arr[i][1] == arr[j][0])) {
                    System.out.println (arr[i][0]+ " "+arr[i][1]);
                }
            }
        }
        //--------------using hashmap------------------
        Map<Integer, Integer> h = new HashMap<>();
        if (arr.length == 0) {
            System.out.println ("No Symmetric pair");
            return;
        }
        int data =0;
        int flag = 0;
        for (int i = 0;i<arr.length;i++) {
            int first = arr[i][0];
            int second = arr[i][1];
            if (h.containsKey(second)){
                data = h.get(second);}
            if (data != 0 && data == first) {
                System.out.println (second +" "+first);
                flag = 1;
            }
            else
                h.put (first, second);
        }
        if (flag == 0)
        {
            System.out.println ("No Symmetric pair");
        }
        //----------------- first unique character in the string---------------
//        HashMap<Character, Integer> map = new HashMap <>();
        String s = "abcdabc";
//        for (int i = 0;i<s.length();i++) {
//            if (map.containsKey(s.charAt(i)))
//                map.put (s.charAt(i), map.get(s.charAt(i)) +1);
//            else
//                map.put(s.charAt(i), 1);
//        }
//
//        for (int i = 0;i<s.length();i++){
//            if (map.get(s.charAt(i)) == 1)
//                System.out.println (s.charAt(i));
//        }

        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0;i<s.length();i++) {
            if (map.containsKey(s.charAt(i)))
                map.put (s.charAt(i), map.get(s.charAt(i)) +1);
            else
                map.put(s.charAt(i), 1);
        }
        Set<Character> keys = map.keySet();
        int a = 0;
        for (char ch : keys) {
            if (map.get(ch) == 1) {
                System.out.println (ch);
                a = 1;
            }
        }
        if (a == 0) {
            System.out.println ("-1");
        }

        //---------------contiguous integers or not----------------

        int [] array = {5 ,8 ,4 ,4 ,7 ,6 ,2 ,6 ,7 ,3};
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i = 0;i< array.length;i++) {
            hashSet.add(array[i]);
        }
        int currentElement = array[0];
        int count = 0;
        while (hashSet.contains(currentElement)) {
            count ++;
            currentElement--;
        }
        currentElement = array[0]+1;
        while (hashSet.contains(currentElement)) {
            count++;
            currentElement++;
        }
        if (count == hashSet.size()) {
            System.out.println ("contiguous: true");
        }
        else
            System.out.println ("contiguous: false");
        //------------------------pair with a sum---------------------
        int array2 [] = {1 ,7 ,40 ,8 ,-7, 3};
        int targetSum = 15;
        hashSet.clear();
        for (int i = 0;i<array2.length;i++) {
            int temp = Math.abs(array2[i]- targetSum);
            if (hashSet.contains(temp))
                System.out.println ("pair with sum : true");
            else
                hashSet.add(array2[i]);
        }
        //-----------------itinerary of the tickets----------------
//        Map <String, String> tickets = new HashMap <>();
//        Scanner sc  = new Scanner (System.in);
//        int n= sc.nextInt();
//        String starting = null;
//        for (int i = 0; i < n; i++) {
//            tickets.put(sc.next(), sc.next());
//        }
//        Map <String, String> reverseTickets = new HashMap<>();
//        Set <String> k = tickets.keySet();
//        for (String key: k) {
//            reverseTickets.put(tickets.get(key), key);
//        }
//        for (String key:k) {
//            if (!reverseTickets.containsKey(key)) {
//                if (starting != null)
//                    starting = lexographic(starting,key);
//                else
//                    starting = key;
//            }
//        }
//        if (starting == null)
//            System.out.println ("Invalid");
//        while (starting != null) {
//            System.out.print (starting+" ");
//            starting = tickets.get(starting);
//        }
        //------------------------- hashmap values overriding-------------
        Map<String, Integer> hashMap = new HashMap<>();
        //hashMap.put("A", new Integer(1));
        hashMap.put("A", 1);
        hashMap.put("B", 2);
        hashMap.put("C", 3);
        hashMap.put("A", 2);
        hashMap.put("C", 2);
        System.out.println(hashMap.entrySet());
        //--------------------------hashmap to set------------------------
        Map <Integer, String> m = new HashMap<>();
        m.put(1,"A");
        printValues(m);

    }
    static void storeInMap (Map <Integer, Integer> map, Node node1, Node node2) {
        Node ptr1 = node1;
        Node ptr2 = node2;
        while (ptr1 != null || ptr2 != null) {
            if (ptr1 != null) {
                map.put( ptr1.data, map.getOrDefault(ptr1.data, 0)+1);
                ptr1 = ptr1.next;
            }
            if (ptr2 != null) {
                map.put (ptr2.data, map.getOrDefault(ptr2.data, 0)+1);
                ptr2 = ptr2.next;
            }
        }
    }
    static Node getIntersection (Map<Integer, Integer> map) {
        Node result = null;
        for (int key: map.keySet()) {
            if (map.get(key) == 2) {
                Node newNode = new Node (key);
                newNode.next = result;
                result = newNode;
            }
        }
        return result;
    }
    static Node getUnion (Map<Integer, Integer> map ) {
        Node result2 = null;
        for (int key: map.keySet()) {
            Node newNode = new Node (key) ;
            newNode.next = result2;
            result2 = newNode;
        }
        return result2;
    }
    static void getUnionIntersection (Node node1, Node node2) {
        Map<Integer, Integer> map = new HashMap<>();
        storeInMap(map, node1, node2);
        Node union = getUnion(map);
        System.out.println ("The union: ");
        printList(union);
        Node intersection = getIntersection(map);
        System.out.println ("The intersection: ");
        printList(intersection);
    }
    static void printList (Node head) {
        Node current = head;
        while (current != null) {
            System.out.print (current.data+" ");
            current = current.next;
        }
        System.out.println ();
    }
    static int maximumDistance (int []arr) {
        Map <Integer, Integer> map = new HashMap<>();
        int maxD= 0;
        for (int i = 0;i< arr.length;i++) {
            if (!map.containsKey(arr[i]))
                map.put(arr[i], i);
            else
                maxD = Math.max (maxD, i-map.get(arr[i]));
        }
        return maxD;
    }
    static int mostFrequent(int [] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i< arr.length;i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1 );
        }
        int maxCount = 0; int res = -1;
        for (Map.Entry<Integer, Integer> e: map.entrySet()) {
            if (maxCount < e.getValue()) {
                maxCount = e.getValue();
                res = e.getKey();
            }
        }
        return res;
    }
    static boolean areDisjoint (int [] arr1, int []arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i<arr1.length;i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0)+1);
        }
        for (int i = 0;i<arr2.length;i++) {
            if (map.containsKey(arr2[i]))
                return false;
        }
        return true;
    }
    static int sumNotIntersection (int [] arr1, int [] arr2) {
        Map <Integer, Integer> map = new HashMap<>();
        for (int i = 0;i< arr1.length;i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0)+1);
        }
        for (int i = 0;i< arr2.length;i++) {
            map.put(arr2[i], map.getOrDefault(arr2[i], 0)+1);
        }
        int sum = 0;
        for (int key: map.keySet()) {
            if (map.get(key) == 1)
                sum += key;
        }
        return sum;
    }
    static boolean areArraysEqual (int [] arr1, int [] arr2) {
        Map <Integer, Integer> map = new HashMap<>();
        for (int i = 0;i< arr1.length;i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0)+1);
        }
        for (int i = 0;i< arr2[i];i++) {
            if (!map.containsKey(arr2[i]))
                return false;
            if (map.get(arr2[i])==0)
                return false;
            map.put(arr2[i], map.get(arr2[i])-1);
        }
        return true;
    }
    static void printMissing (int[] arr, int high, int low) {
        Set <Integer> set= new HashSet<>();
        for (int i = 0;i< arr.length;i++) {
            set.add(arr[i]);
        }
        System.out.print ("Missing elements in the range are ");
        for (int i = low;i <=  high; i++) {
            if (!set.contains(i))
                System.out.print (i+" ");
        }
        System.out.println ();
    }
    static int minimumSubsets(int [] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i< arr.length;i++) {
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        int res = Integer.MIN_VALUE;
        for (int key: map.keySet()) {
            res = Math.max (res, map.get(key));
        }
        return res;
    }
    static int removeMinimum (int [] arr1, int [] arr2){
        Map <Integer, Integer> map1 = new HashMap<>();
        Map <Integer, Integer> map2 = new HashMap<>();

        for (int i = 0;i< arr1.length;i++) {
            map1.put(arr1[i], map1.getOrDefault(arr1[i],0) +1);
        }
        for (int i =0;i< arr2.length;i++) {
            map2.put(arr2[i], map2.getOrDefault(arr2[i], 0)+1);
        }
        int res = 0;
        for (int key: map1.keySet()) {
            if (map2.containsKey(key))
            {
                res += Math.min(map1.get(key), map2.get(key));
            }
        }
        return res;
    }
    static int countPairSum (int [] arr, int k) {
        Map <Integer, Integer> map = new HashMap <>();
        int count = 0;
        System.out.print ("The pairs are ");
        for (int i = 0;i< arr.length;i++){
            if (map.containsKey(k-arr[i])) {
                count += map.get(k-arr[i]);
                System.out.print ("("+arr[i]+","+ (k-arr[i])+")");
            }
            else
                map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        System.out.println ();
        return count;
    }
    static int quadruple (int [] arr1, int []arr2, int []arr3, int[]arr4, int x) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i<arr1.length;i++)
            for (int j = 0;j< arr2.length;j++) {
                int sum = arr1[i]+arr2[j];
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
        int count = 0;
        for (int i= 0;i<arr3.length;i++) {
            for (int j = 0;j<arr4.length;j++) {
                int sum = arr3[i]+arr4[j];
                int temp = x- sum;
                if (map.containsKey(temp))
                    count += map.get(temp);
            }
        }
        return count;
    }
    static Vector<Integer> sortBFrequency (int [] arr) {
        Map <Integer, Integer> map = new HashMap<>();
        Vector <Integer> v = new Vector<>();
        for (int i = 0;i< arr.length;i++) {
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        Vector <Map.Entry<Integer,Integer>> v1 = new Vector<>(map.entrySet());
        Collections.sort(v1, new SortByValue());
        for (int i = 0;i<v1.size();i++) {
            for (int j = 0;j< v1.get(i).getValue();j++) {
                v.add(v1.get(i).getKey());
            }
        }
        return v;
    }
    static void printVector (Vector <Integer> v ){
        for (int i = 0;i< v.size();i++) {
            System.out.print (v.get(i)+" ");
        }
        System.out.println ();
    }
    static String getKey (String s) {
        boolean [] visited = new boolean[26];
        Arrays.fill(visited,false);
        for (int i = 0;i<s.length();i++) {
            visited[s.charAt(i)-'a'] = true; // to convert character into its ascii value
        }
        String key = "";
        for (int i = 0;i< visited.length;i++) {
            if (visited[i])
                key += (char) ('a'+i); // to convert ascii value into its character
        }
        return key;
    }
    static void printPairs(String [] words) {
        Map<String, ArrayList<Integer>> map  = new HashMap <>(); // key = unique characters in each word, value = index having same keys.
        for (int i = 0;i< words.length;i++) {
            String key = getKey(words[i]);
            if (map.containsKey(key)) {
                ArrayList<Integer> getValue = map.get(key);
                getValue.add(i);
                map.put(key, getValue);
            }
            else
            {
                ArrayList<Integer> value = new ArrayList<>();
                value.add(i);
                map.put(key, value);
            }
        }
        for (Map.Entry<String, ArrayList<Integer>> it: map.entrySet() ) {
            ArrayList<Integer> indices = it.getValue();
            for (Integer x: indices) {
                System.out.print (words[x]+" ");
            }
            System.out.println ();
        }
    }
    static int distinctElement (int [] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i< arr.length;i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        int count = 0;
        for (int i = 0;i< arr.length;i++) {
            if (map.get(arr[i]) == 1)
                count ++;
            if (count == k)
                return arr[i];
        }
        return -1;
    }
    static void mngrEmp (Map<String,String> dataSet) {
        Map<String, List<String>> mngrEmp = new HashMap<>();
        for (Map.Entry<String, String> entry : dataSet.entrySet()) {
            String emp = entry.getKey();
            String mngr = entry.getValue();

            if (emp != mngr) {
                List <String> directReportList = mngrEmp.get(mngr);
                if (directReportList ==null) {
                    directReportList = new ArrayList<String>();
                    mngrEmp.put(mngr, directReportList);
                }
                directReportList.add(emp);
            }
        }
        for (String s: dataSet.keySet()) {
            if (mngrEmp.containsKey(s)) {
                List <String> count = mngrEmp.get(s);
                System.out.println(s+ " "+ count.size());
            }
            else
                System.out.println (s+" 0");
        }

    }
    static int longestSubarrWthSumDivByK(int arr[], int n,
                                         int k)
    {
        Map<Integer, Integer> map = new HashMap<>(); // storing mod values and index of element till sum.

        int max_len = 0;
        int sum = 0;
        int ending = -1;
        int start = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            // to handle negative values as well
            int mod = ((sum % k) + k) % k;

            if (mod == 0) {
                max_len = i + 1;
                ending = i;
            }

            if (!map.containsKey(mod))
                map.put(mod, i);
            else {
                int sz = i - map.get(mod);
                if (max_len<sz) {
                    max_len = sz;
                    ending = i;
                }
            }
        }
        start = ending-max_len+1;
        System.out.println ("Element from "+start+" to "+ending +" have sum divisible by "+k);
        return max_len;
    }
    static int longestIncreasingSub (int [] arr)
    {
        HashMap <Integer,Integer> map = new HashMap <>();
        for (int i = 0;i< arr.length;i++) {
            if (map.containsKey(arr[i]-1))
            {
                System.out.print (arr[i]+" ");
                map.put(arr[i], map.get(arr[i]-1)+1);
                map.remove(arr[i]-1);
            }
            else
            {
                map.put(arr[i],1);
            }
        }
        System.out.println ();
        return Collections.max(map.values());
    }
    static int maxDiff (int [] arr) {
        Map <Integer, Integer> pmap = new HashMap<>();
        Map <Integer,Integer> nmap = new HashMap<>();
        for (int i = 0;i< arr.length;i++) {
            if (arr[i]>0)
                pmap.put(arr[i], pmap.getOrDefault(arr[i],0)+1);
        }
        for (int i = 0;i<arr.length;i++) {
            if (arr[i]<0)
                nmap.put(Math.abs(arr[i]), nmap.getOrDefault(Math.abs(arr[i]),0)+1);
        }
        int subSet1 = 0;
        int subSet2 = 0;
        for (int i = 0;i<arr.length;i++) {
            if (arr[i] >0 && pmap.containsKey(arr[i]) && pmap.get(arr[i]) == 1)
                subSet1 += arr[i];
        }
        for (int i =0;i<arr.length;i++) {
            if (arr[i]<0 && nmap.containsKey(Math.abs(arr[i])) && nmap.get(Math.abs(arr[i]))==1)
                subSet2 += arr[i];
        }
        return subSet1-subSet2;
    }
    static String minimumIndexedChar (String str, String patt) {
        Set <Character> set = new HashSet<>();
        for (int i = 0;i< patt.length();i++) {
            set.add(patt.charAt(i));
        }
        for (int i = 0;i< str.length();i++) {
            if (set.contains(str.charAt(i))) {
                return str.charAt(i)+"";
            }
        }
        return "$";
    }
    public static boolean subsetOrNot (int [] arr1, int []arr2) {
        HashSet <Integer> set = new HashSet<> ();
        for (int e: arr1) {
            set.add(e);
        }
        for (int i = 0;i< arr2.length;i++) {
            if (!set.contains(arr2[i]))
                return false;
        }
        return true;
    }
    public static void countDistinctWindow(int [] arr, int k ){
        HashMap <Integer, Integer> map = new HashMap<>();
        for (int i = 0;i< k;i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        System.out.print(map.size() +" ");
        for (int i = k;i< arr.length;i++) {
            if (map.get(arr[i-k]) == 1) {
                map.remove((arr[i-k]));
            }
            else
                map.put(arr[i-k], map.getOrDefault(arr[i-k], 0)-1);
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
            System.out.print (map.size()+" ");
        }
    }
    public static void printValues(Map<Integer,String> map){
        //Write your code here
        Set<String> temp = new LinkedHashSet<>();
        Set <Integer> keys = map.keySet();
        for (int k : keys) {
            temp.add(map.get(k));
        }
        for (String s: temp) {
            System.out.print (s+" ");
        }

    }
    public static String lexographic (String s1, String s2) {
        char [] ch1 = s1.toCharArray();
        char [] ch2 = s2.toCharArray();
        int sum1= 0;
        int sum2= 0;
        for (char ch: ch1) {
            sum1 += ch;
        }
        for (char ch: ch2) {
            sum2 += ch;
        }
        if (sum1 < sum2) {
            return s2;
        }
        else if (sum1 > sum2)
            return s1;
        return s1;

    }




}
