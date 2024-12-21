package com.ism.Factory.FactoryViews;


import java.util.Scanner;

<<<<<<< HEAD
import com.ism.Core.Views.YamlViews;
import com.ism.Core.Views.Impl.YamlViewsImpl;
import com.ism.Factory.FactoryViewsImpl;
import com.ism.Service.ArticleServiceInt;
=======
import com.ism.Core.Database.ClientRepoListInt;
import com.ism.Core.Database.UserRepoListInt;
import com.ism.Repositories.JPA.ClientRepoJpa;
import com.ism.Repositories.JPA.UserRepoJpa;
>>>>>>> 636e632b84cd90083a1320eeab3b5026a11454c2
import com.ism.Service.ClientServiceInt;
import com.ism.Service.DemandeArticleServiceInt;
import com.ism.Service.DemandeServiceInt;
import com.ism.Service.UserServiceInt;
import com.ism.Views.ClientViews;
import com.ism.Views.DemandeViews;
import com.ism.Views.DetteViews;
import com.ism.Views.PaiementViews;
import com.ism.Views.UserViewInt;
import com.ism.Views.UserViews;
<<<<<<< HEAD
=======
import com.ism.entities.Client;
import com.ism.entities.User;
>>>>>>> 636e632b84cd90083a1320eeab3b5026a11454c2

public class FactoryViews extends FactoryViewsImpl<ClientViews,UserViews,ArticleViews,DemandeViews,DetteViews,PaiementViews> implements FactoryViewsInt<ClientViews,UserViews,ArticleViews,DemandeViews,DetteViews,PaiementViews> {

  YamlViews yamlViews;

  public FactoryViews() {
    yamlViews = new YamlViewsImpl();
  }

<<<<<<< HEAD
  @Override
  public ClientViews getInstanceClient(Scanner scan, ClientServiceInt clientService,
      UserViewInt uViews,UserServiceInt userService) {
        if (dT == null) {
          dT = (ClientViews) yamlViews.getInstanceClient("view","client",scan,clientService,uViews,userService);
          //dT= new ClientViews(scan, clientService, uViews);
          System.out.println(dT);
        }
        return dT;
  }
=======
  private static ClientViews clientService = null ;
  private static UserViews userService = null ;
>>>>>>> 636e632b84cd90083a1320eeab3b5026a11454c2

  @Override
  public UserViews getInstanceUser(Scanner scan, UserServiceInt userService) {
    if (dA == null) {
      return (UserViews) yamlViews.getInstanceUser("view","user",scan,userService); 
    }
    return dA;
  }

<<<<<<< HEAD
  @Override
  public ArticleViews getInstanceArticle(Scanner scan, ArticleServiceInt articleService) {
      if (dY == null) {
        return (ArticleViews) yamlViews.getInstanceArticle("view","article",scan,articleService);
      }
      return dY;
  }

  @Override
  public DemandeViews getInstanceDemande(Scanner scan, DemandeServiceInt demandeService,ArticleServiceInt articleService, DemandeArticleServiceInt  demandeArticleService) {
    if (dO == null) {
      return (DemandeViews) yamlViews.getInstanceDemande("view","demande",scan,demandeService,articleService,demandeArticleService);
=======



public static ClientViews getInstanceC(Scanner breuhk, ClientServiceInt<Client,ClientRepoJpa> breuk,UserViewInt moi){
  if (clientService == null) {
    clientService = new ClientViews(breuhk,breuk,moi);
>>>>>>> 636e632b84cd90083a1320eeab3b5026a11454c2
    }
    return dO;
  }

 

  @Override
  public DetteViews getInstanceDette(Scanner scan,DemandeServiceInt  demandeService) {
        if (dP == null) {
          return (DetteViews) yamlViews.getInstanceDette("view","dette",scan, demandeService); 
        }
        return dP;
  }

<<<<<<< HEAD
  @Override
  public PaiementViews getInstancePaiement(Scanner scan) {
    if (dE == null) {
      return (PaiementViews) yamlViews.getInstancePaiement("view","paiement",scan); 
=======

public static UserViews getInstanceU(Scanner breuhk, UserServiceInt<User,UserRepoJpa> breuk) {
  if (userService == null) {
    userService = new UserViews(breuhk,breuk);
>>>>>>> 636e632b84cd90083a1320eeab3b5026a11454c2
    }
    return dE;
  }





}
