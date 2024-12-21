package com.ism.Factory.FactotyRepo.list;



public interface Factoryint<A,T,Y,O,G,P,B,E> {
  A getInstanceClient();
  T getInstanceUser();
  Y getInstanceArticle();
  O getInstanceDemande();
  G getInstanceDemandeArticle();
  P getInstanceDette();
  B getInstanceRole();
  E getInstancePaiement();
}
