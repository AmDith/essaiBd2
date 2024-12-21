package com.ism.Repositories.list.Impl;

import java.util.ArrayList;
import java.util.List;

import com.ism.Repositories.Repository;


public  abstract class RepositoryImpl<T> implements Repository<T> {


  protected List<T> datas = new ArrayList<>();

  @Override
  public int insert(T amour) {
    datas.add(amour);
    return 0;
  }

  @Override
  public List<T> selectAll() {
    return datas;
  }

  @Override
  public void remove(T amour) {
    datas.remove(amour);
  }

  

 

  


  
  
}
