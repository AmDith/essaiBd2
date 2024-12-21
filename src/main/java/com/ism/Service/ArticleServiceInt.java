package com.ism.Service;


import com.ism.Core.Database.ArticleRepoListInt;
import com.ism.Core.Database.Service;
import com.ism.entities.Article;


public interface ArticleServiceInt extends Service<Article,ArticleRepoListInt> {
  void updateQteStock(int qteRe,String val);
}
