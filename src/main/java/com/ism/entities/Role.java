package com.ism.entities;

<<<<<<< HEAD
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)

public class Role extends AbstractEntity{
  private String nomRole;

  public Role() {
  }

  public Role(String nomRole) {
    this.nomRole = nomRole;
  }

  
=======
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Role")
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(length = 25, unique = true)
  private String nomRole;

>>>>>>> 636e632b84cd90083a1320eeab3b5026a11454c2
}
