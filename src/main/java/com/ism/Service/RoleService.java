package com.ism.Service;

import com.ism.Core.Database.RoleRepoListInt;
import com.ism.Repositories.list.RoleRepo;

public class RoleService implements RoleServiceInt {

  private RoleRepoListInt roleRepo;

  
  public RoleService() {
    this.roleRepo = new RoleRepo();
  }


  @Override
  public RoleRepoListInt findData() {
    return roleRepo;
  }
}
