package com.ism.Factory.FactotyRepo.BD;

import com.ism.Core.Database.ArticleRepoListInt;
import com.ism.Core.Database.ClientRepoListInt;
import com.ism.Core.Database.DemandeRepoListInt;
import com.ism.Core.Database.DetteRepoListInt;
import com.ism.Core.Database.UserRepoListInt;

public interface Factoryint<A,T,Y,O,G,P,E> {
  A getInstanceClient(UserRepoListInt uRepo);
  T getInstanceUser();
  Y getInstanceArticle();
  O getInstanceDemande(ClientRepoListInt clientRepo);
  G getInstanceDemandeArticle(ArticleRepoListInt articleRepo, DemandeRepoListInt detteRepo);
  P getInstanceDette(ClientRepoListInt clientRepo);
  E getInstancePaiement(DetteRepoListInt dette);
}
