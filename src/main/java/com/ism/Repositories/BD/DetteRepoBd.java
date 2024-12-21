package com.ism.Repositories.BD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ism.Core.Database.ClientRepoListInt;
import com.ism.Core.Database.DetteRepoListInt;
import com.ism.Repositories.BD.ImplBD.RepositoryImplBd;
import com.ism.entities.Dette;
import com.ism.enums.EtatDette;

public class DetteRepoBd extends RepositoryImplBd<Dette> implements DetteRepoListInt{

  private ClientRepoListInt clientRepo;

  public DetteRepoBd(ClientRepoListInt clientRepo) {
    this.clientRepo = clientRepo;
  }

  @Override
  public int insert(Dette amour) {
    String query = generateSql("INSERT INTO `dette` (`dateCreate`, `dateUpdate`, `etat`, `montant`, `montantVerser`, `usercreateId`, `userupdateId`, `clientId`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
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
  public List<Dette> selectAll() {
    String query =generateSql("SELECT d.*, ed.nomEtatDette FROM dette d "+
                    "JOIN etatdette ed ON d.etat = ed.id");
    
    try{
        conn = connexion();  
        init(query);
        try (ResultSet rs = this.executeQuery()) {
            while (rs.next()) {
              amour = new Dette();
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
  public void remove(Dette amour) {
    String query = generateSql("DELETE FROM `dette` WHERE `id` = ?");
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
  public Dette setfields(ResultSet rs, Dette amour) throws SQLException {
    amour.setId(rs.getInt("id"));
    amour.setDateCreate(rs.getDate("dateCreate").toLocalDate());
    amour.setDateUpdate(rs.getDate("dateUpdate").toLocalDate());
    amour.setEtat(EtatDette.valueOf(rs.getString("nomEtatDette")));
    amour.setMontant(rs.getDouble("montant"));
    amour.setMontantVerser(rs.getDouble("montantVerser"));
    amour.setUsercreate(rs.getInt("usercreateId"));
    amour.setUserupdate(rs.getInt("userupdateId")); 
    amour.setClient(clientRepo.selectById(rs.getInt("clientId")));
    return amour;
  }

  @Override
  public int stmtfields(Dette amour, String query) throws SQLException {
    try {
      init(query);
      stmt.setDate(1, java.sql.Date.valueOf(amour.getDateCreate()));
      stmt.setDate(2, java.sql.Date.valueOf(amour.getDateUpdate()));
      int etat = amour.getEtat() == EtatDette.Archiver ? 1 : 2;
      stmt.setInt(3, etat);
      stmt.setDouble(4, amour.getMontant());
      stmt.setDouble(5, amour.getMontantVerser());
      stmt.setInt(6, amour.getUsercreate());
      stmt.setInt(7, amour.getUserupdate());
      stmt.setInt(8, amour.getClient().getId()); 
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
  public Dette selectById(int id) {
    return datas.stream()
            .filter(article -> article.getId() == id)
            .findFirst()
            .orElse(null);
  }

  @Override
  public void update(Dette amour) {
    String query =generateSql( "UPDATE dette SET montantVerser = ? WHERE id = ?");
      try{
        conn = connexion(); 
        init(query); 
        stmt.setDouble(1, amour.getMontantVerser());
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
