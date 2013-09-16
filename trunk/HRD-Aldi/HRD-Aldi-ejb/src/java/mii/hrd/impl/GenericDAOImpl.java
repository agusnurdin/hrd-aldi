/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.hrd.impl;

import javax.persistence.EntityManager;
import mii.hrd.dao.GenericDAO;

/**
 *
 * @author Rinaldi
 */
public class GenericDAOImpl implements GenericDAO{
    
    protected EntityManager em;
    public GenericDAOImpl(EntityManager em){
        this.em = em;
    }
    
    @Override
    public void insert(Object obj) {
        this.em.persist(obj);
    }

    @Override
    public void update(Object obj) {
         this.em.merge(obj);
    }

    @Override
    public void delete(Object obj) {
        this.em.remove(obj);
    }
    
}
