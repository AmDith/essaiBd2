package com.ism.entities;

import java.util.ArrayList;
import java.util.List;

import com.ism.enums.EtatDeDemande;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
public class Demande extends AbstractEntity{
  private EtatDeDemande etatDeDemande;
  private Client client;
  private Dette dette;
  private double montant;
  private static int nbreDEM;
  private List<DemandeArticle> demandearticles = new ArrayList<>();

  public Demande() {
    this.id = ++ nbreDEM;
  }

  public static void setNbreDEM(int n){
    Demande.nbreDEM = n;
}

public static int getNbreDEM() {
    return Demande.nbreDEM;
}

public void addDemandeAticle(DemandeArticle demandearticle) {
  demandearticles.add(demandearticle);
}

  
}
