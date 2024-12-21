package com.ism.Factory.FactotyRepo.BD;

import com.ism.Core.Database.ArticleRepoListInt;
import com.ism.Core.Database.ClientRepoListInt;
import com.ism.Core.Database.DemandeRepoListInt;
import com.ism.Core.Database.DetteRepoListInt;
import com.ism.Core.Database.UserRepoListInt;
import com.ism.Core.Repo.BD.YamlRepo;
import com.ism.Core.Repo.BD.Impl.YamlRepoImpl;
import com.ism.Factory.FactoryImplBd;
import com.ism.Repositories.BD.ArticleRepoBd;
import com.ism.Repositories.BD.ClientRepoBd;
import com.ism.Repositories.BD.DemandeRepoBd;
import com.ism.Repositories.BD.DemandeArticleRepoBd;
import com.ism.Repositories.BD.DetteRepoBd;
import com.ism.Repositories.BD.PaiementRepoBd;
import com.ism.Repositories.BD.UserRepoBd;

public class FactoryRepo extends FactoryImplBd<ClientRepoBd,UserRepoBd,ArticleRepoBd,DemandeRepoBd,DemandeArticleRepoBd,DetteRepoBd,PaiementRepoBd> implements Factoryint<ClientRepoBd,UserRepoBd,ArticleRepoBd,DemandeRepoBd,DemandeArticleRepoBd,DetteRepoBd,PaiementRepoBd> {


  YamlRepo yamlRepo;




  public FactoryRepo() {
    yamlRepo = new YamlRepoImpl();
  }


  @Override
  public ClientRepoBd getInstanceClient(UserRepoListInt uRepo) {
    if (dT == null) {
      return (ClientRepoBd) yamlRepo.getInstanceClient("repositoryBd","client",uRepo); 
    }
    return dT;
  }
  @Override
  public UserRepoBd getInstanceUser() {
    if (dA == null) {
      return (UserRepoBd) yamlRepo.getInstance("repositoryBd","user"); 
    }
    return dA;
  }
  @Override
  public ArticleRepoBd getInstanceArticle() {
    if (dY == null) {
      return (ArticleRepoBd) yamlRepo.getInstance("repositoryBd","article"); 
    }
    return dY;
  }
  @Override
  public DemandeRepoBd getInstanceDemande(ClientRepoListInt clientRepo) {
    if (dO == null) {
      return (DemandeRepoBd) yamlRepo.getInstanceDemande("repositoryBd","demande",clientRepo); 
    }
    return dO;
  }
  @Override
  public DemandeArticleRepoBd getInstanceDemandeArticle(ArticleRepoListInt articleRepo, DemandeRepoListInt detteRepo) {
    if (dG == null) {
      return (DemandeArticleRepoBd) yamlRepo.getInstanceDemandeArticle("repositoryBd","demandeArticle",articleRepo,detteRepo); 
    }
    return dG;
  }
  @Override
  public DetteRepoBd getInstanceDette(ClientRepoListInt clientRepo) {
    if (dP == null) {
      return (DetteRepoBd) yamlRepo.getInstanceDette("repositoryBd","dette",clientRepo); 
    }
    return dP;
  }
  @Override
  public PaiementRepoBd getInstancePaiement(DetteRepoListInt dette) {
    if (dE == null) {
      return (PaiementRepoBd) yamlRepo.getInstancePaiement("repositoryBd","paiement",dette); 
    }
    return dE;
  }
  
}

