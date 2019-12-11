package doodleblue10_12_19;
/**
 *
 * @author Selvabharathi S
 * THEORY
 *      1) it is a technique where, one object acquire all the properties
 *          and behaviors of a parent object.
 *      2) one classes variable and function(called parent) can be inherited
 *         and used in other class (called child).
 *      3) it represent IS-A relationship also called as parent-child relationship.
 *      4) class , subclass or child class, super class or parent class.
 *      5) types of inheritance ; extends keyword is used to inherit
 *          > single
 *          > multi level
 *          > hierarchical
 *      6) NOTE : multiple and hybrid inheritance is supported through
 *                interface only.
 *              : hybrid is a combination of multiple and hierarchical.
 *      7) IMPORTANT : there can only be one class per .java file. But we can have nested class.
 *      $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
 *      1) Method Overriding is a feature that allow a child class to provide some specific
 *         implementation of a method that is already provided by parent class.
 *      2) here the method will have same name, same return type, same arguments list.
 *      3) rules for method overriding.
 *          > access modifiers can allow more, but not less.
 *            i.e parent class can have protected or public, but child class should
 *            have protected or public. not as private.
 *          > final method can not be overridden.
 *          > static method can not be overridden, when we declare static method it is method hiding.
 *          > private method can not be overridden.
 *          > should have same return type.
 *          > we can not override constructor. as both class name varies.
 *          > abstract class...
 *          > exception handling...
 *      4) we can invoke overridden method from child class using a super keyword.
 *          > it is a reference variable, used to refer immediate parent class object.
 *          > used to invoke immediate parent class constructor.
 *          > As we know well that default constructor is provided by compiler automatically if there is no constructor. 
 *            But, it also adds super() as the first statement.
 *      
 *          
 * UNDERSTANDING
 *      1) we can reuse some function defined in some other class,
 *         depending on our project modules.
 *      2) it is use full for method overriding.
 *          by which run time polymorphism can be achieved.
 * 
 */
public class Inheritance // main class
{
   public class Inheritance_1// parent class
   {
       String food="petegeri";// it is an instance variable
       public void eat()
        {
            System.out.println("eating..");
        }
        protected void show()
        {
            System.out.println("Parent");
        }
   }
   static public class Inheritance_2 extends Inheritance_1// child class, as we used nested class and inherited, it need to be static to be called in other class.
    {
       String food="meat";// it is an instance variable, variable overloading.
        void bark()
        {
            System.out.println("barking..");
        }
       
        public void show()// method overriding, same name in parent class, same return type etc.
        {
            System.out.println("Child");
        }
        protected void food()
        {
            System.out.println("child food is "+food);
            System.out.println("parent food is "+super.food);//invoking super keyword to refer the parent class.
        }
    }

   public static void main(String args[])
   {
       Inheritance_2 obj = new Inheritance_2();// creating object for child class.
       obj.bark();// calling function inside child class using child class object.
       obj.eat();// calling function inside parent class using child class object.
       obj.show();
       obj.food();
   }
}


