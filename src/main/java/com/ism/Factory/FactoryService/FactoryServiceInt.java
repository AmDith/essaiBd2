package com.ism.Factory.FactoryService;


import com.ism.Core.Database.ArticleRepoListInt;
import com.ism.Core.Database.ClientRepoListInt;
import com.ism.Core.Database.DemandeRepoListInt;
import com.ism.Core.Database.DemandeArticleRepoListInt;
import com.ism.Core.Database.DetteRepoListInt;
import com.ism.Core.Database.PaiementRepoListInt;
import com.ism.Core.Database.RoleRepoListInt;
import com.ism.Core.Database.UserRepoListInt;

public interface FactoryServiceInt<A,T,Y,O,G,P,B,E> {
  A getInstanceClient(ClientRepoListInt clientRepo);
  T getInstanceUser(UserRepoListInt userRepo);
  Y getInstanceArticle(ArticleRepoListInt articleRepo);
  O getInstanceDemande(DemandeRepoListInt demandeRepo);
  G getInstanceDemandeArticle(DemandeArticleRepoListInt demandeAricleRepo);
  P getInstanceDette(DetteRepoListInt  detteRepo);
  B getInstanceRole(RoleRepoListInt  roleRepo);
  E getInstancePaiement(PaiementRepoListInt  paiementRepo);


}
