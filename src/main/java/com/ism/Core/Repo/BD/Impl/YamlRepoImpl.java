package com.ism.Core.Repo.BD.Impl;

import com.ism.Core.Database.ArticleRepoListInt;
import com.ism.Core.Database.ClientRepoListInt;
import com.ism.Core.Database.Database;
import com.ism.Core.Database.DemandeRepoListInt;
import com.ism.Core.Database.DetteRepoListInt;
import com.ism.Core.Database.UserRepoListInt;
import com.ism.Core.Repo.BD.YamlRepo;

public class YamlRepoImpl implements YamlRepo {


@Override
    public Object getInstance(String repoType, String repoType2) {
        try {
            String className = Database.getActiveDatabase(repoType, repoType2);
            if (className != null) {
                Class<?> clazz = Class.forName(className);
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

     @Override
    public Object getInstanceClient(String repoType, String repoType2, UserRepoListInt uRepo) {
    try {
      String className = Database.getActiveDatabase(repoType, repoType2);
      if (className != null) {
          Class<?> clazz = Class.forName(className);
          return clazz.getDeclaredConstructor(UserRepoListInt.class).newInstance(uRepo);
      }
      } catch (Exception e) {
          e.printStackTrace();
      }
      return null;
    }


    @Override
    public Object getInstanceDemande(String repoType, String repoType2, ClientRepoListInt clientRepo) {
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
    public Object getInstanceDemandeArticle(String repoType, String repoType2, ArticleRepoListInt articleRepo, DemandeRepoListInt demandeRepo) {
      try {
        String className = Database.getActiveDatabase(repoType, repoType2);
        if (className != null) {
            Class<?> clazz = Class.forName(className);
            return clazz.getDeclaredConstructor(ArticleRepoListInt.class,DemandeRepoListInt.class).newInstance(articleRepo,demandeRepo);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Object getInstanceDette(String repoType, String repoType2, ClientRepoListInt clientRepo) {
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
    public Object getInstancePaiement(String repoType, String repoType2, DetteRepoListInt dette) {
      try {
        String className = Database.getActiveDatabase(repoType, repoType2);
        if (className != null) {
            Class<?> clazz = Class.forName(className);
            return clazz.getDeclaredConstructor(DetteRepoListInt.class).newInstance(dette);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }




}
