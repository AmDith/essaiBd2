package com.ism.Views;

import java.util.List;

import com.ism.Core.Database.Views2;
import com.ism.entities.Article;

public interface ArticleViewInt extends Views2<Article>{
  void afficheByDisponibility(List<Article> datas);
  
}
