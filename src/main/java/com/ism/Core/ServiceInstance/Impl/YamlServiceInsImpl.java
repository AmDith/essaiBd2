package com.ism.Core.ServiceInstance.Impl;


import com.ism.Core.Database.ArticleRepoListInt;
import com.ism.Core.Database.ClientRepoListInt;
import com.ism.Core.Database.Database;
import com.ism.Core.Database.DemandeRepoListInt;
import com.ism.Core.Database.DemandeArticleRepoListInt;
import com.ism.Core.Database.DetteRepoListInt;
import com.ism.Core.Database.PaiementRepoListInt;
import com.ism.Core.Database.RoleRepoListInt;
import com.ism.Core.Database.UserRepoListInt;
import com.ism.Core.ServiceInstance.YamlServiceIns;

public class YamlServiceInsImpl implements YamlServiceIns{

    

  
     

  @Override
  public Object getInstanceClient(String repoType, String repoType2, ClientRepoListInt clientRepo) {
    try {
      String className = Database.getActiveDatabase(repoType, repoType2);
      if (className != null) {
          Class<?> clazz = Class.forName(className);
          return clazz.getDeclaredConstructor(ClientRepoListInt.class).newInstance(clientRepo);
      }
      } catch (Exception e) {
          e.printStackTrace();
      }
      return null;
  }

  @Override
  public Object getInstanceUser(String repoType, String repoType2, UserRepoListInt userRepo) {
    try {
      String className = Database.getActiveDatabase(repoType, repoType2);
      if (className != null) {
          Class<?> clazz = Class.forName(className);
          return clazz.getDeclaredConstructor(UserRepoListInt.class).newInstance(userRepo);
      }
      } catch (Exception e) {
          e.printStackTrace();
      }
      return null;
  }

  @Override
  public Object getInstanceArticle(String repoType, String repoType2, ArticleRepoListInt articleRepo) {
    try {
      String className = Database.getActiveDatabase(repoType, repoType2);
      if (className != null) {
          Class<?> clazz = Class.forName(className);
          return clazz.getDeclaredConstructor(ArticleRepoListInt.class).newInstance(articleRepo);
      }
      } catch (Exception e) {
          e.printStackTrace();
      }
      return null;
  }

  @Override
  public Object getInstanceDemande(String repoType, String repoType2, DemandeRepoListInt demandeRepo) {
    try {
      String className = Database.getActiveDatabase(repoType, repoType2);
      if (className != null) {
          Class<?> clazz = Class.forName(className);
          return clazz.getDeclaredConstructor(DemandeRepoListInt.class).newInstance(demandeRepo);
      }
      } catch (Exception e) {
          e.printStackTrace();
      }
      return null;
  }

  @Override
  public Object getInstanceDemandeArticle(String repoType, String repoType2, DemandeArticleRepoListInt demandeArticleRepo) {
    try {
      String className = Database.getActiveDatabase(repoType, repoType2);
      if (className != null) {
          Class<?> clazz = Class.forName(className);
          return clazz.getDeclaredConstructor(DemandeArticleRepoListInt.class).newInstance(demandeArticleRepo);
      }
      } catch (Exception e) {
          e.printStackTrace();
      }
      return null;
  }

  @Override
  public Object getInstanceDette(String repoType, String repoType2, DetteRepoListInt detteRepo) {
    try {
      String className = Database.getActiveDatabase(repoType, repoType2);
      if (className != null) {
          Class<?> clazz = Class.forName(className);
          return clazz.getDeclaredConstructor(DetteRepoListInt.class).newInstance(detteRepo);
      }
      } catch (Exception e) {
          e.printStackTrace();
      }
      return null;
  }

  @Override
  public Object getInstancePaiement(String repoType, String repoType2, PaiementRepoListInt paiementRepo) {
    try {
      String className = Database.getActiveDatabase(repoType, repoType2);
      if (className != null) {
          Class<?> clazz = Class.forName(className);
          return clazz.getDeclaredConstructor(PaiementRepoListInt.class).newInstance(paiementRepo);
      }
      } catch (Exception e) {
          e.printStackTrace();
      }
      return null;
  }

@Override
public Object getInstanceRole(String repoType, String repoType2, RoleRepoListInt roleRepo) {
    try {
        String className = Database.getActiveDatabase(repoType, repoType2);
        if (className != null) {
            Class<?> clazz = Class.forName(className);
            return clazz.getDeclaredConstructor(RoleRepoListInt.class).newInstance(roleRepo);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
  
}
