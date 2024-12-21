package com.ism.Views;

import com.ism.Core.Database.Views;
import com.ism.entities.Client;
import com.ism.entities.Demande;
import com.ism.enums.EtatDeDemande;

public interface DemandeViewInt extends Views<Demande, Client>{
  void voirArticleDemande(int id);
  void filtrerByEtat(EtatDeDemande etat);
  String response();
}
