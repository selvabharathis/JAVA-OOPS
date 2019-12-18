package college;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 *
 * @author Selvabharathi S
 */
interface Mark
{
    void getResultInterface();
    void setResultInterface();
    void addSubject();
    void removeSubject();
}

public class University 
{
    protected ArrayList<String> subject = new ArrayList<>();  
    protected LinkedHashMap<Object,Integer> subjectMarkMapping = new LinkedHashMap<Object,Integer>();
    protected void showExam()
    {
        int i = 1;
        for (String num : subject) { 
           System.out.println(i+". "+num);
           i++;
      }
    }
    
    protected void showQuestionPaper()
    {
        int i = 1;
        for (String num : subject) { 
           System.out.println(i+". "+num +" Question Paper");
           i++;
      }
    }
    
   /* public void addSubject()
    {
        Scanner scannerInput = new Scanner(System.in);
        System.out.print("enter subject name = ");
        String subName = scannerInput.next();
        subject.add(subName);       
    }
    
    public void removeSubject()
    {
        Scanner scannerInput = new Scanner(System.in);
        System.out.print("enter subject name to remove = ");
        String subName = scannerInput.next();
        subject.remove(subName);
    } */

   /* public int getEngMark() {
        return engMark;
    }

    public void setEngMark(int engMark) {
        this.engMark = engMark;
    }


    public int getHinMark() {
        return hinMark;
    }

    public void setHinMark(int hinMark) {
        this.hinMark = hinMark;
    }


    public int getSciMark() {
        return sciMark;
    }


    public void setSciMark(int sciMark) {
        this.sciMark = sciMark;
    }

    public int getMatMark() {
        return matMark;
    }

    public void setMatMark(int matMark) {
        this.matMark = matMark;
    } */
}