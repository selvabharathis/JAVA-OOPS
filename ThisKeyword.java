package doodleblue10_12_19;
/**
 *
 * @author Selvabharathi S
 * THEORY
 *      1) Keyword THIS is a reference variable in Java that refers to the current object
 *      2) It can be used to refer instance variable of current class
 *      3) It can be used to invoke or initiate current class constructor
 *      4) It can be passed as an argument in the method call
 *      5) It can be passed as argument in the constructor call
 *      6) It can be used to return the current class instance
 * UNDERSTANDING
 *      to avoid naming conflict
 */
public class ThisKeyword 
{
   int a;// instance variable
   int b;// instance variable

 public void setData(int a ,int b)
 {
  this.a = a;
  this.b = b;
 }
 public void showData()
 {
   System.out.println("Value of A ="+a);
   System.out.println("Value of B ="+b);
 }
 public static void main(String args[])
 {
   ThisKeyword obj = new ThisKeyword();
   obj.setData(2,3);
   obj.showData();
 }

}
