package com.ism.Factory.FactotyRepo.list;

import com.ism.Core.Repo.list.YamlRepo;
import com.ism.Core.Repo.list.Impl.YamlRepoImpl;
import com.ism.Factory.FactoryImpl;
import com.ism.Repositories.list.ArticleRepo;
import com.ism.Repositories.list.ClientRepo;
import com.ism.Repositories.list.DemandeArticleRepo;
import com.ism.Repositories.list.DemandeRepo;
import com.ism.Repositories.list.DetteRepo;
import com.ism.Repositories.list.PaiementRepo;
import com.ism.Repositories.list.RoleRepo;
import com.ism.Repositories.list.UserRepo;

public class FactoryRepo extends FactoryImpl<ClientRepo,UserRepo,ArticleRepo,DemandeRepo,DemandeArticleRepo,DetteRepo,RoleRepo,PaiementRepo> implements Factoryint<ClientRepo,UserRepo,ArticleRepo,DemandeRepo,DemandeArticleRepo,DetteRepo,RoleRepo,PaiementRepo> {


  YamlRepo yamlRepo;




  public FactoryRepo() {
    yamlRepo = new YamlRepoImpl();
  }


  @Override
  public ClientRepo getInstanceClient() {
    if (dT == null) {
      return (ClientRepo) yamlRepo.getInstance("repositoryList","client"); 
    }
    return dT;
  }
  @Override
  public UserRepo getInstanceUser() {
    if (dA == null) {
      return (UserRepo) yamlRepo.getInstance("repositoryList","user"); 
    }
    return dA;
  }
  @Override
  public ArticleRepo getInstanceArticle() {
    if (dY == null) {
      return (ArticleRepo) yamlRepo.getInstance("repositoryList","article"); 
    }
    return dY;
  }
  @Override
  public DemandeRepo getInstanceDemande() {
    if (dO == null) {
      return (DemandeRepo) yamlRepo.getInstance("repositoryList","demande"); 
    }
    return dO;
  }
  @Override
  public DemandeArticleRepo getInstanceDemandeArticle() {
    if (dG == null) {
      return (DemandeArticleRepo) yamlRepo.getInstance("repositoryList","demandeArticle"); 
    }
    return dG;
  }
  @Override
  public DetteRepo getInstanceDette() {
    if (dP == null) {
      return (DetteRepo) yamlRepo.getInstance("repositoryList","dette"); 
    }
    return dP;
  }
  @Override
  public RoleRepo getInstanceRole() {
    if (dB == null) {
      return (RoleRepo) yamlRepo.getInstance("repositoryList","role"); 
    }
    return dB;
  }
  @Override
  public PaiementRepo getInstancePaiement() {
    if (dE == null) {
      return (PaiementRepo) yamlRepo.getInstance("repositoryList","paiement"); 
    }
    return dE;
  }


 
  
}

