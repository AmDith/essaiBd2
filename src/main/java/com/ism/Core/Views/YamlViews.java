package com.ism.Core.Views;

import java.util.Scanner;

import com.ism.Service.ArticleServiceInt;
import com.ism.Service.ClientServiceInt;
import com.ism.Service.DemandeArticleServiceInt;
import com.ism.Service.DemandeServiceInt;
import com.ism.Service.UserServiceInt;
import com.ism.Views.UserViewInt;

public interface YamlViews {
  Object getInstanceClient(String repoType, String repoType2,Scanner scan,ClientServiceInt clientService,UserViewInt uViews,UserServiceInt userService);
  Object getInstanceUser(String repoType, String repoType2,Scanner scan,UserServiceInt userService);
  Object getInstanceArticle(String repoType, String repoType2,Scanner scan,ArticleServiceInt articleService);
  Object getInstanceDemande(String repoType, String repoType2,Scanner scan,DemandeServiceInt demandeService, ArticleServiceInt articleService, DemandeArticleServiceInt  demandeArticleService);
  Object getInstanceDette(String repoType, String repoType2,Scanner scan,DemandeServiceInt demandeService);
  Object getInstancePaiement(String repoType, String repoType2,Scanner scan);
}