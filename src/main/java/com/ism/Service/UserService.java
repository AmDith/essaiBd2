package com.ism.Service;


import java.util.List;

import com.ism.Repositories.JPA.UserRepoJpa;
import com.ism.entities.User;
import com.ism.enums.Etat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode

<<<<<<< HEAD
public class UserService implements UserServiceInt{
=======
public class UserService implements UserServiceInt<User,UserRepoJpa>{
>>>>>>> 636e632b84cd90083a1320eeab3b5026a11454c2

  private UserRepoJpa userRepo;

  
  public UserService(UserRepoJpa userRepo) {
    this.userRepo = userRepo;
  }


  @Override
  public boolean saveList(User objet) {
    if(objet != null){
      userRepo.insert(objet);
      return true;
    }
    return false;
  }


  @Override
  public List<User> show() {
    return userRepo.selectAll();
  }




  @Override
  public void Off(User user) {
    user.setEtat(Etat.Desactiver);
  }


  @Override
  public void On(User amour) {
    amour.setEtat(Etat.Activer);
  }


  @Override
  public UserRepoJpa findData() {
    return userRepo;
  }


  


  


  
  
  
}
