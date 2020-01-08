package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Project 
{
    static private int projectId;                                               // STATIC VARIABLE
    private HashMap<Integer,ProjectModelClass> projectHashObj;                  // HASH-MAP
    private Scanner userInput;  
    private SyncProjFreeLanc syncObj;                                           // OBJECT
    
    protected Project(int value)                                                // PARAMETERISED CONSTRUCTOR
    {
        projectId = value;
        projectHashObj  = new HashMap<Integer,ProjectModelClass>();
        userInput  = new Scanner(System.in);
    }
    
    public Boolean verifyProjectId(int projId)
    {
        if(projectHashObj.containsKey(projId))
            return true;
        else
        {
            System.out.println("the entered project Id is wrong");
            return false;
        }
    }
    
    public HashMap<Integer,ProjectModelClass> getProjectHashObj()
    {
        return projectHashObj;
    }
    
    public void setSampleInterface(SyncProjFreeLanc syncObj)
    {
        this.syncObj = syncObj;
    }
    
    public void projectMenu()
    {
        System.out.println("\n1. List Project");
        System.out.println("2. Add Project");
        System.out.println("3. Remove Project");
        System.out.println("4. Assign company to project");
        System.out.println("5. Remove company from project");
        System.out.println("6. Go back\n");
    }
    
    public void projectSubMenu()
    {
        System.out.println("\n1. List Free Lancer Working on choosen project");
        System.out.println("2. company assigned to the choosen project");
        System.out.println("3. go back\n");
    }
    
    public int listProject()
    {
        if(projectHashObj.isEmpty())
        {
            System.out.println("there is no project in the list");
            return 0;
        }    
        else
        {
            for(HashMap.Entry<Integer,ProjectModelClass> iterator : projectHashObj.entrySet())
                System.out.println(iterator.getValue().getProjectId()+" - "+iterator.getValue().getProjectName());
            return 1;
        }
    }
    
    public void addProject()
    {
        ProjectModelClass projObj = new ProjectModelClass();
        System.out.print("Enter Project Name = ");
        String projName = userInput.next();
        projObj.setProjectName(projName);
        projObj.setProjectId(projectId);
        projectHashObj.put(projectId,projObj);
        projectId++;
        System.out.println("New project added successfully");
    }
    
    public void removeProject(HashMap<Integer,CompanyModelClass> companyHashObj)
    {
        if(projectHashObj.isEmpty())
            System.out.println("there is no project in the list");
        else
        {
            System.out.print("enter project id to remove a project = ");
            int projId = userInput.nextInt();
            if(projectHashObj.containsKey(projId))
            {
                ProjectModelClass tempObj=projectHashObj.get(projId);
                ArrayList<Integer> company = tempObj.getCompany();
                if(company==null || company.isEmpty())
                {
                    projectHashObj.remove(projId);
                    System.out.println("the project removed successfully");
                }
                else
                {
                    System.out.println("the project is assigned to some company and has free lancer working in it");
                    System.out.println("do you want to delete the project?");
                    System.out.print("enter \"yes\" to confirm delete = ");
                    String confirm = userInput.next();
                    if(confirm.equals("yes"))
                    {
                        for(int i=0;i<company.size();i++)
                        {
                            syncObj.removeProjectFromCompany(projId,company.get(i));
                            CompanyModelClass compObj = companyHashObj.get(company.get(i));
                            ArrayList<Integer> freeLancerCompArray = compObj.getFreeLancer();
                            syncObj.identifyFreeLancerProjectForRemove(freeLancerCompArray,projId);
                        }
                        projectHashObj.remove(projId);
                        System.out.println("the project removed successfully");
                    }
                    else
                        System.out.println("delete operation canceled");
                }
                
            }
            else
                System.out.println("Invalid project ID");
        }
    }
    
    public void listFreeLancerWorkingInProject(int freeLancerId,String freeLancerName)
    {
       System.out.println(freeLancerId+"-"+freeLancerName);
    }
    
    public void whichCompanyProject(int projectId,HashMap<Integer,CompanyModelClass> companyHashObj)
    {
         for(HashMap.Entry<Integer,CompanyModelClass> iterator : companyHashObj.entrySet())
         {
             CompanyModelClass comp = iterator.getValue();
             ArrayList<Integer> array = comp.getProject();
             if(array == null || array.isEmpty())
             {
                 System.out.println("no company is assigned to the choosen project");
             }
             else
             {
                 for(int i=0;i<array.size();i++)
                 {
                    if(array.get(i)==projectId)
                        System.out.println(iterator.getValue().getCompanyId()+"-"+iterator.getValue().getCompanyName());
                 }
             }    
         }
    }
  
    public void assignCompanyToProject(HashMap<Integer,CompanyModelClass> companyHashObj)
    {   
        if(projectHashObj.isEmpty())
            System.out.println("there is no project in the list");
        else
        {
            System.out.print("enter project id = ");
            int projId = userInput.nextInt();
            ProjectModelClass tempObj = projectHashObj.get(projId);
            if(tempObj == null)
                System.out.println("there is no project in the list");
            else
            {
                ArrayList<Integer> company = tempObj.getCompany();
                if(company == null ||company.isEmpty())
                    company = new ArrayList();                
                System.out.print("enter company id = ");
                int compId = userInput.nextInt();
                if(companyHashObj.containsKey(compId))
                {
                    CompanyModelClass companyObj = companyHashObj.get(compId);
                    ArrayList<Integer> project = companyObj.getProject();
                    if(project == null ||project.isEmpty())
                        project = new ArrayList(); 
                    if(project.size()>=1)
                    {
                        System.out.println("The project is already assigned to a company,if you want to work in this project");
                        System.out.println("collaborate company, and then try assigning project");
                    }
                    else
                    {
                        company.add(compId);
                        tempObj.setCompany(company);
                        projectHashObj.put(projId, tempObj);
                        syncObj.setProject(projId,compId);
                        System.out.println("New company assigned to project successfully"); 
                    }
                }
                else
                    System.out.println("the entered company id is wrong"); 
            }
        }
    }
   
    public void removeProjectFromCompany(HashMap<Integer,CompanyModelClass> companyHashObj)
    {                                                                                      
        System.out.print("enter project id = ");
        int projectId = userInput.nextInt();
        if(projectHashObj.containsKey(projectId))
        {
            ProjectModelClass tempObj = projectHashObj.get(projectId);
            if(tempObj == null)
                System.out.println("No project found");
            else
            {
                ArrayList<Integer> projectCompanyArray = tempObj.getCompany();
                if(projectCompanyArray == null || projectCompanyArray.isEmpty())
                    System.out.println("The project is not assigned to the company");
                else
                {
                    System.out.println("list of company availabe under "+tempObj.getProjectName());
                    for(int i=0;i<projectCompanyArray.size();i++)
                    {
                       System.out.println(projectCompanyArray.get(i)+"-"+companyHashObj.get(projectCompanyArray.get(i)).getCompanyName());
                    }    
                    System.out.print("enter company Id = ");
                    int companyId = userInput.nextInt();
                    if(companyHashObj.containsKey(companyId))
                    {
                        for(int i=0;i<projectCompanyArray.size();i++)
                        {                                     
                            if(projectCompanyArray.get(i)==companyId) 
                            {
                                CompanyModelClass compObj = companyHashObj.get(projectCompanyArray.get(i));
                                ArrayList<Integer> companyFreeLancer = compObj.getFreeLancer(); 
                                for(int j=0;j<companyFreeLancer.size();j++)
                                {
                                    syncObj.removeProjectFromFreeLancer( projectId,companyFreeLancer.get(i));
                                }
                                projectCompanyArray.remove(i);
                                syncObj.removeProjectFromCompany(projectId, companyId);
                                System.out.println("company is removed successfully from "+tempObj.getProjectName());
                                break;
                            }
                        }
                        tempObj.setCompany(projectCompanyArray); 
                        projectHashObj.put(projectId,tempObj); 
                    }
                    else
                        System.out.println("wrong company Id");  
                }
            }
        }
        else
            System.out.println("the entered project id not found");   
    }
}
