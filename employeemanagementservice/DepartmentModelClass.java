package employeemanagementservice;

import java.util.ArrayList;

public class DepartmentModelClass         
{
    private String deptName;
    private int deptId;
    private String mentorName;
    private ArrayList<EmployeeModelClass> employeeArray;              // ARRAY LIST
    public String getDeptName() {                             // ENCAPSULATION  
        return deptName;
    }
    public void setDeptName(String deptNameTemp) {
        this.deptName = deptNameTemp;
    }
    public int getDeptId(){
        return deptId;
    }
    public void setDeptId(int deptIdTemp){
        this.deptId = deptIdTemp;
    }
    public String getMentorName(){
        return mentorName;
    }
    public void setMentorName(String mentorName){
        this.mentorName = mentorName;
    }        
    public void setEmployeeArray(ArrayList<EmployeeModelClass> employeeArray){
        this.employeeArray = employeeArray;
    }
    public ArrayList<EmployeeModelClass> getEmployeeArray()
    {
        return employeeArray;
    }
}
