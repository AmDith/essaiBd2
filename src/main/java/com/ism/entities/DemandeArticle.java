package com.ism.entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = {"demande","article"})
@EqualsAndHashCode(callSuper = false)

public class DemandeArticle extends  AbstractEntity {
  private Double somme;
  private int qteDemande;
  private Demande demande;
  private Article article;
  private static int nbreNA;

  public DemandeArticle() {
    id = ++ nbreNA;
  }

  public static void setNbreNA(int n){
    DemandeArticle.nbreNA = n;
}

  public static int getNbreNA() {
    return DemandeArticle.nbreNA;
}

  
  
}
