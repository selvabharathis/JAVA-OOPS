/*
 * @2020.
 */

package PassDataUsingInterface;

/*
 * @author Selvabharathi S
 */
public class TestTwo {
    
    ISample interfaceObj;
    
    void setData(){
        interfaceObj.putSampleString("test");
        int a = interfaceObj.getSample();
        System.out.println(a);
        System.out.println(interfaceObj.getSampleString());
    }
    
    void setSampleInterface(ISample interfaceObj){
        this.interfaceObj = interfaceObj;
        setData();
    }
}
