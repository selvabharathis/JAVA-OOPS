package employeemanagement;

import java.util.Scanner;

public class EmployeeManagement extends Operations           // INHERITANCE
{
      public static void main(String args[])
      {
          boolean flag=true;
          int deptId = 100,empId = 101;
          Scanner inputScanner = new Scanner(System.in);
          Operations operate= new Operations();
          while(true)
          {
              operate.menuObj.mainMenu();
              System.out.print("enter your choice = ");
              int choice1 = inputScanner.nextInt();
              switch(choice1)
              {
                  case 1:// LIST DEPARTMENT1
                            operate.menuObj.showDepartment();
                            int deptSelectById = operate.menuObj.listDepartment();
                            if(deptSelectById == 6)
                                break;
                            else
                            {
                                flag = true;                                        
                                while(flag)
                                {                                    
                                    operate.menuObj.employeeMenu();
                                    System.out.print("enter your choice = ");
                                    int choice2 = inputScanner.nextInt();                                
                                    switch(choice2)
                                    {
                                        case 1://LIST EMPLOYEES
                                            operate.menuObj.listEmployee(deptSelectById);
                                            break;
                                        case 2://REMOVE EMPLOYEE
                                            operate.menuObj.removeEmployee(deptSelectById);
                                            break;
                                        case 3://CHANGE MENTOR
                                            System.out.print("enter new mentor id = ");
                                            int newMentorId = inputScanner.nextInt();
                                            operate.menuObj.changeMentor(newMentorId,deptSelectById);
                                            break;
                                        case 4://VIEW MENTOR
                                            operate.menuObj.viewMentor(deptSelectById);
                                            break;
                                        case 5://ADD EMPLOYEE
                                            System.out.print("Enter Employee name = ");
                                            String empNameTemp = inputScanner.next();
                                            operate.menuObj.createEmployee(empNameTemp,empId++,deptSelectById);
                                            break;             
                                        case 6:// GO BACK TO MENU
                                            flag=false;
                                            break;
                                        default:
                                            System.out.println("INVALID CHOICE");
                                    }
                                }
                                    break;
                                }
                  case 2:// ADD DEPARTMENT
                      System.out.print("Enter department name : ");
                      String deptNameTemp = inputScanner.next();
                      operate.menuObj.createDepartment(deptNameTemp,deptId++);
                      break;
                  case 3:// REMOVE DEPARTMENT
                      if(operate.deptHashObj.isEmpty())
                          System.out.println("Department list is empty");
                      else
                      {
                         System.out.print("Enter department id to remove : ");
                         int depId = inputScanner.nextInt();
                         if(operate.deptHashObj.containsKey(deptId))
                         {
                            operate.deptHashObj.remove(depId);
                            System.out.println("Department removed successfully."); 
                         }
                         else
                             System.out.println("the entered department ID is not found");
                      }
                      break;
                  case 4:// LIST MENTORS
                      operate.menuObj.listMentor();
                      break;
                  case 5:
                      System.exit(0);
                  default:
                      System.out.println("INVALID CHOICE");
              }
          } 
      }
 }