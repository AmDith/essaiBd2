package com.ism.Views;

import java.util.List;

import com.ism.Core.Database.Views;
import com.ism.entities.Client;
import com.ism.entities.Dette;

public interface DetteViewInt extends Views<Dette, Client> {
  void detteNonSolder(List<Dette> dettes);
}
