// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main extends Language { // last program uses language abstract class
    public static void main(String[] args) {
        // 1. program to create a class called "Shape" with abstract methods for calculating area and perimeter,
        // and subclasses for "Rectangle", "Circle", and "Triangle"
        Shape s;
        s = new Circle(2.3);
        System.out.println ("The area of Circle is "+s.area());
        System.out.println ("The perimeter of Circle is "+s.perimeter());
        s = new Rectangle(5,4.9);
        System.out.println ("The area of rectangle is "+s.area());
        System.out.println ("The perimeter of rectangle is "+s.perimeter());
        s = new Triangle (4,5.65);
        System.out.println ("The area of Triangle is "+s.area());
        System.out.println ("The perimeter of triangle is "+s.perimeter());
        //2. program to create an abstract class Animal with an abstract method called sound().
        // Create subclasses Lion and Tiger that extend the Animal class and implement the sound() method to make
        // a specific sound for each animal.
        System.out.println ("---------------------------------------------");
        Animal animal ;
        animal = new Lion();
        System.out.println (animal.sound());
        animal = new Tiger();
        System.out.println (animal.sound());
        //3.program to create an abstract class BankAccount with abstract methods deposit() and withdraw(). Create
        // subclasses: SavingsAccount and CurrentAccount that extend the BankAccount class and implement the respective
        // methods to handle deposits and withdrawals for each account type
        System.out.println ("---------------------------------------------");
        BankAccount bankAccount;
        bankAccount = new SavingAccount(12345, 1000);
        System.out.println ("The current balance:" + BankAccount.getBalance());
        bankAccount.deposit(500);
        bankAccount.withdraw(200);
        bankAccount.withdraw (1400);
        bankAccount = new CurrentAcc(456789, 1500);
        System.out.println ("---Current account---");
        System.out.println ("Current balance:" + BankAccount.getBalance());
        bankAccount.withdraw(500);
        bankAccount.deposit(800);
        //4. program to create an abstract class Employee with abstract methods calculateSalary() and displayInfo().
        // Create subclasses Manager and Programmer that extend the Employee class and implement the respective methods
        // to calculate salary and display information for each role.
        System.out.println ("---------------------------------------------");
        Employee[] e;
        Manager m1 = new Manager("Pradeep", 2);
        Manager m2 = new Manager("Vinita",3);
        Manager m3 = new Manager("Sneha", 5);
        Programmer p1 = new Programmer("krishna", 2);
        Programmer p3 = new Programmer("shivani", 1);
        Programmer p2 = new Programmer("krishna", 3);
        e = new Employee[]{m1, m2, m3, p1,p2,p3}; // I have used upcasted references.
        for (Employee employee : e)
        { // enhanced for loop
            employee.calculateSalary();
            employee.displayinfo();
        }
        //5. program to create an abstract class Shape3D with abstract methods calculateVolume() and calculateSurfaceArea().
        // Create subclasses Sphere and Cube that extend the Shape3D class and implement the respective methods to
        // calculate the volume and surface area of each shape.
        System.out.println ("---------------------------------------------");
        Shape3D shape;
        shape = new Cube(5);
        shape.volume();
        shape.surfaceArea();
        shape.displayInfo();
        shape = new Sphere(6);
        shape.volume();
        shape.surfaceArea();
        shape.displayInfo();
        //6. program to create an abstract class Vehicle with abstract methods startEngine() and stopEngine().
        // Create subclasses Car and Motorcycle that extend the Vehicle class and implement the respective methods to
        // start and stop the engines for each vehicle type
        System.out.println ("---------------------------------------");
        vehicle v ;
        v = new car();
        v.startEngine();
        v.stopEngine();
        v = new Motorcycle();
        v.startEngine();
        v.stopEngine();
        //7.program to create an abstract class Person with abstract methods eat() and exercise(). Create subclasses
        // Athlete and LazyPerson that extend the Person class and implement the respective methods to describe how
        // each person eats and exercises
        System.out.println ("---------------------------------------");
        Person p ;
        p = new Lazy ();
        p.eat();
        p.exercise();
        p = new Athelete();
        p.eat();
        p.exercise();
        //8.
        System.out.println ("---------------------------------------");
        Shapes shapes;
        shapes = new Area();

        System.out.println ("The area of rect is "+ shapes.rectangleArea(4,3.9));
        System.out.println ("The area of circle is "+   shapes.circleArea(5));
        System.out.println ("The area of triangle is "+   shapes.triArea(4,5,8));
        //9. calculating the percentage of marks of 2 students A and B
        System.out.println ("---------------------------------------");
        Marks marks ;
        marks = new A(86,94,77);
        System.out.println ("The per of student A is "+ marks.getPercentage());
        marks = new B(99,100);
        System.out.println ("The per of marks by student B is "+marks.getPercentage());
        //10.making the main class an extention of the abstract class.--------------------------------------------------
        System.out.println ("---------------------------------------");
        Main obj = new Main ();
        obj.display();
    }
}
abstract class Language{
    public  void display(){
        System.out.println ("Hello, this is an abstract class and concrete method");
    }
}
abstract class Marks{
    public abstract  double getPercentage();
}
class A extends Marks {
    private int a;
    private int b;
    private int c;
    public A (int a, int b, int c){
        this.a= a;
        this.b= a;
        this.c= c;
    }
    public double getPercentage (){
        return (double) (a + b + c) /3;
    }
}
class B extends Marks {
    private int a ;
    private int b;
    public B (int a, int b){
        this.a= a;
        this.b = b;
    }
    public double getPercentage (){
        return (double) (a + b) /2;
    }
}
abstract class Shapes {
    public abstract double rectangleArea (double l, double b);
    public abstract double triArea (double l, double b, double h);
    public abstract double circleArea (double radius);

}
class Area extends Shapes {
    public double rectangleArea (double l, double b){
        return (l*b);
    }
    public double triArea (double l, double b, double h){
        return (0.5*b*h);
    }
    public double circleArea (double radius){
        return (Math.PI *Math.pow(radius, 2));
    }
}
abstract class Person {
    public abstract void eat();
    public abstract void exercise();

}
class Lazy extends Person {
    public void eat (){
        System.out.println ("Lazy person eats more carbs and junk");
    }
    public void exercise(){
        System.out.println ("Lazy person does no workout");
    }
}
class Athelete extends Person {
    public void eat (){
        System.out.println ("Athelete does eat protien iron calcium");
    }
    public void exercise (){
        System.out.println ("Athelete does regular exercise");
    }
}
abstract class vehicle {
    public abstract void startEngine();
    public abstract void stopEngine();
}
class car extends vehicle {
    public void startEngine() {
        System.out.println ("Car : Starting the engine");
    }
    public void stopEngine (){
        System.out.println ("Car : stoping the engine");
    }
}
class Motorcycle extends vehicle{
    public void startEngine (){
        System.out.println ("Motorcyle: starting the engine");
    }
    public void stopEngine (){
        System.out.println ("Motorcycle: stopping the engine");
    }
}
abstract class Shape3D{
    // 0- arg constructor inserted by the compiler automatically
    public abstract double volume ();
    public abstract double surfaceArea();
    public void displayInfo (){
        System.out.println("The volume is "+volume()+ " and the surface area is "+surfaceArea());
    }
}
class Cube extends Shape3D{
    private double l;
    public Cube (double l){
        this.l = l;
    }
    public double volume (){
        return (Math.pow(l,3));
    }
    public double surfaceArea(){
        return (6* (Math.pow(l,2)));
    }
}
class Sphere extends Shape3D{
    private double radius;
    public Sphere (double radius){
        this.radius = radius;
    }
    public double volume (){
        return (4*Math.PI*Math.pow(radius,3)/3);
    }
    public double surfaceArea (){
        return (4*Math.PI*Math.pow(radius,2));
    }
}
abstract class Employee {
    protected String name;
    protected int years;
    public Employee(String name, int years){
        this.name = name;
        this.years = years;
    }
    public abstract int calculateSalary();
    public abstract void displayinfo();
}
class Manager extends Employee{
    public Manager (String name, int years){
        super (name, years);
    }
    public int calculateSalary (){
        return (years * 40000);
    }
    public void displayinfo (){
        System.out.println (name+ " is a manager with salary "+calculateSalary());

    }
}
class Programmer extends Employee{
    public Programmer (String name, int years){
        super (name, years);
    }
    public int calculateSalary(){
        return (years*20000);
    }
    public void displayinfo(){
        System.out.println (name+ " is a programmer with salary "+ calculateSalary());
    }
}
abstract class BankAccount{
    private int accno;
    private static  int balance;
    public BankAccount(int accno, int balance){
        this.accno = accno;
        BankAccount. balance = balance;
    }
    public static int getBalance (){ // concrete function, made it static because it is a common property.
        return balance;
    }
    public int getAccno (){
    return accno;}

    public void setBalance(int b){
        balance = b;
    }
    public abstract void deposit(int amount);
    public abstract void withdraw(int amount);
}
class SavingAccount extends BankAccount {

    public SavingAccount(int accno, int balance){
        super (accno, balance);
    }
    public void  deposit (int amount){
        setBalance(getBalance() + amount);
       System.out.println ("The current balance after depositing the "+amount+ " is "+ getBalance());
    }
    public void withdraw (int amount){
        if (getBalance() > amount){
            setBalance(getBalance() - amount);
           System.out.println ("current balance after withdrawing "+ amount+ " is "+getBalance());
        }
        else
            System.out.println ("can not withdraw");
    }
}
class CurrentAcc extends BankAccount{
    public CurrentAcc(int accno, int balance){super (accno, balance);}
    public void  deposit (int amount){
        setBalance(getBalance() + amount);
        System.out.println ( "Crrent balance after depositing the "+amount+ " is "+ getBalance());
    }
    public void  withdraw (int amount){
        if (getBalance() >= amount){
            setBalance(getBalance() - amount);
            System.out.println ("current balance after withdrawing the "+amount+ " is "+getBalance());
        }
        else
           System.out.println ("Operation failed");
    }
}

abstract class Animal {
    public abstract String sound ();
}
class Lion extends Animal {
    public  String sound(){
        return "lion roars";
    }
}
class Tiger extends Animal {
    public String sound (){
        return "Tiger growls";
    }
}

abstract class Shape {
    protected final double PI  = 3.14;
    public abstract double area ();
    public abstract double perimeter ();

}
class Circle extends Shape {
    private double radius ;
    public Circle (double radius){
        this.radius = radius;
    }
    public double area (){
        return (PI * radius *radius );
    }
    public double perimeter (){
        return (2*PI*radius);
    }
}
class Rectangle extends Shape {
    private double length;
    private double breadth;
    public Rectangle (double l, double b){
        length = l;
        breadth = b;
    }
    public double area (){
        return length * breadth;
    }
    public double perimeter (){
        return 2*(length+breadth);
    }
}
class Triangle extends Shape {
    private double length;
    private double heigth;
    public Triangle (double l, double h){
        length = l;
        heigth = h;
    }
    public double area (){
        return (0.5*length *heigth);
    }
    public double perimeter (){
        return (length+length+heigth); // suppose the two sides of the triangle are equal.
    }
}
