package com.ism.Views;

import com.ism.Core.Database.Views;
import com.ism.entities.Client;
import com.ism.entities.Role;
import com.ism.entities.User;


public interface UserViewInt extends Views<User,Client> {
  void filtreRole(String nomRole);
  Role findRole();
  Role findRoleClient();
  Role AffAss();
  User Connexion();
}
