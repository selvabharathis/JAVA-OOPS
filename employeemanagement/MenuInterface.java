package employeemanagement;


public interface MenuInterface  // INTERFACE
{
    public void employeeMenu();
    public void mainMenu();
    public void createDepartment(String name,int id);
    public void createEmployee(String name,int id,int deptId);
    public void listEmployee(int deptId);
    public int listDepartment();
    public void removeEmployee(int deptSelectById);
    public void viewMentor(int deptId);
    public void changeMentor(int newMentorId,int deptId);
    public void listMentor();
    public void showDepartment();
}
