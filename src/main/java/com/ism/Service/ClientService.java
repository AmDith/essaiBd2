package com.ism.Service;

import java.util.List;

import com.ism.Repositories.JPA.ClientRepoJpa;
import com.ism.entities.Client;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


<<<<<<< HEAD

@Setter
@Getter
@EqualsAndHashCode

public class ClientService implements ClientServiceInt {
=======
public class ClientService implements ClientServiceInt<Client,ClientRepoJpa> {
>>>>>>> 636e632b84cd90083a1320eeab3b5026a11454c2

  private ClientRepoJpa clientRepo;

  
  public ClientService(ClientRepoJpa clientRepo) {
    this.clientRepo = clientRepo;
  }


  @Override
  public boolean saveList(Client objet) {
    if(objet != null){
      clientRepo.insert(objet);
      return true;
    }
    return false;
  }


  @Override
  public List<Client> show() {
    return clientRepo.selectAll();
  }

  


  @Override
  public ClientRepoJpa findData() {
    return clientRepo;
  }


  @Override
  public Client searchSurname(String name) {
    return clientRepo.selectBySurname(name);
  }
  
}
