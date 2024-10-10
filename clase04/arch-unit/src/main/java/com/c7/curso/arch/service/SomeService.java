package com.c7.curso.arch.service;

import com.c7.curso.arch.repository.SomeRepository;

public class SomeService {

  private SomeRepository someRepository;

  public void sayHi(){
    System.out.println("Hi from Service");
  }

  public void sayNo(){
    someRepository.save();
  }


}
