package employeemanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Operations 
{
    public HashMap<Integer,DepartmentModelClass> deptHashObj = new HashMap<Integer,DepartmentModelClass>();  // HASH MAP
    
    protected MenuInterface menuObj = new MenuInterface(){         // CONCRET INNER CLASS
        @Override
        public void employeeMenu(){
            System.out.println("\n1. List Employees");
            System.out.println("2. Remove Employee");
            System.out.println("3. Change Mentor");
            System.out.println("4. View Mentor");
            System.out.println("5. Add Employee");
            System.out.println("6. Menu\n");
        }
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
                if(empArray == null)
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
            if(deptHashObj.isEmpty())
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
                    if(empArray == null)
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
                        tempObj.setEmployeeArray(empArray);
                        deptHashObj.put(deptId, tempObj);
                        System.out.println("Employee removed successfully."); 
                    }   
                }
            }
            else
                System.out.println("the entered department ID is not found");
        }
     @Override
     public void changeMentor(int newMentorId,int deptId)
     {
         boolean flag = true;
         DepartmentModelClass tempObj = deptHashObj.get(deptId);
         if(tempObj == null)
                System.out.println("No department is found");
         ArrayList<EmployeeModelClass> empArray = tempObj.getEmployeeArray();  
         for(int i=0;i<empArray.size();i++)
         {
             if(empArray == null)
                    System.out.println("Employee list is empty");
             else
             {
                  EmployeeModelClass obj = empArray.get(i);
                  if(obj.getEmpId() == newMentorId)
                  {
                    flag = false;
                    tempObj.setMentorName(obj.getEmpName());
                    deptHashObj.put(deptId, tempObj);
                    System.out.println("Now new mentor is "+tempObj.getMentorName()+" for "+tempObj.getDeptName()+" department ");
                  }
             }        
         }
         if(flag == true)
             System.out.println("Entered employee id is wrong or no such employee in this department");
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
                    System.out.println(tempObj.getMentorName()+" is the mentor for "+tempObj.getDeptName()+" Departemnt");     
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
                 System.out.println(iterator.getValue().getDeptName()+" - "+iterator.getValue().getMentorName());
             }
         }
     }
    }; 
}
