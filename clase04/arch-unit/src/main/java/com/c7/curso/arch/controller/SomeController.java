package com.c7.curso.arch.controller;

import com.c7.curso.arch.service.SomeService;

public class SomeController {

  private SomeService someService;

  public void methodOne(){
    someService.sayHi();
  }

}
