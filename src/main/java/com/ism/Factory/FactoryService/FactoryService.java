package com.ism.Factory.FactoryService;

import com.ism.Core.Database.ClientRepoListInt;
<<<<<<< HEAD
import com.ism.Core.Database.DemandeRepoListInt;
import com.ism.Core.Database.DemandeArticleRepoListInt;
import com.ism.Core.Database.DetteRepoListInt;
import com.ism.Core.Database.PaiementRepoListInt;
import com.ism.Core.Database.RoleRepoListInt;
import com.ism.Core.Database.UserRepoListInt;
import com.ism.Core.ServiceInstance.YamlServiceIns;
import com.ism.Core.ServiceInstance.Impl.YamlServiceInsImpl;
import com.ism.Factory.FactoryImpl;
import com.ism.Service.ArticleService;
import com.ism.Service.ClientService;
import com.ism.Service.DemandeArticleService;
import com.ism.Service.DemandeService;
import com.ism.Service.DetteService;
import com.ism.Service.PaiementService;
import com.ism.Service.RoleService;
=======
import com.ism.Core.Database.UserRepoListInt;
import com.ism.Repositories.JPA.ClientRepoJpa;
import com.ism.Repositories.JPA.UserRepoJpa;
import com.ism.Service.ClientService;
>>>>>>> 636e632b84cd90083a1320eeab3b5026a11454c2
import com.ism.Service.UserService;

public class FactoryService extends FactoryImpl<ClientService,UserService,ArticleService,DemandeService,DemandeArticleService,DetteService,RoleService,PaiementService> implements FactoryServiceInt<ClientService,UserService,ArticleService,DemandeService,DemandeArticleService,DetteService,RoleService,PaiementService>{

  private YamlServiceIns yamlService;


public FactoryService() {
    this.yamlService = new YamlServiceInsImpl();
  }

<<<<<<< HEAD
@Override
public ClientService getInstanceClient(ClientRepoListInt clientRepo) {
  if (dT == null) {
    return (ClientService) yamlService.getInstanceClient("service","client",clientRepo);
  }
  return dT;
}

@Override
public UserService getInstanceUser(UserRepoListInt userRepo) {
  if (dA == null) {
    return (UserService) yamlService.getInstanceUser("service","user",userRepo); 
  }
  return dA;
}

@Override
public ArticleService getInstanceArticle(ArticleRepoListInt articleRepo) {
  if (dY == null) {
    return (ArticleService) yamlService.getInstanceArticle("service","article",articleRepo); 
  }
  return dY;
}

@Override
public DemandeService getInstanceDemande(DemandeRepoListInt demandeRepo) {
  if (dO == null) {
    return (DemandeService) yamlService.getInstanceDemande("service","demande",demandeRepo); 
  }
  return dO;
=======
  private static ClientService clientService = null ;
  private static UserService userService = null ;



public static ClientService getInstanceC(ClientRepoJpa breuhk) {
  if (clientService == null) {
    clientService = new ClientService(breuhk);
    }
    return clientService;
}




public static UserService getInstanceU(UserRepoJpa breuhk) {
  if (userService == null) {
    userService = new UserService(breuhk);
    }
    return userService;
>>>>>>> 636e632b84cd90083a1320eeab3b5026a11454c2
}

@Override
public DemandeArticleService getInstanceDemandeArticle(DemandeArticleRepoListInt demandeAricleRepo) {
  if (dG == null) {
    return (DemandeArticleService) yamlService.getInstanceDemandeArticle("service","demandeArticle",demandeAricleRepo);
  }
  return dG;
}

@Override
public DetteService getInstanceDette(DetteRepoListInt detteRepo) {
  if (dP == null) {
    return (DetteService) yamlService.getInstanceDette("service","dette",detteRepo); 
  }
  return dP;
}

@Override
public RoleService getInstanceRole(RoleRepoListInt roleRepo) {
  if (dB == null) {
    return (RoleService) yamlService.getInstanceRole("service","role",roleRepo); 
  }
  return dB;
}

@Override
public PaiementService getInstancePaiement(PaiementRepoListInt paiementRepo) {
  if (dE == null) {
    return (PaiementService) yamlService.getInstancePaiement("service","paiement",paiementRepo); 
  }
  return dE;
}

}