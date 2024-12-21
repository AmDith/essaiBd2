package com.ism.Service;

import java.util.List;

import com.ism.Core.Database.DemandeArticleRepoListInt;
import com.ism.entities.Article;
import com.ism.entities.Demande;
import com.ism.entities.DemandeArticle;

public class DemandeArticleService implements DemandeArticleServiceInt {


  private DemandeArticleRepoListInt demandeArticleRepo;


  public DemandeArticleService(DemandeArticleRepoListInt demandeArticleRepo) {
    this.demandeArticleRepo = demandeArticleRepo;
  }

  @Override
  public boolean saveList(DemandeArticle objet) {
    if(objet != null){
      demandeArticleRepo.insert(objet);
      return true;
    }
    return false;
  }

  @Override
  public List<DemandeArticle> show() {
    return demandeArticleRepo.selectAll();
  }

  @Override
  public DemandeArticleRepoListInt findData() {
    return demandeArticleRepo;
  }

  @Override
 public DemandeArticle verf(Demande demande, Article article, int id) {
    return demande.getDemandearticles().stream()
    .filter(da -> da.getArticle().equals(article) && da.getId() == id)
    .findFirst()
    .orElse(null);
  }

// @Override
// public Detail getLastDetail(Dette dette) {
//     List<Detail> details = dette.getDetails();
//     if (details != null && !details.isEmpty()) {
//         return details.get(details.size() - 1);
//     }
//     return null;
// }


  
}
