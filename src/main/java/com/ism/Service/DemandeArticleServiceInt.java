package com.ism.Service;

import com.ism.Core.Database.DemandeArticleRepoListInt;
import com.ism.Core.Database.Service;
import com.ism.entities.Article;
import com.ism.entities.Demande;
import com.ism.entities.DemandeArticle;

public interface DemandeArticleServiceInt extends Service<DemandeArticle, DemandeArticleRepoListInt>{
  DemandeArticle verf(Demande demande, Article article, int id);
}
