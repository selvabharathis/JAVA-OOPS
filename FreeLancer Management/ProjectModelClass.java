package test;

import java.util.ArrayList;

public class ProjectModelClass                                                  // ENCAPSULATION
{
    private String projectName;                                                 // INSTANCE VARIABLE
    private int projectId;                                                      // INSTANCE VARIABLE
    private ArrayList<Integer> company;                                         // ARRAY-LIST
    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }
    public String getProjectName()
    {
        return projectName;
    }
    public void setProjectId(int projectId)
    {
        this.projectId = projectId;
    }
    public int getProjectId()
    {
        return projectId;
    }
    public void setCompany(ArrayList<Integer> company)
    {
        this.company = company;
    }
    public ArrayList<Integer> getCompany()
    {
        return company;
    }
}
