package com.ism.Repositories.BD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ism.Core.Database.ClientRepoListInt;
import com.ism.Core.Database.UserRepoListInt;
import com.ism.Repositories.BD.ImplBD.RepositoryImplBd;
import com.ism.entities.Client;
import com.ism.entities.User;

public class ClientRepoBd extends RepositoryImplBd<Client> implements ClientRepoListInt {


    private UserRepoListInt uRepo;


    public ClientRepoBd(UserRepoListInt uRepo) {
        this.uRepo = uRepo;
    }
    


// @Override
//   public int insert(Client amour) {
//       String query = generateSql("INSERT INTO `client` (`name`, `tel`, `adresse`, `idUser`) VALUES (?, ?, ?, ?)");
//       try (Connection conn = connexion();
//           PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

//           stmt.setString(1, amour.getName());
//           stmt.setString(2, amour.getTel());
//           stmt.setString(3, amour.getAdresse());
//             if (amour.getUser() != null) {
//                 stmt.setInt(4, uRepo.insert(amour.getUser()));
//             } else {
//                 stmt.setNull(4, java.sql.Types.INTEGER);
//             }

//             executeUpdate();
//       } catch (ClassNotFoundException e) {
//           System.out.println("Erreur de chargement du Driver: " + e.getMessage());
//       } catch (SQLException e) {
//           System.out.println("Erreur de Connexion a votre BD: " + e.getMessage());
//       }finally{
//         try {
//             closeConnection();
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }
//       return 0;
//   }


@Override
  public int insert(Client amour) {
      String query = generateSql("INSERT INTO `client` (`dateCreate`, `dateUpdate`, `adresse`, `name`, `tel`, `usercreateId`, `userupdateId`, `userId`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

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




// @Override
// public List<Client> selectAll() {
//     List<Client> clients = new ArrayList<>();
//     String query =generateSql("SELECT c.* FROM client c");
    
//     try (Connection conn = connexion(); 
//          PreparedStatement stmt = conn.prepareStatement(query);
//          ResultSet rs = executeQuery()) {

//         while (rs.next()) {
//             client = new Client();
//             client = setfields(rs,client);
//             clients.add(client);
//         }

//     } catch (ClassNotFoundException | SQLException e) {
//         System.out.println("Erreur de connexion ou d'exécution : " + e.getMessage());
//     }

//     return clients;
//  }

@Override
public List<Client> selectAll() {
    String query =generateSql("SELECT c.* FROM client c");
    
    try{
        conn = connexion();  
        init(query);
        try (ResultSet rs = this.executeQuery()) {
            while (rs.next()) {
                amour = new Client();
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



//   @Override
//   public Client selectByPhone(String phone) {
//     String query = generateSql("SELECT c.* FROM client c " +
//     "WHERE c.tel = ?");
//     try (Connection conn = connexion(); 
//       PreparedStatement stmt = conn.prepareStatement(query)) {
//       stmt.setString(1, phone);
//       try (ResultSet rs = executeQuery()) {
//           if (rs.next()) {
//             client = new Client();
//             client = setfields(rs,client);
//             }
//       }
//     } catch (ClassNotFoundException | SQLException e) {
//     System.out.println("Erreur de connexion ou d'exécution : " + e.getMessage());
//     }
//     return client;
//       }

@Override
  public Client selectByPhone(String phone) {
    String query = generateSql("SELECT c.* FROM client c " +
    "WHERE c.tel = ?");
    try{
      conn = connexion(); 
      init(query);
      stmt.setString(1, phone);
      try (ResultSet rs = this.executeQuery()) {
          if (rs.next()) {
            amour = new Client();
            amour = setfields(rs,amour);
            }
      }
    } catch (ClassNotFoundException | SQLException e) {
    System.out.println("Erreur de connexion ou d'exécution : " + e.getMessage());
    }finally{
        fermer();
    }
    return amour;
      }


@Override
public void update(Client amour) {
    String query =generateSql( "UPDATE client SET idUser = ? WHERE id = ?");
      try{
        conn = connexion(); 
        init(query); 
        stmt.setInt(1, amour.getUser().getId());
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







@Override
public Client setfields(ResultSet rs,Client client) throws SQLException {
    client.setId(rs.getInt("id"));
    client.setDateCreate(rs.getDate("dateCreate").toLocalDate());
    client.setDateUpdate(rs.getDate("dateUpdate").toLocalDate());
    client.setAdresse(rs.getString("adresse"));
    client.setName(rs.getString("name"));
    client.setTel(rs.getString("tel"));
    client.setUsercreate(rs.getInt("usercreateId"));
    client.setUserupdate(rs.getInt("userupdateId"));
    if (!rs.wasNull()) {
        if (client.getUser() == null) {
            client.setUser(new User());
        }
        client.getUser().setId(rs.getInt("userId"));
    } else {
        client.setUser(null);
    }
    Client.setNbreC(Client.getNbreC() - 1);
    return client;

}


// @Override
// public Client selectBySurname(String val) {
//     String query = generateSql("SELECT c.* FROM client c " +
//     "WHERE c.name = ?");
//     try (Connection conn = connexion(); 
//     PreparedStatement stmt = conn.prepareStatement(query)) {
//       stmt.setString(1, val);
//       try (ResultSet rs = executeQuery()) {
//           if (rs.next()) {
//                 client = new Client();
//                 client = setfields(rs,client);
//           }
//       }
//     } catch (ClassNotFoundException | SQLException e) {
//     System.out.println("Erreur de connexion ou d'exécution : " + e.getMessage());
//     }
//     return client;
// }


@Override
public Client selectBySurname(String val) {
    String query = generateSql("SELECT c.* FROM client c " +
    "WHERE c.name = ?");
    try{
        conn = connexion(); 
        init(query);
        stmt.setString(1, val);
        try (ResultSet rs = this.executeQuery()) {
            if (rs.next()) {
                amour = new Client();
                amour = setfields(rs,amour);
              }
        }
    } catch (ClassNotFoundException | SQLException e) {
    System.out.println("Erreur de connexion ou d'exécution : " + e.getMessage());
    }finally{
        fermer();
    }
    return amour;
}



@Override
public int stmtfields(Client amour,String query) throws SQLException {
    try {
        init(query);
        stmt.setDate(1, java.sql.Date.valueOf(amour.getDateCreate()));
        stmt.setDate(2, java.sql.Date.valueOf(amour.getDateUpdate()));
        stmt.setString(3, amour.getAdresse());
        stmt.setString(4, amour.getName());
        stmt.setString(5, amour.getTel());
        stmt.setInt(6, amour.getUsercreate());
        stmt.setInt(7, amour.getUserupdate());
        if (amour.getUser() != null) {
            stmt.setInt(8, uRepo.insert(amour.getUser()));
        } else {
            stmt.setNull(8, java.sql.Types.INTEGER);
        }
    
        return this.executeUpdate();
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
    return 0;
}



@Override
public void remove(Client amour) {
    String query = generateSql("DELETE FROM `client` WHERE `id` = ?");
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
public Client selectById(int id) {
    return datas.stream()
            .filter(article -> article.getId() == id)
            .findFirst()
            .orElse(null);
}












  
}
