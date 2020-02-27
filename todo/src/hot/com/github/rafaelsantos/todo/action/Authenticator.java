package com.github.rafaelsantos.todo.action;

import javax.ejb.Local;

@Local
public interface Authenticator {

    boolean authenticate();

}
