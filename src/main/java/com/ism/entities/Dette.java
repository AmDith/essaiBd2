package com.ism.entities;

import java.util.ArrayList;
import java.util.List;

import com.ism.enums.EtatDette;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)

public class Dette extends AbstractEntity{
  private double montant;
  private double montantVerser;
  private double montantRestant;
  private EtatDette etat;
  private Client client;
  private Demande demande;
  private List<Paiement> paiements = new ArrayList<>();
  private static int nbreD;
  

  public Dette() {
    this.id = ++nbreD;
  }
  public static void setNbreD(int n){
    Dette.nbreD = n;
}

public static int getNbreD() {
    return Dette.nbreD;
}

public void addPaiement(Paiement dette) {
  paiements.add(dette);
}


}
