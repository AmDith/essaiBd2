package com.ism.Repositories.list;


import com.ism.Core.Database.DetteRepoListInt;
import com.ism.Repositories.list.Impl.RepositoryImpl;
import com.ism.entities.Dette;



public class DetteRepo extends RepositoryImpl<Dette> implements DetteRepoListInt {

  @Override
  public void update(Dette amour) {
  }

  @Override
  public Dette selectById(int id) {
    return datas.stream()
    .filter(dette -> dette.getId() == id)
    .findFirst()
    .orElse(null);
  }


  
}
