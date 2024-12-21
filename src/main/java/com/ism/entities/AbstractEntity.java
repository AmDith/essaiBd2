package com.ism.entities;

import java.time.LocalDate;

import lombok.Data;


@Data

public abstract class AbstractEntity {
  
  protected int id;
  protected LocalDate dateCreate;
  protected LocalDate dateUpdate;
  protected int usercreate;
  protected int userupdate;

}
