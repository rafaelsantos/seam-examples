package com.github.rafaelsantos.ur.action;

import javax.ejb.Local;

@Local
public interface Authenticator {

    boolean authenticate();

}
