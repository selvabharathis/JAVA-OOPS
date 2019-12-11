package doodleblue10_12_19;
/**
 *
 * @author Selvabharathi S
 * THEORY
 *      1) It is the basic of object oriented programming.
 *      2) object are used to invoke the elements(i.e data member, member function) of a class.
 *      3) It is used to create the instance.
 *      4) object can be created at the end of class using ;
 *      5) object can also be created inside main or any other function using the s/x
 *          > class_name object_variable = new class_name();
 *      6) for creating a multiple object which do the same, can be used as array of object.
 *      6) A class is container which contains member function and data member.
 *      7) A class is a blue print for an object.
 */
public class Object // here Object is a class
{
    private int score; // data member
    private int gameId;
    private int playerId;
    public void startGame(int score,int gameId,int playerId) //member function
    {
        System.out.println("your game starts now");
        System.out.println("your score is "+score);
        System.out.println("the game ends");
    }
    public static void main(String args[])
    {
        Object obj = new Object(); //object creation for a class
        obj.score=0; // initialise the datamember as 0, useing dot operator 
        obj.startGame(0,101,201603090);//calling the member function of class using dot operator.
    }
}
