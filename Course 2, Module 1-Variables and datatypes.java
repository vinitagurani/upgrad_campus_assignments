import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) 
  
 // question 1---------------------java program to print int, char, double on screen
        int int_num;
        char name_char;
        double double_num;
        Scanner in = new Scanner (System.in);
        System.out.println ("Enter an integer");
        int_num = in.nextInt();
        System.out.println ("Enter a character");
        name_char = in.next().charAt(0);
        System.out.println ("Enter a number ");
        double_num = in.nextDouble();
        System.out.println (int_num+" "+name_char+" "+double_num);

  //question 2 --------------------------------program to print area of a rectangle

        int a = 3;
        int b = 2;
        int area = a * b;
        System.out.println ("Area of rectangle is = "+area);
// question 3-------------------------------program to print product of numbers

        float c = 8.2f;
        int s = 6;
        double product = c * s;
        System.out.println (product);

//question 4-----------------------------to print the ASCII value of any character
        char d;
        System.out.println ("enter a character");
        d = in.next().charAt(0);
        int e = (int) d;
        System.out.printf ("The ASCII value of the char %c is %d\n",d,e);

//question 5-----------------------------typecasting

        double f = 100.235;
        int g = (int) f;
        System.out.println ("The integer value is "+g);

//question 6----------------------------adding 3 to the ASCII value of the character

        System.out.println ("Enter a character");
        char ch = in.next().charAt(0);
        int chi = ((int) ch) + 3;
        System.out.println ("The value after adding is "+chi);

//question 7------------------------adding integer and double

        int u = 6;
        double t= 4.555556;
        System.out.println ("Added value = "+(u+t));

//question 8---------------------------finding the square of a  number
        System.out.println ("Enter a number to find the square");
        double l = in.nextDouble();
        double square_num = Math.pow(l,2);
        System.out.println ("The square of "+l+ "is "+square_num);

//question 9--------------------------------------finding the discount 

Scanner sc;
int dis;float totexp;
sc = new Scanner(System.in);
System.out.println ("Enter the quantity and price");
int qty = sc.nextInt();
float price = sc.nextFloat();

if(qty > 1000)
	dis = 10;
else
	dis = 0;
totexp = qty*price - qty*price*dis/100;
system.out.println ("total xpense = " +totexp  "total discount = " +dis);

// question 10-------------------------------------------

int m1, m2, m3 , avg, i =1;
Scanner sc;
for (i = 1; i <= 10; i++)
{
	sc = new Scanner (System.in);
	m1 = sc. nextInt ();
	m2 = sc. nextInt();
	m3 = sc.nextInt();
	avg = (m1+m2+m3)/100;
	System.out.println(avg);

//-----------------------------------------------------------------------



    }
}
