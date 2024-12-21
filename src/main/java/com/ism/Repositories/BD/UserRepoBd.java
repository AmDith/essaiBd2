package com.ism.Repositories.BD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ism.Core.Database.UserRepoListInt;
import com.ism.Repositories.BD.ImplBD.RepositoryImplBd;
import com.ism.entities.Role;
import com.ism.entities.User;
import com.ism.enums.Etat;

public class UserRepoBd extends RepositoryImplBd<User>  implements UserRepoListInt{


  @Override
  public int insert(User amour) {
    String query = generateSql("INSERT INTO `user` (`dateCreate`, `dateUpdate`, `email`, `etat`, `login`, `password`, `usercreateId`, `userupdateId`, `roleId`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
      try {
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
  public List<User> selectAll() {
        String query = generateSql("SELECT u.*, e.nomEtat, r.nomRole " +
                        "FROM user u " +
                        "JOIN etat e ON u.etatId = e.id " +
                        "JOIN role r ON u.roleId = r.id");

        try {
            conn = connexion();  
            init(query);
            try (ResultSet rs = this.executeQuery()) {
                while (rs.next()) {
                    amour = new User();
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
  public User selectByLogin(String login) {
    String query = generateSql("SELECT u.*, e.nomEtat, r.nomRole " +
                    "FROM user u " +
                    "JOIN etat e ON u.etatId = e.id " +
                    "JOIN role r ON u.roleId = r.id "+
                    "WHERE u.login = ? ");
    try{
        conn = connexion(); 
        init(query);
        stmt.setString(1, login);
        try (ResultSet rs = this.executeQuery()) {
          if (rs.next()) {
            amour = new User();
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
public User setfields(ResultSet rs,User user)  throws SQLException {
        user.setId(rs.getInt("id"));
        user.setDateCreate(rs.getDate("dateCreate").toLocalDate());
        user.setDateUpdate(rs.getDate("dateUpdate").toLocalDate());
        user.setEmail(rs.getString("email"));
        user.setEtat(Etat.valueOf(rs.getString("nomEtat")));
        user.setLogin(rs.getString("login"));
        user.setPassword(rs.getString("password"));
        user.setUsercreate(rs.getInt("usercreateId"));
        user.setUserupdate(rs.getInt("userupdateId"));
        Role role = new Role();
        String nomRole = rs.getString("nomRole");
        if (nomRole.equals("Admin")) {
            role.setId(2);
        } else if (nomRole.equals("Boutiquier")) {
            role.setId(1);}
        else if (nomRole.equals("Client")) {
                role.setId(3);}    
        role.setNomRole(rs.getString("nomRole"));
        user.setRole(role);
        User.setNbreU(User.getNbreU()-1);
    return user;

}

@Override
public String login(String val) {
    datas = selectAll();
    boolean isUnique = datas.stream()
                            .noneMatch(user -> user.getLogin().equals(val));
    
    return isUnique ? val : null;
}

@Override
public int stmtfields(User amour,String query) throws SQLException {
    try {
        init(query);
        stmt.setDate(1, java.sql.Date.valueOf(amour.getDateCreate()));
        stmt.setDate(2, java.sql.Date.valueOf(amour.getDateUpdate()));
        stmt.setString(3, amour.getEmail());
        int etatId = amour.getEtat() == Etat.Activer ? 1 : 2;
        stmt.setInt(4, etatId);
        stmt.setString(5, amour.getLogin());
        stmt.setString(6, amour.getPassword());
        stmt.setInt(7, amour.getUsercreate());
        stmt.setInt(8, amour.getUserupdate());
        stmt.setInt(9, amour.getRole().getId()); 
    
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
public User selectByPassord(String val) {
    String query = generateSql("SELECT u.*, e.nomEtat, r.nomRole " +
                    "FROM user u " +
                    "JOIN etat e ON u.etatId = e.id " +
                    "JOIN role r ON u.roleId = r.id "+
                    "WHERE u.password = ? ");
    try{
        conn = connexion(); 
        init(query);
        stmt.setString(1, val);
        try (ResultSet rs = this.executeQuery()) {
          if (rs.next()) {
            amour = new User();
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
public User selectByEmail(String val) {
    String query = generateSql("SELECT u.*, e.nomEtat, r.nomRole " +
                    "FROM user u " +
                    "JOIN etat e ON u.etatId = e.id " +
                    "JOIN role r ON u.roleId = r.id "+
                    "WHERE u.email = ? ");
    try{
        conn = connexion(); 
        init(query);
        stmt.setString(1, val);
        try (ResultSet rs = this.executeQuery()) {
          if (rs.next()) {
            amour = new User();
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
public void remove(User amour) {
    String query = generateSql("DELETE FROM `user` WHERE `id` = ?");
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
public User selectById(int id) {
    return datas.stream()
            .filter(article -> article.getId() == id)
            .findFirst()
            .orElse(null);
}


}








    












  

