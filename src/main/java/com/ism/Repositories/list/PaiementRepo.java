package com.ism.Repositories.list;

import com.ism.Core.Database.PaiementRepoListInt;
import com.ism.Repositories.list.Impl.RepositoryImpl;
import com.ism.entities.Paiement;

public class PaiementRepo extends RepositoryImpl<Paiement> implements PaiementRepoListInt {

  @Override
  public Paiement selectById(int id) {
    return datas.stream()
    .filter(paiement -> paiement.getId() == id)
    .findFirst()
    .orElse(null);
  }
  
}
