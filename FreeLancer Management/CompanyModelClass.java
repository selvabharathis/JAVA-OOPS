package test;

import java.util.ArrayList;

public class CompanyModelClass                                                  // ENCAPSULATION
{
    private String companyName;                                                 // INSTANCE VARIABLE                                                 
    private int companyId;                                                      // INSTANCE VARIABLE
    private ArrayList<Integer> project;                                         // ARRAY-LIST
    private ArrayList<Integer> freeLancer;                                      // ARRAY-LIST
    private ArrayList<Integer> collaboratedCompany;                             // ARRAY-LIST
    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }
    public String getCompanyName()
    {
        return companyName;
    }
    public void setCompanyId(int companyId)
    {
        this.companyId = companyId;
    }
    public int getCompanyId()
    {
        return companyId;
    }
    public void setProject(ArrayList<Integer> project)
    {
        this.project = project;
    }
    public ArrayList<Integer> getProject()
    {
        return project;
    }
    public void setFreeLancer(ArrayList<Integer> freeLancer)
    {
        this.freeLancer = freeLancer;
    }
    public ArrayList<Integer> getFreeLancer()
    {
        return freeLancer;
    }
    public void setCollaboratedCompany(ArrayList<Integer> collaboratedCompany)
    {
        this.collaboratedCompany = collaboratedCompany;
    }
    public ArrayList<Integer> getCollaboratedCompany()
    {
        return collaboratedCompany;
    }
}
