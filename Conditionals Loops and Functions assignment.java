import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //----------------------------------------print even and odd and prime also
       int i;

       for (i = 1; i <100; i++)
       {
           boolean isPrime =true;
           if (i%2 == 0)
           {
               System.out.println (i+ " is even");
           }
           else {
               for (int k = 2; k < i; k++) {
                   if (i % k == 0)
                   {isPrime = false;
                   break;}
               }
               if (isPrime)
               System.out.println (i+ " is odd prime");
               else System.out.println (i+ " is odd");

           }
       }

       //------------------------Write a Java program that accepts three integers from the user and
        // returns true if two or more of them (integers) have the same rightmost digit.
        // The integers are non-negative.------------------------------------------------------------

        Scanner sc = new Scanner (System.in);
       System.out.println("Enter 3 integers");
      String a = Integer.toString(sc.nextInt()); int alength = a.length(); // integer to string
      String b = Integer.toString(sc.nextInt()); int blength = b.length();
      String c = Integer.toString(sc.nextInt()); int clength = c.length ();
      if (a.charAt(alength-1) == b.charAt(blength -1) || a.charAt(alength -1) == c.charAt(clength-1) ||b.charAt(blength-1) == c.charAt(clength-1))
          System.out.println ("True"); // extracting a character from string

        //--------------------------to convert seconds to hours mins and seconds
        int sec = 86399; // can take from user also
        int hours = sec/3600;
        int min = (sec- (hours*3600))/60;
        int secs = sec -(hours*3600 + min*60);
        System.out.println (hours+":"+min+":"+secs);
        //----------------------------Write a Java program to find the number of values in a given
        // range divisible by a given value.For example x = 5, y=20 and p =3,
        // find the number of integers within the range x..y and that are divisible by p

        int x = 5;
        int y = 20; int p = 3; int num = 0;
        for (i = 5; i <= 20; i++)
        {
            if (i%3 == 0)
            {
                System.out.println (i+ " is divible by 3");
                num += 1;
            }
        }
        System.out.println (num+ " integers are divisible by 3");
        //----------------- Write a Java program to accept an integer and count the factors of the number

        System.out.println ("Enter an integer");
        int integer = sc.nextInt(); int number =0;
        for (i = 1; i <=integer; i++)
        {
            if (integer%i == 0)
                number +=1;

        }
        System.out.println (number+ " numbers are factor of "+integer);

        //-------------------------to capitalize first letter of each word in a sentence
        System.out.println ("Input a sentence");
        Scanner in = new Scanner(System.in);
        String sentence = in.nextLine();
        Scanner linescan = new Scanner (sentence);
        String uppercase = "";
        while (linescan.hasNext()){ // if the line sentence has next word
            String word = linescan.next();
            uppercase += Character.toUpperCase(word.charAt(0)) + word.substring(1) + " ";
        }
        System.out.println (uppercase);

         //----------------------------------------convert a string to lowercase

        char[] ch = sentence.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            System.out.print(Character.toUpperCase(ch[i])); // can use sentence.uppercase() function.
        }

        String [] words  = sentence.split ("[ ]+"); // string to word array.

        //-------------------------------------reverse a word
        String word = "Vinita";
        char charc [] = word.toCharArray();
        for (int j =charc.length-1; j >=0 ; j--)
        {
            System.out.print (charc[j]);
        }
        //------------------------------------Write a Java program that accepts two integer values from
        // the user and returns the largest value. However if the two values are the same, return 0 and
        // find the smallest value if the two values have the same remainder when divided by 6
        System.out.println ("Enter two integer values");
        int p = sc.nextInt(); int remp = p%6;
        int q = sc.nextInt(); int remq= q%6;
        if (p>q & remp!= remq)
            System.out.println(p);
        else if (p < q &remp!=remq)
            System.out.println(q);
        else if (p == q)
            System.out.println ("0");
        else if (remp == remq)
            System.out.println (p>q? q:p);
        //---------------------------------------------
        System.out.println ("Enter two integers between 25 and 75");
        int k = sc.nextInt();
        int l = sc.nextInt();
        if (k > 25 && k <75 && l >25 && l <75)
        {
            int qk = k/10;  int remk = k%10;
            int ql = l/10;  int reml = l%10;
            if (qk == ql || qk == reml || remk==ql || remk ==reml)
                System.out.println ("true");
        }
        //----------------------------------to calculate the absolute value of any number
        //using user defined function
        Scanner in = new Scanner (System.in);
        System.out.println ("Enter a number whose absolute value you want");
        int d = in.nextInt();
        System.out.println ("The absolute value of the "+d+" is "+absolute(d));
        //--------------------------sum of first 100 prime numbers
        int i=2;
        int sum =0;
        for (; i <=100; i++)
        {
            boolean isPrime = true;
            for (int k = 2; k <i; k++)
            {
                if (i%k == 0)
                {isPrime = false;
                break;}

            }
            if (isPrime)
                sum +=i;
        }
        System.out.println ("The sum of first 100 prime numbers is "+sum);
        //----------------------to know if the number entered by user is prime
        Scanner sc = new Scanner(System.in);
        System.out.println ("Enter a number");
        int x = sc.nextInt();
        System.out.println ("The number is "+(primecal(x)? "prime":"not prime"));
        //--------------------------- to add a word in the middle of a string
        String main_string = "Upgrad portal has recorded videos";
        String word = "great";
        String modified = main_string.substring(0,18) + word + main_string.substring(17);
        System.out.println (modified);
        //--------------------------extracting the first half of a even string
        String main_string = "Python"; // an even string
        System.out.println(main_string.substring(0,(main_string.length()/2 )));
        //--------------------------------------- concatenation
          String Main_string = "Hello";
          String s2 = "World";
          String final_string = (Main_string.substring(1)) +s2.substring(1) ;
          System.out.println (final_string);
          //-----------------------------------------








    }

    static int absolute (int a)
    {
        if (a >= 0)
            return (a);
        else
            return (-a);
    }
    static boolean primecal (int a){
        boolean isPrime = true;
        for (int i = 2; i <a; i++)
        {
            if (a%i == 0)
            {
                isPrime = false;
                break;
            }

        }
        return isPrime;
    }
   }



        }
    }
