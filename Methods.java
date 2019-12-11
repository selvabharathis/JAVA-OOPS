package doodleblue10_12_19; 

import static doodleblue10_12_19.Biller.printBill3;


/**
 *
 * @author Selvabharathi S
 * THEORY
 *      1) method is also called as function.
 *      2) it contains a set of executable code snippet in a block{}.
 *      3) we can send data to function which is said as parameters to feed in.
 *      4) a method must declare inside a class.
 *      5) we use parentheses () to define a function.
 *      6) s/x for defining a function
 *          return_type functionName(data_types parameter)
 *          {
 *          }
 *      7) s/x for calling a function
 *          fucntionName(parameter_values);
 *      
 * UNDERSTANDING
 *      we use method for reuse of code, most of places we just require 
 *      to use the same logic application, so we write once, and use at
 *      multiple place, by calling those set of codes.
 */
public class Methods // Methods is a class
{
    static void basketModel(int price,String productName)// function-1 definition within the class
    {
        System.out.println("PRODUCT NAME : "+productName+"\nPRODUCT PRICE : "+price);
    }
    static int prepareForBilling(int price)//fucntion-4 with return type, and with argument
    {
        int sum=0;
        sum = price+price;
        return sum;
    }
    public static void main(String args[])
    {
        int sum;
        basketModel(30,"apple");//function-1 call
        sum = prepareForBilling(100);// fucntion-4 call 
        System.out.println(sum);
        Biller object = new Biller();//creating an instance to refer to that class.
        object.printBill(180,"onion");//calling a function-2 outside a class, by creating instance.
        printBill3(87,"carrot");//calling a function-3 outside a class, by importing.
    }
}

class Biller
{
    void printBill(int price,String productName)// function-2 definition within the class, it is a non-static function.
    {
        System.out.println("PRODUCT NAME : "+productName+"\nPRODUCT PRICE : "+price);
    }
    static void printBill3(int price,String productName)//fucntion-3 deficniton within the class, it is a static member function
    {
         System.out.println("PRODUCT NAME : "+productName+"\nPRODUCT PRICE : "+price);
    }
}
