package com.ism.Service;

import java.util.List;

import com.ism.Core.Database.ArticleRepoListInt;
import com.ism.entities.Article;


public class ArticleService implements ArticleServiceInt {


  private ArticleRepoListInt articleRepo;

  
  
  public ArticleService(ArticleRepoListInt articleRepo) {
    this.articleRepo = articleRepo;
  }

  @Override
  public boolean saveList(Article objet) {
    if(objet != null){
      articleRepo.insert(objet);
      return true;
    }
    return false;
  }

  @Override
  public List<Article> show() {
    return articleRepo.selectAll();
  }


  @Override
  public void updateQteStock(int qteRe, String val) {
    articleRepo.selectAll().stream()
        .filter(article -> article.getLibelle().compareTo(val) == 0)
        .forEach(article -> {
          article.setQteStock(article.getQteStock() + qteRe);
          articleRepo.update(article);
        });
}



  @Override
  public ArticleRepoListInt findData() {
    return articleRepo;
  }

  
}
