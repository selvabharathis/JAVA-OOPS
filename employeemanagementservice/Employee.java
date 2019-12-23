package employeemanagementservice;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Selvabharathi S
 */
public class Employee extends Department // INHERITANCE
{
        protected EmployeeInterface menuEmpObj = new EmployeeInterface(){         // CONCRET INNER CLASS
        @Override                                                                // METHOD OVERLOADING - POLYMORPHISM
        public void employeeMenu(){
            System.out.println("\n1. List Employees");
            System.out.println("2. Remove Employee");
            System.out.println("3. Change Mentor");
            System.out.println("4. View Mentor");
            System.out.println("5. Add Employee");
            System.out.println("6. Menu\n");
        }
        @Override
        public void createEmployee(String empName,int empId,int depId){
            DepartmentModelClass tempObj = deptHashObj.get(depId);
            ArrayList<EmployeeModelClass> empArray = tempObj.getEmployeeArray();
            if(empArray == null)
                empArray = new ArrayList();
            EmployeeModelClass empObj = new EmployeeModelClass();
            empObj.setEmpId(empId);
            empObj.setEmpName(empName);
            empArray.add(empObj);
            tempObj.setEmployeeArray(empArray);
            empObj = empArray.get(0);
            tempObj.setMentorName(empObj.getEmpName());
            deptHashObj.put(depId, tempObj);
            System.out.println("New employee added successfully.");
        }
        @Override
        public void listEmployee(int deptId)
        {
            DepartmentModelClass tempObj = deptHashObj.get(deptId);
            if(tempObj == null)
                System.out.println("No department is found");
            else
            {
                ArrayList<EmployeeModelClass> empArray = tempObj.getEmployeeArray();
                if(empArray == null || empArray.isEmpty())  
                    System.out.println("No employee available");
                else
                {
                   int sNum = 1;
                   for(int i=0;i<empArray.size();i++)
                   {
                        System.out.println(sNum+". "+empArray.get(i).getEmpId()+"-"+empArray.get(i).getEmpName());
                        sNum++;
                   } 
                } 
            }
        }
        @Override
        public void removeEmployee(int deptId) 
        {
            if(deptHashObj.containsKey(deptId))
            {
                DepartmentModelClass tempObj = deptHashObj.get(deptId);
                if(tempObj == null)
                    System.out.println("No department is found");
                else
                {
                    ArrayList<EmployeeModelClass> empArray = tempObj.getEmployeeArray();
                    if(empArray == null  || empArray.isEmpty())  
                        System.out.println("Employee list is empty");
                    else
                    {
                        Scanner inputScanner = new Scanner(System.in);
                        System.out.print("Enter Employee Id to remove : ");
                        int delete = inputScanner.nextInt();
                        for(int i=0;i<empArray.size();i++)
                        {
                            if(empArray.get(i).getEmpId() == delete)
                                empArray.remove(i);
                        }
                        tempObj.setMentorName(empArray.get(0).getEmpName());
                        tempObj.setEmployeeArray(empArray);
                        deptHashObj.put(deptId, tempObj);
                        System.out.println("Employee removed successfully."); 
                    }   
                }
            }
            else
                System.out.println("the entered department ID is not found");
        }
    }; 
}
