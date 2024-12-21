package com.ism.Core.Repo.BD;

import com.ism.Core.Database.ArticleRepoListInt;
import com.ism.Core.Database.ClientRepoListInt;
import com.ism.Core.Database.DemandeRepoListInt;
import com.ism.Core.Database.DetteRepoListInt;
import com.ism.Core.Database.UserRepoListInt;

public interface YamlRepo {
  Object getInstance(String repoType, String repoType2);
  Object getInstanceClient(String repoType, String repoType2, UserRepoListInt uRepo);
  Object getInstanceDemande(String repoType, String repoType2, ClientRepoListInt clientRepo);
  Object getInstanceDemandeArticle(String repoType, String repoType2, ArticleRepoListInt articleRepo, DemandeRepoListInt demandeRepo);
  Object getInstanceDette(String repoType, String repoType2, ClientRepoListInt clientRepo);
  Object getInstancePaiement(String repoType, String repoType2, DetteRepoListInt dette);
}
