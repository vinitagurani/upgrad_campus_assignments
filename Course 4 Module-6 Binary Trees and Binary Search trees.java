class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Tree {
    Node root;
    static int count = 0;

    public Tree() {
        root = null; // creating a empty tree.
    }
    public static int KthSmallestElement(Node root, int k) {
        // Write your code here
        if (root == null || count >= k)
            return -1;
        int d = KthSmallestElement(root.left, k);
        //System.out.println (d);
        if (d!= -1)
            return d;
        count++;
        if (count == k)
            return root.data;
        return KthSmallestElement(root.right, k);
    }
  //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    void addAllGreaterElements(Node node, int[] sum) { // reverse inorder, right, root , left
        if (node == null)
            return;
        addAllGreaterElements(node.right, sum);
        sum[0] += node.data; // while back tracking we have to preserve the sum thats why an object is used
        //sum+= node.data;
        node.data = sum[0];
        //node.data = sum;
        addAllGreaterElements(node.left, sum);
    } //350 330 300 260 210 150 80

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    void preOrder(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    void inOrder(Node node) {
//        if (node == null) {
//            return;
//        }
//        inOrder(node.left);
//        System.out.print(node.data + " ");
//        inOrder(node.right);


        Stack <Node> stack = new Stack <>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node .left;
            }
            node = stack.pop();
            System.out.print (node.data+" ");
            node = node.right;
        }

    }
  //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    void postOrdeer(Node node) {
        if (node == null)
            return;
        postOrdeer(node.left);
        postOrdeer(node.right);
        System.out.print(node.data + " ");
    }
  //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public void printNodesmultiple(Node node) { // printing nodes that are multiple of root node.
        // parameter passed id root node
        if (root.data == 0) {
            System.out.println("Division by zero is undefined");
            return;
        }
        if (node == null) {
            return;
        }
        printNodesmultiple(node.left);

        if (node.data % root.data == 0)
            System.out.print(node.data + " ");

        printNodesmultiple(node.right);
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------6.-------------------------------------------
    public int countNodes(Node node) {
//        Queue<Node> q = new LinkedList<>();
//        q.add(node);
//        int count = 0;
//
//        while (!q.isEmpty()) {
//            Node temp = q.remove();
//            if (temp != null) {
//                count++;
//                if (temp.left != null)
//                    q.add(temp.left);
//
//                if (temp.right != null)
//                    q.add(temp.right);
//            }
//        }
//        return count;

        if (node == null)
            return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

  //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    int height(Node node) {
        if (node == null)
            return 0;
        int l = 1 + height(node.left);
        int r = 1 + height(node.right);
        if (l > r)
            return l;
        else
            return r;
//        Queue <Node> q = new LinkedList<>();
//        q . add (node);
//        int height = 0;
//        while (!q.isEmpty()) {
//            for (int i = 0;i< q.size(); i++) {
//                Node temp = q.remove();
//                if (temp.left != null)
//                    q.add(temp.left);
//                if (temp.right != null)
//                    q.add(temp.right);
//            }
//            height++;
//        }
//        return height;
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    void levelOrderTraversal(Node node) {
        int height = height(node);
        for (int i = 1; i <= height; i++) {
            printNodesAtLevel(node, i, 1);
        }
        System.out.println();
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------recursive method---------------------------------
    void printNodesAtLevel(Node node, int level, int currentLevel) {
        if (node == null)
            return;
        if (level == currentLevel)
            System.out.print(node.data + " ");
        else {
            printNodesAtLevel(node.left, level, currentLevel + 1);
            printNodesAtLevel(node.right, level, currentLevel + 1);
        }
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    void levelOrderIterative(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node temp = q.remove();
            if (temp != null) {
                System.out.print(temp.data + " ");
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
        }
        System.out.println();
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Node findMax(Node node) {
        // for BT
//       Queue <Node> q= new LinkedList<>();
//       q.add(node);
//       int max = 0;
//       while (!q.isEmpty()) {
//           Node temp = q.remove ();
//           if (temp != null) {
//               max = Math.max (max,temp.data);
//               if (temp.left != null)
//                   q.add(temp.left);
//               if (temp.right != null)
//                   q.add(temp.right);
//           }
//       }
//       return max; // return type int

        //---for BST----- recursive approach--------
        if (node.right == null)
            return node;
        return findMax(node.right); // return type node
        //-----for BST------iterative approach--------
//        int minv = root.data;
//        while (root.right != null)
//        {
//            minv = root.right.data;
//            root = root.data;
//        }
//        return minv; // return type int
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Node mirror(Node node) {
        if (node == null)
            return node;
        Node l = mirror(node.left);
        Node r = mirror(node.right);
        node.left = r;
        node.right = l;
        return node;
    }
  //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    int elementsInRange(Node node, int a, int b) {
        // applicable for binary search tree.
        if (node == null)
            return 0;
        if (node.data >= a && node.data <= b)
            return 1 + elementsInRange(node.left, a, b) + elementsInRange(node.right, a, b);
        if (node.data >= b)
            return elementsInRange(node.left, a, b);
        else
            return elementsInRange(node.right, a, b);
    }
  //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    boolean search(Node node, int key) {
        //for BST recursive method-----------
//        if (node == null)
//            return false;
//        if (key == node.data)
//            return true;
//        if (key > node.data)
//            return search(node.right, key);
//        else
//            return search(node.left, key);
        //----------------iterative method
        while (node != null) {
            if (key == node.data)
                return true;
            else if (key < node.data)
                node = node.left;
            else
                node = node.right;
        }
        return false;
    }
  //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    Node insertNodeBST(Node node, int key) {
        if (node == null) {
            node = new Node(key);
            return node;
        }
        if (key < node.data)
            node.left = insertNodeBST(node.left, key);
        else if (key > node.data)
            node.right = insertNodeBST(node.right, key);
        return node;
    }
  //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    Node LCA(Node node, int n1, int n2) {
        if (node == null)
            return null;
        if (node.data > n1 && node.data > n2)
            return LCA(node.left, n1, n2);
        if (node.data < n1 && node.data < n2)
            return LCA(node.right, n1, n2);
        return node;
    }
  //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    int sumNodes(Node node) {
        if (node == null)
            return 0;
        int l = sumNodes(node.left);
        int r = sumNodes(node.right);
        node.data += l + r;
        return node.data;
    }

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Node BalancedTreeArray(int[] arr, int start, int end) { // array is sorted
        if (start > end)
            return null;
        int mid = (int) Math.floor((double) (start + end) / 2);
        Node node = new Node(arr[mid]);
        node.left = BalancedTreeArray(arr, start, mid - 1);
        node.right = BalancedTreeArray(arr, mid + 1, end);
        return node;
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    int getLeafCount(Node node) {
        if (node == null)
            return 0;
        else if (node.left == null && node.right == null)
            return 1;
        else
            return getLeafCount(node.left) + getLeafCount(node.right);
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    void printNodesWithNoSibling(Node node) {
        if (node == null)
            return;
        else if (node.left == null && node.right != null)
            System.out.println(node.right.data);
        else if (node.left != null && node.right == null)
            System.out.println(node.left.data);

        printNodesWithNoSibling(node.left);
        printNodesWithNoSibling(node.right);
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    void printRootToLeaf(Node node, int path[], int pathLen) {
        if (node == null)
            return;
        path[pathLen] = node.data;
        if (node.left == null && node.right == null) {
            for (int i = 0; i <= pathLen; i++)
                System.out.print(path[i] + " ");
            System.out.println();
            return;
        }
        printRootToLeaf(node.left, path, pathLen + 1);
        printRootToLeaf(node.right, path, pathLen + 1);

    }
  //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Node leafDelete (Node node) {
        if (node == null)
            return null;
        if (node.left == null && node.right == null)
            return null;
        node.left = leafDelete(node.left);
        node.right = leafDelete(node.right);
        return node;
    }
  //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Node inorderSucc (Node root, int key ) {
        Stack <Node > stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null){
                stack.push (root);
                root = root.left;
            }
            root = stack.pop();
            if (root.data > key) return root;
            root = root.right;
        }
        return null;
    }
  //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    void swapNodes (Node n1 , Node n2) {
        int temp = n1.data;
        n1.data = n2.data;
        n2.data = temp;
    }
  //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    void findFault (int [] arr) {
        int first = -1;
        int last = -1;
        for (int i = 1;i< arr.length;i++) {
            if (arr[i] < arr[i-1] && first == -1)
                first = i-1;

            if (arr[i]< arr[i-1] && first != -1)
                last = i;
        }
        System.out.println (arr[first] +" "+arr[last]);
    }
  //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    int index = 0;
    void storeInorder (int [] arr, Node node) {
        if (node == null)
            return;
        storeInorder(arr, node.left);
        arr[index] = node.data;
        index ++;
        storeInorder(arr, node.right);
    }
}
