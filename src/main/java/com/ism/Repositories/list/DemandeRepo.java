package com.ism.Repositories.list;

import com.ism.Core.Database.DemandeRepoListInt;
import com.ism.Repositories.list.Impl.RepositoryImpl;

import com.ism.entities.Demande;
public class DemandeRepo extends RepositoryImpl<Demande> implements DemandeRepoListInt {

  @Override
  public Demande selectById(int id) {
    return datas.stream()
    .filter(demande -> demande.getId() == id)
    .findFirst()
    .orElse(null);
  }
  
}
