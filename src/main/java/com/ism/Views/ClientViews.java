package com.ism.Views;


<<<<<<< HEAD
import com.ism.Service.ClientServiceInt;
import com.ism.Service.UserServiceInt;
=======
import com.ism.Repositories.JPA.ClientRepoJpa;
import com.ism.Service.ClientServiceInt;
>>>>>>> 636e632b84cd90083a1320eeab3b5026a11454c2
import com.ism.Views.Impl.ViewImpl;
import com.ism.entities.Client;
import com.ism.entities.User;

import java.util.Scanner;


public class ClientViews extends ViewImpl<Client,User> implements ClientViewsInt{
  
<<<<<<< HEAD
  private ClientServiceInt clientService;
  private UserServiceInt userService;
  private UserViewInt uViews;
  
  public ClientViews(Scanner scan,ClientServiceInt clientService,UserViewInt uViews,UserServiceInt userService) {
=======
  private ClientServiceInt<Client,ClientRepoJpa> clientService;
  private UserViewInt uViews;
  public ClientViews(Scanner scan,ClientServiceInt<Client,ClientRepoJpa> clientService,UserViewInt uViews) {
>>>>>>> 636e632b84cd90083a1320eeab3b5026a11454c2
    ViewImpl.scan = scan;
    this.clientService = clientService;
    this.userService = userService;
    this.uViews = uViews;
  }

  @Override
  public Client created(User us) {
    Client client = new Client();
<<<<<<< HEAD
    do {
      System.out.println("Enter le surname: ");
=======
      System.out.println("Enter surname: ");
>>>>>>> 636e632b84cd90083a1320eeab3b5026a11454c2
      scan.nextLine();
      client.setName(scan.nextLine().trim());
      System.out.println("Enter le numero de phone: ");
      client.setTel(scan.nextLine().trim()); 
      System.out.println("Enter l'address: ");
      client.setAdresse(scan.nextLine().trim());
      choixCreateUser(client,us);
<<<<<<< HEAD
    } while (clientService.search(client.getTel()) != null || clientService.searchSurname(client.getName()) != null);
=======
      System.out.println(client);
>>>>>>> 636e632b84cd90083a1320eeab3b5026a11454c2
    return client;
  }

  public void choixCreateUser(Client client,User us){
    String response;
    do {
      System.out.println("Voulez-vous ajouter un compte à ce client(y/n)");
      response = scan.next().trim();
      scan.nextLine();
      if (response.equalsIgnoreCase("y")) {
          User user = uViews.created(client);
          client.setUser(user);
          userService.saveList(user);
      }else{
        client.setUser(us);
      }
    } while (!response.equalsIgnoreCase("y") && !response.equalsIgnoreCase("n"));
  }

  

  

  
  
}
