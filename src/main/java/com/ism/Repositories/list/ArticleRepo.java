package com.ism.Repositories.list;


import com.ism.Core.Database.ArticleRepoListInt;
import com.ism.Repositories.list.Impl.RepositoryImpl;
import com.ism.entities.Article;



public class ArticleRepo extends RepositoryImpl<Article> implements ArticleRepoListInt {

  @Override
  public Article selectByLibelle(String val) {
    datas = selectAll();
    return datas.stream()
    .filter(article -> article.getLibelle().compareTo(val) == 0)
    .findFirst()
    .orElse(null);
  }

  @Override
  public void update(Article amour) {
  }

  @Override
  public Article selectById(int id) {
    return datas.stream()
    .filter(article -> article.getId() == id)
    .findFirst()
    .orElse(null);
  }

  

  
  
}
