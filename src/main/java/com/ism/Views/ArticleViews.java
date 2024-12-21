package com.ism.Views;

import java.util.List;

import com.ism.Service.ArticleServiceInt;
import com.ism.Views.Impl.Helper;
import com.ism.Views.Impl.ViewImpl2;
import com.ism.entities.Article;

import java.util.Scanner;

public class ArticleViews extends ViewImpl2<Article> implements ArticleViewInt{

  private ArticleServiceInt articleService;

  public ArticleViews(Scanner scan,ArticleServiceInt articleService) {
    ViewImpl2.scan = scan;
    this.articleService = articleService;
  }
  @Override
  public Article created() {
    Article michel = new Article();
   do {
      System.out.println("Veuillez saisir la reference");
      scan.nextLine();
      michel.setRef(scan.nextLine().trim());
      System.out.println("Veuillez saisir le libelle de l'article");
      michel.setLibelle(scan.nextLine().trim());
      System.out.println("Veuillez saisir le prix de l'article");
      michel.setPrix(Helper.saisieDouble(scan));
      System.out.println("Veuillez saisir la quantité de stock de l'article");
      michel.setQteStock(Helper.saisieInt(scan));
   } while (articleService.findData().selectByLibelle(michel.getLibelle()) != null);
   return michel;
  }
    @ Override
    public void afficheByDisponibility(List<Article> datas){
      datas.stream()
        .filter(article -> article.getQteStock() != 0)
        .forEach(System.out::println);
    }

    


  
  
}
