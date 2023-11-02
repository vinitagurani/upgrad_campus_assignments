// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        //-------------------------------------------COMPOSITION/CONTAINERSHIP----------------------------------------------
        Book b1 = new Book("The silent patient", "James");
        Book b2 = new Book ("monk", "robin");
        Book.addBook(b1);
        Book.addBook(b2);
        Book.display();
        Book.removeBook(b1);
        System.out.println ("after removing the b1 book");
        Book.display();
        //--------------------------------------------------------------------------------------------
        Bank acc1 = new Bank (123456, 2000, "sehna");
        Bank acc2 = new Bank (78894, 10000, "sashi");
        Bank acc3 = new Bank (2246626, 40000, "Vinita");
        Bank.addacc(acc1);
        Bank.addacc(acc2);
        Bank.addacc(acc3);
        Bank.display();
        Bank.removeacc(acc1);
        System.out.println ("After removing the account 1");
        Bank.display();
        //-----------------------------------------------------------------------------------------------
        Student s1 = new Student ("vini", 25);
        s1.display();
        s1.addcourse("english");
        s1.addcourse("computer");
        s1.display_course();
        s1.removecourse("english");
        System.out.println ("after removing the course english");
        s1.display_course();
        //------------------------------------------------------------------------------------------------
        Books book1= new Books("abc", "xyz");
        Books book2= new Books("456", "ijk");
        Library.addBook(book1);
        Library.addBook(book2);
        Library. display();
        Library.removeBook(book1);
        System.out.println ("after removing book1");
        Library.display();
        //-------------------------------------------------------------------------------------------------------
        Product p1 = new Product ("Trademill", 120);
        Product p2 = new Product ("Cycle", 50);
        p1.display();
        p2.display();
        Inventory.addProduct(p1);
        Inventory.addProduct(p2);
        Inventory.checkInventory(p1);
        Inventory.checkInventory(p2);
        //--------------------------------------------------------------------------------------------------------
        bcche bc1 = new bcche("vinita", 25);
        bcche bc2= new bcche("veenal", 10);
        bcche bc3= new bcche("vini", 20);

        Teachers t1 = new Teachers("asha", "English");
        Teachers t2 = new Teachers("Rani", "Hindi");
        Teachers t3 = new Teachers("hema", "Science");

        Sclass class1 = new Sclass ("English", t1);
        Sclass class2 = new Sclass ("Hindi", t2);
        Sclass class3 = new Sclass ("Science", t3);

        class1.addBcche(bc1);
        class1.addBcche(bc2);
        class2.addBcche(bc1);
        class2.addBcche(bc2);
        class2.addBcche(bc3);
        class3 .addBcche(bc3);

        School.addClassess(class1);
        School.addClassess(class2);
        School.addClassess(class3);

        School.addTeacher(t1);
        School.addTeacher(t2);
        School.addTeacher(t3);

        School.getClassess();
        class1.getBccheArray();
        //----------------------------------------------------------------------------
        Movie m1 = new Movie("rrr", "rajmouli", new ArrayList<String>(Arrays.asList("abc", "xyz")));// new
        Review r1 = new Review("vini", "great", 5);
        Review r2 = new Review("deepa", "no", 5.8);
        m1.addReview(r1);
        m1.addReview(r2);
        System.out.println ("the movie "+m1.getMovieName()+ " is directed by "+m1.getDirector());
        for (Review r: m1.getReviews()){
            System.out.println ("The review given by "+r.getName()+ " says that "+r.getText()+ " rating is "+r.getRating()); // new
        }
        //---------------------------------------------------INHERITANCE---------------------------------------
        Dog d = new Dog();
        d.makeSound();
        //-------------------------------------------------------------------
        Vehicle v  =new Vehicle();
        v.drive();
        Car car = new Car();
        car.drive();
        //-------------------------------------------------------------------
        Employee e = new Employee (60000);
        HRmanager mgr = new HRmanager(80000);
        e.work();
        e.getSalary();
        mgr.work();
        mgr.getSalary();
        Employee e1 = new Employee (12000);
        mgr.addEmployee(e1);
        //------------------------------------------------------------------
        Account a1 = new Account("Vinita", 100000000);
        //a1.balance= 10; // why it is accessing in the main method.
        a1.deposit(100);
        a1.withdraw(10);
        Saving sav1= new Saving("Alice", 500000);
        //sav1.balance= 10; // here also it is accessed although it ia protected variable
        sav1.deposit(200);
        sav1.withdraw(5000);
        //-----------------------------------------------------------------
        Person p = new Person ("Binod", "Sharma");
        System.out.println ("The first name of the person is "+p.getFirstName());
        System.out.println ("The first name of the person is "+p.getLastName());
        Employees es = new Employees("hazel", "khan", "Software developer");
        System.out.println("The "+es.getFirstName()+ " works as a  "+es.getLastName());
        //-------------------------------------------------------------------
    }
}
class Person {
    private String firstName;
    private String lastName;
    public Person (String firstName, String lastName){
        this.firstName= firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
}
class Employees extends Person{
    private String jobTitle;
    public Employees (String fm, String ln, String jobTitle){
        super (fm, ln);
        this.jobTitle = jobTitle;
    }

    @Override
    public String getLastName() {
        return jobTitle;
    }
}
class Account {
    private String name;
    protected int balance;
    public Account (String name, int balance){
        this.name = name;
        this. balance = balance;
    }
    public void withdraw (int b){
        balance -= b;
        System.out.println ("The balance after withdrawing the "+b+ " amount is "+balance);
    }
    public void deposit (int b){
        balance += b;
        System.out.println ("The balance after depositing the amount "+ b+ " is "+ balance);
    }
}
class Saving extends Account{
    public Saving (String name, int balance){
        super (name, balance);
    }

    @Override
    public void withdraw(int b) {
        if (balance < 100 ){
            System.out.println ("The withdrawal is not allowed");
        }
        else
        {
            balance -= b;
            System.out.println ("The balance after withdrawing the amount "+b+ " is "+ balance);
        }
    }
}
class Employee {
    private int salary;
    public Employee (int salary){
        this.salary = salary;
    }
    public void work(){
        System.out.println ("Working as an employee");
    }
    public void getSalary(){
        System.out.println ("The salary of the employee is "+salary);
    }
}
class HRmanager extends Employee {
    public HRmanager (int salary){
        super(salary);
    }
    public void work(){
        System.out.println ("Works as a manager");
    }
    public void addEmployee (Employee e){
        System.out.println ("Adding new employee");

    }
}
class Vehicle {
    public void drive(){
        System.out.println ("The car is driving");
    }
}
class Car extends Vehicle {
    @Override
    public void drive (){
        System.out.println ("Overriden: The car is repairing");
    }
}
class Animal {
    public void makeSound(){
        System.out.println ("sound");
    }
}
class Dog extends Animal {
    public void makeSound (){
        System.out.println ("overridden: bark!");
    }
}
class Movie {
    private String movieName;
    private String director;
    private ArrayList<String> actors = new ArrayList<>();
    private ArrayList<Review> reviews = new ArrayList<>();

    public Movie (String name, String d, ArrayList<String >ac ){
        movieName = name;
        director = d;
        actors = ac;
    }
    public void addReview (Review r){
        reviews.add(r);
    }
    public void removeReviews (Review r)
    {
        reviews.remove(r);
    }

    public String getMovieName() {
        return movieName;
    }

    public String getDirector() {
        return director;
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }
}
class Review {
    private String name;
    private String text;
    private double rating;
    public Review (String name, String text, double rating){
        this.name = name;
        this.text = text;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public double getRating() {
        return rating;
    }
}
class School {
    private static ArrayList<Sclass> classess = new ArrayList<Sclass>();
    private static ArrayList<Teachers> teacher = new ArrayList<Teachers>();

    public static void addClassess(Sclass c) {
        classess.add(c);
    }

    public static void removeClassess(Sclass c) {
        classess.remove(c);
    }

    public static void addTeacher(Teachers t) {
        teacher.add(t);
    }

    public static void removeTeacher(Teachers t) {
        teacher.remove(t);
    }

    public static void getClassess() {
       for (Sclass sc: classess){
           System.out.println ("class name: " +sc.getClassName()+" teachers name: "+sc.getTeacher().getName());
       }
    }


    public static ArrayList<Teachers> getTeacher() {
        return teacher;
    }
}


class Sclass {
    Teachers teacher;
    ArrayList<bcche> bccheArray = new ArrayList<bcche>();
    private String className;
    public Sclass (String className, Teachers teacher){
        this.className = className;
        this.teacher = teacher;
    }
    public String getClassName(){
        return className;
    }

    public Teachers getTeacher() {
        return teacher;
    }
    public void addBcche(bcche b){
        bccheArray.add(b);
    }
    public void removeBcche(bcche b){
        bccheArray.remove (b);
    }
    public void getBccheArray(){
      for (bcche b: bccheArray){
          System.out.println ("Student name: "+b.getName()+" , student age: "+b.getAge());
      }
    }
}
class bcche {
    private String name;
    private int age;
    public bcche(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
}
class Teachers {
    private final String name;
    private String subject;
    public Teachers(String name, String subject){
        this.name = name;
        this.subject = subject;
    }
    public String getName(){
        return name;
    }
    public String getSubject(){
        return subject;
    }
}
class Product {
    private String name;
    private int quantity;
    public Product (String name, int quantity){
        this.name = name;
        this.quantity = quantity;
    }
    public String getName (){
        return name;
    }
    public int getQuantity (){
        return quantity;
    }
    public void display (){
        System.out.println ("The product "+name+ " has quantity "+quantity);
    }
}
class Inventory {
    private static ArrayList<Product> products = new ArrayList<Product>();
    public static void addProduct (Product p){
        products.add(p);
    }
    public static void removeProduct (Product p){
        products.remove(p);
    }
    public static void checkInventory (Product p){
        if (p.getQuantity() >100){
            System.out.println ("The quantity of product "+p.getName()+ " is " +p.getQuantity());
        }
        else
            System.out.println ("the product quantity " +p.getQuantity()+" is less than 100 ");
    }
}
class Books {
    private String title;
    private String name;
    public Books(String title, String name){
        this.title = title ;
        this.name = name;
    }
    public String getTitle(){
        return title;
    }
    public String getName(){
        return name;
    }
}
class Library {
    private static ArrayList<Books> library= new ArrayList<Books>();
    public static void addBook (Books b){
        library.add(b);
    }
    public static void removeBook (Books b){
        library.remove(b);
    }
    public static void  display (){
        for (Books b:library){
            System.out.println ("title: "+b.getTitle()+ ", name: "+b.getName());
        }
    }
}
class Student {
    private String name;
    private int age;
    private ArrayList<String>courses = new ArrayList<String>();
    public Student (String name, int age){
        this.name = name;
        this.age = age;
    }
    public void addcourse(String course){
        courses.add(course);
    }
    public void removecourse(String course){
        courses.remove (course);
    }
    public void display (){
        System.out.println ("name: "+name+", age: "+age);
    }
    public void display_course(){
        for (String c:courses){
            System.out.println (c);
        }
    }
}
class Bank {
    private int accno;
    private int balance;
    private String name;
    private static ArrayList<Bank> accounts = new ArrayList<Bank>();
    public Bank (int accno, int balance, String name ){
        this.accno= accno;
        this.balance = balance;
        this. name = name;
    }

    public int getAccno() {
        return accno;
    }

    public int getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }
    public void deposit (int amount){
        balance += balance;
    }
    public void withdraw (int amount){
        balance -= balance;
    }
    public static void addacc (Bank acc){
        accounts.add(acc);
    }
    public static void removeacc (Bank acc){
        accounts.remove(acc);
    }
    public static void display(){
        for (Bank account :accounts){
            System.out.println ("Account number: "+account.getAccno() +", name: "+account.getName()+ ", balance: "+account.getBalance());
        }
    }


}
 class Book {
    private String  title ;
    private String name;
    private static ArrayList<Book> bookCollection = new ArrayList<Book>();
    public Book (String title, String name){
        this.title = title ;
        this.name = name;
    }

     public String getTitle() {
         return title;
     }

     public String getName() {
         return name;
     }

     public static ArrayList<Book> getBookCollection() {
         return bookCollection;
     }
     public static void addBook (Book b){
        bookCollection.add(b);
     }
     public static void removeBook (Book b)
     {
         bookCollection.remove(b);
     }
     public static void display (){
        for (Book i: bookCollection){
            System.out.println ("title: "+i.getTitle()+ ", name: "+i.getName());
        }
     }
 }
