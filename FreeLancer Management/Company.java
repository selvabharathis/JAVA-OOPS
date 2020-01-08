package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Company 
{
    static private int companyId;                                               // STATIC VARIABLE
    private HashMap<Integer,CompanyModelClass> companyHashObj;                  // HASH-MAP
    private Scanner userInput;  
    private Project projObj;                                                    // OBJECT
    private FreeLancer freeLancObj;                                             // OBJECT
    
    protected Company(int value)                                                // PARAMETERISED CONSTRUCTOR
    {
        companyId = value;
        companyHashObj = new HashMap<Integer,CompanyModelClass>();
        userInput  = new Scanner(System.in);
        projObj = new Project(200);
        freeLancObj = new FreeLancer(300);
    }
    
    public Boolean verifyCompanyId(int companyId)
    {
        if(companyHashObj.containsKey(companyId))
            return true;
        else
        {
            System.out.println("the entered company Id is wrong or company not found");
            return false;
        }
    }
    
    private SyncProjFreeLanc syncObj = new SyncProjFreeLanc()                   // CONCRET INNER CLASS    
    {
        @Override                                                               // OVER-RIDING
        public void setProject(int projId,int compId)
        {
          CompanyModelClass compObj  = companyHashObj.get(compId);
          ArrayList<Integer> ProjectToCompanyArray = compObj.getProject();
          if(ProjectToCompanyArray == null ||ProjectToCompanyArray.isEmpty())
                    ProjectToCompanyArray = new ArrayList();    
              ProjectToCompanyArray.add(projId);
              compObj.setProject(ProjectToCompanyArray);
              companyHashObj.put(compId, compObj);
        }
        @Override
        public void setFreeLancer(int freeLancerId,int compId)
        {
          CompanyModelClass compObj  = companyHashObj.get(compId);
          ArrayList<Integer> freeLancerToCompanyArray = compObj.getFreeLancer();
          if(freeLancerToCompanyArray == null ||freeLancerToCompanyArray.isEmpty())
                    freeLancerToCompanyArray = new ArrayList();    
              freeLancerToCompanyArray.add(freeLancerId);
              compObj.setFreeLancer(freeLancerToCompanyArray);
              companyHashObj.put(compId, compObj);
        }
        @Override
        public void removeProjectFromCompany(int projId,int compId)
        {
            CompanyModelClass compObj  = companyHashObj.get(compId);
            ArrayList<Integer> ProjectToCompanyArray = compObj.getProject();
            Object item = projId;
            ProjectToCompanyArray.remove((Integer)item);
            compObj.setProject(ProjectToCompanyArray);
            companyHashObj.put(compId, compObj);
        }
        @Override
        public void removeFreeLancerFromCompany(int freeLancerId,int compId)
        {
            CompanyModelClass compObj  = companyHashObj.get(compId);
            ArrayList<Integer> freeLancerToCompanyArray = compObj.getFreeLancer();
            Object item = freeLancerId;
            freeLancerToCompanyArray.remove((Integer)item);
            compObj.setFreeLancer(freeLancerToCompanyArray);
            companyHashObj.put(compId, compObj);
        }
        @Override
        public void removeProjectFromFreeLancer(int projId,int freeLancerId)
        {
            FreeLancerModelClass lancerObj = freeLancObj.getFreeLancerHashObj().get(freeLancerId);
            ArrayList<Integer> projectToFreeLancerArray = lancerObj.getProject();
            Object item = projId;
            projectToFreeLancerArray.remove((Integer)item);
            lancerObj.setProject(projectToFreeLancerArray);
            freeLancObj.getFreeLancerHashObj().put(freeLancerId,lancerObj);
        }
        @Override
        public void removeCompanyFromFreeLancer(int compId,int freeLancerId)
        {
            FreeLancerModelClass lancerObj = freeLancObj.getFreeLancerHashObj().get(freeLancerId);
            ArrayList<Integer> companyToFreeLancerArray = lancerObj.getCompany();
            Object item = compId;
            companyToFreeLancerArray.remove((Integer)item);
            lancerObj.setProject(companyToFreeLancerArray);
            freeLancObj.getFreeLancerHashObj().put(freeLancerId,lancerObj);
        }
        @Override
        public void identifyFreeLancerProjectForRemove(ArrayList<Integer> freeLancerCompArray,int projectId)
        {
            for(int i=0;i<freeLancerCompArray.size();i++)
            {
                FreeLancerModelClass lancerObj = freeLancObj.getFreeLancerHashObj().get(freeLancerCompArray.get(i));
                ArrayList<Integer> freeLancerProjectArray = lancerObj.getProject();
                for(int j=0;j<freeLancerProjectArray.size();j++)
                {
                    if(freeLancerProjectArray.get(i)==projectId)
                    {
                        syncObj.removeProjectFromFreeLancer(projectId, lancerObj.getFreeLancerId());
                    }
                }
            }
        }
        @Override
        public void identifyCompanyFreelancerForRemove(int freeLancerId,int companyId)
        {
            FreeLancerModelClass freeLancerObj = freeLancObj.getFreeLancerHashObj().get(freeLancerId);
            ArrayList<Integer> freeLancerCompany = freeLancerObj.getCompany();
            for(int i=0;i<freeLancerCompany.size();i++)
            {
                if(freeLancerCompany.get(i)==companyId)
                {
                    syncObj.removeCompanyFromFreeLancer(companyId,freeLancerId);
                }
            }
        }
        @Override
        public void identifyCompanyProjectForRemove(int projectId,int companyId)
        {
            ProjectModelClass projectObj = projObj.getProjectHashObj().get(projectId);
            ArrayList<Integer> projectCompany = projectObj.getCompany();
            for(int i=0;i<projectCompany.size();i++)
            {
                if(projectCompany.get(i)==companyId)
                {
                    Object comId = projectCompany.get(i);
                    projectCompany.remove((Integer)comId);
                    projectObj.setCompany(projectCompany);
                    projObj.getProjectHashObj().put(projectId,projectObj);
                }
            }
        }
    };
    
    public void sendProjInterface()
    {
         projObj.setSampleInterface(syncObj);
    }
    
    public void sendFreeLancerInterface()
    {
         freeLancObj.setSampleInterface(syncObj);
    }
    
    public void mainMenu()
    {
       System.out.println("\n1. List Company");
       System.out.println("2. Add Company");
       System.out.println("3. Remove Company");
       System.out.println("4. FreeLancer Menu");
       System.out.println("5. Project Menu");
       System.out.println("6. Exit\n");   
    }
    
    public void subMenu()
    {
       System.out.println("\n1. projects in this company");
       System.out.println("2. free lancer in this company");
       System.out.println("3. collaborated companies");
       System.out.println("4. remove company from collaboration");
       System.out.println("5. add collaborated company");
       System.out.println("6. go back\n");
    }
    
    public void addCompany()
    {
        CompanyModelClass comObj = new CompanyModelClass();
        System.out.print("Enter company Name = ");
        String companyName = userInput.next();
        comObj.setCompanyName(companyName);
        comObj.setCompanyId(companyId);
        companyHashObj.put(companyId,comObj);
        companyId++;
        System.out.println("New company added successfully");
    }
    
    public int listCompany()
    {
        if(companyHashObj.isEmpty())
        {
           System.out.println("there is no company in the list");
           return 0; 
        }     
        else
        {   
            for(HashMap.Entry<Integer,CompanyModelClass> iterator : companyHashObj.entrySet())
            {
                System.out.println(iterator.getValue().getCompanyId()+" - "+iterator.getValue().getCompanyName());
            }
            return 1;
        }   
    }
    
    public void removeCompany()
    {
        if(companyHashObj.isEmpty())
            System.out.println("there is no company in the list");
        else
        {
            System.out.print("Enter company Id = ");
            int comId = userInput.nextInt();
            if(companyHashObj.containsKey(comId))
            {
                CompanyModelClass tempObj = companyHashObj.get(comId);
                ArrayList<Integer> proj = tempObj.getProject();
                ArrayList<Integer> fl = tempObj.getFreeLancer();
                if((proj==null || proj.isEmpty())&&(fl==null || fl.isEmpty()))
                {
                   companyHashObj.remove(comId);
                   System.out.println("the company removed successfully");     
                }
                else
                {
                    System.out.println("the company has project and freelancer in it");
                    System.out.println("do you want to remove company?");
                    System.out.print("enter \"yes\" to confirm delete = ");
                    String confirm = userInput.next();
                    if(confirm.equals("yes"))
                    {
                        for(int i=0;i<proj.size();i++)
                        {  
                            syncObj.identifyCompanyProjectForRemove(proj.get(i),comId);
                        }
                        for(int i=0;i<fl.size();i++)
                        {
                            syncObj.identifyCompanyFreelancerForRemove(fl.get(i),comId);
                        }
                        companyHashObj.remove(comId);
                        System.out.println("Successfully deleted the company");
                    }
                    else
                        System.out.println("Delete operation canceled");
                }      
            }
            else
               System.out.println("Invalid company ID"); 
        }   
    }
    
    public void projectsInCompany(int compId)
    {
        CompanyModelClass tempObj=companyHashObj.get(compId);
        if(tempObj==null)
            System.out.println("no company found");
        else
        {
            ArrayList<Integer> project = tempObj.getProject();
            if(project==null || project.isEmpty())
                System.out.println("no project is assigned to the company");
            else
            {
               for(int i=0;i<project.size();i++)
                {
                    ProjectModelClass pro = projObj.getProjectHashObj().get(project.get(i));
                    System.out.println(pro.getProjectId()+"-"+pro.getProjectName());
                } 
            }     
        }
    }
    
    public void freeLancerInCompany(int compId)
    {
        CompanyModelClass tempObj=companyHashObj.get(compId);
        if(tempObj==null)
            System.out.println("no company found");
        else
        {
            ArrayList<Integer> freelancer = tempObj.getFreeLancer();
            if(freelancer==null || freelancer.isEmpty())
                System.out.println("no freelancer is assigned to the company");
            else
            {
               for(int i=0;i<freelancer.size();i++)
                {
                    FreeLancerModelClass fl = freeLancObj.getFreeLancerHashObj().get(freelancer.get(i));
                    System.out.println(fl.getFreeLancerId()+"-"+fl.getFreeLancerName());
                } 
            }     
        }
    }
    
    public void addCollaboratedCompany(int compId)
    {
        CompanyModelClass comObjOne = companyHashObj.get(compId);
        System.out.print("enter company Id to collaborate = ");
        int collaborate = userInput.nextInt();
        if(companyHashObj.containsKey(collaborate))
        {
            ArrayList<Integer> collaborateArray = comObjOne.getCollaboratedCompany();
            if(collaborateArray==null || collaborateArray.isEmpty())
                collaborateArray = new ArrayList();
            collaborateArray.add(collaborate);
            comObjOne.setCollaboratedCompany(collaborateArray);
            companyHashObj.put(compId,comObjOne);
            System.out.println("company successfully collaborated");
        }
        else
            System.out.println("the entered company id is wrong");
    }
    
    public void listCollaboratedCompany(int compId)
    {
        CompanyModelClass comObj = companyHashObj.get(compId);
        ArrayList<Integer> collaborateArray = comObj.getCollaboratedCompany();
        if(collaborateArray==null || collaborateArray.isEmpty())
            System.out.println("no collaborated company");
        else
        {
          for(int i=0;i<collaborateArray.size();i++)
          {
            CompanyModelClass tempObj = companyHashObj.get(collaborateArray.get(i));
            System.out.println(collaborateArray.get(i)+"-"+tempObj.getCompanyName());
          }  
        }
        
    }
    
    public void removeCollaboratedCompany(int compId)
    {
        CompanyModelClass comObj = companyHashObj.get(compId);
        System.out.print("enter company id to remove from collaboration = ");
        int collaborate = userInput.nextInt();
        if(companyHashObj.containsKey(collaborate))
        {
            ArrayList<Integer> collaborateArray = comObj.getCollaboratedCompany();
            if(collaborateArray==null || collaborateArray.isEmpty())
                System.out.println("no collaborated company");
            else
            {
                collaborateArray.remove(collaborate);
                comObj.setCollaboratedCompany(collaborateArray);
                companyHashObj.put(compId,comObj);
                System.out.println("collaborated company successfully removed");
            }
        }
        else
            System.out.println("the entered company id is wrong");
    }
    
    public void freeLancer()
    {
        sendFreeLancerInterface();
        boolean flag1=true;
        boolean flag2=true;
        while(flag1)
        {
            flag2=true;
            freeLancObj.freeLancerMenu();
            System.out.print("Enter your choice = ");
            int choiceTwo = userInput.nextInt();
            switch(choiceTwo)
            {
                case 1:// List free lancer  
                      int status = freeLancObj.listFreeLancer();
                      if(status == 1)
                      {
                            System.out.print("enter free lancer id view in detail = ");
                            int freeLancerId = userInput.nextInt();
                            if(freeLancObj.verifyFreeLancerId(freeLancerId))
                            {
                                while(flag2)
                                { 
                                    freeLancObj.freeLancerSubMenu();
                                    System.out.print("Enter your choice = ");
                                    int choiceThree = userInput.nextInt();
                                    switch(choiceThree)
                                    {
                                        case 1://list free lancer project
                                            FreeLancerModelClass tempObj = freeLancObj.getFreeLancerHashObj().get(freeLancerId);
                                            ArrayList<Integer> freeLancerProjectArray = tempObj.getProject();
                                            if(freeLancerProjectArray == null || freeLancerProjectArray.isEmpty())
                                                System.out.println("The free lancer is not assigned to project");
                                            else
                                            {
                                                System.out.println("list of project availabe under "+tempObj.getFreeLancerName());
                                                for(int i=0;i<freeLancerProjectArray.size();i++)
                                                {
                                                   freeLancObj.listFreeLancerProject(freeLancerProjectArray.get(i),projObj.getProjectHashObj().get(freeLancerProjectArray.get(i)).getProjectName()); 
                                                }    
                                            }       
                                            break;
                                        case 2:// list free lancer company
                                            freeLancObj.listFreeLancerCompany(freeLancerId,companyHashObj);
                                            break;
                                        case 3://go back
                                            flag2=false;
                                            break;
                                        default:
                                            System.out.println("...INVALID CHOICE...");
                                    }
                                }
                            }
                        }   
                        break;
                    case 2:// add free lancer
                        freeLancObj.addFreelancer();
                        break;
                    case 3:// remove free lancer
                        freeLancObj.removeFreeLancer();
                        break;
                    case 4:// assign project to free lancer
                        System.out.print("enter project id = ");
                        int projId1 = userInput.nextInt();
                        if(projObj.verifyProjectId(projId1))
                            freeLancObj.assignProjectToFreeLancer(companyHashObj,projId1);
                        break;
                    case 5://Assign company to Free Lancer
                        freeLancObj.assignCompanyToFreeLancer(companyHashObj);
                        break;
                    case 6://remove free lancer from project
                        System.out.print("enter project id to remove = ");
                        int projId = userInput.nextInt();
                        if(projObj.verifyProjectId(projId))
                            freeLancObj.removeFreeLancerFromProject(projId);
                        break;
                    case 7://Remove free lancer from company                                  
                        freeLancObj.removeFreeLancerFromCompany(companyHashObj);
                        break;
                    case 8:// go back
                        flag1=false;
                        break;
                    default:
                        System.out.println("...INVALID CHOICE...");
            }   
        }
    }

    public void project()
    {
       sendProjInterface(); 
       boolean flag1=true;
       boolean flag2=true;
       while(flag1)
       {
            flag2=true;
            projObj.projectMenu();
            System.out.print("Enter your choice = ");
            int choiceFour = userInput.nextInt();
            switch(choiceFour)
            {
                case 1:// list project
                    int status = projObj.listProject();
                    if(status == 1)
                    {
                        System.out.print("Enter project id to view in detail = ");
                        int projectId = userInput.nextInt();
                        if(projObj.verifyProjectId(projectId))
                        {
                            while(flag2)
                            {   
                                projObj.projectSubMenu();
                                System.out.print("enter your choice = ");
                                int choiceFive = userInput.nextInt();
                                switch(choiceFive)
                                {
                                    case 1:// list free lancer working on the project
                                        int flag3=0,flag4=0;
                                        if(freeLancObj.getFreeLancerHashObj().isEmpty())
                                        {
                                            System.out.println("no free lancer is assigned to this project");
                                        }
                                        else
                                        {
                                            for(HashMap.Entry<Integer,FreeLancerModelClass> iterator : freeLancObj.getFreeLancerHashObj().entrySet())
                                            {
                                                FreeLancerModelClass tempObj = iterator.getValue();
                                                ArrayList<Integer> freeLancerProj = tempObj.getProject();
                                                if(freeLancerProj == null || freeLancerProj.isEmpty())
                                                    flag3 = 1;
                                                else
                                                {
                                                    flag4 = 1;
                                                    for(int i=0;i<freeLancerProj.size();i++)
                                                    {
                                                        if(freeLancerProj.get(i) == projectId)
                                                        {
                                                            projObj.listFreeLancerWorkingInProject(tempObj.getFreeLancerId(),tempObj.getFreeLancerName());
                                                        }
                                                    }
                                                }
                                            }
                                            if(flag3 ==1 && flag4==0)
                                                System.out.println("no free lancer is assigned to this project");
                                        }                                                                
                                        break;
                                    case 2://  Which company is assigned to the choosen project
                                        if(companyHashObj.isEmpty())
                                            System.out.println("no company found");
                                        else
                                            projObj.whichCompanyProject(projectId,companyHashObj);
                                        break;
                                    case 3:// go back to project menu
                                        flag2=false;
                                        break;
                                    default:
                                        System.out.println("...INVALID CHOICE...");
                                }
                            } 
                        }                      
                    } 
                    break;
                case 2:// add project
                    projObj.addProject();
                    break;
                case 3:// remove project
                    projObj.removeProject(companyHashObj);
                    break;
                 case 4:// Assign Company to Project
                    projObj.assignCompanyToProject(companyHashObj);  
                    break;
                case 5:// remove project from company
                    projObj.removeProjectFromCompany(companyHashObj);
                    break;
                case 6:// go back
                    flag1=false;
                    break;
                default:
                    System.out.println("...INVALID CHOICE...");
            } 
        }                   
    }
}

