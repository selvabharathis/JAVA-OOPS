/*
 * @2020.
 */
package inheritance;

/**
 *
 * @author Selvabharathi S
 */
public class Animal {
    
    private int age;

    public Animal(int age){
        this.age = age;
        System.out.println("An animal has been created");
    }
    
    
    public void eat(){
        System.out.println("An animal is eating");
    }
    
    public int getAge(){
        return age;
    }
    
    public static void main(String[] args) {
        // object is super class of everything
        Animal a = new Animal(5);
        Dog d = new Dog();
        Cat c = new Cat();
        d.ruff();
        System.out.println(d.getAge()); // d.age is private in animal, so we use getter to access it
        c.meow();
        System.out.println(c.getAge());
        a.eat();
        d.eat();
        c.eat();
        d.run();
        c.prance();
        Animal o = new Dog();// a dog is infact an animal; 
        // o is not going to have the access to the method of dog, because: the compiler think o is object of animal.
        // this technique is called, generalized. a subclass can be generalized to a super class.
//        Dog o = new Animal(); we cant do like this.
        // A super class cannot become a more specific subclass.
    }
    // allow us to create new classes from existing classes, reuse code
}
