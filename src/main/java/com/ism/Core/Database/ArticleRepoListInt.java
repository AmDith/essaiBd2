package com.ism.Core.Database;

import com.ism.Repositories.Repository;
import com.ism.entities.Article;

public interface ArticleRepoListInt extends Repository<Article> {
  Article selectByLibelle(String val);
  void update(Article amour);
}
