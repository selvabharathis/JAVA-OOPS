package doodleblue10_12_19;
/**
 *
 * @author Selvabharathi S
 * THEORY
 *      1) A constructor is also similar to function, it has some set of code.
 *      2) it is called when an instance(object) of a class is created.
 *      3) it is used to initialize the object.
 *      4) when ever an object is created using new(), a constructor is called.
 *      5) types of constructor in java
 *          > default constructor/ no-argument constructor
 *          > parameterized constructor
 *      6) java compiler creates a default constructor if there is no constructor is created.
 *      7) RULES for creating constructor
 *          > constructor name should be same as class name.
 *          > constructor has no explicit return type
 *          > constructor cannot be abstract, static, final and synchronized.
 * UNDERSTANDING
 *      > default constructor is used to initialize some variables.
 *      > parameterized constructor is used to provide different values to
 *        distinct objects
 */ 
public class Constructor 
{
    private int id; //instance variable
    private String name; //instance variable
    
    Constructor()// default constructor, same name as class name, no static, abstract, final etc.
    {
        System.out.println("it is a default constructor");
    }
    Constructor(int idTemp,String nameTemp)// parameterized constructor
    {
        id = idTemp;
        name = nameTemp;
    }
    
    private void display()
    {
        System.out.println("id "+id+" name "+name);
    }
    
    public static void main(String args[])
    {
        Constructor obj = new Constructor();// during instance creation, default constructor is called.
        Constructor obj1 = new Constructor(2016,"selva");//passing value to constructor
        obj1.display();
        obj.display();
    }
 }

