/*
 * @2020.
 */
package inheritance;

/*
 * @author Selvabharathi S
 */
public class Dog extends Animal{
   
    public Dog(){
       super(15);// using super we are calling the parent constructor. with one parameter
       System.out.println("A dog has been created");
   }
   
   public void ruff(){
       System.out.println("The dog says ruff");
   }
   
   public void run(){
       System.out.println("A dog is running");
   }
   
}
