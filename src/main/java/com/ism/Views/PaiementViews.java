package com.ism.Views;

import java.util.Scanner;

import com.ism.Views.Impl.Helper;
import com.ism.Views.Impl.ViewImpl;
import com.ism.entities.Dette;
import com.ism.entities.Paiement;

public class PaiementViews extends ViewImpl<Paiement, Dette> implements PaiementViewInt {

  public PaiementViews(Scanner scan) {
    ViewImpl.scan = scan;
  }

  @Override
public Paiement created(Dette michel) {
    Paiement paiement = new Paiement();
    double montant;
    do {
        michel.setMontantRestant(michel.getMontant() - michel.getMontantVerser());
        System.out.println("Entrez une somme:");
        montant = Helper.saisieDouble(scan);
        if (montant <= 0 ||  montant >  michel.getMontantRestant() ) {
            System.out.println("La somme doit être un montant positif et ne doit pas dépasser le montant restant .");
        } else { 
            michel.setMontantVerser(michel.getMontantVerser() + montant);
            michel.setMontantRestant(michel.getMontant() - michel.getMontantVerser());
            paiement.setMontant(montant);
            paiement.setDette(michel);
            System.out.println("Il reste: " + michel.getMontantRestant() + "$");
        }
    } while (michel.getMontantVerser() <= 0 ||  michel.getMontantVerser() >  michel.getMontantRestant());

    return paiement;
}

  
}
