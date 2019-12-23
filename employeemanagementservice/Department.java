package employeemanagementservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Selvabharathi S
 */
public class Department 
{
     public HashMap<Integer,DepartmentModelClass> deptHashObj = new HashMap<Integer,DepartmentModelClass>();  // HASH MAP
     protected DepartmentInterface menuDeptObj = new DepartmentInterface(){         // CONCRET INNER CLASS
        @Override                                      // METHOD OVERLOADING - POLYMORPHISM
        public void mainMenu(){
            System.out.println("\t\t\nwelcome to doodle blue");
            System.out.println("1. List Departments");
            System.out.println("2. Add Department");
            System.out.println("3. Remove Department");
            System.out.println("4. List Mentors");
            System.out.println("5. exit \n");
        } 
        @Override
        public void createDepartment(String deptName,int deptId){
            DepartmentModelClass deptObj = new DepartmentModelClass();
            deptObj.setDeptId(deptId);
            deptObj.setDeptName(deptName);
            deptHashObj.put(deptId, deptObj);
            System.out.println("New department added successfully");
        }
        @Override
        public void showDepartment()
        {
                int sNo = 1;
                for(HashMap.Entry<Integer,DepartmentModelClass> something : deptHashObj.entrySet())
                {
                    System.out.println(sNo+". "+something.getKey()+"-"+ something.getValue().getDeptName()); 
                    sNo++;
                }   
        }
        @Override
        public int listDepartment()
        {
            if(deptHashObj.isEmpty())   // EXCEPTION NOT WORKING
            {
                System.out.println("department is empty");
                return 6;
            }
            else
            {  
                Scanner inputScanner = new Scanner(System.in);
                System.out.print("Enter Department ID = ");                    
                int deptSelectById = inputScanner.nextInt();
                return deptSelectById;
            }
        }
     @Override
     public void changeMentor(int newMentorId,int deptId)
     {
         boolean flag = true;
         DepartmentModelClass tempObj = deptHashObj.get(deptId);
         if(tempObj == null)
                System.out.println("No department is found");
         ArrayList<EmployeeModelClass> empArray = tempObj.getEmployeeArray();
         if(empArray == null || empArray.isEmpty())                                                   
                    System.out.println("Employee list is empty");
         else
         {
            for(int i=0;i<empArray.size();i++)
            {
                    EmployeeModelClass obj = empArray.get(i);
                    if(obj == null)
                        System.out.println("Employee list is empty");
                    if(obj.getEmpId() == newMentorId)
                    {
                        flag = false;
                        tempObj.setMentorName(obj.getEmpName());
                        deptHashObj.put(deptId, tempObj);
                        System.out.println("Now new mentor is "+tempObj.getMentorName()+" for "+tempObj.getDeptName()+" department ");
                    }
            }
            if(flag == true)
                System.out.println("Entered employee id is wrong or no such employee in this department");
         }
         
     }
     @Override
     public void viewMentor(int deptId)
     {
         if(deptHashObj.containsKey(deptId))
         {
            DepartmentModelClass tempObj = deptHashObj.get(deptId);
            if(tempObj == null)
                    System.out.println("No department is found");
            else
            {
                if(tempObj.getMentorName()!=null)
                    System.out.println(tempObj.getMentorName()+" is the mentor for "+tempObj.getDeptName()+" Departemnt");     
                else
                    System.out.println("no mentor since no employee created");
            }
         }
         else
             System.out.println("the entered department ID is not found");
     }
     @Override
     public void listMentor()
     {
         if(deptHashObj.isEmpty())
             System.out.println("no department found");
         else
         {
             for(HashMap.Entry<Integer,DepartmentModelClass> iterator : deptHashObj.entrySet())
             {
                 if(iterator.getValue().getMentorName()!=null)
                    System.out.println(iterator.getValue().getDeptName()+" - "+iterator.getValue().getMentorName());
                 else
                    System.out.println("no mentor since no employee created");
             }
         }
     }
    };   
}
