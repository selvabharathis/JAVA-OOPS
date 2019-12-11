package doodleblue10_12_19;
import java.util.Scanner;
/**
 *
 * @author Selvabharathi S
 * THEORY
 *     1) method overloading is a technique that allow a class to have more
 *        than one function having same name, if their argument list(i.e parameter) are different.
 *     2) In method overloading the return type need to be same. i.e return type of method is not a part of method signature.
 *     3) Three ways to overload a function
 *          > Number of parameters.
 *          > Data type of parameters.
 *          > Sequence of Data type of parameters.
 * UNDERSTANDING/ PURPOSE OF USE
 *     1) when we need to send 2 or 3 parameter and more for some purpose to a method.
 *     2) a common method is used for multiple purpose, which saves the memory.
 *     3) it is use full in dynamic code binding, the method which decide this is don't at runtime,
 *        depending on the object that we use to call that method.
 *     
 */
public class MethodOverloading 
{
    static void measurements(int side)
    {
        System.out.println("Area of square = "+side*side);
    }
    static void measurements(int length, int breadth)
    {
        System.out.println("Area of rectangle = "+length*breadth); 
    }
    static void measurements(int length, int breadth, int height)
    {
        System.out.println("Area of cube = "+length*breadth*height);
    }
    public static void main(String args[])
    {
        int a,b,c,choice;
        Scanner input = new Scanner(System.in);
        System.out.println("choose your option[1-3] = ");
        choice = input.nextInt();
        switch(choice)
        {
            case 1: 
                a = input.nextInt();
                measurements(a);
                break;
            case 2:
                a = input.nextInt();
                b = input.nextInt();
                measurements(a,b);
                break;
            case 3:
                a = input.nextInt();
                b = input.nextInt();
                c = input.nextInt();
                measurements(a,b,c);
                break;
            default:
                System.out.println("INVALID OPTIONS");
        }
    }
}
