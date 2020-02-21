
package com.github.rafaelsantos.cl.action;

import javax.ejb.Local;

/**
 *
 * @author rafaelsantos
 */
@Local
public interface MessageManager {
    
    public void findMessages();
    public void select();
    public void delete();
    public void destroy();
}
