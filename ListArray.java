package doodleblue10_12_19;
import java.util.*;
/**
 *
 * @author Selvabharathi S
 * THEORY
 *      1) it is a part of collection framework, present in java.util package. 
 *      2) it will be slower than normal array, as it provide dynamic content.
 *      3) it allow us to
 *          > it is initialized by a size, and latter can be increased and decreased.
 *          > randomly access the list.
 *          > it can not be used for primitive types, like int,char etc.
 *      4) s/x
 *           ArrayList<Integer> arr= new ArrayList<Integer>(Size);
 *         
 */    
public class ListArray
{
    public static void main(String args[])
    {
        ArrayList<Integer> myarray = new ArrayList<Integer>();
        myarray.add(100);//append new element at the end of the list.
        System.out.println(myarray);//print all element
        myarray.add(200);//append at end
        System.out.println(myarray);//print all element
        myarray.remove(1);//remove element at index 1 
        System.out.println(myarray);//print all element
        System.out.println(myarray.get(0));//print element at index 0
        myarray.clear();//remove all element from the array list.
        myarray.add(500);
        myarray.add(400);
        myarray.add(300);
        myarray.contains(100);//check if 100 is in array list
        for(int i=0;i<myarray.size();i++)
            System.out.println(myarray.get(i));
        Collections.sort(myarray);// sort the array list
    }
}
