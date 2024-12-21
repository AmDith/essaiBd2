package com.ism.Repositories.list;

import com.ism.Core.Database.DemandeArticleRepoListInt;
import com.ism.Repositories.list.Impl.RepositoryImpl;
import com.ism.entities.DemandeArticle;

public class DemandeArticleRepo extends RepositoryImpl<DemandeArticle> implements DemandeArticleRepoListInt {

  @Override
  public DemandeArticle selectById(int id) {
    return datas.stream()
    .filter(demandeArticle -> demandeArticle.getId() == id)
    .findFirst()
    .orElse(null);
  }
  
}
