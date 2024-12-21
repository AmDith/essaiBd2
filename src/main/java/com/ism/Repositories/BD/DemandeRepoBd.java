package com.ism.Repositories.BD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ism.Core.Database.ClientRepoListInt;
import com.ism.Core.Database.DemandeRepoListInt;
import com.ism.Repositories.BD.ImplBD.RepositoryImplBd;
import com.ism.entities.Demande;
import com.ism.enums.EtatDeDemande;

public class DemandeRepoBd extends RepositoryImplBd<Demande> implements DemandeRepoListInt {


  private ClientRepoListInt  clientRepo;




  public DemandeRepoBd(ClientRepoListInt clientRepo) {
    this.clientRepo = clientRepo;
  }

  @Override
  public int insert(Demande amour) {
    String query = generateSql("INSERT INTO `demande` (`dateCreate`, `dateUpdate`, `etatDeDemande`,`usercreateId`, `userupdateId`, `clientId`) VALUES (?, ?, ?, ?, ?, ?)");
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
  public List<Demande> selectAll() {
    String query =generateSql("SELECT dem.*, de.nomDemande FROM demande dem "+
                    "JOIN etatdedemande de ON dem.etatDeDemande = de.id");
    
    try{
        conn = connexion();  
        init(query);
        try (ResultSet rs = this.executeQuery()) {
            while (rs.next()) {
              amour = new Demande();
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
  public void remove(Demande amour) {
    String query = generateSql("DELETE FROM `demande` WHERE `id` = ?");
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
  public Demande setfields(ResultSet rs, Demande amour) throws SQLException {
    amour.setId(rs.getInt("id"));
    amour.setDateCreate(rs.getDate("dateCreate").toLocalDate());
    amour.setDateUpdate(rs.getDate("dateUpdate").toLocalDate());
    amour.setEtatDeDemande(EtatDeDemande.valueOf(rs.getString("nomDemande")));
    amour.setUsercreate(rs.getInt("usercreateId"));
    amour.setUserupdate(rs.getInt("userupdateId"));
    amour.setClient(clientRepo.selectById(rs.getInt("articleId")));
    return amour;
  }

  @Override
  public int stmtfields(Demande amour, String query) throws SQLException {
    try {
      init(query);
      stmt.setDate(1, java.sql.Date.valueOf(amour.getDateCreate()));
      stmt.setDate(2, java.sql.Date.valueOf(amour.getDateUpdate()));
      int etat = amour.getEtatDeDemande() == EtatDeDemande.encours ? 1 :
          amour.getEtatDeDemande() == EtatDeDemande.valider ? 2 : 3;
      stmt.setInt(3, etat);
      stmt.setInt(4, amour.getUsercreate());
      stmt.setInt(5, amour.getUserupdate());
      stmt.setInt(6, amour.getClient().getId());
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
  public Demande selectById(int id) {
    return datas.stream()
            .filter(article -> article.getId() == id)
            .findFirst()
            .orElse(null);
  }
  
}
