package com.ism.Views.Impl;

import java.util.List;
import java.util.Scanner;

import com.ism.Core.Database.Views2;

public abstract class ViewImpl2<T> implements Views2<T> {
  protected static Scanner scan;

    
    public static void setScanner(Scanner scan) {
        ViewImpl.scan = scan;
    }
    public static Scanner getScanner(){
       return ViewImpl.scan;
    }

    @ Override
    public void affiche(List<T> datas){
      datas.forEach(System.out::println);
    }
}
