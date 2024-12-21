package com.ism.Service;

import com.ism.Core.Database.DetteRepoListInt;
import com.ism.Core.Database.Service;
import com.ism.entities.Dette;

public interface DetteServceInt extends Service<Dette, DetteRepoListInt> {
  void archiverSolider();
  Dette searchDette(int id);
}
