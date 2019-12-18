package college;

import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Selvabharathi S
 */

public class Rajalakshmi extends University
{
    IntermediateInterface concretInnerClassObj = new IntermediateInterface(){
     @Override
     public void setResultInterface()
     {
        Scanner scannerInput = new Scanner(System.in);
        for(String num : subject) 
        { 
           System.out.print("enter "+num+" Mark = ");
           int score = scannerInput.nextInt();
           subjectMarkMapping.put(num,score);
        } 
     }
     @Override
     public void getResutlInterface()
     {
         for(Map.Entry<Object,Integer> entry : subjectMarkMapping.entrySet()) 
            System.out.println(entry.getKey()+" mark = "+entry.getValue());
     }
     @Override
     public void addSubjectInterface()
     {
        Scanner scannerInput = new Scanner(System.in);
        System.out.print("enter subject name = ");
        String subName = scannerInput.next();
        subject.add(subName);
     }
     public void removeSubjectInterface()
     {
        Scanner scannerInput = new Scanner(System.in);
        System.out.print("enter subject name to remove = ");
        String subName = scannerInput.next();
        subject.remove(subName);
     }
    };
    public void setRecResult()
    {
        Scanner scannerInput = new Scanner(System.in);
        for(String num : subject) 
        { 
           System.out.print("enter "+num+" Mark = ");
           int score = scannerInput.nextInt();
           subjectMarkMapping.put(num,score);
        }
    }
    public void getRecResult()
    {
        for (Map.Entry<Object,Integer> entry : subjectMarkMapping.entrySet()) 
            System.out.println(entry.getKey()+" mark = "+entry.getValue());
    }
}