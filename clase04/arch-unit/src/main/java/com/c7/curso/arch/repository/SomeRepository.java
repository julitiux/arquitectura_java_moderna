package com.c7.curso.arch.repository;

import com.c7.curso.arch.service.SomeService;

public class SomeRepository {

  private SomeService someService;

  public void sayNo() {
    someService.sayHi();
  }


}
