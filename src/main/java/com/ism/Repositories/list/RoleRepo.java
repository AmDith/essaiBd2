package com.ism.Repositories.list;

import com.ism.Core.Database.RoleRepoListInt;
import com.ism.Repositories.list.Impl.RepositoryImpl;
import com.ism.entities.Role;

public class RoleRepo  extends RepositoryImpl<Role> implements RoleRepoListInt{

  @Override
  public Role selectById(int id) {
    return datas.stream()
    .filter(role -> role.getId() == id)
    .findFirst()
    .orElse(null);
  }
  
}
