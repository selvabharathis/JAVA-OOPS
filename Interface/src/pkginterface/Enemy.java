/*
 * @2020.
 */

package pkginterface;

/*
 * @author Selvabharathi S
 */
public class Enemy implements Character{

    public String weapon = "LightSaber";
    
    public Enemy(){
        
    }
    
    @Override
    public void attack() {
        System.out.println("The enemy attacks you");
    }

    @Override
    public void heal() {
        System.out.println("the enemy heals himself");
    }
    
    public void weaponDraw(){
        System.out.println("draw out weapon");
    }

    @Override
    public String getWeapon() {
        return weapon;
    }
}
