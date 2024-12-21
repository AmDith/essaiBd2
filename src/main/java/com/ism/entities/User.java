package com.ism.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ism.enums.Etat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

<<<<<<< HEAD
@Getter
@Setter
@ToString(exclude = {"client"})
@EqualsAndHashCode(callSuper = false , of = {"login"}) 

public class User extends AbstractEntity{
  private String email;
=======
@Data
@Entity
@Table(name = "User")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  @Column(length = 25, unique = true)
>>>>>>> 636e632b84cd90083a1320eeab3b5026a11454c2
  private String login;
  @Column(length = 25,unique = true)
  private String email;
  @Column(length = 25,unique = false)
  private String password;
  @Enumerated(EnumType.STRING)
  private Etat etat;
  //Navigabilité
  @OneToOne
  @JoinColumn
  private Role role;

  //Navigabilité
  @OneToOne
  @JoinColumn
  private Client client;
<<<<<<< HEAD
  private static int nbreU;


  public User() {
    this.id = ++nbreU;
  }

  public User(String email, String login, String password, Etat etat, Role role) {
    this.email = email;
    this.login = login;
    this.password = password;
    this.etat = etat;
    this.role = role;
  }

  public static void setNbreU(int n){
    User.nbreU = n;
}

public static int getNbreU() {
    return User.nbreU;
}

=======
>>>>>>> 636e632b84cd90083a1320eeab3b5026a11454c2

  
  
}
