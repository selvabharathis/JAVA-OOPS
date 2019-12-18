package college;

import java.util.Scanner;

/**
 *
 * @author Selvabharathi S
 */
public class College 
{
    public static void main(String[] args) 
    {
       Boolean flag1 = true,flag2 = true;
       Scanner scannerInput = new Scanner(System.in);
       Srm srmObj = new Srm();
       Rajalakshmi recObj = new Rajalakshmi();
       while(flag1)
       {
           flag2=true;
           System.out.println("1. SRM");
           System.out.println("2. REC");
           System.out.println("3. EXIT");
           System.out.print("select university = ");
           int choice = scannerInput.nextInt();
           switch(choice)
           {
               case 1:
                   while(flag2)
                   {
                        System.out.println(".....WELCOME TO SRM UNIVERSITY.....");
                        System.out.println("1. Show Exam");
                        System.out.println("2. get Question Paper");
                        System.out.println("3. Enter Results using inheritance");
                        System.out.println("4. Show Results using inheritance");
                        System.out.println("5. Enter Results using interface");
                        System.out.println("6. Show Results using interface");
                        System.out.println("7. add subject using interface");
                        System.out.println("8. remove subject using interface");
                        System.out.println("9. Go back to main menu");
                        System.out.print("select features = ");
                        int choiceSecond =scannerInput.nextInt();
                        switch(choiceSecond)
                        {
                            case 1:
                                srmObj.showExam();
                                break;
                            case 2:
                                srmObj.showQuestionPaper();
                                break;
                            case 3:
                                srmObj.setSrmResult();
                                break;
                            case 4:
                                srmObj.getSrmResult();
                                break;
                            case 5:
                                srmObj.concretInnerClassObj.setResultInterface();
                                break;
                            case 6:
                                srmObj.concretInnerClassObj.getResutlInterface();
                                break;
                            case 7:
                                srmObj.concretInnerClassObj.addSubjectInterface();
                                break;
                            case 8:
                                srmObj.concretInnerClassObj.removeSubjectInterface();
                                break;
                            case 9:
                                flag2 = false;
                                break;
                            default:
                                System.out.println("Invalid Choice");
                        }
                   }
                   break;
               case 2:
                   while(flag2)
                   {
                        System.out.println(".....WELCOME TO REC UNIVERSITY.....");
                        System.out.println("1. Show Exam");
                        System.out.println("2. get Question Paper");
                        System.out.println("3. Enter Results using inheritance");
                        System.out.println("4. Show Results using inheritance");
                        System.out.println("5. Enter Results using interface");
                        System.out.println("6. Show Results using interface");
                        System.out.println("7. add subject using interface");
                        System.out.println("8. remove subject using interface");
                        System.out.println("9. Go back to main menu");
                        System.out.print("select features = ");
                        int choiceSecond =scannerInput.nextInt();
                        switch(choiceSecond)
                        {
                            case 1:
                                recObj.showExam();
                                break;
                            case 2:
                                recObj.showQuestionPaper();
                                break;
                            case 3:
                                recObj.setRecResult();
                                break;       
                            case 4:
                                recObj.getRecResult();
                                break;
                            case 5:
                                recObj.concretInnerClassObj.setResultInterface();
                                break;
                            case 6:
                                recObj.concretInnerClassObj.getResutlInterface();
                                break;
                            case 7:
                                recObj.concretInnerClassObj.addSubjectInterface();
                                break;
                            case 8:
                                recObj.concretInnerClassObj.removeSubjectInterface();
                                break;
                            case 9:
                                flag2 = false;
                                break;
                            default:
                                System.out.println("Invalid Choice");
                        }
                   }
                   break;
               case 3:
                   flag1 = false;
                   break;
               default:
                   System.out.println("invalid choice");
           }
       }
    }
}