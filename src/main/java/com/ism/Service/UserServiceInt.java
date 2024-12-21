package com.ism.Service;


import com.ism.Core.Database.Service;
import com.ism.Core.Database.UserRepoListInt;
import com.ism.entities.User;


public interface UserServiceInt extends Service<User,UserRepoListInt> {

  void Off (User amour);
  void On (User amour);
}
