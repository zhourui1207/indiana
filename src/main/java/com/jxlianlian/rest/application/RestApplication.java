package com.jxlianlian.rest.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;
import com.jxlianlian.rest.api.UsersApi;

public class RestApplication extends Application {

  HashSet<Object> singletons = new HashSet<Object>();
  HashSet<Class<?>> classes = new HashSet<Class<?>>();

  @Override
  public Set<Class<?>> getClasses() {
    classes.add(UsersApi.class);
    return classes;
  }

  @Override
  public Set<Object> getSingletons() {
    return singletons;
  }

}
