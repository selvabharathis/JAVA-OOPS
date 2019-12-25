package employeemanagementservice;

import java.util.Scanner;

public class EmployeeManagementService extends Employee           // INHERITANCE
{
      public static void main(String args[])
      {
          boolean flag=true;
          int deptId = 100,empId = 101;
          Scanner inputScanner = new Scanner(System.in);
          Employee operate = new Employee();
          while(true)
          {
              operate.menuDeptObj.mainMenu();
              System.out.print("enter your choice = ");
              int choice1 = inputScanner.nextInt();
              switch(choice1)
              {
                  case 1:// LIST DEPARTMENT1
                            operate.menuDeptObj.showDepartment();
                            int deptSelectById = operate.menuDeptObj.listDepartment();
                            if(deptSelectById == 6)
                                break;
                            else
                            {
                                flag = true;                                        
                                while(flag)
                                {                                    
                                    operate.menuEmpObj.employeeMenu();
                                    System.out.print("enter your choice = ");
                                    int choice2 = inputScanner.nextInt();                                
                                    switch(choice2)
                                    {
                                        case 1://LIST EMPLOYEES
                                            operate.menuEmpObj.listEmployee(deptSelectById);
                                            break;
                                        case 2://REMOVE EMPLOYEE
                                            operate.menuEmpObj.removeEmployee(deptSelectById);
                                            break;
                                        case 3://CHANGE MENTOR
                                            System.out.print("enter new mentor id = ");
                                            int newMentorId = inputScanner.nextInt();
                                            operate.menuDeptObj.changeMentor(newMentorId,deptSelectById);
                                            break;
                                        case 4://VIEW MENTOR
                                            operate.menuDeptObj.viewMentor(deptSelectById);
                                            break;
                                        case 5://ADD EMPLOYEE
                                            System.out.print("Enter Employee name = ");
                                            String empNameTemp = inputScanner.next();
                                            operate.menuEmpObj.createEmployee(empNameTemp,empId++,deptSelectById);
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
                      operate.menuDeptObj.createDepartment(deptNameTemp,deptId++);
                      break;
                  case 3:// REMOVE DEPARTMENT
                      if(operate.deptHashObj.isEmpty())
                          System.out.println("Department list is empty");
                      else
                      {
                         System.out.print("Enter department id to remove : ");
                         int depId = inputScanner.nextInt();
                         if(operate.deptHashObj.containsKey(depId))
                         {
                            operate.deptHashObj.remove(depId);
                            System.out.println("Department removed successfully."); 
                         }
                         else
                             System.out.println("the entered department ID is not found");
                      }
                      break;
                  case 4:// LIST MENTORS
                      operate.menuDeptObj.listMentor();
                      break;
                  case 5:
                      System.exit(0);
                  default:
                      System.out.println("INVALID CHOICE");
              }
          } 
      }
 }
