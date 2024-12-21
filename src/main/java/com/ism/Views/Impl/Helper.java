package com.ism.Views.Impl;

import java.util.Scanner;

public class Helper {
  public static int saisieInt(Scanner scan) {
    int entier;
    while (true) {
        try {
            System.out.print("Veuillez entrer un entier : ");
            entier = scan.nextInt();
            break;
        } catch (Exception e) {
            System.out.println("Erreur : Veuillez entrer un nombre entier valide.");
            scan.nextLine();
        }
    }
    return entier;
}

public static double saisieDouble(Scanner scan) {
  double reel;
  while (true) {
      try {
          System.out.print("Veuillez entrer un reel : ");
          reel = scan.nextDouble();
          break;
      } catch (Exception e) {
          System.out.println("Erreur : Veuillez entrer un nombre reel valide.");
          scan.nextLine();
      }
  }
  return reel;
}

}
