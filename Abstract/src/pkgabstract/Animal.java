/*
 * @2020.
 */
package pkgabstract;

/**
 *
 * @author Selvabharathi S
 */
/*
    - abstract class : class with at least one abstract method, method declared without an implementation.
    - may have abstract and non-abstract methods
    - cannot be initialized
    - abstract method: dont have a body
    - classes that extend abstract classes must implement abstract method or be abstract themselves.
    - since abstract class cannot initialized,
        we subclass it, we create subclasses that extend this abstract class, we can instantiate the subclass to then 
        use the method that are in the abstract class.
*/
public abstract class Animal {
    
    private int age;

    public Animal(int age){
        this.age = age;
        System.out.println("An animal has been created");
    }
    
    
    public abstract void eat();
    
    public void sleep(){
        System.out.println("An animal is sleeping");
    }
    
    public int getAge(){
        return age;
    }
    
    public static void main(String[] args) {
        // object is super class of everything
        Dog d = new Dog();
        Cat c = new Cat();
        d.eat();
        c.eat();
        d.sleep();
        c.sleep();
        // casting
        Object dog = new Dog();// we dont have dog method, so we cast dog..
        Dog realDog = (Dog) dog;// now realDog has the dog method; this is object casting
        
        Object str ="east";
        String realStr = (String)str;
        
        Dog doggy = new Dog();
        if(doggy instanceof Animal){          // doggy is subclass of animal -- return true
            Animal animal = (Animal)doggy;    // even we casted animal to doggy, we don't loose the essence of dog (sleep); this line means , doesnot matter what doggy was before, we just are now guaranteed that we use animal were gonna have all of the animal methods  
            animal.sleep();
            // animal.ruff(); we dont have the dog method because we have casted it to the animal
            // but the overridden method are preserved with this casting operation, thats why we get sleep method of dog.
        }
        doggy.sleep();
    }
    
}
