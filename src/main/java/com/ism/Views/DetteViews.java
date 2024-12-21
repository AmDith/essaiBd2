package com.ism.Views;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ism.Service.ArticleServiceInt;
import com.ism.Service.DemandeServiceInt;
import com.ism.Views.Impl.Helper;
import com.ism.Views.Impl.ViewImpl;
import com.ism.entities.Client;
import com.ism.entities.Demande;
import com.ism.entities.Dette;
import com.ism.enums.EtatDeDemande;
import com.ism.enums.EtatDette;

public class DetteViews extends ViewImpl<Dette, Client> implements DetteViewInt{



    private DemandeServiceInt demandeService;

//   Pour créer une dette je dois vérifier que le client ait fait une demande et la demande doit être validée

// lui demander aussi s'il veut une nouvelle dette ou bien ajouter des détails

// Chaque client a droit qu'à une dette tant
// qu'il n'a pas fini de le payer mais il peut toujours ajouter des détails(articles et quantité)

  

  

  public DetteViews(Scanner scan, DemandeServiceInt demandeService) {
      ViewImpl.scan = scan;
      this.demandeService = demandeService;

    }

  // @Override
  // public Dette created(Client michel) {
  //   Dette dette = new Dette();
  //   Article article;
  //   int qte;
  //   String articleLibelle;
  //   // dette.setDetails(new ArrayList<>());
  //   dette.setMontant(0.0);
  //   do {
  //     System.out.println(articleService.show());
  //     System.out.println("Choisissez l'article et la quantité à emprêter souhaiter");
  //     articleLibelle = scan.nextLine();
  //     qte =  scan.nextInt();
  //     article = articleService.findData().selectByLibelle(articleLibelle);
  //     if (article == null || qte > article.getQteStock()) {
  //       System.out.println("Incorrect");
  //     }else{
  //       Detail detail2 = detailService.verf(article);
  //       if (detail2!= null) {
  //         detail2.setQteVendu(detail2.getQteVendu() + qte);
  //         detail2.setSomme(detail2.getQteVendu() * article.getPrix());
  //       }else{
  //         Detail detail = new Detail();
  //         // article.setDetails(new ArrayList<>());
  //         article.setQteStock(article.getQteStock() -  qte);
  //         articleService.findData().update(article);
  //         detail.setArticle(article);
  //         detail.setQteVendu(detail.getQteVendu() + qte);
  //         detail.setSomme(detail.getQteVendu() * article.getPrix());
  //         article.getDetails().add(detail);
  //         dette.setMontant(dette.getMontant() + detail.getSomme());
  //         dette.setMontantVerser(0.0);
  //         dette.setClient(michel);
  //         dette.getDetails().add(detail);
  //         dette.setEtat(EtatDette.Nonarchiver);
  //         detail.setDette(dette);
  //       }
  //     }
  //   } while (response().equalsIgnoreCase("y") || article == null);
  //   return dette;
  // }

  

  @Override
public void detteNonSolder(List<Dette> dettes) {
  dettes.stream()
        .peek(dette ->dette.setMontantRestant(dette.getMontant() - dette.getMontantVerser()))
        .filter(dette -> dette.getMontantRestant() != 0)
        .forEach(System.out::println);
}

  @Override
  public Dette created(Client michel) {
    Dette dette = new Dette();
    dette.setMontant(0.0);
    System.out.println("Entrez l'id de la demande");
    int id = Helper.saisieInt(scan);
    Demande demande = demandeService.findData().selectById(id);
    if (demande == null) {
      System.out.println("Demande non trouvée");
    }
    else{
      if (demande.getDette() != null || !demande.getClient().equals(michel)) {
        System.out.println("Demande deja traiter ou cette demande n'appartient pas a ce client");
      }
      else{
        if (demande.getEtatDeDemande().equals(EtatDeDemande.valider)) {
          dette.setMontant(demande.getMontant());
          dette.setMontantVerser(0.0);
          dette.setEtat(EtatDette.Nonarchiver);
          dette.setClient(demande.getClient());
          demande.setDette(dette);
        }
      }
      
    }
    return dette;
  }

}
