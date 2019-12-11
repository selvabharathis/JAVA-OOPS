package doodleblue10_12_19;
/**
 *
 * @author Selvabharathi S
 * THEORY
 *      1) Constructor overloading is a technique of having more 
 *          than one constructor with different parameter lists.
 *      2) each constructor performs a different task
 *      3) it is same as method overloading.
 */
public class ConstructorOverloading
{
    private int id; // instance variable
    private String name; // instance variable
    private int age; // instance variable
    
    ConstructorOverloading(int idTemp,String nameTemp)//constructor with 2 parameter
    {
        id = idTemp;
        name = nameTemp;
    }
    ConstructorOverloading(int idTemp,String nameTemp,int ageTemp)//constructor with 3 parameter
    {
        id = idTemp;
        name = nameTemp;
        age = ageTemp;
    }
    void display() 
    {
        System.out.println("id "+id+" name "+name+" age "+age);
    }
    public static void main(String args[])
    {
        ConstructorOverloading object1 = new ConstructorOverloading(2016,"selva");
        object1.display();
        ConstructorOverloading object2 = new ConstructorOverloading(2016,"selva",21);
        object2.display();
    }
}
