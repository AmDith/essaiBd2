package com.ism.Views;

import com.ism.Service.RoleService;
import com.ism.Service.RoleServiceInt;
import com.ism.Service.UserServiceInt;
import com.ism.Views.Impl.Helper;
import com.ism.Views.Impl.ViewImpl;
import com.ism.entities.Client;
import com.ism.entities.Role;
import com.ism.entities.User;
import com.ism.enums.Etat;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;
import java.util.List;

@Setter
@Getter

public class UserViews extends ViewImpl<User,Client> implements UserViewInt {


  private UserServiceInt userService;
  private RoleServiceInt roleService;
  private static int repet = 0; 

  public UserViews(Scanner scan,UserServiceInt userService) {
    ViewImpl.scan = scan;
    this.userService = userService;
    this.roleService = new RoleService();
    
  }

  

  @Override
  public User created(Client client) {
    User user = new User();
    System.out.println("rrr");
    do {
      System.out.println("Veuillez saisir votre login");
      user.setLogin(scan.nextLine().trim());
      System.out.println("Veuillez saisir votre email");
      user.setEmail(scan.nextLine().trim());
      System.out.println("Veuillez saisir votre password");
      user.setPassword(scan.nextLine().trim());
      user.setEtat(Etat.Activer);
      if (client != null) {
        if (client.getUser() == null) {
          user.setRole(findRoleClient());
          user.setClient(client);
        }else{
          System.out.println("Ce client a deja un compte");
        }
      }
      if (client == null){
        user.setRole(findRole());
      }
    } while (userService.findData().selectByLogin(user.getLogin())!= null || userService.findData().selectByEmail(user.getEmail())!= null || userService.findData().selectByPassord(user.getPassword())!= null);
    return user;
  }


  // @Override
  // public User created(Client client) {
  //     User user;
  //     boolean loginCheck;
  //     boolean emailCheck;
  //     boolean passwordCheck;
  //     do {
  //         user = new User(); // Créer un nouvel utilisateur à chaque itération
  //         // Saisie des informations utilisateur
  //         System.out.println("Veuillez saisir votre login");
  //         String login = scan.nextLine();
  //         System.out.println("Veuillez saisir votre email");
  //         String email = scan.nextLine();
  //         System.out.println("Veuillez saisir votre password");
  //         String password = scan.nextLine();

  //         // Affecter les valeurs saisies à l'objet utilisateur
  //         user.setLogin(login);
  //         user.setEmail(email);
  //         user.setPassword(password);
  //         user.setEtat(Etat.Activer);
  //         System.out.println(user.getLogin());
  //         System.out.println(user.getEmail());
  //         System.out.println(user.getPassword());

  //         if (client != null) {
  //             if (client.getUser() == null) {
  //                 user.setRole(findRoleClient());
  //                 System.out.println("EFEE");
  //             } else {
  //                 System.out.println("Ce client a déjà un compte.");
  //             }
  //         } else {
  //             user.setRole(findRole());
  //         }

  //         // Ajoutez des messages de débogage pour chaque condition
  //         loginCheck = userService.findData().selectByLogin(user.getLogin()) != null;
  //         emailCheck = userService.findData().selectByEmail(user.getEmail()) != null;
  //         passwordCheck = userService.findData().selectByPassord(user.getPassword()) != null;

  //         System.out.println("Login check: " + loginCheck);
  //         System.out.println("Email check: " + emailCheck);
  //         System.out.println("Password check: " + passwordCheck);
          

  //     } while (loginCheck || emailCheck || passwordCheck); // La boucle s'arrête quand toutes les conditions sont fausses

  //     return user;
  // }



  @Override
  public Role findRole(){
    int choix ;
    Role role = new Role();
    do {
      System.out.println("Choisissez le rôle du compte");
      System.out.println("1-Boutiquier");
      System.out.println("2-Admin");
      choix = Helper.saisieInt(scan);
    } while (choix < 0 || choix > 2);
    if (choix == 1) {
      role.setNomRole("Boutiquier");
      role.setId(choix);
    }
    else{
      role.setNomRole("Admin");
      role.setId(choix);
    }
    return role;
  }

  

  @Override
  public void affiche(List<User> datas) {
    datas.stream()
         .filter(data -> data.getEtat() == Etat.Activer)
         .forEach(data -> System.out.println(data));
}


  @Override
  public void filtreRole(String nomRole) {
    userService.findData().selectAll().stream()
        .filter(data -> data.getRole().getNomRole().equals(nomRole))
        .forEach(data -> System.out.println(data));
}

  @Override
  public Role findRoleClient() {
    Role role = new Role();
    role.setId(3);
    role.setNomRole("Client");
    return role;
  }
  @Override
  public Role AffAss(){
    int choix ;
    Role role = new Role();
    do {
      System.out.println("1-Admin");
      System.out.println("2-Boutiquier");
      System.out.println("3-Client");
      choix = scan.nextInt();
    } while (choix < 0 || choix > 3);
    if (choix == 1) {
      role.setNomRole("Admin");
      role.setId(choix);
    }
    else if(choix == 2){
      role.setNomRole("Boutiquier");
      role.setId(choix);
    }else{
      role.setNomRole("Client");
      role.setId(choix);
    }
    return role;
  }


  @Override
  public User Connexion(){
    User user;
    String login;
    String password;
    if (repet < 1) {
      fixtures();
      repet = ++repet;
    }
    do{
        System.out.println("--Connexion--");
        System.out.println("----Entrer le login----");
        login =  scan.nextLine().trim();
        System.out.println("----Entrer le mot de passe----");
        password = scan.nextLine().trim();
        user = userService.findData().selectByLogin(login);
    }while ((user == null || userService.findData().selectByPassord(password) == null) || user.getEtat().equals(Etat.Desactiver));
    System.out.println(user);
    return user;
    
}

  // @Override
  public void fixtures() {
    Role role1 = new Role("Boutiquier");
    roleService.findData().insert(role1);
    Role role2 = new Role("Admin");
    roleService.findData().insert(role2);
    Role role3 = new Role("Client");
    roleService.findData().insert(role3);
    User user1 = new User("boutiquier@gmail.com", "loginBoutiquier", "boutiquier", Etat.Activer, role1);
    userService.findData().insert(user1);
    User user2 = new User("admin@gmail.com", "loginAdmin", "admin", Etat.Activer, role2);
    userService.findData().insert(user2);
    User user3 = new User("amour@gmail.com", "amour", "321", Etat.Activer, role3);
    userService.findData().insert(user3);
    System.out.println(userService.show());
  }
  
  
}
