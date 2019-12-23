package employeemanagementservice;

public class EmployeeModelClass 
{
    private String empName; // ENCAPSULATION
    private int empId;
    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empNameTemp) { 
        this.empName = empNameTemp;
    }
    public int getEmpId(){
        return empId;
    }
    public void setEmpId(int empIdTemp){
        this.empId = empIdTemp;
    }  
}
