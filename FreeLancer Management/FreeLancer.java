package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FreeLancer
{
    static private int freeLancerId;                                            // STATIC VARIABLE
    private HashMap<Integer,FreeLancerModelClass> freeLancerHashObj;            // HASH-MAP
    private Scanner userInput; 
    private SyncProjFreeLanc syncObj;                                           // OBJECT
    
    protected FreeLancer(int value)                                             // PARAMETERISED CONSTRUCTOR
    {
       freeLancerId = value;
       freeLancerHashObj  = new HashMap<Integer,FreeLancerModelClass>();
       userInput = new Scanner(System.in);
    }
    
    public Boolean verifyFreeLancerId(int freeLancerId)
    {
        if(freeLancerHashObj.containsKey(freeLancerId))
            return true;
        else
        {
            System.out.println("the entered freeLancer Id is wrong");
            return false;
        }
    }
    
    public HashMap<Integer,FreeLancerModelClass> getFreeLancerHashObj()
    {
        return freeLancerHashObj;
    }
    
    public void setSampleInterface(SyncProjFreeLanc syncObj)
    {
        this.syncObj = syncObj;
    }
    
    public void freeLancerMenu()
    {
        System.out.println("\n1. List Free Lancer");
        System.out.println("2. Add Free Lancer");
        System.out.println("3. Remove Free Lancer");
        System.out.println("4. assign project to freelancer");
        System.out.println("5. assign company to freelancer");
        System.out.println("6. remove free lancer from project");
        System.out.println("7. remove free lancer form company");
        System.out.println("8. Go back\n");
    }
    public void freeLancerSubMenu()
    {
        System.out.println("\n1. List Free Lancer Project");
        System.out.println("2. List Free Lancer Company");
        System.out.println("3.go back\n");
    }
   
    public int listFreeLancer()
    {
        if(freeLancerHashObj.isEmpty())
        {
            System.out.println("there is no free lancer in the list");
            return 0;
        } 
        else
        {   
            for(HashMap.Entry<Integer,FreeLancerModelClass> iterator : freeLancerHashObj.entrySet())
                System.out.println(iterator.getValue().getFreeLancerId()+" - "+iterator.getValue().getFreeLancerName());
            return 1;
        }
    }
    
    public void addFreelancer()
    {
        FreeLancerModelClass freeLancerObj = new FreeLancerModelClass();
        System.out.print("Enter Free Lancer Name = ");
        String freeLancerName = userInput.next();
        freeLancerObj.setFreeLancerName(freeLancerName);
        freeLancerObj.setFreeLancerId(freeLancerId);
        freeLancerHashObj.put(freeLancerId,freeLancerObj);
        freeLancerId++;
        System.out.println("New free lancer added successfully");
    }
    
    public void removeFreeLancer()
    {
        if(freeLancerHashObj.isEmpty())
            System.out.println("there is no free lancer in the list");
        else
        {
            System.out.print("Enter free lancer id to remove free lancer = ");
            int freeLancerId = userInput.nextInt();
            if(freeLancerHashObj.containsKey(freeLancerId))
            {
                FreeLancerModelClass tempObj = freeLancerHashObj.get(freeLancerId);
                ArrayList<Integer> proj = tempObj.getProject();
                ArrayList<Integer> company = tempObj.getCompany();
                if((proj==null || proj.isEmpty())&&(company==null || company.isEmpty()))
                {
                    freeLancerHashObj.remove(freeLancerId);
                    System.out.println("the free lancer removed successfully");     
                }
                else
                {
                    System.out.println("the freelancer is working in company and also he is assigned to project");
                    System.out.println("do you want to remove free lancer?");
                    System.out.print("enter \"yes\" to confirm delete = ");
                    String confirm = userInput.next();
                    if(confirm.equals("yes"))
                    {
                        for(int i=0;i<company.size();i++)
                        {
                            syncObj.removeFreeLancerFromCompany(freeLancerId,company.get(i));
                        }
                        freeLancerHashObj.remove(freeLancerId);
                        System.out.println("the free lancer removed successfully");
                    }
                    else
                    {System.out.println("delete operation canceled");}
                }        
            }
            else
                System.out.println("Invalid free lancer ID");
        }
    } 
    
    public void assignProjectToFreeLancer(HashMap<Integer,CompanyModelClass> companyHashObj,int projId)
    {
        boolean flag=false,flag1=false;
        if(freeLancerHashObj.isEmpty())
            System.out.println("there is no freeLancer in the list");
        else
        {
            System.out.print("enter freelancer id = ");
            int freeLancerId = userInput.nextInt();
            FreeLancerModelClass tempObj = freeLancerHashObj.get(freeLancerId);
            if(tempObj == null)
                System.out.println("there is no freeLancer in the list");
            else
            {
                ArrayList<Integer> project = tempObj.getProject();
                ArrayList<Integer> company = tempObj.getCompany();
                if(company==null || company.isEmpty())
                    System.out.println("the free lancer is not assigned to company");
                else
                {
                    if(project == null)
                        project = new ArrayList();                 
                    for(int i=0;i<company.size();i++)
                    {   
                       ArrayList<Integer> projectCompany = companyHashObj.get(company.get(i)).getProject();                       
                       if(projectCompany == null || projectCompany.isEmpty())
                       {
                           flag = false;
                       }
                       else
                       {
                           for(int j=0;j<projectCompany.size();j++)
                           {
                               if(projectCompany.get(j) == projId)
                               {
                                   flag = true;
                               }
                               if(flag==true)
                                   break;
                           }     
                       }                   
                       if(flag==true)
                            break;
                    }
                    if(flag == true || flag1 ==true)
                    {
                        project.add(projId);
                        tempObj.setProject(project);
                        freeLancerHashObj.put(freeLancerId, tempObj);
                        System.out.println("New project assigned to freeLancer successfully");
                    }
                    else
                        System.out.println("the project is not assigned to company,in which freelancer is working.");
                }
            }
        }
    }
    
    public void assignCompanyToFreeLancer(HashMap<Integer,CompanyModelClass> companyHashObj)
    {
        if(freeLancerHashObj.isEmpty())
            System.out.println("there is no freeLancer in the list");
        else
        {
            System.out.print("enter freelancer id = ");
            int freeLancerId = userInput.nextInt();
            FreeLancerModelClass tempObj = freeLancerHashObj.get(freeLancerId); 
            if(tempObj == null)
                System.out.println("there is no freeLancer in the list");
            else
            {
                ArrayList<Integer> company = tempObj.getCompany();
                if(company == null)
                    company = new ArrayList();
                System.out.print("enter company id = ");
                int compId = userInput.nextInt();
                if(companyHashObj.containsKey(compId))
                {
                    company.add(compId);
                    tempObj.setCompany(company);
                    freeLancerHashObj.put(freeLancerId, tempObj);
                    System.out.println("New company assigned to freeLancer successfully");
                    syncObj.setFreeLancer(freeLancerId,compId);
                }
                else
                    System.out.println("the entered company Id is wrong");
            }
        }
    }

    public void removeFreeLancerFromProject(int projId)
    {
       System.out.print("enter free lancer id = "); 
       int lancerId = userInput.nextInt();
       if(freeLancerHashObj.containsKey(lancerId))
        {
            FreeLancerModelClass tempObj = freeLancerHashObj.get(lancerId);
            if(tempObj == null)
                System.out.println("No Free lancer found");
            else
            {
                ArrayList<Integer> freeLancerProjectArray = tempObj.getProject();
                if(freeLancerProjectArray == null || freeLancerProjectArray.isEmpty())
                    System.out.println("The free lancer is not assigned to any project");
                else
                {
                    System.out.println("list of project availabe under "+tempObj.getFreeLancerName());
                    for(int i=0;i<freeLancerProjectArray.size();i++)
                    {
                       System.out.println(freeLancerProjectArray.get(i));
                    }    
                    for(int i=0;i<freeLancerProjectArray.size();i++)
                    {
                        if(freeLancerProjectArray.get(i)==projId) 
                        {
                            freeLancerProjectArray.remove(i);
                            System.out.println("project is removed successfully from "+tempObj.getFreeLancerName());
                            break;
                        }
                    }
                    tempObj.setProject(freeLancerProjectArray); 
                    freeLancerHashObj.put(lancerId,tempObj);  
                }
            }
        }
        else
            System.out.println("the entered free lancer id not found"); 
    }  
    
    public void removeFreeLancerFromCompany(HashMap<Integer,CompanyModelClass> companyHashObj)
    {                                                                                         
        System.out.print("enter free lancer id = "); 
        int lancerId = userInput.nextInt();
        if(freeLancerHashObj.containsKey(lancerId))
        {
            FreeLancerModelClass tempObj = freeLancerHashObj.get(lancerId);
            if(tempObj == null)
                System.out.println("No Free lancer found");
            else
            {
                ArrayList<Integer> freeLancerCompanyArray = tempObj.getCompany();
                if(freeLancerCompanyArray == null || freeLancerCompanyArray.isEmpty())
                    System.out.println("The free lancer is not assigned to any company");
                else
                {
                    System.out.println("list of company in which "+tempObj.getFreeLancerName()+" is working");
                    for(int i=0;i<freeLancerCompanyArray.size();i++)
                    {
                       System.out.println(freeLancerCompanyArray.get(i)+"-"+companyHashObj.get(freeLancerCompanyArray.get(i)).getCompanyName());
                    }    
                    System.out.print("enter company Id = ");
                    int companyId = userInput.nextInt();
                    if(companyHashObj.containsKey(companyId))
                    {
                        for(int i=0;i<freeLancerCompanyArray.size();i++)
                        {
                            if(freeLancerCompanyArray.get(i)==companyId) 
                            {
                                ArrayList<Integer> freeLancerProjectArray = tempObj.getProject();
                                if(freeLancerProjectArray==null || freeLancerProjectArray.isEmpty())
                                {
                                    freeLancerCompanyArray.remove(i);
                                    syncObj.removeFreeLancerFromCompany(lancerId, companyId);
                                    System.out.println("company is removed successfully from "+tempObj.getFreeLancerName());
                                    break;  
                                }
                                else
                                {
                                    System.out.println("the free lancer is assigned to these project in the company you are deleting");
                                    for(int j=0;j<freeLancerProjectArray.size();j++)
                                        System.out.println(freeLancerProjectArray.get(i));
                                    System.out.println("all the project will be stoped from free lancer once he leave the company");
                                    System.out.print("do you want to remove him, enter \"yes\" to confirm remove operation");
                                    String confirm = userInput.next();
                                    if(confirm.equals("yes"))
                                    {
                                        freeLancerCompanyArray.remove(i);
                                        freeLancerProjectArray.clear();//or use freeLancerProjectArray.removeAll(freeLancerProjectArray);
                                        syncObj.removeFreeLancerFromCompany(lancerId, companyId);
                                        syncObj.removeCompanyFromFreeLancer(companyId,lancerId);
                                        System.out.println("company is removed successfully from "+tempObj.getFreeLancerName());
                                        break;
                                    }
                                    else
                                    {
                                        System.out.println("delete operation canceled");
                                        break;
                                    }                                                                            
                                }
                                
                            }
                        }
                        tempObj.setCompany(freeLancerCompanyArray); 
                        freeLancerHashObj.put(lancerId,tempObj); 
                    }
                    else
                        System.out.println("wrong company Id");  
                }
            }
        }
        else
            System.out.println("the entered free lancer id not found");  
    }
    
    public void listFreeLancerProject(int projId,String projName)
    {
        System.out.println(projId+"-"+projName);         
    }
    
    public void listFreeLancerCompany(int lancerId,HashMap<Integer,CompanyModelClass> companyHashObj)
    {
        FreeLancerModelClass tempObj = freeLancerHashObj.get(lancerId);
            ArrayList<Integer> freeLancerCompanyArray = tempObj.getCompany();
            if(freeLancerCompanyArray == null || freeLancerCompanyArray.isEmpty())
                System.out.println("The free lancer is not assigned to company");
            else
            {
                System.out.println("list of company in which "+tempObj.getFreeLancerName()+" is working");
                for(int i=0;i<freeLancerCompanyArray.size();i++)
                {
                    System.out.println(freeLancerCompanyArray.get(i)+"-"+companyHashObj.get(freeLancerCompanyArray.get(i)).getCompanyName());
                }    
            }     
    } 
}

/*

// assign project to free lancer s
else
                {
                    if(project == null)
                        project = new ArrayList();                 
                    for(int i=0;i<company.size();i++)
                    {   
                       ArrayList<Integer> projectCompany = companyHashObj.get(company.get(i)).getProject();
                       for(HashMap.Entry<Integer,CompanyModelClass> iterator : companyHashObj.entrySet())
                       {
                           ArrayList<Integer> colCompanyArray = iterator.getValue().getCollaboratedCompany();
                           for(int k=0;k<colCompanyArray.size();k++)
                               if(colCompanyArray.get(k)==company.get(i))
                               {
                                   ArrayList<Integer> projectArray = iterator.getValue().getProject();
                                  
                               }
                       }
                       if(projectCompany == null || projectCompany.isEmpty())
                       {
                           flag = false;
                       }
                       else
                       {
                           for(int j=0;j<projectCompany.size();j++)
                           {
                               if(projectCompany.get(j) == projId)
                               {
                                   flag = true;
                               }
                               if(flag==true)
                                   break;
                           }     
                       }                   
                       if(flag==true)
                            break;
                    }
                    if(flag == true)
                    {
                        project.add(projId);
                        tempObj.setProject(project);
                        freeLancerHashObj.put(freeLancerId, tempObj);
                        System.out.println("New project assigned to freeLancer successfully");
                    }
                    else
                        System.out.println("the project is not assigned to company,in which freelancer is working.");
                }


*/