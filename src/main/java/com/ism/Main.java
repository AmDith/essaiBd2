package com.ism;

import java.util.Scanner;

import com.ism.Factory.FactoryService.FactoryService;
<<<<<<< HEAD
import com.ism.Factory.FactoryService.FactoryServiceInt;
import com.ism.Factory.FactoryViews.FactoryViews;
import com.ism.Factory.FactoryViews.FactoryViewsInt;
// import com.ism.Factory.FactotyRepo.BD.FactoryRepo;
// import com.ism.Factory.FactotyRepo.BD.Factoryint;
import com.ism.Factory.FactotyRepo.list.FactoryRepo;
import com.ism.Factory.FactotyRepo.list.Factoryint;
// import com.ism.Repositories.BD.ArticleRepoBd;
// import com.ism.Repositories.BD.ClientRepoBd;
// import com.ism.Repositories.BD.DemandeArticleRepoBd;
// import com.ism.Repositories.BD.DemandeRepoBd;
// import com.ism.Repositories.BD.DetteRepoBd;
// import com.ism.Repositories.BD.PaiementRepoBd;
// import com.ism.Repositories.BD.UserRepoBd;
import com.ism.Repositories.list.ArticleRepo;
import com.ism.Core.Database.ArticleRepoListInt;
import com.ism.Core.Database.ClientRepoListInt;
import com.ism.Core.Database.DemandeRepoListInt;
import com.ism.Core.Database.DemandeArticleRepoListInt;
import com.ism.Core.Database.DetteRepoListInt;
import com.ism.Core.Database.PaiementRepoListInt;
import com.ism.Core.Database.UserRepoListInt;
import com.ism.Repositories.list.ClientRepo;
import com.ism.Repositories.list.DemandeArticleRepo;
import com.ism.Repositories.list.DemandeRepo;
import com.ism.Repositories.list.DetteRepo;
import com.ism.Repositories.list.PaiementRepo;
import com.ism.Repositories.list.RoleRepo;
import com.ism.Repositories.list.UserRepo;
import com.ism.Service.ArticleService;
import com.ism.Service.ClientService;
import com.ism.Service.ClientServiceInt;
import com.ism.Service.DemandeArticleService;
import com.ism.Service.DemandeArticleServiceInt;
import com.ism.Service.DemandeService;
import com.ism.Service.DemandeServiceInt;
import com.ism.Service.DetteServceInt;
import com.ism.Service.DetteService;
import com.ism.Service.PaiementService;
import com.ism.Service.PaiementServiceInt;
import com.ism.Service.RoleService;
import com.ism.Service.UserService;
import com.ism.Service.UserServiceInt;
import com.ism.Views.ArticleViews;
import com.ism.Views.ClientViews;
=======
import com.ism.Factory.FactoryViews.FactoryViews;
import com.ism.Factory.FactotyRepo.JPA.FactoryRepoJpa;
import com.ism.Repositories.JPA.ClientRepoJpa;
import com.ism.Repositories.JPA.UserRepoJpa;
import com.ism.Service.ClientServiceInt;
import com.ism.Service.UserServiceInt;
>>>>>>> 636e632b84cd90083a1320eeab3b5026a11454c2
import com.ism.Views.ClientViewsInt;
import com.ism.Views.DemandeViewInt;
import com.ism.Views.DemandeViews;
import com.ism.Views.DetteViewInt;
import com.ism.Views.DetteViews;
import com.ism.Views.PaiementViewInt;
import com.ism.Views.PaiementViews;
import com.ism.Views.UserViewInt;
<<<<<<< HEAD
import com.ism.Views.UserViews;
import com.ism.Views.Impl.Helper;
import com.ism.entities.Client;
import com.ism.entities.Demande;
import com.ism.entities.Dette;
import com.ism.entities.Paiement;
=======
import com.ism.entities.Client;
>>>>>>> 636e632b84cd90083a1320eeab3b5026a11454c2
import com.ism.entities.User;
import com.ism.enums.EtatDeDemande;

public class Main {
    
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int choix;
        Client cl;
        //Fabrique
<<<<<<< HEAD
        //LIST
        Factoryint<ClientRepo,UserRepo,ArticleRepo,DemandeRepo,DemandeArticleRepo,DetteRepo,RoleRepo,PaiementRepo> factory = new FactoryRepo();
        // Factoryint<ClientRepoBd,UserRepoBd,ArticleRepoBd,DemandeRepoBd,DemandeArticleRepoBd,DetteRepoBd,PaiementRepoBd> factory = new FactoryRepo();
        FactoryViewsInt<ClientViews,UserViews,ArticleViews,DemandeViews,DetteViews,PaiementViews> factoryView = new FactoryViews();
        FactoryServiceInt<ClientService,UserService,ArticleService,DemandeService,DemandeArticleService,DetteService,RoleService,PaiementService> factoryService = new FactoryService();
        //
        // UserRepoListInt uRepo = factory.getInstanceUser();
        // ClientRepoListInt cRepo = factory.getInstanceClient(uRepo);
        // ArticleRepoListInt aRepo = factory.getInstanceArticle();
        // DetteRepoListInt dRepo = factory.getInstanceDette(cRepo);
        // DemandeRepoListInt deRepo = factory.getInstanceDemande(cRepo);
        // DemandeArticleRepoListInt detRepo = factory.getInstanceDemandeArticle(aRepo, deRepo);
        // PaiementRepoListInt pRepo = factory.getInstancePaiement(dRepo);

        //
            //LIST
        UserRepoListInt uRepo = factory.getInstanceUser();
        ClientRepoListInt cRepo = factory.getInstanceClient();
        ArticleRepoListInt aRepo = factory.getInstanceArticle();
        DetteRepoListInt dRepo = factory.getInstanceDette();
        DemandeRepoListInt deRepo = factory.getInstanceDemande();
        DemandeArticleRepoListInt detRepo = factory.getInstanceDemandeArticle();
        PaiementRepoListInt pRepo = factory.getInstancePaiement();
        //
        ClientServiceInt  cService = factoryService.getInstanceClient(cRepo);
        UserServiceInt uService = factoryService.getInstanceUser(uRepo);
        ArticleService aService = factoryService.getInstanceArticle(aRepo);
        DetteServceInt dService = factoryService.getInstanceDette(dRepo);
        DemandeServiceInt deService = factoryService.getInstanceDemande(deRepo);
        DemandeArticleServiceInt detService = factoryService.getInstanceDemandeArticle(detRepo);
        PaiementServiceInt pService = factoryService.getInstancePaiement(pRepo);
        //
        UserViewInt uViews = factoryView.getInstanceUser(sc, uService);
        ClientViewsInt cViews = factoryView.getInstanceClient(sc, cService, uViews,uService);
        ArticleViews aViews = factoryView.getInstanceArticle(sc, aService);
        DetteViewInt dViews = factoryView.getInstanceDette(sc, deService);
        DemandeViewInt deViews = factoryView.getInstanceDemande(sc, deService, aService, detService);
        PaiementViewInt pViews = factoryView.getInstancePaiement(sc);

        //en cas d'utilisation de Listes
        
        
        do {
            choix = Connexion();
            if (choix == 1) {
                sc.nextLine();
                User user = uViews.Connexion();
                    if (user.getRole().getNomRole().equals("Boutiquier")) {
                        do {
                            choix = affichageMenuBoutiquier();
                            switch (choix) {
                                case 1:
                                    cService.saveList(cViews.created(null));
                                    break;
                                case 2:
                                    cViews.affiche(cService.show());
                                    break;   
                                case 3:
                                    sc.nextLine();
                                    System.out.println(cService.search(SaisieNumero()));
                                    break;  
                                case 4:
                                    sc.nextLine();
                                    System.out.println("Entrez l'id de la demnade");
                                    int id = Helper.saisieInt(sc);
                                    sc.nextLine();
                                    Demande da = deService.verf(id);
                                    Dette det = dViews.created(null);
                                    dService.saveList(det);
                                    break;
                                case 5:
                                    System.out.println("Entrez l'id de la dette");
                                    Dette dette = dService.searchDette(Helper.saisieInt(sc)); 
                                    Paiement paie = pViews.created(dette);
                                    pService.saveList(paie);
                                    dService.findData().update(dette);
                                    break;
                                case 6:
                                    dViews.affiche(dService.show());
                                    break;
                                case 7:
                                    sc.nextLine();
                                    cl = cService.search(SaisieNumero());
                                    dViews.detteNonSolder(cl.getDettes());
                                    break;  
                                case 8:
                                    choix = affichageSousMenu3("1-Lister les demandes de la dette encours", "2-Filtrer par état(En Cours, ou Annuler)","3- Voir les articles(avec les quantités réelles disponibles) de la demande","4-Valider ou refuser la dette");
                                    switch (choix) {
                                        case 1:
                                            deViews.affiche(deService.show());
                                            break;
                                        case 2:
                                            choix = affichageSousMenu("1-En Cours", "2-Annuler");
                                            if (choix == 1) {
                                                deViews.filtrerByEtat(EtatDeDemande.encours);
                                            }
                                            else{
                                                deViews.filtrerByEtat(EtatDeDemande.annuler);
                                            }
                                            break;
                                        case 3:
                                            System.out.println("Entrez l'id de la demande");
                                            deViews.voirArticleDemande(Helper.saisieInt(sc));
                                        break;
                                        case 4:
                                            System.out.println("Entrez l'id de la demande");
                                            choix = affichageSousMenu("1-Valider", "2-Refuser");
                                            if (choix == 1) {
                                                deService.traitement(Helper.saisieInt(sc),EtatDeDemande.valider);
                                            }
                                            else{
                                                deService.traitement(Helper.saisieInt(sc),EtatDeDemande.annuler);
                                            }
                                        break;
                                
                                    default:
                                        break;
                                }
                                case 9:
                                    sc.nextLine();
                                    do {
                                        choix=affichageSousMenu("1-Pour un client","2-Pour un boutiquier ou admin");
                                        switch (choix) {
                                            case 1:
                                                cl = cService.search(SaisieNumero());
                                                if (cl.getUser() == null) {//.getRole pour les listes
                                                    User us = uViews.created(cl);
                                                    uService.saveList(us);
                                                    cl.setUser(us);
                                                    cService.findData().update(cl);
                                                } else{
                                                    System.out.println("Ce client a deja un compte");
                                                }
                                                break;  
                                            case 2:
                                                System.out.println("dddd");
                                                User us = uViews.created(null);
                                                uService.saveList(us);
                                                break;    
                                        
                                            default:
                                                break;
                                        }
                                    } while (choix != 2 && choix != 1);
                                    break; 
                                case 10:
                                    choix = affichageSousMenu("1-Actif", "2-Par role");
                                    if (choix == 1) {
                                        uViews.affiche(uService.show());
                                    }
                                    else{
                                        uViews.filtreRole(uViews.AffAss().getNomRole());
                                    }
                                    break; 
                                default:
                                    break;
                            }
                        } while (choix != 11);
                        
                    }
                    else if(user.getRole().getNomRole().equals("Admin")){
                        do {
                            choix = affichageMenuAmin();
                            switch (choix) {
                                case 1:
                                    sc.nextLine();
                                    cl = cService.search(SaisieNumero());
                                    if (cl.getUser() == null) {//.getRole pour les listes
                                        User us = uViews.created(cl);
                                        uService.saveList(us);
                                        cl.setUser(us);
                                        cService.findData().update(cl);
                                    } else{
                                        System.out.println("Ce client a deja un compte");
                                    }
                                    break;
                                case 2:
                                    User us = uViews.created(null);
                                    uService.saveList(us);
                                    break;
                                case 3:
                                    User use;
                                    System.out.println("Entrez le login du compte");
                                    sc.nextLine();
                                    String mot = sc.nextLine().trim();
                                    use = uService.findData().selectByLogin(mot);
                                    if (use != null) {
                                        choix = affichageSousMenu("1-Desactiver un compte utilisateur", "2-Activer un compte utilisateur");
                                        if (choix == 1) {
                                            uService.Off(use);
                                        }
                                        else{
                                            uService.On(use);
                                        }
                                    }else{
                                        System.out.println("Ce compte n'existe pas");
                                    }
                                    break;
                                case 4:
                                    choix = affichageSousMenu("1-Actif", "2-Par role");
                                    if (choix == 1) {
                                        uViews.affiche(uService.show());
                                    }
                                    else{
                                        uViews.filtreRole(uViews.AffAss().getNomRole());
                                    }
                                    break;
                                case 5:
                                    choix = affichageSousMenu2("1-Creer des articles", "2-Lister les articles","3-Filtrer par disponibilite");
                                    switch (choix) {
                                        case 1:
                                            aService.saveList(aViews.created());
                                            break;
                                        case 2:
                                            aViews.affiche(aService.show());
                                            break;
                                        case 3:
                                            aViews.afficheByDisponibility(aService.show());
                                        break;
                                
                                    default:
                                        break;
                                }
                                 break; 
                                case 6:
                                    int va;
                                    String scx;
                                    do {
                                        System.out.println("Entrez la quantité a ajouté");
                                        va = Helper.saisieInt(sc);
                                        sc.nextLine();
                                        System.out.println("Entrez le libelle de l'article");
                                        scx = sc.nextLine().trim();
                                        aService.updateQteStock(va, scx);
                                    } while (aService.findData().selectByLibelle(scx) == null);
                                    break; 
                                case 7:
                                    dService.archiverSolider();
                                    break;  
                            
                                default:
                                    break;
                            }
                        } while (choix != 8);
                    }
                    else if(user.getRole().getNomRole().equals("Client")){
                        do {
                            choix = affichageMenuClient();
                            switch (choix) {
                                case 1:
                                    dViews.detteNonSolder(user.getClient().getDettes());
                                    break;
                                case 2:
                                    deService.saveList(deViews.created(user.getClient()));
                                    break;
                                case 3:
                                    choix = affichageSousMenu("1-Lister", "2-Filtrer");
                                    if (choix == 1) {
                                        deViews.affiche(user.getClient().getDemandes());
                                        deViews.affiche(deService.show());
                                    }else{
                                        choix = affichageSousMenu("1-En Cours", "2-Annuler");
                                        if (choix == 1) {
                                            deViews.filtrerByEtat(EtatDeDemande.encours);
                                        }
                                        else{
                                            deViews.filtrerByEtat(EtatDeDemande.annuler);
                                        }
                                    }
                                    break;
                                case 4:
                                    System.out.println("Entrez l'id de la deamnde à relancer");
                                    int id = Helper.saisieInt(sc);  
                                    deService.relance(id);
                                    break;    
                            
                                default:
                                    break;
                            }
                        } while (choix != 5);
                    }
                    else{
                        System.out.println("Vous n'etes pas connecte");
                    }
            }else{
                System.out.println("Vous n'etes pas connecte");
            }
            
        } while (choix != 2);
        
=======
        UserRepoJpa uRepo = FactoryRepoJpa.getInstanceU();
        ClientRepoJpa cRepo = FactoryRepoJpa.getInstanceC();
        //
        ClientServiceInt<Client,ClientRepoJpa>  cService = FactoryService.getInstanceC(cRepo);
        UserServiceInt<User,UserRepoJpa> uService = FactoryService.getInstanceU(uRepo);
        UserViewInt uViews = FactoryViews.getInstanceU(sc, uService);
        ClientViewsInt cViews = FactoryViews.getInstanceC(sc, cService, uViews);
        do {
            choix = affichageMenuprincipal3();
            switch (choix) {
                            case 1:
                                cService.saveList(cViews.created(null));
                                break;
                            case 2:
                                cViews.affiche(cService.show());
                                break;
                            case 3:
                                uService.saveList(uViews.created(null));
                                break;
                            
                            case 4:
                                uViews.affiche(uService.show());
                                break;
                            }
                
            
        } while (choix != 5);
>>>>>>> 636e632b84cd90083a1320eeab3b5026a11454c2
    }

    public static int affichageMenuAmin(){
        int choix;
        do{
            System.out.println("Menu Admin");
            System.out.println("1-Créer un compte utilisateur à un client n'ayant pas de compte");
            System.out.println("2-Créer un compte utilisateur avec un rôle Boutiquier ou  Admin");
            System.out.println("3-Désactiver/Activer  un compte utilisateur");
            System.out.println("4-Afficher les comptes utilisateurs");
            System.out.println("5-Créer/lister  des articles et filtrer par disponibilité(qteStock!=0)");
            System.out.println("6-Mettre à jour la quantité en stock d'un article");
            System.out.println("7-Archiver les dettes soldées");
            System.out.println("8-Quitter");
            choix = Helper.saisieInt(sc);
        }while(choix<0 || choix>8);
        return choix;
        
    }

    

    public static int affichageMenuprincipal(){
        int choix;
        do{
            System.out.println("Menu");
            System.out.println("1-Utilisateur de rôle Boutiquier");
            System.out.println("2-Utilisateur de rôle Admin");
            System.out.println("3-Utilisateur de rôle Client");
            choix = Helper.saisieInt(sc);
        }while(choix<0 || choix>3);
        return choix;
        
    }

    public static int affichageMenuprincipal3(){
        int choix;
        do{
            System.out.println("Menu");
            System.out.println("1-Creer un client");
            System.out.println("2-Lister les clients");
            System.out.println("3-Creer un user");
            System.out.println("4-Lister les users");
            choix = Helper.saisieInt(sc);
        }while(choix<0 || choix>4);
        return choix;
        
    }

    public static int affichageMenuprincipal3(){
        int choix;
        do{
            System.out.println("Menu");
            System.out.println("1-Creer un client");
            System.out.println("2-Lister les clients");
            System.out.println("3-Creer un user");
            System.out.println("4-Lister les users");
            choix = sc.nextInt();
        }while(choix<0 || choix>4);
        return choix;
        
    }

    public static int affichageMenuBoutiquier(){
        int choix;
        do{
            System.out.println("Menu");
            System.out.println("1- Create un client");
            System.out.println("2- Lister les clients");
            System.out.println("3-Rechercher un client par son numero de telephone");
            System.out.println("4- Create une dette");
            System.out.println("5- Enregistrer un paiement");
            System.out.println("6-Lister les dettes");
            System.out.println("7- Lister les dettes non soldées(montantRestant!=0) d'un client avec l'option de voir les articles ou les paiements");
            System.out.println("8- Demandes");
            System.out.println("9- Create un compte user");
            System.out.println("10- Lister les comptes users");
            System.out.println("11-Quitter");
            choix = Helper.saisieInt(sc);
        }while(choix<0 || choix>11);
        return choix;
        
    }

    public static int affichageMenuClient(){
        int choix;
        do{
            System.out.println("Menu");
            System.out.println("1- Lister mes dettes non soldées(montantRestant!=0) avec l'option de voir les articles ou les paiements ");
            System.out.println("2- Faire une demande de Dette");
            System.out.println("3-Lister ses demandes de dette avec l'option de filtrer par état(En Cours, ou Annuler)");
            System.out.println("4- Envoyer une relance pour une  demande de dette annuler");
            System.out.println("5-Quitter");
            choix = Helper.saisieInt(sc);
        }while(choix<0 || choix>5);
        return choix;
        
    }

    public static int Connexion(){
        int choix;
        do{
            System.out.println("Menu");
            System.out.println("Avez-vous un compte ?");
            System.out.println("1- Oui!");
            System.out.println("2- Non!");
            choix = Helper.saisieInt(sc);
        }while(choix<0 || choix>2);
        return choix;
        
    }

    public static int affichageSousMenu(String val1,String val2){
        int choix;
        do{
            System.out.println("Menu");
            System.out.println(val1);
            System.out.println(val2);
            choix = Helper.saisieInt(sc);
            sc.nextLine();
        }while(choix<0 || choix>2);
        return choix;
        
    }

    public static int affichageSousMenu2(String val1,String val2,String val3){
        int choix;
        do{
            System.out.println("Menu");
            System.out.println(val1);
            System.out.println(val2);
            System.out.println(val3);
            choix = Helper.saisieInt(sc);
        }while(choix<0 || choix>3);
        return choix;
        
    }

    public static int affichageSousMenu3(String val1,String val2,String val3,String val4){
        int choix;
        do{
            System.out.println("Menu");
            System.out.println(val1);
            System.out.println(val2);
            System.out.println(val3);
            System.out.println(val4);
            choix = Helper.saisieInt(sc);
        }while(choix<0 || choix>3);
        return choix;
        
    }

    public static String SaisieNumero(){
        System.out.println("Entrez le numero de telephone du client");
        return sc.nextLine().trim();
    }

    // public static void client(){
    //     Client cl;
    //     cl = cService.search(SaisieNumero());
    //     if (cl.getUser() == null) {
    //         cl.setUser(uViews.created());
    //         uService.saveList(cl.getUser());
    //     } else{
    //         System.out.println("Ce client a deje un compte");
    //     }
    // }


}