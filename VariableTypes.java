package doodleblue10_12_19;
/**
 *
 * @author Selvabharathi S
 * THEORY
 *      1) There are 3 types of variable declaration available in java.
 *         > local variable
 *         > instance variables
 *         > class/static  variable
 *      2) Local variables
 *         > are declared in function, constructors, or any blocks.
 *         > they are created for temporary use, once block ends, they
 *           will be released from the memory allocation, and destroyed.
 *         > it is local and available to only that particular block.
 *         > local variable should be initialized always.
 *         > access modifier cannot be used.
 *      3) Instance variables
 *         > declared in a class, but outside a method, constructor or any block.
 *         > Instance variables are created when an object is created with the use 
 *           of the keyword 'new' and destroyed when the object is destroyed
 *         > access modifier can be used.
 *         > it is visible for all within a block.
 *         > it has default values
 *              for numbers = 0
 *              for booleans = false
 *              for object reference = null
 *         > can be accessed directly by calling the variable name inside the class.
 *           but within static method it should be called properly.
 *      4) CLASS/ STATIC variables
 *         > class variable also knows as static variable.
 *         > declared with static keyword
 *         > its visibility is similar to instance variable
 *  UNDERSTANDING/ PURPOSE OF USE
 *      the scope of variable help us to define how and who can handle those variables.
 */        
public class VariableTypes 
{
    public String name="selvabharathi";// it is a instance variable, declare inside a class, not inside function etc.
    private double rollnumber=2016;// it is a instance variable, visible only to  variableTypes class.
    final static String department="Information Technology";// it is a static/class variable
    static void cart()
    {
        int noOfItems=0;//it is a local variable, need to initialize and scope is within this function only
        noOfItems = noOfItems + 5;
        System.out.println("local variable "+noOfItems);
    }
    void printStudentDetails()
    {
        System.out.println("it is instance variable");
        System.out.println("name "+name);// instance variable can be called anywhere
        System.out.println("rollno "+rollnumber);// instance variable can be called anywhere as its access specifier defines
        System.out.println("class/static variable");
        System.out.println("department "+department);// static variable can be called anywhere as its access specifier defines.
    }
    public static void main(String args[])
    {
        cart();
        VariableTypes obj = new VariableTypes(); //create object instance for calling the function printStudentDetails
        obj.printStudentDetails();
    }
}
