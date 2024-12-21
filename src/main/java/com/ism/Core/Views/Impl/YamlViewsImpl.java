package com.ism.Core.Views.Impl;

import java.util.Scanner;

import com.ism.Core.Database.Database;
import com.ism.Core.Views.YamlViews;
import com.ism.Service.ArticleServiceInt;
import com.ism.Service.ClientServiceInt;
import com.ism.Service.DemandeArticleServiceInt;
import com.ism.Service.DemandeServiceInt;
import com.ism.Service.UserServiceInt;
import com.ism.Views.UserViewInt;

import lombok.Data;
@Data

public class YamlViewsImpl implements YamlViews {

 

  


  



 

  @Override
  public Object getInstanceClient(String repoType, String repoType2, Scanner scan, ClientServiceInt clientService,
      UserViewInt uViews,UserServiceInt userService) {
        try {
          String className = Database.getActiveDatabase(repoType, repoType2);
          System.out.println(className);
            if (className != null) {
              Class<?> clazz = Class.forName(className);
              return clazz.getDeclaredConstructor(Scanner.class,ClientServiceInt.class,UserViewInt.class,UserServiceInt.class).newInstance(scan,clientService,uViews,userService);
          }
          } catch (Exception e) {
              e.printStackTrace();
          }
          return null;
  }

  @Override
  public Object getInstanceUser(String repoType, String repoType2, Scanner scan, UserServiceInt userService) {
    try {
      String className = Database.getActiveDatabase(repoType, repoType2);
      if (className != null) {
          Class<?> clazz = Class.forName(className);
          return clazz.getDeclaredConstructor(Scanner.class,UserServiceInt.class).newInstance(scan,userService);
      }
      } catch (Exception e) {
          e.printStackTrace();
      }
      return null;
  }

  @Override
  public Object getInstanceArticle(String repoType, String repoType2, Scanner scan, ArticleServiceInt articleService) {
    try {
      String className = Database.getActiveDatabase(repoType, repoType2);
      if (className != null) {
          Class<?> clazz = Class.forName(className);
          return clazz.getDeclaredConstructor(Scanner.class,ArticleServiceInt.class).newInstance(scan,articleService);
      }
      } catch (Exception e) {
          e.printStackTrace();
      }
      return null;
  }

  @Override
  public Object getInstanceDemande(String repoType, String repoType2, Scanner scan, DemandeServiceInt demandeService, ArticleServiceInt articleService, DemandeArticleServiceInt  demandeArticleService) {
    try {
      String className = Database.getActiveDatabase(repoType, repoType2);
      if (className != null) {
          Class<?> clazz = Class.forName(className);
          return clazz.getDeclaredConstructor(Scanner.class,DemandeServiceInt.class,ArticleServiceInt.class,DemandeArticleServiceInt.class).newInstance(scan,demandeService,articleService,demandeArticleService);
      }
      } catch (Exception e) {
          e.printStackTrace();
      }
      return null;
  }

  @Override
  public Object getInstanceDette(String repoType, String repoType2, Scanner scan, DemandeServiceInt demandeService) {
        try {
          String className = Database.getActiveDatabase(repoType, repoType2);
          if (className != null) {
              Class<?> clazz = Class.forName(className);
              return clazz.getDeclaredConstructor(Scanner.class,DemandeServiceInt.class).newInstance(scan,demandeService);
          }
          } catch (Exception e) {
              e.printStackTrace();
          }
          return null;
  }

  @Override
  public Object getInstancePaiement(String repoType, String repoType2, Scanner scan) {
    try {
      String className = Database.getActiveDatabase(repoType, repoType2);
      if (className != null) {
          Class<?> clazz = Class.forName(className);
          return clazz.getDeclaredConstructor(Scanner.class).newInstance(scan);
      }
      } catch (Exception e) {
          e.printStackTrace();
      }
      return null;
  }
  
}
