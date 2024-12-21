package com.ism.entities;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false , of = {"tel"})
@ToString(exclude = {"user", "dettes","demandes"})

public class Client extends AbstractEntity {
  private String name;
  private String tel;
  private String adresse;
  private User user;
  private List<Dette> dettes = new ArrayList<>();
  private List<Demande> demandes = new ArrayList<>();
  private static int nbreC;
=======
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "Client")
@ToString(onlyExplicitlyIncluded = true)
public class Client {
>>>>>>> 636e632b84cd90083a1320eeab3b5026a11454c2

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ToString.Include
    private int id;

    @ToString.Include
    @Column(length = 25,unique = true)
    private String name;

<<<<<<< HEAD
public void addDette(Dette dette) {
  dettes.add(dette);
}

public void addDemande(Demande demande) {
  demandes.add(demande);
}



=======
    @ToString.Include
    @Column(length = 25,unique = true)
    private String tel;

    @ToString.Include
    @Column(length = 25,unique = false)
    private String adresse;

    // Navigabilité vers User
    @OneToOne
    @JoinColumn
    private User user;

    // Relation avec Dette
    // @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    // private List<Dette> dettes;
>>>>>>> 636e632b84cd90083a1320eeab3b5026a11454c2

}
