package com.ism.Repositories.BD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ism.Core.Database.ArticleRepoListInt;
import com.ism.Repositories.BD.ImplBD.RepositoryImplBd;
import com.ism.entities.Article;

public class ArticleRepoBd extends RepositoryImplBd<Article> implements ArticleRepoListInt {

  @Override
  public int insert(Article amour) {
    String query = generateSql("INSERT INTO `article` (`dateCreate`, `dateUpdate`, `libelle`, `prix`,`qteStock`, `ref`,`usercreateId`, `userupdateId`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
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
  public List<Article> selectAll() {
    String query =generateSql("SELECT a.* FROM article a");
    
    try{
        conn = connexion();  
        init(query);
        try (ResultSet rs = this.executeQuery()) {
            while (rs.next()) {
              amour = new Article();
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
  public void remove(Article amour) {
    String query = generateSql("DELETE FROM `article` WHERE `id` = ?");
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
  public Article setfields(ResultSet rs, Article amour) throws SQLException {
    amour.setId(rs.getInt("id"));
    amour.setDateCreate(rs.getDate("dateCreate").toLocalDate());
    amour.setDateUpdate(rs.getDate("dateUpdate").toLocalDate());
    amour.setLibelle(rs.getString("libelle"));
    amour.setPrix(rs.getDouble("prix"));
    amour.setQteStock(rs.getInt("qteStock"));
    amour.setRef(rs.getString("ref"));
    amour.setUsercreate(rs.getInt("usercreateId"));
    amour.setUserupdate(rs.getInt("userupdateId"));
    return amour;
  }

  @Override
  public int stmtfields(Article amour, String query) throws SQLException {
     try {
        init(query);
        stmt.setDate(1, java.sql.Date.valueOf(amour.getDateCreate()));
        stmt.setDate(2, java.sql.Date.valueOf(amour.getDateUpdate()));
        stmt.setString(3, amour.getLibelle());
        stmt.setDouble(4, amour.getPrix());
        stmt.setInt(5, amour.getQteStock());
        stmt.setString(6, amour.getRef());
        stmt.setInt(7, amour.getUsercreate());
        stmt.setInt(8, amour.getUserupdate());
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
  public Article selectByLibelle(String val) {
    datas = selectAll();
    return datas.stream()
            .filter(article -> article.getLibelle().equals(val))
            .findFirst()
            .orElse(null);
  }

  @Override
  public Article selectById(int id) {
    return datas.stream()
            .filter(article -> article.getId() == id)
            .findFirst()
            .orElse(null);
  }

  @Override
  public void update(Article amour) {
    String query =generateSql( "UPDATE article SET qteStock = ? WHERE id = ?");
      try{
        conn = connexion(); 
        init(query); 
        stmt.setInt(1, amour.getQteStock());
        stmt.setInt(2, amour.getId());
        this.executeUpdate();
      } catch (ClassNotFoundException e) {
          System.out.println("Erreur de chargement du Driver: " + e.getMessage());
      } catch (SQLException e) {
          System.out.println("Erreur de Connexion a votre BD: " + e.getMessage());
      }finally{
        fermer();
    }
  }
  
}
