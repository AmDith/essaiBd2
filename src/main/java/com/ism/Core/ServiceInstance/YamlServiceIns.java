package com.ism.Core.ServiceInstance;

import com.ism.Core.Database.ArticleRepoListInt;
import com.ism.Core.Database.ClientRepoListInt;
import com.ism.Core.Database.DemandeRepoListInt;
import com.ism.Core.Database.DemandeArticleRepoListInt;
import com.ism.Core.Database.DetteRepoListInt;
import com.ism.Core.Database.PaiementRepoListInt;
import com.ism.Core.Database.RoleRepoListInt;
import com.ism.Core.Database.UserRepoListInt;

public interface  YamlServiceIns {
  Object getInstanceClient(String repoType, String repoType2,ClientRepoListInt clientRepo);
  Object getInstanceUser(String repoType, String repoType2,UserRepoListInt userRepo);
  Object getInstanceArticle(String repoType, String repoType2,ArticleRepoListInt articleRepo);
  Object getInstanceDemande(String repoType, String repoType2,DemandeRepoListInt demandeRepo);
  Object getInstanceDemandeArticle(String repoType, String repoType2,DemandeArticleRepoListInt detailRepo);
  Object getInstanceDette(String repoType, String repoType2,DetteRepoListInt  detteRepo);
  Object getInstanceRole(String repoType, String repoType2,RoleRepoListInt roleRepo);
  Object getInstancePaiement(String repoType, String repoType2,PaiementRepoListInt  paiementRepo);
}