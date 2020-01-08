package test;

import java.util.ArrayList;

public class FreeLancerModelClass                                               // ENCAPSULATION
{
    private String freeLancerName;                                              // INSTANCE VARIABLE
    private int freeLancerId;                                                   // INSTANCE VARIABLE
    private ArrayList<Integer> project;                                         // ARRAY-LIST
    private ArrayList<Integer> company;                                         // ARRAY-LIST
    public void setFreeLancerName(String freeLancerName)
    {
        this.freeLancerName = freeLancerName;
    }
    public String getFreeLancerName()
    {
        return freeLancerName;
    }
    public void setFreeLancerId(int freeLancerId)
    {
        this.freeLancerId = freeLancerId;
    }
    public int getFreeLancerId()
    {
        return freeLancerId;
    }
    public void setProject(ArrayList<Integer> project)
    {
        this.project = project;
    }
    public ArrayList<Integer> getProject()
    {
        return project;
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
