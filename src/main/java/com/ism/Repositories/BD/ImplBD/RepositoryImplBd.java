package com.ism.Repositories.BD.ImplBD;

import java.util.List;
import java.util.ArrayList;

import com.ism.Core.Database.Impl.DataSourceImpl;
import com.ism.Repositories.Repository;

public abstract class RepositoryImplBd<T> extends DataSourceImpl<T> implements Repository<T> {
  protected List<T> datas = new ArrayList<>();
  protected T amour = null;
}
