package com.ism.entities;

import java.util.ArrayList;
import java.util.List;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "details")
@EqualsAndHashCode(callSuper = false , of = {"ref", "libelle"}) 

public class Article extends AbstractEntity{

  private String ref;
  private String libelle;
  private double prix;
  private int qteStock;
  // private List<Detail> details = new ArrayList<>();
  private static int nbreA;
  private List<DemandeArticle> demandeArticles = new ArrayList<>();
  
  public Article() {
    this.id = ++nbreA;
  }

  public void addDemandeAticle(DemandeArticle demandeArticle) {
    demandeArticles.add(demandeArticle);
  }

  public static void setNbreA(int n){
    Article.nbreA = n;
}

public static int getNbreA() {
    return Article.nbreA;
}
  
  
}
