import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

//------------1.program to create a base class Animal (Animal Family) with a method called Sound(). Create two subclasses Bird and Cat.
        // Override the Sound() method in each subclass to make a specific sound for each animal

      Animal a = new Bird();  // upcasted references, storing subclass object in superclass reference
      a.sound(); // polymorphism, method behaves differently based on which object is calling it.
      a = new Cat();
      a.sound();

//-----------2.program to create a class Vehicle with a method called speedUp(). Create two subclasses Car and Bicycle. Override the speedUp()
// method in each subclass to increase the vehicle's speed differently.

        Vehicle v = new Car();
        v.speedUp();
        System.out.println ("The speed of car after increasing "+v.getSpeed());
        v = new Bike();
        v.speedUp();
        System.out.println ("The speed of bike after increasing "+v.getSpeed());

//------------ 3. program to create a base class Shape with a method called calculateArea(). Create three subclasses: Circle, Rectangle
// Override the calculateArea() method in each subclass to calculate and return the shape's area.

        Shape s = new Circle (2.5);
        s.calculateArea();
        s = new Rectangle (5,6);
        s.calculateArea();

//-------------4. create a class Employee with a method called calculateSalary(). Create two subclasses Manager and Programmer. In each subclass,
// override the calculateSalary() method to calculate and return the salary based on their specific roles.

        Employee e = new Manager("sujit", 40000,10000);
        e.calculateSalary();
         e = new Programmer("vinita", 50000,20000);
         System.out.println ("---------------------------");
        e.calculateSalary();
//-------------5. create an arraylist of colors amd print out the list------------------------------------------------------------------------

        List <String> colors= new ArrayList<String>();
        colors.add("Red");
        colors.add( 1, "pink");
        colors.add(0, "yellow"); // adding the element
        colors.remove(1); // removing an element
        String Colors[]= {"arraygreen, arraypurple"};

        System.out.println (Arrays.toString(Colors)); // to print the normal array
        //colors.add(100, "brown");
        System.out.println (colors); // to print arraylist.

//------------6. iterate through all the elements of arraylist using for loop-------------------------------------

        List <Integer> integers = new ArrayList<Integer>();
        integers.add(5);
        integers.add(8);
        integers.add(47);
        integers.add(80);
        integers.remove(0);
        integers.add(4);
        integers.add(70);
        for (int element: integers){
            System.out.println (element);
        }

//------------7. retriving an element from arraylist-------------------------------

        System.out.println ("The number at 5th position is "+integers.get(4));

//-----------8. searching for an element-------------------------------------------

        boolean b = integers.contains(4);
        if (b)
            System.out.println ("Integer 4 is present");
        else
            System.out.println ("Integer 4 is absent");

//---------------9. sorting an arraylist without using stream sorted------------------------------------------

//        for (int i = 0; i <integers.size(); i++){
//            for (int j = i+1; j <integers.size(); j++){
//                int tempi= integers.get(i);
//                int tempj = integers.get(j);
//                if (tempi > tempj){
//                    integers.set(i, integers.get(j));
//                    integers.set(j,integers.get(i));
//                }
//            }
//        }
//        System.out.println ("The manual sorted array is "+integers);

//------------10. Collection stream functions-----------------------------------------------------------------
        Collections.sort(integers); // using stream sort, sorting the integers
        System.out.println (integers);

        List <Integer> list2 = new ArrayList <Integer>();
        list2.add(0);
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);


        Collections.copy (list2, integers); // copying the arrays
        System.out.println ("After copying the integer array to list2 array list2 becomes "+list2);

        Collections.shuffle(integers); // shuffle the list
        System.out.println (integers);

        Collections.reverse(integers); // reversing the integers
        List <Integer> subString =  integers.subList(0,2); // extracting portion os a list.

        list2.addAll(integers); // adding all the elements of integers to list2
        System.out.println ("----------"+list2);

        Collections.swap(list2, 0,5);

        subString.removeAll(subString);
        System.out.println ("Is the subString empty? "+subString.isEmpty());

//-------------11. comparing two arraylists------------------------------------------------
        List <Integer> integers1 = new ArrayList <Integer>();
        integers1.add(4);
        integers1.add(5);
        integers1.add(8);
        integers1.add(6);
        integers1.add(7);

        ArrayList <String> compare = new ArrayList<String>();
        for (int i :list2){
            compare.add(integers1.contains(i)? "yes":"no");
        }
        System.out.println ("Compare: "+compare);

//-----------------12. iterating through the elements of linkedlist, moving forward---------------------------------------------------

        List <String> linkedlist = new LinkedList<String>();
        linkedlist.add("one");
        linkedlist.add("two");
        linkedlist.add("three");
        linkedlist.add("four");
        linkedlist.add("five");
        linkedlist.add("six");

        ListIterator <String> itr = linkedlist.listIterator();
        while (itr.hasNext()){
            System.out.print (itr.next() + "  ");
        }

//-----------------13.  program to iterate through all elements in a linked list starting at the specified position.-------------------

        ListIterator <String> pointer = linkedlist.listIterator(2);
        System.out.println ("\n");
        while (pointer.hasNext()){
            System.out.print (pointer.next()+"  ");
        }
//------------------14. iterating linked list in reverse order---------------------------------
        System.out.println ("\n");
        ListIterator <String> head = linkedlist.listIterator(linkedlist.size());
        while (head.hasPrevious()){
            System.out.print(head.previous()+ "  ");
        }

//----------------------15. interface -----------------------------------------------------------
        Searchable find = new Document("Hello, this is vinita ");
        System.out.println ("The document contains vinita: "+find.search("vinita"));

        find = new Webpage("https://github.com/vinitagurani/upgrad_campus_assignments", "This is my upgrad capmus assignments link");
        System.out.println ("The content contains link keyword: "+find.search("link"));

//---------------------16. interface sports----------------------------------------------

        Sports game = new Football();
        game.play();
        game = new Volleyball();
        game.play();

//--------------------17. pen interface-------------------------------------------------

        Pen obj = new FountainPen();
        obj.write();
        obj.refill();
        FountainPen obj2= new FountainPen();
        obj2.changeNib(); // cannot use the interface reference for concrete object that was not declared in the interfce.
        obj2.refill();

//---------------------






//        int integer [] = {1,2,3,4};
//        int sum = 0;
//        for (int i: integer){
//           sum += i;
//        }
//        System.out.println (sum);












    }
}
interface Pen {
    void write ();
    void refill();
}
class FountainPen implements Pen {
    public void write(){
        System.out.println ("interface pen: FountainPen.write");
    }
    public void refill (){
        System.out.println ("interface pen: FountainPen.refill");
    }
    public void changeNib(){
        System.out.println ("concrete function, FountainPen: changeNib.refill");
    }

}
interface Sports {
    void play();
}
class Football implements Sports{
    public void play (){
        System.out.println ("play football");
    }
}
class Volleyball implements Sports {
    public void play (){
        System.out.println ("play volley ball");
    }
}
interface Searchable {
     boolean search (String keyword);
}
class Document implements Searchable {
    private String content;
    public Document(String content){
        this.content = content;
    }
    public boolean search (String keyword){
        return content.contains(keyword);
    }
}
class Webpage implements Searchable{
    private String url;
    private String htmlContent;
    public Webpage (String url, String htmlContent){
        this.url = url;
        this.htmlContent= htmlContent;
    }
    public boolean search (String keyword){
        return htmlContent.contains(keyword);
    }
}
class Employee {
    private String name;
    private String role;
    protected int baseSalary;
    public Employee (String name, String role, int baseSalary){
        this.name = name;
        this.role = role;
        this.baseSalary = baseSalary;
    }
    public void pDetails (){
        System.out.println ("Name: "+name+"\nRole: "+role);
    }
    public void calculateSalary(){
        System.out.println ("call the method using subclass object");
    }
}
class Manager extends Employee{
    private int bonus;
    public Manager (String name, int baseSalary, int bonus){
        super (name, "Manager", baseSalary);
        this.bonus = bonus;
    }
    public void calculateSalary (){
        super.pDetails();
        System.out.println ("salary: "+(baseSalary+bonus));
    }
}
class Programmer extends Employee {
    private int overtime;
    public Programmer (String name, int baseSalary, int overtime){
        super (name, "Programmer",baseSalary);
        this.overtime = overtime;
    }

    public void calculateSalary(){
        super.pDetails();
        System.out.println ("salary: "+(baseSalary+overtime));
    }
}
class Shape {
    public void calculateArea(){
        System.out.println ("please call this method using a object of subclass or make this class abstract");
    }
}
class Circle extends Shape {
    private double radius;
    public Circle (double radius){
        this.radius = radius;
    }
    public void calculateArea(){
        System.out.println ("The area of circle is "+ Math.PI*(Math.pow(radius,2.0)));
    }
}
class Rectangle extends Shape {
    private int l;
    private int b;
    public Rectangle (int l,int b){
        this.l = l;
        this.b=b;
    }
    public void calculateArea (){
        System.out.println ("The area of rectangle is "+ l*b);
    }
}
class Vehicle {
    protected int speed;
    public void speedUp(){
        speed += 10;
    }
    public int getSpeed(){
        return speed;
    }
}
class Car extends Vehicle {
    public void speedUp(){
        super.speedUp();
        speed +=12;
    }
}
class Bike extends Vehicle{
    public void speedUp(){
        super.speedUp();
        speed += 2;
    }
}
class Animal {
    public void sound(){
        System.out.println ("Animal makes a sound");
    }
}
class Bird extends Animal {
    public  void sound(){ // method overriding
        System.out.println ("Bird Chirps");
    }
}
class Cat extends Animal {
    public  void sound() // method overrriding
    {
       System.out.println ( "Cat meows");
    }
}
