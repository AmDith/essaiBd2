package com.ism.Service;

import com.ism.Core.Database.DemandeRepoListInt;
import com.ism.Core.Database.Service;
import com.ism.entities.Demande;
import com.ism.enums.EtatDeDemande;


public interface DemandeServiceInt extends Service<Demande, DemandeRepoListInt> {
  void traitement(int id, EtatDeDemande etat);
  Demande searchDemande(int id);
  void relance(int id);
  Demande verf(int id);
}
