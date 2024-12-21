package com.ism.Repositories.list;


import com.ism.Core.Database.UserRepoListInt;
import com.ism.Repositories.list.Impl.RepositoryImpl;
import com.ism.entities.User;



public class UserRepo extends RepositoryImpl<User> implements UserRepoListInt {

  @Override
  public User selectByLogin(String val) {
    return datas.stream()
    .filter(user -> user.getLogin().compareTo(val) == 0)
    .findFirst()
    .orElse(null);
  }

  @Override
public String login(String val) {
  boolean isUnique = datas.stream()
  .noneMatch(user -> user.getLogin().equals(val));

      return isUnique ? val : null;
  }

  @Override
  public User selectByPassord(String val) {
    return datas.stream()
    .filter(user -> user.getPassword().compareTo(val) == 0)
    .findFirst()
    .orElse(null);
  }

  @Override
  public User selectByEmail(String val) {
    return datas.stream()
    .filter(user -> user.getEmail().compareTo(val) == 0)
    .findFirst()
    .orElse(null);
  }

  @Override
  public User selectById(int id) {
    return datas.stream()
    .filter(user -> user.getId() == id)
    .findFirst()
    .orElse(null);
  }

  

  

  
}
