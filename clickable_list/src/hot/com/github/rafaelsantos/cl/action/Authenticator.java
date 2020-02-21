package com.github.rafaelsantos.cl.action;

import javax.ejb.Local;

@Local
public interface Authenticator {

    boolean authenticate();

}
