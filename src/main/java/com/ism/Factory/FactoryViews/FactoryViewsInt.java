package com.ism.Factory.FactoryViews;

import java.util.Scanner;

import com.ism.Service.ArticleServiceInt;
import com.ism.Service.ClientServiceInt;
import com.ism.Service.DemandeArticleServiceInt;
import com.ism.Service.DemandeServiceInt;
import com.ism.Service.UserServiceInt;
import com.ism.Views.UserViewInt;

public interface FactoryViewsInt<A,T,Y,O,P,E> {
  A getInstanceClient(Scanner scan,ClientServiceInt clientService,UserViewInt uViews,UserServiceInt userService);
  T getInstanceUser(Scanner scan,UserServiceInt userService);
  Y getInstanceArticle(Scanner scan,ArticleServiceInt articleService);
  O getInstanceDemande(Scanner scan,DemandeServiceInt demandeService,ArticleServiceInt articleService, DemandeArticleServiceInt  demandeArticleService);
  P getInstanceDette(Scanner scan,DemandeServiceInt  demandeService);
  E getInstancePaiement(Scanner scan);
}
