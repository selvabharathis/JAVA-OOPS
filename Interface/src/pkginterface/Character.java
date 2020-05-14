/*
 * @2020.
 */
package pkginterface;

/**
 *
 * @author Selvabharathi S
 */
public interface Character {
    public String base = "Character";// we can have properties, it has to be public, and it is final-we cannot change this later
// and it is static-we don't have to create an instance. 
    public void attack(); // no implementation , its abstract method.
    public void heal();
    public String getWeapon(); // these method are by default public and abstract.
}
