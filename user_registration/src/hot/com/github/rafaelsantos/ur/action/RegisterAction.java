
package com.github.rafaelsantos.ur.action;

import com.github.rafaelsantos.ur.model.User;

import java.util.Collection;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.log.Log;

/**
 *
 * @author rafaelsantos
 */
@Stateless
@Name("register")
public class RegisterAction implements Register {

    @In
    private User user;
    
    @PersistenceContext
    private EntityManager em;
    
    @Logger
    private Log log;
    
    public String register() {
        String query = "SELECT username FROM User WHERE username = #{user.username}";
        Collection<String> existing = em.createQuery(query).getResultList();
        
        if(existing.isEmpty()) {
            em.persist(user);
            log.info("Registered new user #{user.username}");
            
            return "/registered.xhtml";
        } else {
            FacesMessages.instance().add("User #{user.username} already exists!");
            
            return null;
        }
    }
}
