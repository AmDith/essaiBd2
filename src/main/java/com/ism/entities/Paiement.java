package com.ism.entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString (exclude = {"dette"})

public class Paiement extends AbstractEntity{
  private double montant;
  private Dette dette;
  private static int nbreP;

  public Paiement() {
    this.id = ++nbreP;
  }
  
  public static void setNbreP(int n){
    Paiement.nbreP = n;
}

public static int getNbreP() {
    return Paiement.nbreP;
}


}
