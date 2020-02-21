
package com.github.rafaelsantos.cl.action;

import com.github.rafaelsantos.cl.model.Message;

import java.io.Serializable;

import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.jboss.seam.ScopeType;

import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;

import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.annotations.datamodel.DataModelSelection;
import org.jboss.seam.faces.FacesMessages;

/**
 *
 * @author rafaelsantos
 */
@Stateful
@Scope(ScopeType.SESSION)
@Name("messageManager")
public class MessageManagerBean implements Serializable, MessageManager {

    @DataModel
    private List<Message> messageList;
    
    @DataModelSelection
    @Out(required=false)
    private Message message;
    
    @PersistenceContext(type=PersistenceContextType.EXTENDED)
    private EntityManager em;
    
    @Factory("messageList")
    public void findMessages() {
        messageList = em.createQuery("SELECT msg FROM Message msg ORDER BY msg.period DESC").getResultList();
    }

    public void select() {
        message.setFinished(true);
    }

    public void delete() {
        messageList.remove(message);
        
        String msg = String.format("Message %s removed successfully!", this.message.getTitle());
        FacesMessages.instance().add(msg);
        
        this.message = null;
    }

    @Remove
    public void destroy() {}
}
