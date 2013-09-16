/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.hrd.impl;

import java.util.List;
import javax.persistence.EntityManager;
import mii.hrd.dao.DepartemenDAO;
import mii.hrd.entity.Departemen;

/**
 *
 * @author Rinaldi
 */
public class DepartemenDAOImpl extends GenericDAOImpl implements DepartemenDAO {
    
    public DepartemenDAOImpl(EntityManager em){
        super(em);
    }
    @Override
    public Departemen getByID(long id) {
        return em.find(Departemen.class, id);
    }

    @Override
    public List<Departemen> getAll() {
        return em.createQuery("SELECT d from Departemen d").getResultList();
    }
    
}
