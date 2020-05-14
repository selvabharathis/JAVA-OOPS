/*
 * @2020.
 */
package pkginterface;

import java.util.Random;

/**
 *
 * @author Selvabharathi S
 */
public class StarWarsInterfacePractise {
    /*
    INTERFACE:
        - a collection of abstract methods
        - no implementations
        - no constructors
        - used to acheive data abstraction
        - used to pass data between classes
    */
    public static Character summonCharacter(){
        Random rand = new Random();
        if(Math.abs(rand.nextInt())%2 == 0){
            return new Enemy();
        }else{
            return new Hero();
        }
    }
            
    public static void main(String[] args) {
        Enemy darthVader = new Enemy();
        Hero ObiWanKanobi = new Hero();
        darthVader.attack();
        ObiWanKanobi.attack();
        darthVader.heal();
        ObiWanKanobi.heal();
        System.out.println("Enemy weapon: "+darthVader.getWeapon());
        System.out.println("Hero weapon: "+ObiWanKanobi.getWeapon());
        Character spy = summonCharacter(); //Character spy = new Enemy() or new Hero;
        spy.attack();
        spy.heal();
    } 
}
/*
    DIFFERENT BETWEEN ABSTRACT CLASS AND INTERFACE
        - A interface is implicitly abstract and cannot have non-abstract method.
        - A abstract class can have non-abstract methods and its own behaviour.
        - variable inside interface, are final,static,public.
        - variable inside abstract class,can be non-final too.
        - interface are implemented using keyword "implements"
        - abstract class are extended using "extends"
        - an interface can extend another interface only.
        - an abstract class can extend another java class and implement multiple interface.
        - a java class can implement multiple interface but it can extend only one abstract class.
*/