package doodleblue10_12_19;
/**
 *
 * @author Selvabharathi S
 * THEORY
 *      1) an instance of an abstract class cannot be created. but we can have reference.
 *      2) it can have constructors, and it is called when instance of inherited class
 *          is created.
 *      3) we can have an abstract class without any abstract method.
 *      4) they can have final method
 *      5) way to achieve abstraction are
 *          > abstract class 0 to 100%
 *          > interface 100%
 *          >   access specifiers : private, public, protected, default.
 * $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
 *      1) interface is a technique to achieve multiple inheritance.
 *      2) interface method do not have body. i.e the body is provided by the implement class.
 *      3) on implementation of an interface, you must override all of its methods.
 *      4) interface methods are by default abstract and public.
 *      5) interface attributes(fields or public variable) are by default public,static and final.
 *      6) interface cannot contain constructor. since we cannot create object. 
 *      7) java 8 allow to define method in the interface class by using default.
 *      8) interfaces themselves can have only two access specifiers when declared outside any other class.
 * UNDERSTANDING
 *      it is used to achieve data abstraction.
 *      interface can be used to pass data between classes.
 */
 interface  Moveable // it is a interface-1, it cannot be inside a class.
 {
    public void moveFast(); // body not supported, use other class to define.
 }
 interface Crawlable // it is a interface-2
 {
    default void crawl()// java 8 and above allow method defination
    {
        System.out.println("I am crawling !!");
    }  
 }
public class Abstract implements Moveable, Crawlable // inheriting 2 interface and making multiple inheritance
{
    @Override
    public void moveFast()// intereface method definition, after implementing it. 
    {
        System.out.println("i am moving fast");
    }
    abstract protected class Parent// abstract class definition, this class cannot have objects
    {
        abstract void fun();// abstract method definition
    }
    static private class Child extends Parent // inherited parent class
    {
        protected void fun()//method overriding
        {
          System.out.println("inside child");
        }
    }

    public static void main(String args[]) 
    {
        Parent obj = new Child();// accessing abstract class using child class object.
        obj.fun();
        Abstract object = new Abstract();
        object.crawl();// calling interface-2
        object.moveFast();// calling interface-1
    }
}   
