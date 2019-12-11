package doodleblue10_12_19;
/**
 *
 * @author Selvabharathi S
 * THEORY
 *      1) it is a technique to wrap variable and function together.
 *      2) in this technique variable of one class will be hidden from 
 *          other class, and can be accessed only through the methods
 *          of their current class.
 *      3) to achieve this 
 *          > we can declare the variable with some access specifier i.e private at most cases.
 *          > we use 2 operation of function
 *              > getter => get the value to assign to the variable.
 *              > setter => set those value to the private variable specified in the same class.
 *          > the function will be declared as public to interact with outside environment.
 * UNDERSTANDING
 *      1) they are used for data hiding/ abstraction.
 *      2) so that we can fix some privilege for accessing the features we specify in 
 *          our program.
 *      3) The get and set function encapsulation techniques is used to pass data.
 */
public class Encapsulation 
{
    private String name;// instance private variable                         //  
    private String idNum;// instance private variable                        //            
    private int age;// instance private variable                             //
                                                                             //
    public int getAge() //function public access                             //
    {                                                                        // getter function starts here-should be in public
        return age;                                                          //
    }                                                                        //
   public String getName() //function public access                          //
   {                                                                         //
        return name;                                                         //
   }                                                                         //
                                                                             //
   public String getIdNum() //function public access                         //
   {                                                                         //
      return idNum;                                                          //        ENCAPSULATED
   }                                                                         //
                                                                             // setter function starts here-should be in public        
   public void setAge( int newAge) //function public access                  //       
   {                                                                         //
      age = newAge;                                                          //
   }                                                                         //
                                                                             //
   public void setName(String newName) //function public access              //
   {                                                                         //
      name = newName;                                                        //
   }                                                                         //
                                                                             //
   public void setIdNum( String newId) //function public access              //         
   {                                                                         //
      idNum = newId;                                                         //
   }                                                                         //
   public static void main(String args[]) // by default access specier in java is private 
   {
      Encapsulation encap = new Encapsulation();
      encap.setName("selva");
      encap.setAge(21);
      encap.setIdNum("201603090");
      System.out.print("Name : " + encap.getName() + "\nAge : " + encap.getAge());
   }
}
