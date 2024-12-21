package com.ism.Repositories.BD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ism.Core.Database.DetteRepoListInt;
import com.ism.Core.Database.PaiementRepoListInt;
import com.ism.Repositories.BD.ImplBD.RepositoryImplBd;
import com.ism.entities.Paiement;

public class PaiementRepoBd extends RepositoryImplBd<Paiement> implements PaiementRepoListInt{


  private DetteRepoListInt detteRepo;
  
  public PaiementRepoBd(DetteRepoListInt dette) {
    this.detteRepo = dette;
  }

  @Override
  public int insert(Paiement amour) {
    String query = generateSql("INSERT INTO `paiement` (`dateCreate`, `dateUpdate`, `montant`, `usercreateId`, `userupdateId`, `detteId`) VALUES (?, ?, ?, ?, ?, ?)");
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
  public List<Paiement> selectAll() {
     String query =generateSql("SELECT p.* FROM paiement p");
    
    try{
        conn = connexion();  
        init(query);
        try (ResultSet rs = this.executeQuery()) {
            while (rs.next()) {
              amour = new Paiement();
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
  public void remove(Paiement amour) {
    String query = generateSql("DELETE FROM `paiement` WHERE `id` = ?");
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
  public Paiement setfields(ResultSet rs, Paiement amour) throws SQLException {
    amour.setId(rs.getInt("id"));
    amour.setDateCreate(rs.getDate("dateCreate").toLocalDate());
    amour.setDateUpdate(rs.getDate("dateUpdate").toLocalDate());
    amour.setMontant(rs.getDouble("montant"));
    amour.setUsercreate(rs.getInt("usercreateId"));
    amour.setUserupdate(rs.getInt("userupdateId"));   
    amour.setDette(detteRepo.selectById(rs.getInt("detteId")));
    return amour;
  }

  @Override
  public int stmtfields(Paiement amour, String query) throws SQLException {
    try {
        init(query);
        stmt.setDate(1, java.sql.Date.valueOf(amour.getDateCreate()));
        stmt.setDate(2, java.sql.Date.valueOf(amour.getDateUpdate()));
        stmt.setDouble(3, amour.getMontant());
        stmt.setInt(4, amour.getUsercreate());
        stmt.setInt(5, amour.getUserupdate());
        stmt.setInt(6, amour.getDette().getId()); 
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
  public Paiement selectById(int id) {
    return datas.stream()
            .filter(article -> article.getId() == id)
            .findFirst()
            .orElse(null);
  }
  
}
