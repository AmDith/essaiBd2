package com.ism.Service;

import java.util.List;

import com.ism.Core.Database.DemandeRepoListInt;
import com.ism.entities.Article;
import com.ism.entities.Demande;
import com.ism.entities.DemandeArticle;
import com.ism.enums.EtatDeDemande;

public class DemandeService implements DemandeServiceInt{

  private DemandeRepoListInt demandeRepo;

  public DemandeService(DemandeRepoListInt demandeRepo) {
    this.demandeRepo = demandeRepo;
  }

  @Override
  public boolean saveList(Demande objet) {
    if(objet != null){
      demandeRepo.insert(objet);
      return true;
    }
    return false;
  }

  @Override
  public List<Demande> show() {
    return  demandeRepo.selectAll();
  }

  @Override
  public DemandeRepoListInt findData() {
    return  demandeRepo;
  }

  @Override
  public void traitement(int id, EtatDeDemande etat) {
    Demande demande = searchDemande(id);
    demande.setEtatDeDemande(etat);
  }

  @Override
  public Demande searchDemande(int id) {
    return demandeRepo.selectById(id);
  }

  @Override
  public void relance(int id) {
    Demande demande = searchDemande(id);
   if (demande!= null) {
      demande.setEtatDeDemande(EtatDeDemande.encours);
    }
  }

  @Override
  public Demande verf(int id) {
    return show().stream()
    .filter(da -> da.getId() == id)
    .findFirst()
    .orElse(null);
  }
}
