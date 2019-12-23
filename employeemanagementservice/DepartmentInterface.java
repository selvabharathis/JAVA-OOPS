package employeemanagementservice;

/**
 *
 * @author Selvabharathi S
 */
interface DepartmentInterface //INTERFACE
{
    public void mainMenu();
    public void createDepartment(String name,int id);
    public int listDepartment();
    public void showDepartment();
    public void viewMentor(int deptId);
    public void changeMentor(int newMentorId,int deptId);
    public void listMentor();   
}
