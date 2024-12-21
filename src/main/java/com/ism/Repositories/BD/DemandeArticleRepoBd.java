package com.ism.Repositories.BD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ism.Core.Database.ArticleRepoListInt;
import com.ism.Core.Database.DemandeArticleRepoListInt;
import com.ism.Core.Database.DemandeRepoListInt;
import com.ism.Repositories.BD.ImplBD.RepositoryImplBd;
import com.ism.entities.DemandeArticle;

public class DemandeArticleRepoBd extends RepositoryImplBd<DemandeArticle> implements DemandeArticleRepoListInt {

  private ArticleRepoListInt articleRepo;
  private DemandeRepoListInt demandeRepo;
  
  public DemandeArticleRepoBd(ArticleRepoListInt articleRepo, DemandeRepoListInt demandeRepo) {
    this.articleRepo = articleRepo;
    this.demandeRepo = demandeRepo;
  }

  @Override
  public int insert(DemandeArticle amour) {
    String query = generateSql("INSERT INTO `demandearticle` (`dateCreate`, `dateUpdate`, `qteDemande`, `somme`,`usercreateId`, `userupdateId`, `aricleId`, `demandeId`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
      try{
          conn = connexion(); 
          return stmtfields(amour,query);
      } catch (ClassNotFoundException e) {
          System.out.println("Erreur de chargement du Driver: " + e.getMessage());
      } catch (SQLException e) {
          System.out.println("Erreur de Connexion a votre BD: " + e.getMessage());
      }finally{
        fermer();
    }
      return 0;
  }

  @Override
  public List<DemandeArticle> selectAll() {
     String query =generateSql("SELECT de.* FROM demandearticle de");
    
    try{
        conn = connexion();  
        init(query);
        try (ResultSet rs = this.executeQuery()) {
            while (rs.next()) {
              amour = new DemandeArticle();
              amour = setfields(rs,amour);
              datas.add(amour);
              }
        }

    } catch (ClassNotFoundException | SQLException e) {
        System.out.println("Erreur de connexion ou d'exécution : " + e.getMessage());
    }finally{
        fermer();
    }

    return datas;
  }

  @Override
  public void remove(DemandeArticle amour) {
    String query = generateSql("DELETE FROM `demandearticle` WHERE `id` = ?");
    try {
        conn = connexion();
        init(query);
        stmt.setInt(1, amour.getId());
        stmt.executeUpdate();
    } catch (ClassNotFoundException e) {
        System.out.println("Erreur de chargement du Driver: " + e.getMessage());
    } catch (SQLException e) {
        System.out.println("Erreur de Connexion a votre BD: " + e.getMessage());
    } finally {
        fermer();
    }
  }

  @Override
  public DemandeArticle setfields(ResultSet rs, DemandeArticle amour) throws SQLException {
    amour.setId(rs.getInt("id"));
    amour.setDateCreate(rs.getDate("dateCreate").toLocalDate());
    amour.setDateUpdate(rs.getDate("dateUpdate").toLocalDate());
    amour.setQteDemande(rs.getInt("qteVendu"));
    amour.setSomme(rs.getDouble("somme"));
    amour.setUsercreate(rs.getInt("usercreateId"));
    amour.setUserupdate(rs.getInt("userupdateId"));
    amour.setArticle(articleRepo.selectById(rs.getInt("articleId")));
    amour.setDemande(demandeRepo.selectById(rs.getInt("detteId")));
    return amour;
  }

  @Override
  public int stmtfields(DemandeArticle amour, String query) throws SQLException {
    try {
      init(query);
      stmt.setDate(1, java.sql.Date.valueOf(amour.getDateCreate()));
      stmt.setDate(2, java.sql.Date.valueOf(amour.getDateUpdate()));
      stmt.setInt(3, amour.getQteDemande());
      stmt.setDouble(4, amour.getSomme());
      stmt.setInt(5, amour.getUsercreate());
      stmt.setInt(6, amour.getUserupdate());
      stmt.setInt(7, amour.getArticle().getId()); 
      stmt.setInt(8, amour.getDemande().getId());
      this.executeUpdate();
  
      try (ResultSet rs = stmt.getGeneratedKeys()) {
          if (rs.next()) {
              return rs.getInt(1);
          }
      }
  } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
  }
  return 0;
  }

  @Override
  public DemandeArticle selectById(int id) {
    return datas.stream()
            .filter(article -> article.getId() == id)
            .findFirst()
            .orElse(null);
  }
  
}
