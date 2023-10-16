import java.util.Arrays;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        int a = 10, b = 20, c = 30, s, sm, p;
        double d = 45;
        double r = Math.toRadians(d);
        System.out.println(Math.PI);
        System.out.println(Math.sin(r)); // sin cos tan and all trigonometric functions take the values in radians form.
        int num = (int) (Math.random() * 20);
        // Math.random() will return random numbers between 0.0 to 1.0, we want the numbers to
        //be between 0 and 20 in the int form hence the typecasting is done and *20 is also done.
        s = calSum(a, b, c);
        sm = sumProd(a, b, c, 1);
        p = sumProd(a, b, c, 2);
        System.out.println(num);


        // calSum (10, a , 1+c) actual arguments can be variables, expressions or constants
        // nested calls can happen
        // calSum(a, calSum(a,b,c), 10);
        // returned value can be stored or can be ignored.
        System.out.println(sm + " " + p);

        //------------------------function overloading
        int i = absValue(8);
        long j = absValue(-45545455);
        double d1 = absValue(-123.456);
        // static functions can be called without creating object of the class
        //--------------------creating a function that returns factorial of integer
        System.out.println("Enter an integer for fact and even odd and fibonacci calculation");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // nextInt() is a non static method as it requires a object named Sc of the class Scanner to call it
        System.out.println("The factorial of " + n + " is " + fact(n));
        //---------------------find if a number is even or odd and returns boolean
        // take the upper n for the calculation
        // creating an object of the class Main to call an instance function.
        Main obj = new Main();
        boolean eo = obj.EvenOdd(n);
        if (eo == true)
            System.out.println("The number " + n + " is even");
        else
            System.out.println("The number " + n + " is odd");

        //--------------------overloaded functions tat sums two integers and two doubles
        System.out.println("The sum of two integers 2 and 3 is " + sum(2, 3));
        System.out.println("The sum of two doubles 4.36589 and 5.789644 is " + sum(4.36589, 5.789644));
        //--------passing arrays to functions
        int[] intarray = new int[4];// new keyword is used to create objects and arrays are implemented as objects
        intarray = new int[]{1, 2, 3}; // no error why?
        System.out.println("The sum of the array elements is " + SumArray(intarray));
        //--------------------function that take the array of strings and returns the longest string in the arry
        String[] sarray = {"hello", "Vinita", "functions", "java"};
        System.out.println ("The longest string is "+longests(sarray));
        //-----------------finonacci number
        System.out.println ("The "+n+" fibonacci number is "+fib(n));
        //--------------printing an array of prime numbers in the given range
        System.out.println("enter the range between which you want prime numbers");
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        System.out.println ("The array of prime numbers is " + Arrays.toString(primenumbers(n1,n2)));
        // function to reverse a string
        System.out.println ("Enter a string to be reversed");
        String l= sc.next();
        System.out.println ("the reversed string is "+reverse(l));
        //------------------------------variable arguments function
        int m1 = 2;
        int m2 = 3;
        int m3 = 4;
        System.out.println ("The average of the numbers is "+vbleargs(m1,m2,m3));
        //------------------------------match the character
        String s1 = "vinita";
        char ch= 'i';
        System.out.println ("The char "+ch+ " is at "+match(s1,ch)+" place in the string "+s1 );
    }
    static int match (String s, char ch)
    {

        for (int i = 0; i <s.length(); i++){
            if (s.charAt(i) == ch)
                return (i+1);
        }
        return 0;
    }
    static int vbleargs(int...n){
        int sum = 0;
        for (int item :n)
        {
            sum = sum+  item;
        }
        return(sum/n.length);
    }

    static String reverse (String p){

        char[] ch = p.toCharArray();
        char[] chm = new char[ch.length];
        for (int i = 0; i <ch.length; i++){
            chm[i] = ch[p.length()-1-i];
        }
        return String.valueOf(chm);
    }

    static int calSum(int x, int y, int z) {
        return (x + y + z);
    }
    // a, b,c = actual arguments
    //x,y,z = formal arguments.

    static int sumProd(int a, int b, int c, int code) {
        int ss;
        int pp;
        ss = a + b + c;
        pp = a * b * c;
        if (code == 1)
            return ss;
        else
            return pp;

    }

    static int absValue(int ii) {
        return (ii > 0 ? ii : ii * -1);
    }

    static long absValue(long ll) {
        return (ll > 0 ? ll : ll * -1);
    }

    static double absValue(double dd) {
        return (dd > 0 ? dd : dd * -1);
    }

    static int fact(int n) {
        if (n == 0 || n == 1)
            return 1;
        else
            return (n * fact(n - 1));
    }

    // creating a instance function
    boolean EvenOdd(int n) {
        if (n % 2 == 0)
            return true;
        else
            return false;
    }

    static int sum(int n1, int n2) {
        return (n1 + n2);
    }

    static double sum(double d1, double d2) {
        return (d1 + d2);
    }

    static int SumArray(int[] p) {
        int sum = 0;
        for (int element : p) // special for loop it will loop by giving the array elements one by one.
        {
            sum += element;
        }
        return sum;
    }
    static String longests (String[] sarray){

        int maxLength = sarray[0].length();
        int k =0;
        for (int i = 1; i < sarray.length; i++)
        {
            if (sarray[i].length() > maxLength)
            {
                maxLength = sarray[i].length();
                k = i;
            }

        }
        return sarray[k];
    }
    static int fib (int n) {
        if (n <= 1)
            return n;
        else
            return (fib(n-2)+fib(n-1));
    }
    static int[] primenumbers (int n, int n1)
    {
        int count = 0;
        if ( n < 2)
            n = 2;
        for (int i = n; i <= n1; i++)
        {
            if (prime(i))
                count++;
        }
        int [] p = new int[count];
        int index = 0;
        for (int i = n; i <= n1; i++)
        {
            if (prime(i))
            { p[index] = i;
            index++;}
        }
        return p;
    }
    static boolean prime (int n){
        for (int i = 2; i <n ; i++){
            if (n%i == 0)
                return false;
        }
        return true;
    }
}
