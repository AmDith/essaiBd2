package com.ism.Core.Database;

import com.ism.Repositories.Repository;
import com.ism.entities.Dette;

public interface DetteRepoListInt extends Repository<Dette> {
  // Dette selectById(int id);
  void update(Dette amour);
}
