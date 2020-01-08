package test;

import java.util.ArrayList;

public interface SyncProjFreeLanc                                               // INTERFACE
{
    public void setProject(int projId,int compId);
    public void setFreeLancer(int freeLancerId,int compId);
    public void removeProjectFromCompany(int projId,int compId);
    public void removeFreeLancerFromCompany(int freeLancerId,int compId);
    public void removeProjectFromFreeLancer(int projId,int freeLancerId);
    public void removeCompanyFromFreeLancer(int compId,int freeLancerId);
    public void identifyFreeLancerProjectForRemove(ArrayList<Integer> freeLancerCompArray,int projectId);
    public void identifyCompanyFreelancerForRemove(int freeLancerId,int companyId);
    public void identifyCompanyProjectForRemove(int projectId,int companyId);
}
