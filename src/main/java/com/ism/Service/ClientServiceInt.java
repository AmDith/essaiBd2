package com.ism.Service;

import com.ism.Core.Database.ClientRepoListInt;
import com.ism.Core.Database.Service;
import com.ism.entities.Client;

<<<<<<< HEAD
public interface ClientServiceInt extends Service<Client,ClientRepoListInt> {
  Client search(String phone);
  Client searchSurname(String name);
=======
public interface ClientServiceInt<T,A> extends Service<T,A> {
>>>>>>> 636e632b84cd90083a1320eeab3b5026a11454c2
}
