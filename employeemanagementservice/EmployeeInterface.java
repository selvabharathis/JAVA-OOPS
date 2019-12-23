package employeemanagementservice;

/**
 *
 * @author Selvabharathi S
 */
interface EmployeeInterface //INTERFACE
{
    public void employeeMenu();
    public void createEmployee(String name,int id,int deptId);
    public void listEmployee(int deptId);
    public void removeEmployee(int deptSelectById);
}
