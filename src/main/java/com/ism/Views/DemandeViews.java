package com.ism.Views;

import java.util.List;
import java.util.Scanner;

import com.ism.Service.ArticleServiceInt;
import com.ism.Service.DemandeArticleServiceInt;
import com.ism.Service.DemandeServiceInt;
import com.ism.Views.Impl.Helper;
import com.ism.Views.Impl.ViewImpl;
import com.ism.entities.Article;
import com.ism.entities.Client;
import com.ism.entities.Demande;
import com.ism.entities.DemandeArticle;
import com.ism.enums.EtatDeDemande;
public class DemandeViews extends ViewImpl<Demande, Client> implements DemandeViewInt{

  private DemandeServiceInt demandeService;
  private ArticleServiceInt articleService;
  private DemandeArticleServiceInt  demandeArticleService;
  private static int idDemande = 0;


  public DemandeViews(Scanner scan,DemandeServiceInt demandeService,ArticleServiceInt articleService, DemandeArticleServiceInt  demandeArticleService) {
    ViewImpl.scan = scan;
    this.demandeService = demandeService;
    this.articleService = articleService;
    this.demandeArticleService = demandeArticleService;
  }


  @Override
  public void voirArticleDemande(int id) {
    demandeService.searchDemande(id)
        .getDemandearticles()
        .stream()
        .map(DemandeArticle::getArticle) // Extraire les articles
        .forEach(System.out::println); // Afficher chaque article
}

  //Donner le choix de choisir entre En cours et Annuler
  @Override
  public void filtrerByEtat(EtatDeDemande etat) {
    demandeService.show().stream()
        .filter(demande -> demande.getEtatDeDemande().equals(etat))
        .forEach(System.out::println);
  }
  //Avant de créer une demande verifier si le client à un compte👌
  // @Override
  // public Demande created(Client client) {
  //  Demande demande = new Demande();
  //  demande.setClient(client);
  //  demande.setUsercreate(client.getUser().getId());
  //  demande.setUserupdate(client.getUser().getId());
  //  client.getDemandes().add(demande);
  //  demande.setEtatDeDemande(EtatDeDemande.encours);
  //  return demande;
  // }


  

  

 
     

  @Override
  public Demande created(Client michel) {
    Demande demande = new Demande();
    demande.setMontant(0.0);
    Article article;
    int qte;
    String articleLibelle;
    scan.nextLine();
    do {
      System.out.println(articleService.show());
      System.out.println("Choisissez l'article");
      articleLibelle = scan.nextLine().trim();
      System.out.println("La quantité à emprêter souhaiter");
      qte =  Helper.saisieInt(scan);
      article = articleService.findData().selectByLibelle(articleLibelle);
      if (article == null || qte > article.getQteStock()) {
        System.out.println("Incorrect");
      }else{

        DemandeArticle demandeArticle = demandeArticleService.verf(demande, article, idDemande);
        if (demandeArticle != null) {
            demandeArticle.setQteDemande(demandeArticle.getQteDemande() + qte);
            demandeArticle.setSomme(demandeArticle.getQteDemande() * article.getPrix());
        } else {
            demandeArticle = new DemandeArticle();
            demandeArticle.setArticle(article);
            demandeArticle.setQteDemande(qte);
            demandeArticle.setSomme(qte * article.getPrix());
            demandeArticle.setDemande(demande);
            demande.addDemandeAticle(demandeArticle);
            idDemande = demandeArticle.getId();
        }
        article.setQteStock(article.getQteStock() - qte);
        articleService.findData().update(article);
        demande.setMontant(demande.getMontant() + demandeArticle.getSomme());
      }
    } while (response().equalsIgnoreCase("y") || article == null);
    return demande;
  }

  @Override
  public String response() {
    String response;
    do {
      scan.nextLine();
      System.out.println("Voulez-vous ajouter une autre article(y/n)");
      response = scan.nextLine().trim();
    } while (!response.equalsIgnoreCase("y") && !response.equalsIgnoreCase("n"));
    return response;
  }

  @Override
  public void affiche(List<Demande> datas){
      datas.stream()
      .filter(demande -> demande.getEtatDeDemande().equals(EtatDeDemande.encours))
      .forEach(System.out::println);
  }





}
