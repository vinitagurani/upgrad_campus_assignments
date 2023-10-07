// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        int a = 10, b = 20, c = 30, s, sm, p  ;
        double d = 45;
        double r = Math.toRadians(d);
        System.out.println (Math.PI);
        System.out.println(Math.sin(r)); // sin   cos tan and all trigonometric functions take the values in radians form.
        int num = (int) (Math.random() * 20);
        // Math.random() will return random numbers between 0.0 to 1.0, we want the numbers to
        //be between 0 to 20 in the int form hence te typecasting is done and *20 is also done.
        s = calSum(a, b, c);
        sm = sumProd(a,b,c,1);
        p = sumProd (a,b,c,2);
        System.out.println(num);


        // calSum (10, a , 1+c) actual arguments can be variables, expressions or constants
        // nested calls can happen
        // calSum(a, calSum(a,b,c), 10);
        // returned value can be stored or can be ignored.
        System.out.println(sm+ "" +p);

        //------------------------function overloading
        int i = absValue(8);
        long j = absValue(-45545455);
        double d =absValue(-123.456);

    }

    static int calSum(int x, int y, int z)
    {
        return (x+y+z);
    }
    // a, b,c = actual arguments
    //x,y,z = formal arguments.

    static int sumProd (int a ,int b ,int c, int code)
    {
        int ss; int pp;
        ss = a + b + c;
        pp = a*b*c;
        if (code == 1)
            return ss;
        else
            return pp;

    }
    static int absValue (int ii)
    {
        return (ii>0? ii: ii* -1);
    }
    static long absValue (long ll)
    {
        return (ll>0 ? ll: ll* -1);
    }
    static double absValue (double dd)
    {
        return (dd >0 ? dd:dd* -1);
    }
}