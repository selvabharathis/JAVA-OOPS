/*
    TEST START : 23/12/19
    TEST END   ; 7/1/19
    TEST TITLE : Free Lancer Management
    collaboration operation pending
*/
package test;

import java.util.Scanner;

public class Admin                                                              // CLASS
{
    public static void main(String[] args) 
    {
        boolean flag = true;                                                    // LOCAL VARIABLE
        Company comp = new Company(100);
        Scanner getUserInput = new Scanner(System.in);
        while(true)
        {
            flag = true;
            comp.mainMenu();
            System.out.print("Enter your choice = ");
            int choiceOne = getUserInput.nextInt();
            switch(choiceOne)                                                   
            {
                case 1:// List Company
                    int status = comp.listCompany();
                    if(status == 1)
                    {
                        System.out.print("enter company ID to view in detail = ");
                        int compId = getUserInput.nextInt();
                        if(comp.verifyCompanyId(compId))
                        {
                            while(flag)
                            {
                                comp.subMenu();
                                System.out.print("Enter your choice = ");
                                int choiceTwo = getUserInput.nextInt();
                                switch(choiceTwo)
                                {
                                    case 1://project in this company
                                        comp.projectsInCompany(compId);
                                        break;
                                    case 2://free lancer in this company
                                        comp.freeLancerInCompany(compId);
                                        break;
                                    case 3://collaborated compinies
                                        comp.listCollaboratedCompany(compId);                                       
                                        break;
                                    case 4://remove company from collabration
                                        comp.removeCollaboratedCompany(compId);
                                        break;
                                    case 5://add collaborated company
                                        comp.addCollaboratedCompany(compId);
                                        break;
                                    case 6://go back
                                        flag = false;
                                        break;
                                } 
                            }
                        }
                    }
                    break;
                case 2:// Add Company
                    comp.addCompany();
                    break;
                case 3:// Remove Company
                    comp.removeCompany();
                    break;
                case 4:// FreeLancer Menu
                    comp.freeLancer();
                    break;
                case 5:// Project Menu
                    comp.project();
                    break;
                case 6:// Exit
                    System.exit(0);
                default:
                    System.out.println("...INVALID CHOICE...");
            }
        }   
    }  
}
