/*
 * @2020.
 */

package PassDataUsingInterface;

/*
 * @author Selvabharathi S
 */
public class TestOne{ 
    
    public static void main(String args[]){

        ISample interfaceObj = new ISample()
        {
            @Override
            public int getSample() {
                return 1;
            }

            @Override
            public void putSampleString(String data) {
                System.out.println(data);
            }

            @Override
            public String getSampleString() {
                return "str";
            }
        };
        
        TestTwo obj = new TestTwo();
        
        obj.setSampleInterface(interfaceObj);
        

    }

}
